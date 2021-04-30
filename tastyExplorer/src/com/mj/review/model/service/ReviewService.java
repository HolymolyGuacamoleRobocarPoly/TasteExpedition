package com.mj.review.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.mj.review.model.dao.ReviewDAO;
import com.mj.review.model.vo.Review;

public class ReviewService {

	private Connection con;
	private ReviewDAO dao = new ReviewDAO();
	
	
	public ArrayList<Review> selectList(int currentPage) {
		con = getConnection();
		
		ArrayList<Review> list = dao.selectList(con, currentPage);
		
		close(con);
		
		return list;
	}
	
	
	
	
	public int insertReview(Review r) {
		con = getConnection();
		
		int result = dao.insertReview(con, r);
		
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




	public int deleteReview(int rNo) {
		con = getConnection();
		
		int result = dao.deleteReview(con,rNo);
		
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
}
