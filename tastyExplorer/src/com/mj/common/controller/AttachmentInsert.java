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
import com.mj.cBoardCommunity.model.vo.Comunity;
import com.mj.common.model.vo.Attachment;
import com.mj.event.model.vo.EventAdmin;
import com.mj.mRestaurant.model.vo.Ticket;
import com.mj.notice.model.vo.Notice;
import com.mj.review.model.vo.Review;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class cBoardInsert
 */
@WebServlet("/insert.att")
public class AttachmentInsert extends HttpServlet {
	private static final long serialVersionUID = 1211L;
       
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
		
		// multipart 로 전송된 것인지 확인하기
		if(! ServletFileUpload.isMultipartContent(request)) {
			
			request.setAttribute("error-msg", "multipart 전송이 아닙니다.");
			
			request.getRequestDispatcher("views/common/errorPage.jsp")
			       .forward(request, response);
		} else {
			// MultipartRequest
			// 파일 저장 경로
			
			String savePath = request.getServletContext()
					          .getRealPath("/resources/temp");
			
			// 파일 허용 용량
			// 1024Byte -> 1KB --> 1024KB --> 1MB
			int maxSize = 1024 * 1024 * 100;
			// 100MB => 보통 4k 화질 사진 1장 80MB
			
			// MultipartRequest 작성
			
			MultipartRequest mr = new MultipartRequest(request, savePath, maxSize, 
					"UTF-8", new MyRenamePolicy());
			
			String newPath = ""; // 새로운 파일 경로
			String fLevel = mr.getParameter("attMFlevel");
			String filename = mr.getFilesystemName("attFile");
			
			if( fLevel.equals("1")) { // 쿠폰 생성
				
				Coupon c = new Coupon();
				Attachment a = new Attachment();
				
				newPath = request.getServletContext()
				                 .getRealPath("/resources/coupon");
				
				c.setcTitle(mr.getParameter("cTitle"));
				c.setcContent(mr.getParameter("cContent"));
				
				a.setAttMFileName(filename);
				a.setAttMFlevel(flevel);
				
				System.out.println("확인 : " + c.getcTitle() + ", " + c.getcContent() + ", " 
											 + a.setAttMFileName(filename));
				

				// 파일 원하는 위치로 이동
				File file = new File(savePath + "/" + fileName);
				file.renameTo(new File(newPath + "/" + fileName));
				
				CouponService cService = new CouponService();
				AttachmentService aService = new AttachmentService();
				
				int result1 = cService.insertCoupon(a);
				
				if (result1 > 0) {
				
					int result2 = aService.insertCouponAttachment(a);
					
				} else {
					
					
					request.setAttribute("error-msg",  "쿠폰 내용 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
					
				}
				
				if (result2 > 0) {
					
					response.sendRedirect("?");
					
				} else {
					// 게시글 등록 실패시 저장되었던 파일 삭제
					for (int i = 0; i < changeNames.size(); i++) {
						
						new File(newPath + "/" + changeNames.get(i)).delete();
						
					}
					
					request.setAttribute("error-msg",  "리뷰 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
				}
				
				
				
			} else if ( fLevel.equals("2")) { // 티켓 생성
				
				Ticket t = new Ticket();
				Attachment a = new Attachment();

				t.setTTitle(mr.getParameter("tTitle"));
				t.setTContent(mr.getParameter("tContent"));
				
				a.setAttMFileName(filename);
				a.setAttMFlevel(flevel);
				
				newPath = request.getServletContext()
				                 .getRealPath("/resources/ticket");
				
				System.out.println("확인 : " + t.gettTitle() + ", " + t.gettContent() + ", " + t.getmNo);

				
				TicketService tService = new TicketService();
				
				AttachmentService aService = new AttachmentService();
				
				int result1 = tService.insertTeview(t);
				
				if (result1 > 0) {
				
					int result2 = aService.insertTicketAttachment(a);
					
				} else {
					
					
					request.setAttribute("error-msg",  "리뷰 글 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
					
				}
				
				if (result2 > 0) {
					response.sendRedirect("?");
				} else {
					// 게시글 등록 실패시 저장되었던 파일 삭제
					for (int i = 0; i < changeNames.size(); i++) {
						
						new File(newPath + "/" + changeNames.get(i)).delete();
						
					}
					
					request.setAttribute("error-msg",  "리뷰 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
				}
				
				
			} else if ( fLevel.equals("3")) { // 공지사항
				
				Notice n = new Notice();
				Attachment a = new Attachment();

				n.setNTitle(mr.getParameter("nTitle"));
				n.setNContent(mr.getParameter("nContent"));
				newPath = request.getServletContext()
				                 .getRealPath("/resources/notice");
				
				System.out.println("확인 : " + n.getnTitle() + ", " + n.getnContent());
				
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
				
				NoticeService eService = new NoticeService();
				
				AttachmentService aService = new AttachmentService();
				
				int result1 = nService.insertNotice(n);
				
				if (result1 > 0) {
				
					int result2 = aService.insertNoticeAttachment(a);
					
				} else {
					
					
					request.setAttribute("error-msg",  "리뷰 글 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
					
				}
				
				if (result2 > 0) {
					response.sendRedirect("?");
				} else {
					// 게시글 등록 실패시 저장되었던 파일 삭제
					for (int i = 0; i < changeNames.size(); i++) {
						
						new File(newPath + "/" + changeNames.get(i)).delete();
						
					}
					
					request.setAttribute("error-msg",  "리뷰 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
				}
				
				
				
				
			} else if ( fLevel.equals("4")) { // 이벤트
			
				EventAdmin e = new EventAdmin();
				Attachment a = new Attachment();

				String eTitle = mr.getParameter("eTitle");
				String eContent = mr.getParameter("eContent");
				newPath = request.getServletContext()
				                 .getRealPath("/resources/event");
				
				System.out.println("확인 : " + e.geteTitle() + ", " + e.geteComment());
				
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
				
				e.setAttList(list);
				
				EventAdminService eService = new EventAdminService();
				
				AttachmentService aService = new AttachmentService();
				
				int result1 = eService.insertEventBoard(e);
				
				if (result1 > 0) {
				
					int result2 = aService.insertEventAttachment(a);
					
				} else {
					
					
					request.setAttribute("error-msg",  "리뷰 글 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
					
				}
				
				if (result2 > 0) {
					response.sendRedirect("?");
				} else {
					// 게시글 등록 실패시 저장되었던 파일 삭제
					for (int i = 0; i < changeNames.size(); i++) {
						
						new File(newPath + "/" + changeNames.get(i)).delete();
						
					}
					
					request.setAttribute("error-msg",  "리뷰 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
				}
				
				
				
			} else if ( fLevel.equals("5")) { // 리뷰
				
				Review r = new Review();
				Attachment a = new Attachment();

				String rContent = mr.getParameter("rContent");
				String hashTag = mr.getParameter("hashTag");
				String score = mr.getParameter("score");
				String mNo = mr.getParameter("mNo");
				newPath = request.getServletContext()
						         .getRealPath("/resources/review");
				
				System.out.println("확인 : " + r.getrContent() + ", 해쉬태그 : (" + r.getrHashTag() + "), " 
											 + r.getrScore() + ", " + r.getmNo());
				
				r.setrContent(rContent);
				r.setrHashTag(hashTag);
				r.setrScore(score);
				r.setmNo(mNo);
				
				ArrayList<String> changeNames = new ArrayList<>();
				Enumeration<String> tagNames = mr.getFileNames();

				while (tagNames.hasMoreElements()) {
					// 파일 name 속성을 하나씩 추출하여 해당 파일의 이름을 가져온다.
					
					String tagName = tagNames.nextElement();
					fileName = mr.getFilesystemName(tagName);
					
					changeNames.add(fileName);
					// 파일 원하는 위치로 이동
					File file = new File(savePath + "/" + fileName);
					file.renameTo(new File(newPath + "/" + fileName));
					
				}
				
				ArrayList<Attachment> list = new ArrayList<Attachment>();
				
				for (int i = changeNames.size() - 1; i >= 0; i--) {

					a.setAttMFileName(changeNames.get(i));
					
					list.add(a);
				}
				
				a.setAttList(list);
				
				ReviewService rService = new ReviewService();
				
				AttachmentService aService = new AttachmentService();
				
				int result1 = rService.insertReview(r);
				
				if (result1 > 0) {
				
					int result2 = aService.insertReviewAttachment(a);
					
				} else {
					
					
					request.setAttribute("error-msg",  "리뷰 글 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
					
				}
				
				if (result2 > 0) {
					response.sendRedirect("?");
				} else {
					// 게시글 등록 실패시 저장되었던 파일 삭제
					for (int i = 0; i < changeNames.size(); i++) {
						
						new File(newPath + "/" + changeNames.get(i)).delete();
						
					}
					
					request.setAttribute("error-msg",  "리뷰 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
				}
				
				
				
			} else if ( fLevel.equals("6")) { // 커뮤니티
				
				Community b = new Community();
				Attachment a = new Attachment();

				String cBoardTitle = mr.getParameter("cBoardTitle");
				String cBoardContent = mr.getParameter("cBoardNo");
				String mNo = mr.getParameter("mNo");
				newPath = request.getServletContext()
				         		 .getRealPath("/resources/community");
				
				System.out.println("확인 : " + c.getcBoardTitle() 
											 + ", " + c.getcBoardContent() + ", " + c.getmNo());

				while (tagNames.hasMoreElements()) {
					// 파일 name 속성을 하나씩 추출하여 해당 파일의 이름을 가져온다.
					
					String tagName = tagNames.nextElement();
					
					changeNames.add(mr.getFilesystemName(tagName));
					
				}
				
				ArrayList<Attachment> list = new ArrayList<Attachment>();
				
				
				for (int i = changeNames.size() - 1; i >= 0; i--) {

					a.setAttMFileName(changeNames.get(i));
					
					list.add(a);
				}
				
				c.setAttList(list);
				
				ComunityService bService = new ComunityService();
				
				AttachmentService aService = new AttachmentService();
				
				int result1 = cService.insertBoard(b);
				
				if (result1 > 0) {
				
					int result2 = aService.insertBoardAttachment(a);
					
				} else {
					
					
					request.setAttribute("error-msg",  "리뷰 글 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
					
				}
				
				if (result2 > 0) {
					response.sendRedirect("?");
				} else {
					// 게시글 등록 실패시 저장되었던 파일 삭제
					for (int i = 0; i < changeNames.size(); i++) {
						
						new File(newPath + "/" + changeNames.get(i)).delete();
						
					}
					
					request.setAttribute("error-msg",  "리뷰 등록 실패!");
					
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
