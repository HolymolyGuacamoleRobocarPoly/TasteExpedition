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
		System.out.println("Service : " + loginMember.toString());
		Member result = dao.selectMember(con, loginMember);
		
		close(con);
		
		return result;
	}


	public int updateMember(Member m) {
		con = getConnection();
		
		int result = dao.updateMember(con, m);
		
		if (result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int deleteMember(String userId) {
		con = getConnection();
		
		int result = dao.deleteMember(con, userId);
		
		if (result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int idcheck(String userId) {
		con = getConnection();
		
		int result = dao.idcheck(con, userId);
		
		close(con);
		
		return result;
	}


}
