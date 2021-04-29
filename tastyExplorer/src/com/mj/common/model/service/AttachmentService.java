package com.mj.common.model.service;

import static com.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;

import com.mj.common.model.dao.AttachmentDAO;
import com.mj.common.model.vo.Attachment;
import com.mj.review.model.vo.Review;

public class AttachmentService {

	private Connection con;
	private AttachmentDAO dao = new AttachmentDAO();
	
	public ArrayList<Attachment> selectList() {
		
		con = getConnection();
		
		ArrayList<Attachment> list = dao.selectList(con);
		
		close(con);
		
		return list;
	}
	
	public int insertReveiwAttachment(Attachment a) {
		
		con = getConnection();
		ArrayList<Attachment> list = a.getAttList();

		int result = 0;

		
		int rNo = dao.getCurrentRNo(con);
		
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setAttBNo('r'+ parseString(rNo));
		}
		
		// 4개 이하로 올릴 수도 있으므로 
		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) != null &&
					list.get(i).getAttMFileName() != null) {
				// 해당 파일이 null 이 아니거나
				// 파일 이름이 null 이 아닐 때
				// => 파일을 알맞게 추가했다면
				
				result = dao.insertAttachment(con, list.get(i));
				if(result == 0) break; 
				// 중간에 잘못 처리된 첨부 파일이 있다면 반복 중지 
			} else {
				result = 1; // 정상으로 변경
			}
		}
		
		if (result > 0) {
			commit(con);
			result = 1;
		} else {
			rollback(con);
		}
		
		close(con);
		
		return result;
		
	}

	private String parseString(int i) {
		// TODO Auto-generated method stub
		return null;
	}
	
}