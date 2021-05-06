package com.mj.event.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mj.event.model.service.EventAdminService;
import com.mj.event.model.service.EventMemberService;
import com.mj.event.model.vo.EventAdmin;
import com.mj.member.model.vo.Member;

/**
 * Servlet implementation class EventHistory
 */
@WebServlet("/select.eh")
public class EventHistory extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventHistory() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		
		Member m = (Member)session.getAttribute("member");
		int mNo = m.getmNo();
		EventMemberService service = new EventMemberService();
		ArrayList<EventAdmin> list = new ArrayList<>(); 
		
		list = service.selectList(mNo);
		
		request.setAttribute("elist", list);
		request.getRequestDispatcher("views/member/mypage1.jsp")
		       .forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
