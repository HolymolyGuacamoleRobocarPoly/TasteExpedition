package com.mj.review.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.common.model.vo.PageInfo;
import com.mj.member.model.vo.Coupon;
import com.mj.review.model.service.ReviewService;
import com.mj.review.model.vo.Review;

/**
 * Servlet implementation class ReviewSelectList
 */
@WebServlet("/selectList.rv")
public class ReviewList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 게시판 목록 처리하는 변수
		ArrayList<Review> list = new ArrayList<>(); 
		ReviewService service = new ReviewService();
		
	
		list = service.selectList();
		
		// System.out.println("list : " + list);
		System.out.println("rlist가 잘 왔나" +list);
		request.setAttribute("rlist", list);

		
		RequestDispatcher view =
				request.getRequestDispatcher("views/mRestaurant/mRestaurantDetail.jsp");
		
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
