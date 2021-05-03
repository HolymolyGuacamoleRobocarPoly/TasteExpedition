package com.mj.common.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.common.model.service.AttachmentService;
import com.mj.common.model.vo.Attachment;

/**
 * Servlet implementation class AttachmentRestaurantSelectOne
 */
@WebServlet("/selectOne.mjAtt")
public class AttachmentRestaurantSelectOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttachmentRestaurantSelectOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mjNo = Integer.parseInt(request.getParameter("mRestaurantNo"));
		int fLevel = Integer.parseInt(request.getParameter("fLevel"));
		
		ArrayList<Attachment> attList = new ArrayList<>();
		
		AttachmentService service = new AttachmentService();
		
		attList = service.selectOne(mjNo, fLevel);
		// 각각의 영역 안에서 import 를 해야하는 지?
		
		request.setAttribute("attList", attList);
		
		request.getRequestDispatcher("views/index.jsp")
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
