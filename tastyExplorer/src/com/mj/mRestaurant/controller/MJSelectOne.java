package com.mj.mRestaurant.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.mRestaurant.model.service.MRestaurantService;
import com.mj.mRestaurant.model.vo.MRestaurant;
import com.mj.review.model.service.ReviewService;
import com.mj.review.model.vo.Review;

/**
 * Servlet implementation class MJSelectOne
 */
@WebServlet("/selectOne.mj")
public class MJSelectOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MJSelectOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 식당 번호
		int mjNo = Integer.parseInt(request.getParameter("mjNo"));
		
		MRestaurantService service = new MRestaurantService();
		 
		// 조회한 식당 한개 정보 
		MRestaurant mj = service.selectOne(mjNo);
		
		// 리뷰 조회 서비스 입력 
		ReviewService reviewService = new ReviewService();
		
		// 해당 식당의 리뷰 리스트 불러오기
		ArrayList<Review> rlist = reviewService.selectList(mjNo);
		
		String page = "";
		
		if( mj != null ) {
			
			request.setAttribute("mj", mj);
			request.setAttribute("rlist", rlist);
			
			page = "views/mRestaurant/mRestaurantDetail.jsp";
			
		} else {
			
			request.setAttribute("error-msg", "식당 조회 실패");
			
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
