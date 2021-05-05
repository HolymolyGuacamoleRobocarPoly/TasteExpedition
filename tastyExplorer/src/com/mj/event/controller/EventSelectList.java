package com.mj.event.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.common.model.service.AttachmentService;
import com.mj.common.model.vo.Attachment;
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
		Attachment a = new Attachment();
		ArrayList<Attachment> resultSet = new ArrayList();
		AttachmentService aService = new AttachmentService();
		
		int fLevel = 4;
		
		int result = 0;
		
		list = service.selectList();
		
		for (int i = 0; i < list.size(); i++ ) {
			result = list.get(i).geteNo();
			a = aService.eventSelectList(result, fLevel);
			resultSet.add(a);
		}
		
	
		
		
		System.out.println("list가 잘 왔나 : " + list);
		System.out.println("att가 잘 왔나" + resultSet);
		request.setAttribute("elist", list);
		request.setAttribute("alist", resultSet);

		
		RequestDispatcher view =
				request.getRequestDispatcher("views/event/eventList.jsp");
	
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
