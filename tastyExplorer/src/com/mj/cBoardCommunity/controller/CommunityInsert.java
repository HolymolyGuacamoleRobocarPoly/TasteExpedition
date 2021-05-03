package com.mj.cBoardCommunity.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.mj.cBoardCommunity.model.service.CommunityService;
import com.mj.cBoardCommunity.model.vo.Community;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class CommunityInsert
 */
@WebServlet("/insert.co")
public class CommunityInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String savePath = request.getServletContext().getRealPath("/resources/temp");
		
		int maxSize = 1024 * 1024* 10;
		
		if(! ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("error-msg", "multipart 전송이 아닙니다.");
			
			request.getRequestDispatcher("views/common/errorPage.jsp")
			       .forward(request, response);
		}
		
		//System.out.println(request);
		
		MultipartRequest mr = new MultipartRequest(request, savePath, maxSize, 
				   "UTF-8", new DefaultFileRenamePolicy());
		
		// 5. 전송값 처리
		String title = mr.getParameter("c_board_title");
		String content = mr.getParameter("c_board_content");
		String mNickname = mr.getParameter("m_nickname");
		
		System.out.println("확인 : " +title + ", " + content + ", " + mNickname);
		
		//6. 함께 저장된 파일의 이름 추출하기
    	String filename = mr.getFilesystemName("file");
    	
    	// 7. VO 작성하기
    	Community c = new Community(title, content, mNickname);
    	
    	// 8. 서비스 시작!
    	CommunityService service = new CommunityService();
    	
    	int result = service.insertCommunity(c);
    	
    	if( result > 0 ) {
    		response.sendRedirect("selectList.co");
    	} else {
    		request.setAttribute("error-msg", "게시글 작성 실패!");
    		
    		request.getRequestDispatcher("views/common/errorPage.jsp")
    		       .forward(request, response);
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
