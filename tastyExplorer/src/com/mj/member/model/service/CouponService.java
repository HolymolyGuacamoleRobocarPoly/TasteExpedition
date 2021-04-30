package com.mj.member.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.mj.member.model.dao.CouponDAO;
import com.mj.member.model.vo.Coupon;

public class CouponService {

	private Connection con;
	private CouponDAO dao = new CouponDAO();
	
	public ArrayList<Coupon> selectList(int currentPage) {
		con = getConnection();
		
		ArrayList<Coupon> list = dao.selectList(con, currentPage);
		
		close(con);
		
		return list;
	}
	
	public int insertCoupon(Coupon c) {
		
		con = getConnection();
		
		int result = dao.insertCoupon(con, c);
		
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

	public int deleteCoupon(int cNo) {
		con = getConnection();
		
		int result = dao.deleteCoupon(con,cNo);
	
		if (result > 0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
	}
	
}
