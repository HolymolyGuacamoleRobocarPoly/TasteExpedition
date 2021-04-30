package com.mj.member.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mj.member.model.vo.Coupon;

public class CouponDAO {
	
	private Properties prop;
	
	public CouponDAO() {
		prop = new Properties();
		
		String filePath = CouponDAO.class
						           .getResource("/config/Coupon.properties")
						           .getPath();
		
		try {
			prop.load(new FileReader(filePath));
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public int insertCoupon(Connection con, Coupon c) {
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("insertCoupon");
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, c.getcContent());
			ps.setString(2, c.getcTitle());

			
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

	public ArrayList<Coupon> selectList(Connection con, int currentPage) {
		ArrayList<Coupon> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectList");
		int startRow = (currentPage - 1) * 10 + 1;
		int endRow = currentPage * 10;
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, endRow);
			ps.setInt(2, startRow);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Coupon c = new Coupon();
				
				c.setcNo( rs.getInt("C_NO") );
				c.setcDuration( rs.getDate("C_DURATION"));
				c.setcDate(rs.getDate("C_DATE"));
				c.setcContent(rs.getString("C_CONTENT"));
				c.setcTitle( rs.getString("C_TITLE"));
				c.setcStatus( rs.getString("C_STATUS"));
				c.setmNo( rs.getInt("M_NO"));

				
				list.add(c);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		
		return list;
	}

	public int deleteCoupon(Connection con, int cNo) {
		int result = 0;
		
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("deleteCoupon");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, cNo);

			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			
			close(ps);
			
		}
		
		return result;
	}

}
