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
	
	public ArrayList<Attachment> selectList(int bNo, int fLevel) {
		
		con = getConnection();
		
		ArrayList<Attachment> list = dao.selectList(con, bNo, fLevel);
		
		close(con);
		
		return list;
	}
	

	public Attachment selectOne(int bNo, int fLevel) {
		con = getConnection();
		
		Attachment a = dao.selectOne(con, bNo, fLevel);
		
		close(con);
		
		return a;
	}
	

	public int deleteAttachmentDelete(int attBNo, int fLevel) {
		con = getConnection();
		String realAttBNo = "";
		/*
		if (fLevel == 1) {
			realAttBNo = "cp" + attBNo;
		} else if (fLevel == 2) {
			realAttBNo = "t" + attBNo;
		} else 
		*/
		if (fLevel == 3) {
			realAttBNo = "n" + attBNo;
		} else if (fLevel == 4) {
			realAttBNo = "e" + attBNo;
		} else if (fLevel == 5) {
			realAttBNo = "r" + attBNo;
		} else if (fLevel == 6) {
			realAttBNo = "cm" + attBNo;
		} else if (fLevel == 7) {
			realAttBNo = "mj" + attBNo;
		}
		
		int	result = dao.deleteAttachment(con, realAttBNo);
			
		
		if (result > 0) commit(con);
		else rollback(con);
	
		close(con);
		
		return result;
	}

	
	
	public int insertAttachment(Attachment a, int fLevel) {
		con = getConnection();
		ArrayList<Attachment> list = a.getAttList();

		int result = 0;
		
		int bNo = dao.getCurrentNo(con, fLevel);
		String name = "";
		/*
		if (fLevel == 1) {
			name = "cp";
		} else if (fLevel == 2) {
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
		
		for (int i = 0; i < list.size(); i++) {
			list.get(i).setAttBNo(name + String.valueOf(bNo));
			System.out.println("게시글 번호 반복문 : " + list.get(i).getAttBNo());
		}

		for (int i = 0; i < list.size(); i++) {
			if(list.get(i) != null &&
				list.get(i).getAttMFileName() != null) {
				// 해당 파일이 null 이 아니거나
				// 파일 이름이 null 이 아닐 때
				// => 파일을 알맞게 추가했다면
				System.out.println("Service => DAO : " + list.get(i));
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

}