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
 * Servlet implementation class CommunityUpdate
 */
@WebServlet("/update.co")
public class CommunityUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String savePath = request.getServletContext()
		          .getRealPath("/resources/CommunityUploadFiles");

		int maxSize = 1024 * 1024 * 10; 

		if(! ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("error-msg", "멀티파트 전송이 아닙니다.");
	
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		MultipartRequest mr = new MultipartRequest(request, savePath, maxSize,
				   "UTF-8", new DefaultFileRenamePolicy());
		
		// 수정할 정보 
		int cboardno = Integer.parseInt(mr.getParameter("cboardno"));
		String cboardtitle = mr.getParameter("cboardtitle");
		String cboardcontent = mr.getParameter("cboardcontent");
		
		
		// 수정 전 원본
		CommunityService service = new CommunityService();
		
		Community c = service.selectOne(cboardno);
		
		c.setcBoardTitle(cboardtitle);
		c.setcBoardContent(cboardcontent);
		
		int result = service.updateCommunityBoard(c);
		
		if ( result > 0) {
			response.sendRedirect("selectList.co");
		} else {
			request.setAttribute("error-msg", "게시글 수정 실패!");
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
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
