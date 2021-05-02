package com.mj.event.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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
		
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		String eNo = request.getParameter("eNo");
		String mNo = request.getParameter("mNo");
		String stringDate = request.getParameter("eDate");
		
		Date eDate = null;
		try {
			eDate = (Date) transFormat.parse(stringDate);
			
			System.out.println("eDuration : "+eDate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		
		EventMember em = new EventMember(eNo, mNo, eDate);
		
		EventMemberService service = new EventMemberService();
		
		int result = service.insertEventMember(em);
		
		if(result > 0) {
			response.sendRedirect("list.ev"); // EventList.java
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
