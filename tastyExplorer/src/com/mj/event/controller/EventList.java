package com.mj.event.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.event.model.service.EventAdminService;
import com.mj.event.model.service.EventMemberService;
import com.mj.event.model.vo.EventAdmin;
import com.mj.event.model.vo.EventMember;

/**
 * Servlet implementation class EventList
 */
@WebServlet("/list.ev")
public class EventList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// EventInsert에서 mNo를 보냈는데 못가져옴
		// 에러 -> 질문하기
		int mNo = Integer.parseInt(request.getParameter("mNo"));
		System.out.println("list에 mNo" + mNo);
		ArrayList<EventAdmin> list = new ArrayList<>(); 
		EventMemberService service = new EventMemberService();
		
		list = service.selectList(mNo);
			
		request.setAttribute("elist", list);

		RequestDispatcher view =
				request.getRequestDispatcher("views/member/mypage1.jsp"); // 마이페이지 경로, 마이페이지 jsp에서 for문
	
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
