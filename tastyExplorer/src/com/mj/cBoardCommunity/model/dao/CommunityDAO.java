package com.mj.cBoardCommunity.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mj.cBoardCommunity.model.vo.Community;

public class CommunityDAO {

	private Properties prop;
	
	public CommunityDAO()	 {
		prop = new Properties();
		
		String filePath = Community.class
						  .getResource("/config/community.properties")
						  .getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public ArrayList<Community> selectList(Connection con, int currentPage) {
		
		ArrayList<Community> list = new ArrayList<>();
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
				
				Community c = new Community();
				
				c.setcBoardNo( rs.getInt("cboardno") );
				c.setcBoardTitle( rs.getString("cboardtitle"));
				c.setcBoardContent(rs.getString("cboardcontent"));
				c.setcBoardwriter(rs.getString("cboardwriter"));
				c.setmNickname( rs.getString("mnickname"));
				c.setcBoardTeam( rs.getInt("cboardteam"));
				c.setcBoardCount( rs.getInt("cboardcount"));
				c.setcBoardDate( rs.getDate("cboarddate"));
				
				
				list.add(c);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return list;

	}

	// 게시글 작성
	public int insertCommunity(Connection con, Community c) {
		
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("insertCommunity");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, c.getcBoardTitle());
			ps.setString(2, c.getcBoardContent());
			ps.setString(3, c.getmNickname());
			ps.setInt(4, c.getcBoardTeam());
			ps.setInt(5, c.getcBoardCount());
			
			result = ps.executeUpdate();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		
		return result;
	}
	
	// 상세보기
	public Community selectOne(Connection con, int cboardno) {
		
		Community c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectOne");
		
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, cboardno);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				c = new Community();
				
				c.setcBoardNo(cboardno);
				c.setcBoardTitle( rs.getString("cboardtitle"));
				c.setcBoardContent(rs.getString("cboardcontent"));
				c.setcBoardwriter(rs.getString("cboardwriter"));
				c.setmNickname( rs.getString("mnickname"));
				c.setcBoardTeam( rs.getInt("cboardteam"));
				c.setcBoardCount( rs.getInt("cboardcount"));
				c.setcBoardDate( rs.getDate("cboarddate"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		
		return c;
	}
	
	// 조회수
	public int updateReadCount(Connection con, int cboardno) {
		
		int result = 0;
		
		PreparedStatement ps = null;
		String sql = prop.getProperty("updateReadCount");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, cboardno);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}
	
	//게시글 수정
	public int updateCommunityBoard(Connection con, Community c) {
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("updateCommunityBoard");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, c.getcBoardTitle());
			ps.setString(2, c.getcBoardContent());
			ps.setInt(3,c.getcBoardNo());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}
	
	// 게시글삭제
	public int deleteCommunityBoard(Connection con, int cboardno) {
		
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("deleteCommunityBoard");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, cboardno);
			
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



}