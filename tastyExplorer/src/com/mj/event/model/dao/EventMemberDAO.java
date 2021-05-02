package com.mj.event.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.mj.event.model.vo.EventAdmin;
import com.mj.event.model.vo.EventMember;

public class EventMemberDAO {
	private Properties prop;
	
	public EventMemberDAO() {
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

	

	public int insertEventMember(Connection con, EventMember em) {
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertEventMember");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, em.geteNo());
			ps.setInt(2, em.getmNo());
			ps.setDate(3, em.geteDate());
			
			result = ps.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}
	

}
