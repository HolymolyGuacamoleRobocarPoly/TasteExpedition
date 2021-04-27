package com.mj.bComment.controller;

import static com.common.JDBCTemplate.*;
import java.sql.Connection;

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
	
	
	
	
	
	
	
	
}
