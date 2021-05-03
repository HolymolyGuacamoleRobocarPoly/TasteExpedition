package com.mj.event.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.event.model.service.EventMemberService;
import com.mj.event.model.vo.EventMember;

/**
 * Servlet implementation class EventInsert
 */
@WebServlet("/insert.ev")
public class EventInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int eNo = Integer.parseInt(request.getParameter("eNo"));
		int mNo = Integer.parseInt(request.getParameter("mNo"));
		System.out.println("eNo, " +eNo);
		System.out.println(" mNo" +mNo);

		EventMember em = new EventMember();
		
		em.seteNo(eNo);
		em.setmNo(mNo);

		EventMemberService service = new EventMemberService();
		
		int result = service.insertEventMember(em);
		
		
		
		if(result > 0) {
			
			// request.setAttribute("mNo",mNo);
			// 210503 질문 
			// 왜 get방식으로 해야 잘 전달되고 아래처럼 작성하면 왜 안되는지?
			// response.sendRedirect("list.ev"); // EventList.java
			response.sendRedirect("list.ev?mNo=" + mNo);
		} else {
			request.setAttribute("error-msg",  "이벤트 참여 실패");
			
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
