package com.mj.event.model.service;

import com.mj.event.model.vo.EventMember;
import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.mj.event.model.dao.EventAdminDAO;
import com.mj.event.model.dao.EventMemberDAO;
import com.mj.event.model.vo.EventAdmin;

public class EventMemberService {
	
	private Connection con;
	private EventMemberDAO dao = new EventMemberDAO();

	public int insertEventMember(EventMember em) {
		con = getConnection();
		
		int result = dao.insertEventMember(con, em);
		
		if( result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public ArrayList<EventAdmin> selectList(int mNo) {
		con = getConnection();
		ArrayList<EventAdmin> list = dao.selectList(con, mNo);
		
		close(con);

		return list;
	}

}
