package com.mj.event.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.mj.event.model.dao.EventAdminDAO;
import com.mj.event.model.vo.EventAdmin;

public class EventAdminService {
	
	private Connection con;
	private EventAdminDAO dao = new EventAdminDAO();
	
	public int insertEventBoard(EventAdmin e) {
		
		con = getConnection();
		
		int result = dao.insertEventBoard(con, e);
		
		if( result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

}
