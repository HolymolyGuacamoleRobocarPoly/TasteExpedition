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

	public ArrayList<Review> selectList(Connection con, int currentPage) {
		// TODO Auto-generated method stub
		return null;
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
