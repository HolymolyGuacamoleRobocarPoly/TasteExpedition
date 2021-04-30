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
		
		
		return null;
	}
	
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

	
}
