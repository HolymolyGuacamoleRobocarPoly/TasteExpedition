package com.mj.event.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.common.model.vo.PageInfo;
import com.mj.event.model.service.EventAdminService;
import com.mj.event.model.vo.EventAdmin;

/**
 * Servlet implementation class EventSelectList
 */
@WebServlet("/selectList.ev")
public class EventSelectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventSelectList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 게시판 목록 처리하는 변수
		ArrayList<EventAdmin> list = new ArrayList<>(); 
		EventAdminService service = new EventAdminService();
		
		// 10개 씩 자르기 위한 변수들
		int startPage;
		int endPage;
		int maxPage;
		int currentPage;
		int limit = 10;
		currentPage = 1;
		
		// 만약 사용자가 다른 페이지 번호에서 들어온다면
		if (request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		// 총 게시글 확인
		int listCount = service.getListCount();
		
		maxPage = (int)(((double)listCount)/10 + 0.9);
		// 따라서 0.9를 더하기 해준다.
		
		// 한 번에 보일 페이지 수
		// 시작 페이지 
		startPage = (int)(((double)currentPage)/10 + 0.9 -1) * limit + 1;
		
		// 끝 페이지
		// endPage = startPage + limit - 1;
		endPage = startPage + 9;
		
		// 만약 최종 페이지가 끝페이지보다 작다면
		if (maxPage < endPage) {
			endPage = maxPage; 
			// 15페이지 까지라고 한다면 15페이지 까지만
		}
		
		// ---------------------- 페이지 처리 끝! --------------------- //
		
		
		list = service.selectList(currentPage);
		
		// System.out.println("list : " + list);
		
		request.setAttribute("list", list);
		PageInfo pi = new PageInfo(startPage, endPage, maxPage,
								   currentPage, limit, listCount);
		request.setAttribute("pi", pi);
		
		RequestDispatcher view =
				request.getRequestDispatcher("views/board/boardList.jsp");
		
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
