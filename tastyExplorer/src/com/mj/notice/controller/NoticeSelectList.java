package com.mj.notice.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.cBoardCommunity.model.vo.Community;
import com.mj.cBoardCommunity.model.vo.PageInfo;
import com.mj.notice.model.service.NoticeService;
import com.mj.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeSelectList
 */
@WebServlet("/selectList.no")
public class NoticeSelectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSelectList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Notice> list = new ArrayList<>();
		NoticeService service = new NoticeService();
		
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
		
		System.out.println(pi);
		
		RequestDispatcher view =
				request.getRequestDispatcher("views/notice/noticeList.jsp");
		
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
