package com.mj.common.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mj.common.model.vo.Attachment;

public class AttachmentDAO {

	private Properties prop;
	
	public AttachmentDAO() {
		prop = new Properties();
		
		// 210430_수정 Attachment -> attachment
		String filePath 
			= AttachmentDAO.class
						   .getResource("/config/attachment.properties")
					  	   .getPath();

		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	public ArrayList<Attachment> selectList(Connection con, int bNo, int fLevel) {
		ArrayList<Attachment> attList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectAttachment");
		String name = "";
		/*
		if (fLevel == 1) {
			sql = prop.getProperty("selectCouponAttachment");
			name = "cp";
		} else if (fLevel == 2) {
			sql = prop.getProperty("selectTicketAttachment");
			name = "t";
		} else 
		*/
		if (fLevel == 3) {
			name = "n";
		} else if (fLevel == 4) {
			name = "e";
		} else if (fLevel == 5) {
			name = "r";
		} else if (fLevel == 6) {
			name = "cm";
		} else if (fLevel == 7) {
			name = "mj";
		}

		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, name+bNo);
			
			rs = ps.executeQuery();
			
			while ( rs.next()) {
				Attachment a = new Attachment();
				
				a.setAttMNo(rs.getInt("ATT_M_NO"));          
				a.setAttMFileName(rs.getString("ATT_M_FILENAME"));
				a.setAttBNo(rs.getString("ATT_M_BNO"));
				
				attList.add(a);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return attList;

	}
	

	public ArrayList<Attachment> selectOne(Connection con, int bNo, int fLevel) {
		ArrayList<Attachment> attList = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectOneRestaurantAttachment");

		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, "mj"+bNo);
			
			rs = ps.executeQuery();
			
			while ( rs.next()) {
				Attachment a = new Attachment();
				
				a.setAttMNo(rs.getInt("ATT_M_NO"));          
				a.setAttMFileName(rs.getString("ATT_M_FILENAME"));
				a.setAttBNo(rs.getString("ATT_M_BNO"));
				
				attList.add(a);
				
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return attList;
	}

	
	public int insertAttachment(Connection con, Attachment attachment) {
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertAttachment");
		System.out.println("DAO 넘어 온 값 : " + attachment);
		try {
			ps = con.prepareStatement(sql);
		
			ps.setString(1, attachment.getAttMFileName());
			ps.setInt(2, attachment.getAttMFlevel());
			ps.setString(3, attachment.getAttBNo());

			
			result = ps.executeUpdate();
		} catch (SQLException e) {
			
			e.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

	public int deleteAttachment(Connection con, String attBNo) {
		
		int result = 0;
		PreparedStatement ps = null;
		
		String sql = prop.getProperty("deleteAttachment");
			
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, attBNo);
			
			result = ps.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		} finally {
			close(ps);
		}

		return result;
	}
	
	public int getCurrentNo(Connection con, int fLevel) {
		int result = 0;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("currentcmNo");
		/*
		if (fLevel == 1) {
			sql = prop.getProperty("currentCNo");
		} else if (fLevel == 2) {
			sql = prop.getProperty("currentTNo");
		} else 
		*/
		if (fLevel == 3) {
			sql = prop.getProperty("currentNNo");
		} else if (fLevel == 4) {
			sql = prop.getProperty("currentENo");
		} else if (fLevel == 5) {
			sql = prop.getProperty("currentRNo");
		} else if (fLevel == 6) {
			sql = prop.getProperty("currentcmNo");
		} else if (fLevel == 7) {
			sql = prop.getProperty("currentmjNo");
		}
		
		
		try {
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			if( rs.next()) {
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
