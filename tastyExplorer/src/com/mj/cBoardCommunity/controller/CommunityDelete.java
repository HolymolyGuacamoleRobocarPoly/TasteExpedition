package com.mj.cBoardCommunity.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.cBoardCommunity.model.service.CommunityService;

/**
 * Servlet implementation class CommunityDelete
 */
@WebServlet("/delete.co")
public class CommunityDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cboardno = Integer.parseInt(request.getParameter("cBoardNo"));
		
		// 게시판 번호 가져오는지 확인
		System.out.println("deletecboardno 확인 : " + cboardno);
		
		CommunityService service = new CommunityService();
		
		int result = service.deleteCommunityBoard(cboardno);
		
		System.out.println("삭제 : " + cboardno);
		
		
		if (result > 0) {
			response.sendRedirect("selectList.co");
			
		
		} else {
			request.setAttribute("error-msg", "게시글 삭제를 실패했습니다.");
			
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
