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
			ps.setInt(2, bc.getCommentNo());
			
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

	public ArrayList<BComment> selectList(Connection con, int cboardno) {
		ArrayList<BComment> clist = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = prop.getProperty("selectList");
		
		try {
			ps = con.prepareStatement(sql);
			
			// cboard 번호 가져오기
			ps.setInt(1, cboardno);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				BComment bco = new BComment();
		
				bco.setCommentNo(   rs.getInt("COMMENT_NO") );
				bco.setCommentContent( rs.getString("COMMENT_CONTENT"));
				bco.setCommentDate( rs.getDate("COMMENT_DATE"));
				bco.setcBoardNo(rs.getInt("C_BOARD_NO"));
				bco.setmNo(rs.getInt("M_NO"));
				
				System.out.println("cdao bco : " + bco);
				clist.add(bco);				
			}
			// clist를 여기서 아예 못가져오는데 쿼리문제?..db에서는 조회가 잘됨
			System.out.println("cdao clist : " + clist);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}		
		
		return clist;
		
	}
	
	
	
	
	
	
	
	
	
	
}
