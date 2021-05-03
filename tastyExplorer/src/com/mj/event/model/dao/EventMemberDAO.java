package com.mj.event.model.dao;

import static com.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.mj.event.model.vo.EventAdmin;
import com.mj.event.model.vo.EventMember;

public class EventMemberDAO {
	private Properties prop;
	
	public EventMemberDAO() {
		prop = new Properties();
		
		String filePath 
			= EventMemberDAO.class
					  	   .getResource("/config/event.properties")
					  	   .getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	public int insertEventMember(Connection con, EventMember em) {
		int result = 0;
		PreparedStatement ps = null;
		String sql = prop.getProperty("insertEventMember");
		
		try {
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, em.geteNo());
			ps.setInt(2, em.getmNo());

			result = ps.executeUpdate();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		} finally {
			close(ps);
		}
		
		return result;
	}

// 마이페이지 접근 -> 마이페이지 메뉴버튼(내가 참여한 이벤트 접근)
	// 메뉴 버튼을 누를때 hidden으로 mNO 보내고

	public ArrayList<EventAdmin> selectList(Connection con, int mNo) {
	
		ArrayList<EventAdmin> list = new ArrayList<>();
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		String sql = prop.getProperty("selectListMember");
	
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, mNo);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				
				EventAdmin ea = new EventAdmin();
				
				ea.seteNo( rs.getInt("E_NO") );
				ea.seteTitle( rs.getString("E_TITLE"));
				ea.seteContent(rs.getString("E_CONTENT"));
				ea.seteDuration(rs.getDate("E_DURATION"));

				list.add(ea);
			}
			
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			close(rs);
			close(ps);
		}
		System.out.println("멤버list불러오기" + list);
		return list;
	}

}
