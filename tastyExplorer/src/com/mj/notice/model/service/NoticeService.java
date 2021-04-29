package com.mj.notice.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.commit;
import static com.common.JDBCTemplate.getConnection;
import static com.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.mj.member.model.dao.CouponDAO;
import com.mj.member.model.vo.Coupon;
import com.mj.notice.model.dao.NoticeDAO;
import com.mj.notice.model.vo.Notice;

public class NoticeService {

	private Connection con;
	private NoticeDAO dao = new NoticeDAO();
	
	public int insertNotice(Notice n) {
		
		con = getConnection();
		
		int result = dao.insertNotice(con, n);
		
		if( result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
}
