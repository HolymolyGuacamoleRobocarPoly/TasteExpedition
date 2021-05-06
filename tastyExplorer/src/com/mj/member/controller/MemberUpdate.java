package com.mj.member.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.MyRenamePolicy;
import com.mj.common.model.service.AttachmentService;
import com.mj.common.model.vo.Attachment;
import com.mj.member.model.service.MemberService;
import com.mj.member.model.vo.Member;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class Member
 */
@WebServlet("/update.me")
public class MemberUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			
			String newPath = request.getServletContext()
	                 				.getRealPath("/resources/profile"); // 새로운 파일 경로

			

			String userPwd = mr.getParameter("userPwd");
			String email = mr.getParameter("email");
			String phone = mr.getParameter("tel1") + "-"
					     + mr.getParameter("tel2") + "-"
					     + mr.getParameter("tel3");
		
			String address = mr.getParameter("zipCode") + ", "
				           + mr.getParameter("address1") + ", "
				     	   + mr.getParameter("address2");
			
			String profile = mr.getFilesystemName("profile");
			
			
			// 파일 위치 이동
			File file = new File(savePath + "/" + profile);
			file.renameTo(new File(newPath + "/" + profile));
			
			
			// 해당 회원을 구분짓는 ID 받아오기
			HttpSession session = request.getSession(false);
			
			Member m = (Member)session.getAttribute("member");
			// 기존의 회원 정보를 새로운 값으로 변경하기
			m.setUserPwd(userPwd);
			m.setEmail(email);
			m.setPhone(phone);
			m.setAddress(address);
			m.setmProfileAtt(profile);

			System.out.println("변경한 회원 정보 확인 : " + m);
			
			MemberService service = new MemberService();
			
			int result = service.updateMember(m);

			
			if (result > 0) {
				
				// session.setAttribute("member", m);
				session.invalidate();
				
				response.sendRedirect("index.jsp");
			} else {
				
				request.setAttribute("error-msg", "회원 프로필 수정 실패");
				
				request.getRequestDispatcher("views/common/errorPage.jsp")
				       .forward(request, response);
				

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
