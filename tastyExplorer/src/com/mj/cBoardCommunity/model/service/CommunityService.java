package com.mj.cBoardCommunity.model.service;


import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.mj.cBoardCommunity.model.dao.CommunityDAO;
import com.mj.cBoardCommunity.model.vo.Community;

public class CommunityService {

	private Connection con;
	private CommunityDAO dao = new CommunityDAO();
	
	public ArrayList<Community> selectList(int currentPage) {
		con = getConnection();
		
		ArrayList<Community> list = dao.selectList(con, currentPage);
		
		close(con);
		
		return list;
		
		
	}
	
	public int getListCount() {
		
		

		
		return 0;

	}

	
}
