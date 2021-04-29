package com.mj.mRestaurant.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;

import com.mj.mRestaurant.model.dao.MRestaurantDAO;
import com.mj.mRestaurant.model.vo.MRestaurant;

public class MRestaurantService {

	private Connection con;
	private MRestaurantDAO dao = new MRestaurantDAO();
	
	public MRestaurant selectOne(int mjNo) {
		con = getConnection();
				
		MRestaurant mj = dao.selectOne(con, mjNo);
		
		close(con);
		
		return mj;
	} 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
