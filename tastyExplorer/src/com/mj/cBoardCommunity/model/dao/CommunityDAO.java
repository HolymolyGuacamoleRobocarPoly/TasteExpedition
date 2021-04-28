package com.mj.cBoardCommunity.model.dao;


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
		
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("");
		
		
		
		
		return null;

	}

}
