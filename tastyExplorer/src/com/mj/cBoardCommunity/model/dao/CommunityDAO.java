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
		ArrayList<Community> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectList");
		
		int startRow = (currentPage - 1) * 10  + 1;
		int endRow = currentPage * 10;
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1,  endRow);
			ps.setInt(2, startRow);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Community c = new Community();
				
				c.setcBoardNo(rs.getInt("cboardno"));
				c.setcBoardTitle(rs.getString("cobardtitle"));
				c.setcBoardContent(rs.getString("cboardcontent"));
				c.setcBoardwriter(rs.getString("cboardwriter"));
				c.setmNickname(rs.getString("mnickname"));
				c.setcBoardTeam(rs.getInt("cboardteam"));
				c.setcBoardCount(rs.getInt("cboardcount"));
				c.setcBoardDate(rs.getDate("cboarddate"));
				//c.setcBoardStatus(rs.getchar("cboardstatus"));
				
				
				list.add(c);
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
		//	close(rs);
		//	close(ps);
		}
		
		
		
		return null;
	}


	public int insertCommunity(Connection con, Community c) {
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("insertCommunity");
		
		try {
			ps = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

}
