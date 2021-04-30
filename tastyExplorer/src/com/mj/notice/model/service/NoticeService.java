package com.mj.notice.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.mj.cBoardCommunity.model.vo.Community;
import com.mj.member.model.dao.CouponDAO;
import com.mj.member.model.vo.Coupon;
import com.mj.notice.model.dao.NoticeDAO;
import com.mj.notice.model.vo.Notice;

public class NoticeService {

	private Connection con;
	private NoticeDAO dao = new NoticeDAO();
	
	public ArrayList<Notice> selectList(int currentPage) {
		
		con = getConnection();
		
		ArrayList<Notice> list = dao.selectList(con, currentPage);
		
		close(con);
	
		return list;
	}
	
	public int insertNotice(Notice n) {
		
		con = getConnection();
		
		int result = dao.insertNotice(con, n);
		
		if( result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
	public Notice selectOne(int nNo) {
		
		con = getConnection();
		
		int result = dao.updateReadCount(con, nNo);
		
		Notice n  = dao.selectOne(con, nNo);
		
		if (result > 0) commit(con);
		else rollback(con);
		
		close( con);
		
		return n;
		
	}
	
	public Notice updateView(int nNo) {
		
		con = getConnection();
		
		Notice n = dao.selectOne(con, nNo);
		
		close(con); 
		
		return n;
	}

	public int deleteNotice(int nNo) {
		
		con = getConnection();
		
		int result = dao.deleteNotice(con, nNo);
		
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

	public int updateNotice(Notice n) {
		con = getConnection();
		
		int result = dao.updateNotice(con, n);
		
		if( result > 0 ) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}



	

	public int getListCount() {
		con = getConnection();
		
		int result = dao.getListCount(con);
		
		close(con);
		
		return result;
	}
	
	public int deleteNotice(int nNo) {
		con = getConnection();
		
		int result = dao.deleteNotice(con,nNo);
		
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	
}
