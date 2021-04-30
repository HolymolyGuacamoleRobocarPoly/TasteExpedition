package com.mj.member.model.service;

import java.sql.Connection;

import com.common.JDBCTemplate;
import com.mj.member.model.dao.MemberDAO;
import com.mj.member.model.vo.Member;
import static com.common.JDBCTemplate.*;

public class MemberService {
	
	private Connection con;
	private MemberDAO dao = new MemberDAO();
	
	public int insertMember(Member m) {
		con = JDBCTemplate.getConnection();
		
		int result = dao.insertMember(con,m);
		
		if(result>0) {
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
		
	}

	public Member selectMember(Member loginMember) {
		con = getConnection();
		
		Member result = dao.selectMember(con, loginMember);
		
		close(con);
		
		return result;
	} 

}
