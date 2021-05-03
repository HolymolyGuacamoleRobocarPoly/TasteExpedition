package com.mj.mRestaurant.model.service;

import static com.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

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
	
	public ArrayList<MRestaurant> selectList(String keyword) {
		con = getConnection();
		
		ArrayList<MRestaurant> mjList = dao.selectList(con, keyword);
		
		close(con);
		
		return mjList;
	}


	public int insertMRestaurant(MRestaurant mj) {
		con = getConnection();
		
		int result = dao.insertMRestaurant(con);
		
		if( result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	} 
	

	public int deleteMRestaurant(int mjNo) {
		con = getConnection();
		
		int result = dao.deleteMRestaurant(con, mjNo);
		
		if( result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
