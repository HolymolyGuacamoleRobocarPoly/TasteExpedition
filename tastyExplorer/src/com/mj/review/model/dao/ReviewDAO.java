package com.mj.review.model.dao;

import static com.common.JDBCTemplate.*;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mj.review.model.vo.Review;

public class ReviewDAO {
	
	private Properties prop;
	
	public ReviewDAO() {
		
		prop = new Properties();
		
		String filePath = Review.class
						  .getResource("/config/review.properties")
						  .getPath();
		
		try {
			prop.load(new FileReader(filePath));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public ArrayList<Review> selectList(Connection con) {
		ArrayList<Review> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectList");
		
try {
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			// 몇개 있는지 모르니 있는거 다 가져와라
			// 게시글은 몇개 있는지 모르니 while문 사용!
			// 로그인 회원가입은 if문을 썼었음
			while(rs.next()) {
				
				Review r = new Review();
				
				r.setrNo( rs.getInt("r_no") );
				r.setrContent( rs.getString("r_content"));
				r.setrLike(rs.getInt("r_Like"));
				r.setrUnLike(rs.getInt("r_Unlike"));
				// 닉네임이나 이름
				r.setrHashTag(rs.getString("r_hashtag"));
				// 아이디  데이터베이스의 컬럼이름과 자바의 변수이름이 같을 필요가 없다...?
				r.setrScore( rs.getInt("r_Score"));
				r.setrDate( rs.getDate("r_Date"));
				r.setmNo( rs.getInt("m_no"));
				r.setmRestaurantNo(rs.getInt("m_restaurant_no"));
				
				// 주어진 list에 하나하나씩 차곡차곡 다음
				list.add(r);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rs); // close도 위에 import static~을 해주어야 함
			close(ps);
		}
		
		return list;
	}

	public int insertReview(Connection con, Review r) {
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("insertReview");
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, r.getrContent());
			ps.setString(2, r.getrHashTag());
			ps.setInt(3, r.getrScore());
			ps.setInt(4, r.getmNo());
			ps.setInt(5, r.getmRestaurantNo());
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			
		} finally {
			
			close(ps);
			
		}
			
		return result;
	}

	public int getListCount(Connection con) {
		int result = 0;
		
		PreparedStatement ps = null;
		
		ResultSet rs = null;
		
		String sql = prop.getProperty("listCount");
		
		try {
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if (rs.next()) {
				result = rs.getInt(1);
				// column 의 수가 count 하나이기 때문에
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		return result;
	}

	public int deleteReview(Connection con, int rNo) {
		int result = 0;
		
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("deleteReview");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, rNo);

			result = ps.executeUpdate();
			
		} catch (SQLException e) {
		
			e.printStackTrace();
			
		} finally {
			
			close(ps);
			
		}
		
		return result;
	}


}
