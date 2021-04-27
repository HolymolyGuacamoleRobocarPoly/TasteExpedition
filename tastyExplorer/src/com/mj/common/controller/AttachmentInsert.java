package com.mj.common.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.MyRenamePolicy;
import com.mj.common.model.vo.Attachment;
import com.mj.mRestaurant.model.vo.Ticket;
import com.mj.notice.model.vo.Notice;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class cBoardInsert
 */
@WebServlet("/insert.att")
public class AttachmentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttachmentInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 3. multipart 로 전송된 것인지 확인하기
		if(! ServletFileUpload.isMultipartContent(request)) {
			
			request.setAttribute("error-msg", "multipart 전송이 아닙니다.");
			
			request.getRequestDispatcher("views/common/errorPage.jsp")
			       .forward(request, response);
		} else {
			// MultipartRequest
			// 1. 파일 저장 경로
			
			String savePath = request.getServletContext()
					          .getRealPath("/resources/temp");
			
			// 2. 파일 허용 용량
			// 1024Byte -> 1KB --> 1024KB --> 1MB
			int maxSize = 1024 * 1024 * 100;
			// 100MB => 보통 4k 화질 사진 1장 80MB
			
			// 4. MultipartRequest 작성
			
			MultipartRequest mr = new MultipartRequest(request, savePath, maxSize, 
					"UTF-8", new MyRenamePolicy());
			
			String newPath = ""; // 새로운 파일 경로
			String fLevel = mr.getParameter("attMFlevel");
			ArrayList<String> changeNames = new ArrayList<>();
			Enumeration<String> tagNames = mr.getFileNames();
			
			if( fLevel.equals("1")) { // 쿠폰
				
				newPath = request.getServletContext()
				          .getRealPath("/resources/coupon");
				
			} else if ( fLevel.equals("2")) { // 티켓
				
				Ticket t = new Ticket();
				
				t.setTNo(mr.getParameter("tNo"));
				t.setTTitle(mr.getParameter("tTitle");
				t.setTContent(mr.getParameter("tContent"));
				t.setMNo(mr.getParameter("mNo"));
				
				newPath = request.getServletContext()
				          .getRealPath("/resources/ticket");
				
				System.out.println("확인 : " + t.setTNo + ", " + t.setTTitle + ", " + t.setTContent + ", " + t.setMNo);

				while (tagNames.hasMoreElements()) {
					// 파일 name 속성을 하나씩 추출하여 해당 파일의 이름을 가져온다.
					
					String tagName = tagNames.nextElement();
					String fileName = mr.getFilesystemName(tagName);
					
					changeNames.add( fileName );
					 // 파일 원하는 위치로 이동
					File file = new File(savePath + "/" + fileName);
					file.renameTo(new File(newPath + "/" + fileName));
					
				}
				
				ArrayList<Attachment> list = new ArrayList<Attachment>();
				
				
				for (int i = changeNames.size() - 1; i >= 0; i--) {
					
					Attachment a = new Attachment();
					
					a.setAttMFileName(changeNames.get(i));
					
					list.add(a);
				}
				
				t.setAttList(list);
				
				TicketService service = new TicketService();
				
				int result = service.insertFile();
				
				if (result > 0) {
					response.sendRedirect("?");
				} else {
					// 게시글 등록 실패시 저장되었던 파일 삭제
					for (int i = 0; i < changeNames.size(); i++) {
						
						new File(newPath + "/" + changeNames.get(i)).delete();
					}
					
					request.setAttribute("error-msg", "티켓 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
				}
				
			} else if ( fLevel.equals("3")) { // 공지사항
				
				Notice n = new Notice();
				
				n.setNNo(mr.getParameter("nNo"));
				n.setNTitle(mr.getParameter("nTitle"));
				n.setNContent(mr.getParameter("nContent"));
				newPath = request.getServletContext()
				          .getRealPath("/resources/notice");  /// 나머지 스스로
				
				System.out.println("확인 : " + nNo + ", " + nTitle + ", " + nContent);
				
				while (tagNames.hasMoreElements()) {
					// 파일 name 속성을 하나씩 추출하여 해당 파일의 이름을 가져온다.
					
					String tagName = tagNames.nextElement();
					
					changeNames.add(mr.getFilesystemName(tagName));
					
				}
				
				ArrayList<Attachment> list = new ArrayList<Attachment>();
				
				
				for (int i = changeNames.size() - 1; i >= 0; i--) {
					
					Attachment a = new Attachment();
					
					a.setAttMFileName(changeNames.get(i));
					
					list.add(a);
				}
				
				n.setAttList(list);
				
				NoticeService service = new NoticeService();
				
				int result = service.insertFile();
				
				if (result > 0) {
					response.sendRedirect("?");
				} else {
					// 게시글 등록 실패시 저장되었던 파일 삭제
					for (int i = 0; i < changeNames.size(); i++) {
						
						new File(newPath + "/" + changeNames.get(i)).delete();
						
					}
					
					request.setAttribute("error-msg", "공지사항 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
				}
				
				
			} else if ( fLevel.equals("4")) { // 이벤트
			
				String eNo = mr.getParameter("eNo");
				String eTitle = mr.getParameter("eTitle");
				String eContent = mr.getParameter("eContent");

				System.out.println("확인 : " + eNo + ", " + eTitle + ", " + eContent);

				while (tagNames.hasMoreElements()) {
					// 파일 name 속성을 하나씩 추출하여 해당 파일의 이름을 가져온다.
					
					String tagName = tagNames.nextElement();
					
					changeNames.add(mr.getFilesystemName(tagName));
					
				}
				
				ArrayList<Attachment> list = new ArrayList<Attachment>();
				
				
				for (int i = changeNames.size() - 1; i >= 0; i--) {
					
					Attachment a = new Attachment();
					
					a.setAttMFileName(changeNames.get(i));
					
					list.add(a);
				}
				
				.setAttList(list);
				
				?Service service = new ?Service();
				
				int result = service.insertFile();
				
				if (result > 0) {
					response.sendRedirect("?");
				} else {
					// 게시글 등록 실패시 저장되었던 파일 삭제
					for (int i = 0; i < changeNames.size(); i++) {
						
						new File(savePath + "/" + changeNames.get(i)).delete();
						
					}
					
					request.setAttribute("error-msg", "이벤트 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
				}
				
			} else if ( fLevel.equals("5")) { // 리뷰
				
				String rNo = mr.getParameter("rNo");
				String rContent = mr.getParameter("rContent");
				String hashTag = mr.getParameter("hashTag");
				String score = mr.getParameter("score");
				String mNo = mr.getParameter("mNo");
				
				System.out.println("확인 : " + rNo + ", " + rContent + ", " + hashTag + ", " + score + ", " + mNo);
				
				while (tagNames.hasMoreElements()) {
					// 파일 name 속성을 하나씩 추출하여 해당 파일의 이름을 가져온다.
					
					String tagName = tagNames.nextElement();
					
					changeNames.add(mr.getFilesystemName(tagName));
					
				}
				
				ArrayList<Attachment> list = new ArrayList<Attachment>();
				
				
				for (int i = changeNames.size() - 1; i >= 0; i--) {
					
					Attachment a = new Attachment();
					
					a.setAttMFileName(changeNames.get(i));
					
					list.add(a);
				}
				
				.setAttList(list);
				
				?Service service = new ?Service();
				
				int result = service.insertFile();
				
				if (result > 0) {
					response.sendRedirect("?");
				} else {
					// 게시글 등록 실패시 저장되었던 파일 삭제
					for (int i = 0; i < changeNames.size(); i++) {
						
						new File(savePath + "/" + changeNames.get(i)).delete();
						
					}
					
					request.setAttribute("error-msg", "리뷰 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
				}
				
				
				
			} else if ( fLevel.equals("6")) { // 커뮤니티
				
				String cBoardNo = mr.getParameter("cBoardNo");
				String cBoardTitle = mr.getParameter("cBoardTitle");
				String cBoardContent = mr.getParameter("cBoardNo");
				String mNo = mr.getParameter("mNo");
				
				System.out.println("확인 : " + cBoardNo + ", " + cBoardTitle + ", " + cBoardContent + ", " + mNo);

				while (tagNames.hasMoreElements()) {
					// 파일 name 속성을 하나씩 추출하여 해당 파일의 이름을 가져온다.
					
					String tagName = tagNames.nextElement();
					
					changeNames.add(mr.getFilesystemName(tagName));
					
				}
				
				ArrayList<Attachment> list = new ArrayList<Attachment>();
				
				
				for (int i = changeNames.size() - 1; i >= 0; i--) {
					
					Attachment a = new Attachment();
					
					a.setAttMFileName(changeNames.get(i));
					
					list.add(a);
				}
				
				.setAttList(list);
				
				?Service service = new ?Service();
				
				int result = service.insertFile();
				
				if (result > 0) {
					response.sendRedirect("?");
				} else {
					// 게시글 등록 실패시 저장되었던 파일 삭제
					for (int i = 0; i < changeNames.size(); i++) {
						
						new File(savePath + "/" + changeNames.get(i)).delete();
						
					}
					
					request.setAttribute("error-msg", "게시글 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
				}
				
			}
		}
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
