package com.mj.mRestaurant.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.mj.mRestaurant.model.dao.MenuDAO;
import com.mj.mRestaurant.model.vo.Menu;

import static com.common.JDBCTemplate.*;

public class MenuService {

	private Connection con;
	private MenuDAO dao = new MenuDAO();
	
	public ArrayList<Menu> selectList(int mjNo) {
		con = getConnection();
		
		ArrayList<Menu> menuList = dao.selectList(con, mjNo);
		
		close(con);
		
		return menuList;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
