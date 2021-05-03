package com.mj.cBoardCommunity.model.service;


import static com.common.JDBCTemplate.*;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.mj.cBoardCommunity.model.dao.CommunityDAO;
import com.mj.cBoardCommunity.model.vo.Community;

public class CommunityService {

	private Connection con;
	private CommunityDAO dao = new CommunityDAO();
	
	public ArrayList<Community> selectList(int currentPage, String field, String query, int i) {
		con = getConnection();
		
		ArrayList<Community> list = dao.selectList(con, currentPage);
		
		close(con);
		
		return list;
		
		
	}
	
	public int insertCommunity(Community c) {
		
		con = getConnection();
		
		int result = dao.insertCommunity(con, c);
		
			if (result > 0) commit(con);
			else rollback(con);
		
		close(con);
	
		return result;
	}
	
	public Community selectOne(int cboardno) {
		con = getConnection();

		int result = dao.updateReadCount(con, cboardno);
		
		Community c = dao.selectOne(con, cboardno);
		
		if( result > 0 ) commit(con);
		else rollback(con);
				
		close(con);
		
		return c;  // 서블릿으로!
	}

	public Community updateView(int cboardno) {
		// 게시글 한 개의 정보를 조회하되
		// 조회수 증가 X
		con = getConnection();
		
		Community c = dao.selectOne(con, cboardno);
		
		close(con);
		
		return c;
	}

	public int updateCommunityBoard(Community c) {
		con = getConnection();
		
		int result = dao.updateCommunityBoard(con, c);
		
		if( result > 0 ) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int deleteCommunityBoard(int cboardno) {
		con = getConnection();
		
		int result = dao.deleteCommunityBoard(con, cboardno);
		
		if( result > 0 ) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	public int getListCount() {
		con = getConnection();
		
		int result = dao.getListCount(con);
		
		close(con);
		
		return result;
	}

	
}
