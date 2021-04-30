package com.mj.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import com.mj.member.model.vo.Member;

public class MemberDAO {
	
	private Properties prop;
	
	public MemberDAO() {
		prop = new Properties();
		
		//파일 경로
		String filePath = MemberDAO.class
				.getResource("/config/member.properties")
				.getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int insertMember(Connection con, Member m) {
		int result = 0;
		PreparedStatement ps = null; //쿼리 준비
		String sql = "INSERT INTO MEMBER VALUES ( ?,?,?,?,?,?,?,?,?,?,? DEFAULT)";
		
		
		return 0;
	}

}
