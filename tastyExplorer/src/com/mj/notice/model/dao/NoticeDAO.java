package com.mj.notice.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mj.notice.model.vo.Notice;

public class NoticeDAO {

	private Properties prop;
	
	public NoticeDAO() {
		prop = new Properties();
		
		String filePath 
			= NoticeDAO.class
					   .getResource("/config/notice.properties")
					   .getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public ArrayList<Notice> selectList(Connection con, int currentPage) {
		 
		ArrayList<Notice> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectList");
		
		int startRow = (currentPage - 1) * 10 + 1;
		int endRow = currentPage * 10;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, endRow);
			ps.setInt(2, startRow);
			
			
			rs = ps.executeQuery();
			
			
			while(rs.next()) {
				
				Notice n = new Notice();
				
				n.setnNo(rs.getInt("nNo"));
				n.setnTitle(rs.getString("ntitle"));
				n.setnContent(rs.getString("ncontent"));
				n.setnWriter(rs.getString("nwriter"));
				n.setmNickname(rs.getString("mnickname"));
				n.setnDate(rs.getDate("ndate"));
				n.setnCount(rs.getInt("ncount"));
				
				list.add(n);
				
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("11");
			close(rs);
			System.out.println("22");
			close(ps);
		}
		
		return list;
	}
	
	// 작성하기
	public int insertNotice(Connection con, Notice n) {
		
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertNotice");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(2, n.getnTitle());
			ps.setString(3, n.getnContent());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
		
	}

	// 상세보기
	public Notice selectOne(Connection con, int nNo) {
		
		Notice n = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectOne");
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, nNo);
			
			rs = ps.executeQuery();
			
			if (rs.next())	{
				
				n = new Notice();
				// 총 6개
				n.setnNo(nNo);
				n.setnTitle(rs.getString("ntitle"));
				n.setnContent(rs.getString("ncontent"));
				n.setnDate(rs.getDate("ndate"));
				n.setnCount(rs.getInt("ncount"));
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return n;
	}


	public int updateReadCount(Connection con, int nNo) {
		
		int result = 0;
		
		PreparedStatement ps = null;
		String sql = prop.getProperty("updateReadCount");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, nNo);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}
	
	
	//게시글 수정
	

	// 게시물 삭제
	public int deleteNotice(Connection con, int nNo) {
	
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("deleteNotice");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, nNo);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		
		return result;
	}


	public int getListCount(Connection con) {
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("listCount");
		
		try {
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
 		}

		return result;
	}


	public int updateNotice(Connection con, Notice n) {
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("updateNotice");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, n.getnTitle());
			ps.setString(2, n.getnContent());
			ps.setInt(3, n.getnNo());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			close(ps);
		}
		
		return result;
	}

	
}
