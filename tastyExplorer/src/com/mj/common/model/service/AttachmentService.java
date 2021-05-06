package com.mj.common.model.service;

import static com.common.JDBCTemplate.*;


import java.sql.Connection;
import java.util.ArrayList;
import java.util.HashMap;

import com.mj.common.model.dao.AttachmentDAO;
import com.mj.common.model.vo.Attachment;
import com.mj.member.model.vo.Member;
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
	

	public Attachment selectOne(int mjNo, int fLevel) {
		con = getConnection();
		
		Attachment a = dao.selectOne(con, mjNo, fLevel);
		
		close(con);
		
		return a;
	}
	

	public int deleteAttachmentDelete(int attBNo, int fLevel) {
		con = getConnection();
		String realAttBNo = "";
		
		if (fLevel == 4) {
			realAttBNo = "E" + attBNo;
		} else if (fLevel == 5) {
			realAttBNo = "R" + attBNo;
		} else if (fLevel == 6) {
			realAttBNo = "CM" + attBNo;
		} else if (fLevel == 7) {
			realAttBNo = "MJ" + attBNo;
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
		
		int bNo = 0;
		int result = 0;
		String name = "";

			bNo = dao.getCurrentNo(con, fLevel);
			
		if (fLevel == 4) {
			name = "E";  // 이벤트 첨부파일
		} else if (fLevel == 5) {
			name = "R";  // 리뷰 사진
		} else if (fLevel == 6) {
			name = "CM"; // 커뮤니티 첨부파일
		} else if (fLevel == 7) {
			name = "MJ"; // 맛집 소개 사진
		} else if (fLevel == 8) {
			name = "MP"; // 회원 프로필
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


	public Attachment eventSelectList(int bNo, int fLevel) {
		con = getConnection();
		
		Attachment a = dao.eventSelectList(con, bNo, fLevel);
		
		close(con);
		
		return a;
	}


	public int insertProfile(Attachment a, Member m, int fLevel) {
		con = getConnection();
		int result = 0;
		result = dao.insertProfile(con, m, a, fLevel);
		
		close(con);
		
		return result;
	}


}