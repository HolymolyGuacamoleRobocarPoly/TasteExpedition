package com.mj.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.common.model.service.AttachmentService;
import com.mj.common.model.vo.Attachment;
import com.mj.mRestaurant.model.service.MRestaurantService;
import com.mj.mRestaurant.model.vo.MRestaurant;

/**
 * Servlet implementation class ReviewInsert
 */
@WebServlet("/insert.review")
public class ReviewInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int mjNo = Integer.parseInt(request.getParameter("mjNo"));
		int mjFLevel = 7;
		
		MRestaurantService service = new MRestaurantService();
		MRestaurant mj = service.selectOne(mjNo);
		
		AttachmentService aService = new AttachmentService();
		ArrayList<Attachment> mjAttList = aService.selectList(mjNo, mjFLevel);
		
		
		request.setAttribute("mj", mj);
		request.setAttribute("mjAttList", mjAttList);
		request.getRequestDispatcher("views/review/reviewWrite.jsp")
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
