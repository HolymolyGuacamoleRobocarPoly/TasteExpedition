package com.mj.mRestaurant.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mj.mRestaurant.model.vo.Menu;

import static com.common.JDBCTemplate.*;

public class MenuDAO {

private Properties prop;
	
	public MenuDAO() {
		prop = new Properties();
		
		String filePath = Menu.class.getResource("/config/Menu.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public ArrayList<Menu> selectList(Connection con, int mjNo) {
		ArrayList<Menu> menuList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, mjNo);
			
			rs = ps.executeQuery();
			
			while ( rs.next()) {
				Menu menu = new Menu();
				
				menu.setmRestaurantNo(rs.getInt("M_RESTAURANT_NO"));
				menu.setMenuName(rs.getString("MENU_NAME"));
				menu.setMenuPrice(rs.getInt("MENU_PRICE"));
				
				menuList.add(menu);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}

		return menuList;
	}

	
	
	
	
	
	
	
	
	
	
	
}
