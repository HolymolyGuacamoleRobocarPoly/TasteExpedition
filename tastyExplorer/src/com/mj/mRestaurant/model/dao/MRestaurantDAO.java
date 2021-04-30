package com.mj.mRestaurant.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mj.mRestaurant.model.vo.MRestaurant;

import static com.common.JDBCTemplate.*;

public class MRestaurantDAO {
	
	private Properties prop;
	
	public MRestaurantDAO() {
		prop = new Properties();
		
		String filePath = MRestaurant.class.getResource("/config/MRestaurant.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public MRestaurant selectOne(Connection con, int mjNo) {
		MRestaurant mj = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectOne");
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, mjNo);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				mj = new MRestaurant();
				
				// status, confirm 은 db query 에서 사용할 변수
				mj.setmRestaurantNo(mjNo);
				mj.setmRestaurantTitle(rs.getString("mjTitle"));
				mj.setmRestaurantContent(rs.getString("mjContent"));
				mj.setmRestaurantAdrress(rs.getString("mjAddress"));
				mj.setmRestaurantTel(rs.getInt("mjTel"));
				mj.setmRestaurantInfo(rs.getString("mjInfo"));
				mj.setmRestaurantLike(rs.getInt("mjLike"));
				mj.setmRestaurantLevel(rs.getInt("mjLevel"));
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return mj;
	}

	public int deleteMRestaurant(Connection con, int mjNo) {
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("deleteMRestaurant");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, mjNo);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

	
	
	
	
	
	
	
	
	
	
	
	
}
