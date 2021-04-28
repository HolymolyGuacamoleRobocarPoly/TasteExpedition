package com.mj.member.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import com.mj.member.model.vo.Coupon;

import static com.common.JDBCTemplate.*;

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

}
