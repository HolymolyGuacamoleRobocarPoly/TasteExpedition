package com.mj.common.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.MyRenamePolicy;
import com.common.EncodingFilter;
import com.mj.cBoardCommunity.model.service.CommunityService;
import com.mj.cBoardCommunity.model.vo.Community;
import com.mj.common.model.service.AttachmentService;
import com.mj.common.model.vo.Attachment;
import com.mj.event.model.service.EventAdminService;
import com.mj.event.model.vo.EventAdmin;
import com.mj.mRestaurant.model.service.TicketService;
import com.mj.mRestaurant.model.vo.Ticket;
import com.mj.member.model.service.CouponService;
import com.mj.member.model.vo.Coupon;
import com.mj.notice.model.service.NoticeService;
import com.mj.notice.model.vo.Notice;
import com.mj.review.model.service.ReviewService;
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
			int fLevel = Integer.parseInt(mr.getParameter("attMFlevel"));

			
			if (fLevel == 1) { // 쿠폰 생성
				
				Coupon c = new Coupon();
				Attachment a = new Attachment();
				ArrayList<String> changeNames = new ArrayList<>();
				Enumeration<String> tagNames = mr.getFileNames();
				
				newPath = request.getServletContext()
				                 .getRealPath("/resources/coupon");
				
				c.setcTitle(mr.getParameter("cTitle"));
				c.setcContent(mr.getParameter("cContent"));
				
				System.out.println("확인 : " + c.getcTitle() + ", " + c.getcContent() + ", " 
											 + a.getAttMFileName() + ", " + a.getAttMFlevel());
				
				while (tagNames.hasMoreElements()) {
					// 파일 name 속성을 하나씩 추출하여 해당 파일의 이름을 가져온다.
					
					String tagName = tagNames.nextElement();
					
					changeNames.add(tagName);
					// 파일 원하는 위치로 이동
					File file = new File(savePath + "/" + changeNames);
					file.renameTo(new File(newPath + "/" + changeNames));
					
				}
				
				ArrayList<Attachment> list = new ArrayList<Attachment>();
				
				for (int i = changeNames.size() - 1; i >= 0; i--) {
					
					a.setAttMFileName(changeNames.get(i));
					
					list.add(a);
				}
				
				a.setAttList(list);
				
				CouponService cService = new CouponService();
				AttachmentService aService = new AttachmentService();
				
				int result1 = cService.insertCoupon(c);
				int result2 = 0;
				
				if (result1 > 0) {
				
					result2 = aService.insertCouponAttachment(a);
					
				} else {
					
					
					request.setAttribute("error-msg",  "쿠폰 내용 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
					
				}
				
				if (result2 > 0) {
					
					response.sendRedirect("index.jsp");
					
				} else {
					// 게시글 등록 실패시 저장되었던 파일 삭제
					for (int i = 0; i < changeNames.size(); i++) {
						
						new File(newPath + "/" + changeNames.get(i)).delete();
										
						request.setAttribute("error-msg",  "쿠폰 등록 실패!");
					
						request.getRequestDispatcher("views/common/errorPage.jsp")
						       .forward(request, response);
					}
				
				}
				
			} else if (fLevel == 2) { // 티켓 생성
				
				Ticket t = new Ticket();
				Attachment a = new Attachment();
				ArrayList<String> changeNames = new ArrayList<>();
				Enumeration<String> tagNames = mr.getFileNames();

				t.settTitle(mr.getParameter("tTitle"));
				t.settContent(mr.getParameter("tContent"));

				newPath = request.getServletContext()
				                 .getRealPath("/resources/ticket");
				
				System.out.println("확인 : " + t.gettTitle() + ", " + t.gettContent() + ", " + t.getmNo());

				
				while (tagNames.hasMoreElements()) {
					// 파일 name 속성을 하나씩 추출하여 해당 파일의 이름을 가져온다.
					
					String tagName = tagNames.nextElement();
					
					changeNames.add(tagName);
					// 파일 원하는 위치로 이동
					File file = new File(savePath + "/" + changeNames);
					file.renameTo(new File(newPath + "/" + changeNames));
					
				}
				
				ArrayList<Attachment> list = new ArrayList<Attachment>();
				
				for (int i = changeNames.size() - 1; i >= 0; i--) {
					
					a.setAttMFileName(changeNames.get(i));
					
					list.add(a);
				}
				
				a.setAttList(list);
				
				TicketService tService = new TicketService();
				
				AttachmentService aService = new AttachmentService();
				
				int result1 = tService.insertTicket(t);
				int result2 = 0;
				
				if (result1 > 0) {
				
					result2 = aService.insertTicketAttachment(a);
					
				} else {
					
					
					request.setAttribute("error-msg",  "티켓 내용 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
					
				}
				
				if (result2 > 0) {
					response.sendRedirect("index.jsp");
				} else {
					// 게시글 등록 실패시 저장되었던 파일 삭제
					for (int i = 0; i < changeNames.size(); i++) {
						
						new File(newPath + "/" + changeNames.get(i)).delete();
						
					}
					
					request.setAttribute("error-msg",  "티켓 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
				}
				
				
			} else if (fLevel == 3) { // 공지사항
				
				Notice n = new Notice();
				Attachment a = new Attachment();
				ArrayList<String> changeNames = new ArrayList<>();
				Enumeration<String> tagNames = mr.getFileNames();

				n.setnTitle(mr.getParameter("nTitle"));
				n.setnContent(mr.getParameter("nContent"));
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

					a.setAttMFileName(changeNames.get(i));
					
					list.add(a);
				}
				
				a.setAttList(list);
				
				NoticeService nService = new NoticeService();
				
				AttachmentService aService = new AttachmentService();
				
				int result1 = nService.insertNotice(n);
				int result2 = 0;
				
				if (result1 > 0) {
				
					result2 = aService.insertNoticeAttachment(a);
					
				} else {
					
					
					request.setAttribute("error-msg",  "공지사항 글 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
					
				}
				
				if (result2 > 0) {
					response.sendRedirect("index.jsp");
				} else {
					// 게시글 등록 실패시 저장되었던 파일 삭제
					for (int i = 0; i < changeNames.size(); i++) {
						
						new File(newPath + "/" + changeNames.get(i)).delete();
						
					}
					
					request.setAttribute("error-msg",  "공지사항 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
				}
				
				
				
				
			} else if (fLevel == 4) { // 이벤트
			
				EventAdmin e = new EventAdmin();
				Attachment a = new Attachment();
				ArrayList<String> changeNames = new ArrayList<>();
				Enumeration<String> tagNames = mr.getFileNames();

				String eTitle = mr.getParameter("eTitle");
				String eContent = mr.getParameter("eContent");
				String eDuration = mr.getParameter("eDuration");
				
				newPath = request.getServletContext()
				                 .getRealPath("/resources/event");
				
				System.out.println("확인 : " + eTitle + ", " + eContent + ", " + eDuration );
				
				e.seteTitle(eTitle);
				e.seteContent(eContent);
				
			
				
				
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
				
				a.setAttList(list);
				
				EventAdminService eService = new EventAdminService();
				
				AttachmentService aService = new AttachmentService();
				
				int result1 = eService.insertEventBoard(e);
				int result2 = 0;
				
				if (result1 > 0) {
				
					result2 = aService.insertEventAttachment(a);
					
				} else {
					
					
					request.setAttribute("error-msg",  "이벤트 글 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
					
				}
				
				if (result2 > 0) {
					response.sendRedirect("index.jsp");
				} else {
					// 게시글 등록 실패시 저장되었던 파일 삭제
					for (int i = 0; i < changeNames.size(); i++) {
						
						new File(newPath + "/" + changeNames.get(i)).delete();
						
					}
					
					request.setAttribute("error-msg",  "이벤트 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
				}
				
				
				
			} else if (fLevel == 5) { // 리뷰
				
				Review r = new Review();
				Attachment a = new Attachment();
				ArrayList<String> changeNames = new ArrayList<>();
				Enumeration<String> tagNames = mr.getFileNames();
				
				String rContent = mr.getParameter("rContent");
				String rHashTag = mr.getParameter("rHashTag");
				int rScore = Integer.parseInt(mr.getParameter("rScore"));
				int mNo = Integer.parseInt(mr.getParameter("mNo"));
				int mRestaurantNo = Integer.parseInt(mr.getParameter("mRestaurantNo"));
				newPath = request.getServletContext()
						         .getRealPath("/resources/review");
				
				System.out.println("확인 : " + rContent + ", 해쉬태그 : (" + rHashTag + "), " 
											 + rScore + ", " + mNo + ", " + mRestaurantNo);
				
				r.setrContent(rContent);
				r.setrHashTag(rHashTag);
				r.setrScore(rScore);
				r.setmNo(mNo);
				r.setmRestaurantNo(mRestaurantNo);
				
				
				
				while (tagNames.hasMoreElements()) {
					// 파일 name 속성을 하나씩 추출하여 해당 파일의 이름을 가져온다.
					
					String tagName = tagNames.nextElement();
					
					changeNames.add(tagName);
					// 파일 원하는 위치로 이동
					File file = new File(savePath + "/" + changeNames);
					file.renameTo(new File(newPath + "/" + changeNames));
					
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
				int result2 = 0;
				
				if (result1 > 0) {
				
					result2 = aService.insertReviewAttachment(a);
					
				} else {
					
					
					request.setAttribute("error-msg",  "리뷰 글 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
					
				}
				
				if (result2 > 0) {
					response.sendRedirect("index.jsp");
				} else {
					// 게시글 등록 실패시 저장되었던 파일 삭제
					for (int i = 0; i < changeNames.size(); i++) {
						
						new File(newPath + "/" + changeNames.get(i)).delete();
						
					}
					
					request.setAttribute("error-msg",  "리뷰 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
				}
				
				
				
			} else if (fLevel == 6) { // 커뮤니티
				
				Community b = new Community();
				Attachment a = new Attachment();
				ArrayList<String> changeNames = new ArrayList<>();
				Enumeration<String> tagNames = mr.getFileNames();

				String cBoardTitle = mr.getParameter("cBoardTitle");
				String cBoardContent = mr.getParameter("cBoardNo");
				String mNickname = mr.getParameter("mNickname");
				newPath = request.getServletContext()
				         		 .getRealPath("/resources/community");
				
				System.out.println("확인 : " + b.getcBoardTitle() 
											 + ", " + b.getcBoardContent() + ", " + b.getmNickname());

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
				
				a.setAttList(list);
				
				CommunityService bService = new CommunityService();
				
				AttachmentService aService = new AttachmentService();
				
				int result1 = bService.insertCommunity(b);
				int result2 = 0;
				
				if (result1 > 0) {
				
					result2 = aService.insertCommunityAttachment(a);
					
				} else {
					
					
					request.setAttribute("error-msg",  "게시글 내용 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
					
				}
				
				if (result2 > 0) {
					response.sendRedirect("index.jsp");
				} else {
					// 게시글 등록 실패시 저장되었던 파일 삭제
					for (int i = 0; i < changeNames.size(); i++) {
						
						new File(newPath + "/" + changeNames.get(i)).delete();
						
					}
					
					request.setAttribute("error-msg",  "게시글 등록 실패!");
					
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
