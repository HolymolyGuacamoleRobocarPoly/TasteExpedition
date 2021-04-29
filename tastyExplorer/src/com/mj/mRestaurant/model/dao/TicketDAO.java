package com.mj.mRestaurant.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

	public int insertTicket(Connection con, Ticket t) {
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertTicket");
		
		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(4, t.gettContent());
			ps.setString(5, t.gettTitle());
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

}
