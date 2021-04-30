package com.mj.mRestaurant.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mj.common.model.dao.AttachmentDAO;
import com.mj.mRestaurant.model.vo.Ticket;

public class TicketDAO {
	
	private Properties prop;
	
	public TicketDAO() {
		prop = new Properties();
		
		String filePath 
			= TicketDAO.class
					   .getResource("/config/ticket.properties")
					   .getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Ticket> selectList(Connection con, int currentPage) {
		ArrayList<Ticket> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectList");
		// 1 : 1 , 2: 11, 3 : 21
		int startRow = (currentPage - 1) * 10 + 1;
		int endRow = currentPage * 10;
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, endRow);
			ps.setInt(2, startRow);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Ticket t = new Ticket();
				
				t.settNo( rs.getInt("T_NO") );
				t.settDuration( rs.getDate("T_DURATION"));
				t.settDate(rs.getDate("T_Date"));
				t.settContent(rs.getString("T_CONTENT"));
				t.settTitle( rs.getString("T_TITLE"));
				t.settStatus( rs.getString("T_STATUS"));
				t.setmNo( rs.getInt("M_NO"));
				
				list.add(t);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return list;
	}

	public int insertTicket(Connection con, Ticket t) {
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertTicket");
		
		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, t.gettContent());
			ps.setString(2, t.gettTitle());
			
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

	public int deleteTicket(Connection con, int tNo) {
		int result = 0;
		
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("deleteTicket");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, tNo);

			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(ps);
			
		}
		
		return result;
	}

}
