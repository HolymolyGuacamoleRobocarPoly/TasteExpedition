package com.mj.event.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.event.model.service.EventAdminService;
import com.mj.event.model.vo.EventAdmin;
import com.mj.mRestaurant.model.vo.MRestaurant;

/**
 * Servlet implementation class EventSelectOne
 */
@WebServlet("/selectOne.ev")
public class EventSelectOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EventSelectOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int eNo = Integer.parseInt(request.getParameter("eNo"));
		
		EventAdminService eService = new EventAdminService();
			
		EventAdmin ev = eService.selectOne(eNo);

		String page ="";
		
		if( ev != null ) {
			
			request.setAttribute("event", ev);
			// request.setAttribute("rlist", rlist);
			
			page = "views/event/eventDetail.jsp";
			
		} else {
			
			request.setAttribute("error-msg", "이벤트 조회 실패");
			
			page = "views/common/errorPage.jsp";
			
		}
		
		request.getRequestDispatcher(page).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}