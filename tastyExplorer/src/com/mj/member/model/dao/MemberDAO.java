package com.mj.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import static com.common.JDBCTemplate.*;

import com.mj.member.model.vo.Member;

public class MemberDAO {
	
	private Properties prop;
	private PreparedStatement pstmt;
	
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
		String sql = prop.getProperty("insertMember");
		
		try {
			ps = con.prepareStatement(sql);
			
			//데이터 베이스 시작은 1부터
			ps.setString(1, m.getUserId());
			ps.setString(2, m.getUserPwd());
			ps.setString(3, m.getUserName());
			ps.setString(4, m.getEmail());
			ps.setString(5, m.getPhone());
			ps.setDate(6, m.getBirthday());
			ps.setString(7, m.getAddress());
			ps.setString(8, m.getNickName());
			
			result = ps.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

	public Member selectMember(Connection con, Member loginMember) {
		Member result = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectMember");
		
		try {
			ps = con.prepareStatement(sql);
			
			System.out.println("loginMember.getUserId() : " + loginMember.getUserId());
			System.out.println("loginMember.getUserPwd() : " + loginMember.getUserPwd());
			
			ps.setString(1, loginMember.getUserId());
			ps.setString(2, loginMember.getUserPwd());
			
			rs = ps.executeQuery();
			System.out.println(rs);
			if(rs.next()){
				result = new Member();
				
				result.setmNo( rs.getInt("m_no"));
				result.setUserId(rs.getString("m_id"));
				result.setUserPwd(rs.getString("m_pwd"));
				result.setUserName( rs.getString("M_NAME"));
				result.setNickName(rs.getString("M_NICKNAME"));
				result.setBirthday(rs.getDate("M_BIRTH"));
				result.setPhone(rs.getString("M_PHONE"));
				result.setEmail( rs.getString("M_EMAIL"));
				result.setAddress(rs.getString("M_ADDR"));
				result.setmLoginType(rs.getInt("M_LOGIN_TYPE"));

			}	
			
			System.out.print("조회 결과 : " + result);
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		close(rs);
		close(ps);
	}
		
		return result;
		
	}
	
	public int updateMember(Connection con, Member m) {
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("updateMember");
		
		try {
		
			ps = con.prepareStatement(sql);
		
			ps.setString(1, m.getUserPwd() );
			ps.setString(2, m.getEmail() );
			ps.setString(3, m.getPhone() );
			ps.setString(4, m.getAddress() );
			ps.setString(5, m.getmProfileAtt() );
			ps.setString(6, m.getUserId() );
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			close(ps);
		}
				
		return result;
	}

	public int deleteMember(Connection con, String userId) {
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("deleteMember");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, userId);
			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}
	
	public String findIdbyEmail(Connection con, String email) {
		String id = null;
		
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("findIdbyEmail");
		
		try {
		ps = con.prepareStatement(sql);
		ps.setNString(1, email);
		rs=ps.executeQuery();
		if(rs.next()) {
			id = rs.getString("id");
			} 
		}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					if(ps!=null) ps.close();
					if(rs!=null) rs.close();
					if(con!=null) con.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
	
		return id;
		
		}

	public int idcheck(Connection con, String userId) {
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("idcheck");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, userId);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return result;
	}
	
	
	


}
