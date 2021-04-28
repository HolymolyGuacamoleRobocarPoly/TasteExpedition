package com.mj.common.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mj.common.model.vo.Attachment;

public class AttachmentDAO {

	private Properties prop;
	
	public AttachmentDAO() {
		prop = new Properties();
		
		String filePath 
			= AttachmentDAO.class
					  	  .getResource("/config/Attachment.properties")
					  	  .getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// ?? 필요한 가?
	public ArrayList<Attachment> selectList(Connection con) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

	public int insertAttachment(Connection con, Attachment attachment) {
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertAttachment");
		
		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(2, attachment.getAttMFileName());
			ps.setInt(3, attachment.getAttMFlevel());
			ps.setString(6, attachment.getAttBNo());
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

	public int getCurrentRNo(Connection con) {
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("currentRNo");
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if( rs.next()) {
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
