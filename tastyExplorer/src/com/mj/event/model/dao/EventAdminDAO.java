package com.mj.event.model.dao;

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
import com.mj.mRestaurant.model.vo.MRestaurant;


public class EventAdminDAO {

	private Properties prop;
	
	public EventAdminDAO() {
		prop = new Properties();
		
		String filePath 
			= EventAdminDAO.class
					  	   .getResource("/config/event.properties")
					  	   .getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public ArrayList<EventAdmin> selectList(Connection con) {
		ArrayList<EventAdmin> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectList");

		//int startRow = (currentPage - 1) * 10 + 1;
		//int endRow = currentPage * 10;
		
		try {
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				EventAdmin ad = new EventAdmin();
				
				ad.seteNo( rs.getInt("E_NO") );
				ad.seteContent( rs.getString("E_CONTENT"));
				ad.seteTitle(rs.getString("E_TITLE"));
				ad.seteDuration(rs.getDate("E_DURATION"));

				list.add(ad);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		System.out.println("list2?" + list);
		return list;
	}
	
	public int insertEventBoard(Connection con, EventAdmin e) {
		
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertEvent");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, e.geteContent());			
			ps.setString(2, e.geteTitle());
			ps.setDate(3, e.geteDuration());

			System.out.println("result :" + e.geteDuration());

			result = ps.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
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
				// column ??? ?????? count ???????????? ?????????
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return result;
	}


	public int deleteEvent(Connection con, int eNo) {
		int result = 0;
		
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("deleteEvent");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, eNo);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(ps);
			
		}
		
		return result;
	}


	public EventAdmin selectOne(Connection con, int eNo) {
		EventAdmin ev = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectOne");
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, eNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				ev = new EventAdmin();
				
				ev.seteNo(eNo);
				ev.seteContent(rs.getString("E_CONTENT"));
				ev.seteTitle(rs.getString("E_TITLE"));
				ev.seteDuration(rs.getDate("E_DURATION"));

			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return ev;
	}


	public int selectCheck(Connection con, int eNo, int mNo) {
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectCheck");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, eNo);
			ps.setInt(2, mNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = 1;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			close(ps);
		}
		
		return result;
	}

}
