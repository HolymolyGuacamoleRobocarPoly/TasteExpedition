package com.mj.event.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.mj.event.model.vo.EventAdmin;

public class EventAdminDAO {

	private Properties prop;
	
	public EventAdminDAO() {
		prop = new Properties();
		
		String filePath 
			= EventAdminDAO.class
					  	   .getResource("/config/notice.properties")
					  	   .getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertEventBoard(Connection con, EventAdmin e) {
		
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertNotice");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(2, e.geteTitle());
			ps.setString(3, e.geteContent());

			result = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

}