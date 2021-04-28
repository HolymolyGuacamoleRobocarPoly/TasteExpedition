package com.mj.bComment.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.mj.bComment.model.dao.BCommentDAO;
import com.mj.bComment.model.vo.BComment;

public class BCommentService {

	private Connection con;
	
	private BCommentDAO dao = new BCommentDAO();

	public int insertComment(BComment comment) {
		con = getConnection();
		
		int result = dao.insertComment(con, comment);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int updateComment(BComment bc) {
		con = getConnection();
		
		int result = dao.updateComment(con, bc);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int deleteComment(int cno) {
		con = getConnection();
		
		int result = dao.deleteComment(con, cno);
		
		if( result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
	
	
	
	
	
	
	
}
