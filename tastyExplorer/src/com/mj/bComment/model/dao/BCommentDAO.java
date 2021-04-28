package com.mj.bComment.model.dao;

import java.io.*;
import java.sql.*;
import java.util.*;

import static com.common.JDBCTemplate.*;

import com.mj.bComment.model.vo.BComment;

public class BCommentDAO {
	private Properties prop;
	
	public BCommentDAO() {
		prop = new Properties();
		
		String filePath = BCommentDAO.class.getResource("/config/comment.properties").getPath();
		
		try {
			
			prop.load(new FileReader(filePath));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}

	public int insertComment(Connection con, BComment comment) {
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("insertComment");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, comment.getCommentContent());
			ps.setInt(2, comment.getcBoardNo());
			ps.setInt(3, comment.getmNo());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

	public int updateComment(Connection con, BComment bc) {
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("updateComment");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, bc.getCommentContent());
			ps.setInt(2, bc.getcBoardNo());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

	public int deleteComment(Connection con, int cno) {
		
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("deleteComment");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, cno);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			
			close(ps);
		}
	
		return result;
	}
	
	
	
	
	
	
	
	
	
	
}
