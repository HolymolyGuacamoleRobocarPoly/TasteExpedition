package com.mj.mRestaurant.model.service;

import java.sql.Connection;
import java.util.ArrayList;

import com.mj.mRestaurant.model.dao.MenuDAO;
import com.mj.mRestaurant.model.vo.MRestaurant;
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

	public int insertMenu(MRestaurant mj, Menu menu) {
		con = getConnection();
		
		int result = 0;
		int mjNo = mj.getmRestaurantNo();
		String [] nameList = menu.getMenuNames();
		String [] priceList = menu.getMenuPrices();
		
		if (nameList.length == priceList.length) {// 입력 받은 행이 동일하다면
			for (int i = 0; i < nameList.length; i++) {
				result = dao.insertMenu(con, mjNo, nameList[i], priceList[i]);
				if(result == 0) break; 
				else result = 1;
			}
		}
		
		
		if( result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
