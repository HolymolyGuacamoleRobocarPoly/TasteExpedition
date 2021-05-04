package com.mj.mRestaurant.model.dao;

import static com.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;


import com.mj.mRestaurant.model.vo.MRestaurant;

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
				
				mj.setmRestaurantNo(mjNo);
				mj.setmRestaurantTitle(rs.getString("M_RESTAURANT_TITLE"));
				mj.setmRestaurantContent(rs.getString("M_RESTAURANT_CONTENT"));
				mj.setmRestaurantAdrress(rs.getString("M_RESTAURANT_ADRRESS"));
				mj.setmRestaurantInfo(rs.getString("M_RESTAURANT_INFO"));
				mj.setmRestaurantLevel(rs.getInt("M_RESTAURANT_LEVEL"));
				mj.setmRestaurantLike(rs.getInt("M_RESTAURANT_LIKE"));
				mj.setmRestaurantTel(rs.getString("M_RESTAURANT_TEL"));
				mj.setOpenTime(rs.getString("M_RESTAURANT_OPEN_TIME"));
				mj.setBrTime(rs.getString("M_RESTAURANT_BR_TIME"));
				mj.setHoliday(rs.getString("M_RESTAURANT_HOLIDAY"));

				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return mj;
	}
	
	

	public ArrayList<MRestaurant> selectList(Connection con, String keyword) {
		ArrayList<MRestaurant> mjList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, keyword);
			
			rs = ps.executeQuery();
			
			while ( rs.next()) {
				MRestaurant mj = new MRestaurant();
				
				mj.setmRestaurantNo(rs.getInt("M_RESTAURANT_NO"));
				mj.setmRestaurantTitle(rs.getString("M_RESTAURANT_TITLE"));
				mj.setmRestaurantContent(rs.getString("M_RESTAURANT_CONTENT"));
				mj.setmRestaurantAdrress(rs.getString("M_RESTAURANT_ADRRESS"));
				mj.setmRestaurantInfo(rs.getString("M_RESTAURANT_INFO"));
				mj.setmRestaurantLevel(rs.getInt("M_RESTAURANT_LEVEL"));
				mj.setmRestaurantLike(rs.getInt("M_RESTAURANT_LIKE"));
				mj.setmRestaurantTel(rs.getString("M_RESTAURANT_TEL"));
				mj.setOpenTime(rs.getString("M_RESTAURANT_OPEN_TIME"));
				mj.setBrTime(rs.getString("M_RESTAURANT_BR_TIME"));
				mj.setHoliday(rs.getString("M_RESTAURANT_HOLIDAY"));

				
				mjList.add(mj);
			}
			
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return mjList;
	}

	
	
	
	

	public int insertMRestaurant(Connection con) {
		MRestaurant mj = null;
		PreparedStatement ps = null;
		
		int result = 0;
		
		String sql = prop.getProperty("insertMRestaurant");
		
		try {
			ps = con.prepareStatement(sql);

			ps.setString(1, mj.getmRestaurantTitle());
			ps.setString(2, mj.getmRestaurantContent());
			ps.setString(3, mj.getmRestaurantAdrress());
			ps.setString(4, mj.getmRestaurantInfo());
			ps.setInt(5, mj.getmRestaurantLevel());
			ps.setString(6, mj.getmRestaurantTel());
			ps.setString(7, mj.getOpenTime());
			ps.setString(8, mj.getBrTime());
			ps.setString(9, mj.getHoliday());
			
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
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
