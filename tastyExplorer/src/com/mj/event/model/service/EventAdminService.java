package com.mj.event.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.mj.event.model.dao.EventAdminDAO;
import com.mj.event.model.vo.EventAdmin;

public class EventAdminService {
	
	private Connection con;
	private EventAdminDAO dao = new EventAdminDAO();

	public ArrayList<EventAdmin> selectList() {
		con = getConnection();
		System.out.println("서비스까진 오나요");
		ArrayList<EventAdmin> list = dao.selectList(con);
		
		close(con);
		System.out.println("list?" + list);
		return list;
	}
	
	public int insertEventBoard(EventAdmin e) {
		System.out.println("eDurtaion2" );
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

	public EventAdmin selectOne(int eNo, int mNo) {
		con = getConnection();
		
		EventAdmin ev = dao.selectOne(con, eNo);
		
		// 이벤트에 참여한 회원인지 아닌지 구분하기 위한 구문
		// 이미 참여한 이벤트인 경우 다시 참여할 수 없기때문에 필요!
		int check = dao.selectCheck(con, eNo, mNo);
		
		if(check == 1) {
			ev.setCheck("N"); // 참여 불가
		} else {
			ev.setCheck("Y"); // 참여 가능
		}
		
		close(con);
		
		return ev;
	}

}
