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

import com.mj.event.model.vo.EventAdmin;
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
				
				n.setnNo( rs.getInt("N_NO") );
				n.setnTitle(rs.getString("N_TITLE"));
				n.setnContent( rs.getString("N_CONTENT"));
				n.setnDate(rs.getDate("N_DATE"));
				n.setnCount( rs.getInt("N_COUNT"));
				n.setnStatus( rs.getString("N_STATUS") );
				
				list.add(n);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return list;
	}
	
	public int insertNotice(Connection con, Notice n) {
		
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertNotice");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, n.getnTitle());
			ps.setString(2, n.getnContent());

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
				// column 의 수가 count 하나이기 때문에
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return result;
	}


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

	
}
