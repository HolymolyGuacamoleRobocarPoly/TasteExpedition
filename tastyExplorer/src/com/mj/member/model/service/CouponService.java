package com.mj.member.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.mj.member.model.dao.CouponDAO;
import com.mj.member.model.vo.Coupon;

public class CouponService {

	private Connection con;
	private CouponDAO dao = new CouponDAO();
	
	public int insertCoupon(Coupon c) {
		
		con = getConnection();
		
		int result = dao.insertCoupon(con, c);
		
		if( result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	
}
