package com.mj.cBoardCommunity.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.cBoardCommunity.model.service.CommunityService;
import com.mj.cBoardCommunity.model.vo.Community;
import com.mj.cBoardCommunity.model.vo.PageInfo;


/**
 * Servlet implementation class CommunityService
 */
@WebServlet("/selectList.co")
public class CommunitySelectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunitySelectList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 게시판처리
		ArrayList<Community> list = new ArrayList<>();
		CommunityService service = new CommunityService();
		
		// 10개씩 짜름
		int startPage;
		
		int endPage;
		
		int maxPage;
		
		int currentPage;
		
		int limit = 10;
		
		currentPage = 1;
		
		if (request.getParameter("currentPage") != null ) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));

		}
		
		// 총게시글 
		int listCount = service.getListCount();
		
		// 최대 페이지수
		maxPage = (int)((double)listCount/10 + 0.9);
		
		// 시작 페이지
		startPage = (int)(((double)currentPage/10 + 0.9) - 1) * limit + 1;
		
		// 끝 페이지
		endPage = startPage + 9;
		
		if( maxPage < endPage) {
			endPage = maxPage;
		}
		
		list = service.selectList(currentPage);
		
		request.setAttribute("list", list);
		PageInfo pi = new PageInfo(startPage, endPage, maxPage, currentPage, limit, listCount);
	
		request.setAttribute("pi", pi);
		
		//System.out.println(pi);

		RequestDispatcher view =
				request.getRequestDispatcher("/tastyServer/views/cBoardCommunity/communityList.jsp");
		
		view.forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
