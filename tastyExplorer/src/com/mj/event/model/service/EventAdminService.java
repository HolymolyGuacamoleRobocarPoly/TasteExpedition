package com.mj.event.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.mj.event.model.dao.EventAdminDAO;
import com.mj.event.model.vo.EventAdmin;
import com.mj.mRestaurant.model.vo.Ticket;
import com.mj.member.model.vo.Coupon;

public class EventAdminService {
	
	private Connection con;
	private EventAdminDAO dao = new EventAdminDAO();

	public ArrayList<EventAdmin> selectList(int currentPage) {
		con = getConnection();
		
		ArrayList<EventAdmin> list = dao.selectList(con, currentPage);
		
		close(con);
		
		return list;
	}
	
	public int insertEventBoard(EventAdmin e) {
		
		con = getConnection();
		
		int result = dao.insertEventBoard(con, e);
		
		if( result > 0) commit(con);
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

	public int deleteEvent(int eNo) {
		con = getConnection();
		
		int result = dao.deleteEvent(con,eNo);
		
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

}
