package com.mj.common.model.service;

import static com.common.JDBCTemplate.close;
import static com.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.ArrayList;

import com.mj.common.model.dao.AttachmentDAO;
import com.mj.common.model.vo.Attachment;

public class AttachmentService {

	private Connection con;
	private AttachmentDAO dao = new AttachmentDAO();
	
	public ArrayList<Attachment> selectList() {
		
		con = getConnection();
		
		ArrayList<Attachment> list = dao.selectList(con);
		
		close(con);
		
		return list;
	}
	
	
	
}
