package com.mj.mRestaurant.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.mj.mRestaurant.model.dao.TicketDAO;
import com.mj.mRestaurant.model.vo.Ticket;
import com.mj.member.model.dao.CouponDAO;
import com.mj.member.model.vo.Coupon;

public class TicketService {
	

	private Connection con;
	private TicketDAO dao = new TicketDAO();

	public ArrayList<Ticket> selectList(int currentPage) {
		con = getConnection();
		
		ArrayList<Ticket> list = dao.selectList(con, currentPage);
		
		close(con);
		
		return list;
	}
	
	public int insertTicket(Ticket t) {
		
		con = getConnection();
		
		int result = dao.insertTicket(con, t);
		
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

	public int deleteTicket(int tNo) {
		con = getConnection();
		
		int result = dao.deleteTicket(con,tNo);
		
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}

	
}