package com.mj.common.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.MyRenamePolicy;
import com.mj.cBoardCommunity.model.service.CommunityService;
import com.mj.cBoardCommunity.model.vo.Community;
import com.mj.common.model.service.AttachmentService;
import com.mj.common.model.vo.Attachment;
import com.mj.event.model.service.EventAdminService;
import com.mj.event.model.vo.EventAdmin;
import com.mj.mRestaurant.model.service.MRestaurantService;
import com.mj.mRestaurant.model.vo.MRestaurant;
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

//			
//			if (fLevel == 1) { // 쿠폰 생성
//				
//				Coupon c = new Coupon();
//				Attachment a = new Attachment();
//				ArrayList<String> changeNames = new ArrayList<>();
//				Enumeration<String> tagNames = mr.getFileNames();
//				
//				newPath = request.getServletContext()
//				                 .getRealPath("/resources/coupon");
//				
//				c.setcTitle(mr.getParameter("cTitle"));
//				c.setcContent(mr.getParameter("cContent"));
//				
//				System.out.println("확인 : " + c.getcTitle() + ", " + c.getcContent() + ", " 
//											 + a.getAttMFileName() + ", " + a.getAttMFlevel());
//				
//				while (tagNames.hasMoreElements()) {
//					// 파일 name 속성을 하나씩 추출하여 해당 파일의 이름을 가져온다.
//					
//					String tagName = tagNames.nextElement();
//					
//					changeNames.add(tagName);
//					
//				}
//				
//				ArrayList<Attachment> list = new ArrayList<Attachment>();
//				
//				for (int i = changeNames.size() - 1; i >= 0; i--) {
//					Attachment add = new Attachment();
//					add.setAttMFileName(changeNames.get(i));
//					
//					// 파일 원하는 위치로 이동
//					File file = new File(savePath + "/" + changeNames.get(i));
//					file.renameTo(new File(newPath + "/" + changeNames.get(i)));
//					
//					list.add(add);
//					// System.out.println("for 문 : " + list);
//				}
//				
//				a.setAttList(list);
//				
//				CouponService cService = new CouponService();
//				AttachmentService aService = new AttachmentService();
//				
//				int result1 = cService.insertCoupon(c);
//				int result2 = 0;
//				
//				if (result1 > 0) {
//				
//					result2 = aService.insertAttachment(a, fLevel);
//					
//				} else {
//					
//					
//					request.setAttribute("error-msg",  "쿠폰 내용 등록 실패!");
//					
//					request.getRequestDispatcher("views/common/errorPage.jsp")
//						   .forward(request, response);
//					
//				}
//				
//				if (result2 > 0) {
//					
//					response.sendRedirect("index.jsp");
//					
//				} else {
//					// 게시글 등록 실패시 저장되었던 파일 삭제
//					for (int i = 0; i < changeNames.size(); i++) {
//						
//						new File(newPath + "/" + changeNames.get(i)).delete();
//										
//						request.setAttribute("error-msg",  "쿠폰 등록 실패!");
//					
//						request.getRequestDispatcher("views/common/errorPage.jsp")
//						       .forward(request, response);
//					}
//					// 게시글 삭제는 어떻게 해야할까?
//					// delete 메소드에서 return 으로 해당 bNo 값을  
//					
//				}
//				
//			} else if (fLevel == 2) { // 티켓 생성
//				
//				Ticket t = new Ticket();
//				Attachment a = new Attachment();
//				ArrayList<String> changeNames = new ArrayList<>();
//				Enumeration<String> tagNames = mr.getFileNames();
//
//				t.settTitle(mr.getParameter("tTitle"));
//				t.settContent(mr.getParameter("tContent"));
//
//				newPath = request.getServletContext()
//				                 .getRealPath("/resources/ticket");
//				
//				System.out.println("확인 : " + t.gettTitle() + ", " + t.gettContent() + ", " + t.getmNo());
//
//				
//				while (tagNames.hasMoreElements()) {
//					// 파일 name 속성을 하나씩 추출하여 해당 파일의 이름을 가져온다.
//					
//					String tagName = tagNames.nextElement();
//					
//					changeNames.add(tagName);
//					
//				}
//				
//				ArrayList<Attachment> list = new ArrayList<Attachment>();
//				
//				for (int i = changeNames.size() - 1; i >= 0; i--) {
//					Attachment add = new Attachment();
//					add.setAttMFileName(changeNames.get(i));
//					
//					// 파일 원하는 위치로 이동
//					File file = new File(savePath + "/" + changeNames.get(i));
//					file.renameTo(new File(newPath + "/" + changeNames.get(i)));
//					
//					list.add(add);
//					// System.out.println("for 문 : " + list);
//				}
//				
//				a.setAttList(list);
//				
//				TicketService tService = new TicketService();
//				
//				AttachmentService aService = new AttachmentService();
//				
//				int result1 = tService.insertTicket(t);
//				int result2 = 0;
//				
//				if (result1 > 0) {
//				
//					result2 = aService.insertAttachment(a, fLevel);
//					
//				} else {
//					
//					
//					request.setAttribute("error-msg",  "티켓 내용 등록 실패!");
//					
//					request.getRequestDispatcher("views/common/errorPage.jsp")
//						   .forward(request, response);
//					
//				}
//				
//				if (result2 > 0) {
//					response.sendRedirect("index.jsp");
//				} else {
//					// 게시글 등록 실패시 저장되었던 파일 삭제
//					for (int i = 0; i < changeNames.size(); i++) {
//						
//						new File(newPath + "/" + changeNames.get(i)).delete();
//						
//					}
//					
//					request.setAttribute("error-msg",  "티켓 등록 실패!");
//					
//					request.getRequestDispatcher("views/common/errorPage.jsp")
//						   .forward(request, response);
//				}
//				
//				
			if (fLevel == 3) { // 공지사항
				
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
					Attachment add = new Attachment();
					add.setAttMFileName(changeNames.get(i));
					
					// 파일 원하는 위치로 이동
					File file = new File(savePath + "/" + changeNames.get(i));
					file.renameTo(new File(newPath + "/" + changeNames.get(i)));
					
					list.add(add);
					// System.out.println("for 문 : " + list);
				}
				
				a.setAttList(list);
				
				NoticeService nService = new NoticeService();
				
				AttachmentService aService = new AttachmentService();
				
				int result1 = nService.insertNotice(n);
				int result2 = 0;
				
				if (result1 > 0) {
				
					result2 = aService.insertAttachment(a, fLevel);
					
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
			
				// Date sql? java.util? 해결 안됨 => 해결 완료 => 해결 안됨
				EventAdmin e = new EventAdmin();
				Attachment a = new Attachment();
				ArrayList<String> changeNames = new ArrayList<>();
				Enumeration<String> tagNames = mr.getFileNames();
				SimpleDateFormat sFormat = new SimpleDateFormat("yyyyMMdd");
				
				String eTitle = mr.getParameter("eTitle");
				String eContent = mr.getParameter("eContent");
				String stringDate = mr.getParameter("eDuration");
				System.out.println("stringDate : " + stringDate);
				try {
					System.out.println("parse Date : " + sFormat.parse(stringDate));
				} catch (ParseException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				Date eDuration = null;
				
				/*
				SimpleDateFormat startFormat = new SimpleDateFormat("yyyy-MM-dd");
				SimpleDateFormat endFormat = new SimpleDateFormat("yyyy-MM-dd");
				
				String [] eDurationArray = stringDate.split("~");
				Date eDurationStart = (Date) startFormat.parse(eDurationArray[1]);
				Date eDurationEnd = (Date) endFormat.parse(eDurationArray[1]);
				*/
				
				java.util.Date uFormat = new java.util.Date();
				System.out.println("uFormat : " + uFormat);
				try {
					uFormat = sFormat.parse(stringDate);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				System.out.println("변경된 uFormat : " + uFormat);
				eDuration = new java.sql.Date(uFormat.getTime());
				
				e.seteTitle(eTitle);
				e.seteContent(eContent);
				e.seteDuration(eDuration);
				
				/*
				try {
					eDuration = new java.sql.Date(uFormat.getTime());
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				*/
				newPath = request.getServletContext()
				                 .getRealPath("/resources/event");
				
				System.out.println("확인 : " + e.geteTitle() + ", " + e.geteContent() + e.geteDuration());
				
				while (tagNames.hasMoreElements()) {
					// 파일 name 속성을 하나씩 추출하여 해당 파일의 이름을 가져온다.
					
					String tagName = tagNames.nextElement();
					
					changeNames.add(mr.getFilesystemName(tagName));
					
				}
				
				ArrayList<Attachment> list = new ArrayList<Attachment>();
				
				
				for (int i = changeNames.size() - 1; i >= 0; i--) {
					Attachment add = new Attachment();
					add.setAttMFileName(changeNames.get(i));
					
					// 파일 원하는 위치로 이동
					File file = new File(savePath + "/" + changeNames.get(i));
					file.renameTo(new File(newPath + "/" + changeNames.get(i)));
					
					list.add(add);
					// System.out.println("for 문 : " + list);
				}
				
				a.setAttList(list);
				
				EventAdminService eService = new EventAdminService();
				
				AttachmentService aService = new AttachmentService();
				
				int result1 = eService.insertEventBoard(e); // 작성 내용 결과
				int result2 = 0; 							// 첨부 파일 결과
				
				if (result1 > 0) {
				
					result2 = aService.insertAttachment(a, fLevel);
					
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
				Enumeration<String> tagNames = mr.getFileNames();  // 태그 이름들 
				
				String rContent = mr.getParameter("rContent");
				String rHashTag = mr.getParameter("rHashTag");
				int rScore = Integer.parseInt(mr.getParameter("rScore"));
				int mNo = Integer.parseInt(mr.getParameter("mNo"));
				int mjNo =Integer.parseInt(mr.getParameter("mRestaurantNo")); 
				
				newPath = request.getServletContext()
						         .getRealPath("/resources/review");
				
				System.out.println("확인 : " + rContent + ", 해쉬태그 : (" + rHashTag + "), " 
											 + rScore + ", " + mNo + mjNo);
				
				r.setrContent(rContent);
				r.setrHashTag(rHashTag);
				r.setrScore(rScore);
				r.setmNo(mNo);
				r.setmRestaurantNo(mjNo);

				while (tagNames.hasMoreElements()) {
					// 파일 name 속성을 하나씩 추출하여 해당 파일의 이름을 가져온다.
					
					String tagName = tagNames.nextElement();
					
					changeNames.add(mr.getFilesystemName(tagName)); // 실제 변경된 파일이름
					System.out.println(tagName + " : " + mr.getFilesystemName(tagName));

				}
				
				ArrayList<Attachment> list = new ArrayList<Attachment>();
				
				for (int i = changeNames.size() - 1; i >= 0; i--) {
					Attachment add = new Attachment();
					add.setAttMFileName(changeNames.get(i));
					
					// 파일 원하는 위치로 이동
					File file = new File(savePath + "/" + changeNames.get(i));
					file.renameTo(new File(newPath + "/" + changeNames.get(i)));
					
					list.add(add);
					// System.out.println("for 문 : " + list);
				}
				
				a.setAttList(list);
				
				ReviewService rService = new ReviewService();
				
				AttachmentService aService = new AttachmentService();
				
				int result1 = rService.insertReview(r);
				int result2 = 0;
				
				if (result1 > 0) {
				
					result2 = aService.insertAttachment(a, fLevel);
					
				} else {
					
					
					request.setAttribute("error-msg",  "리뷰 글 등록 실패!");
					
					request.getRequestDispatcher("views/common/errorPage.jsp")
						   .forward(request, response);
					
				}
				
				if (result2 > 0) {
					response.sendRedirect("views/mRestaurant/mRestaurantDetail.jsp");
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
					Attachment add = new Attachment();
					add.setAttMFileName(changeNames.get(i));
					
					// 파일 원하는 위치로 이동
					File file = new File(savePath + "/" + changeNames.get(i));
					file.renameTo(new File(newPath + "/" + changeNames.get(i)));
					
					list.add(add);
					// System.out.println("for 문 : " + list);
				}
				
				a.setAttList(list);
				
				CommunityService bService = new CommunityService();
				
				AttachmentService aService = new AttachmentService();
				
				int result1 = bService.insertCommunity(b);
				int result2 = 0;
				
				if (result1 > 0) {
				
					result2 = aService.insertAttachment(a, fLevel);
					
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
				
				
			} else if (fLevel == 7) {
				
				MRestaurant mj = new MRestaurant();
				Attachment a = new Attachment();
				ArrayList<String> changeNames = new ArrayList<>();
				Enumeration<String> tagNames = mr.getFileNames();
				
				// 식당 요청자 정보 받아오기 => 필요한가?
				int mNo = Integer.parseInt(mr.getParameter("mNo"));
				
				// 식당 정보 받아오기 
				String mjTitle = mr.getParameter("mjName");						// 식당 이름
				String mjContent = mr.getParameter("mjContent"); 				// 식당 소개
				String mjAddress = request.getParameter("zipCode") + ", "		// 식당 주소 
						   		 + request.getParameter("address1") + ", "
						   		 + request.getParameter("address2");
				// 식당 편의시설 받아오기 
				String mjInfo = String.join(", ", request.getParameterValues("Convenience"));
				int mjLevel = Integer.parseInt(request.getParameter("mjLevel"));// 식당 분류
				String mjTel = mr.getParameter("tel");							// 식당 전화번호
				String openTime = mr.getParameter("openTime");					// 식당 영업시간
				String brTime = mr.getParameter("brTime");						// 식당 브레이크 타임
				String holiday = mr.getParameter("holiday");					// 식당 휴무일 
				

				mj.setmRestaurantTitle(mjTitle);
				mj.setmRestaurantContent(mjContent);
				mj.setmRestaurantAdrress(mjAddress);
				mj.setmRestaurantInfo(mjInfo);
				mj.setmRestaurantLevel(mjLevel);
				mj.setmRestaurantTel(mjTel);
				mj.setOpenTime(openTime);
				mj.setBrTime(brTime);
				mj.setHoliday(holiday);
				
				System.out.println("mj.toString : " + mj.toString());
				
				while (tagNames.hasMoreElements()) {
					// 파일 name 속성을 하나씩 추출하여 해당 파일의 이름을 가져온다.
					
					String tagName = tagNames.nextElement();
					
					changeNames.add(mr.getFilesystemName(tagName)); // 실제 변경된 파일이름
					System.out.println(tagName + " : " + mr.getFilesystemName(tagName));

				}
				
				ArrayList<Attachment> list = new ArrayList<Attachment>();
				
				for (int i = changeNames.size() - 1; i >= 0; i--) {
					Attachment add = new Attachment();
					add.setAttMFileName(changeNames.get(i));
					
					// 파일 원하는 위치로 이동
					File file = new File(savePath + "/" + changeNames.get(i));
					file.renameTo(new File(newPath + "/" + changeNames.get(i)));
					
					list.add(add);
					// System.out.println("for 문 : " + list);
				}
				
				a.setAttList(list);
				
				MRestaurantService mjService = new MRestaurantService();
				
				AttachmentService aService = new AttachmentService();
				
				int result1 = mjService.insertMRestaurant(mj);
				int result2 = 0;
				
				if (result1 > 0) {
				
					result2 = aService.insertAttachment(a, fLevel);
					
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
