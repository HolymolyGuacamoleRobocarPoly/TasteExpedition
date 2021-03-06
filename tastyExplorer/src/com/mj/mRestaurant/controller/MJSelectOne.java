package com.mj.mRestaurant.controller;

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
import com.mj.mRestaurant.model.service.MenuService;
import com.mj.mRestaurant.model.vo.MRestaurant;
import com.mj.mRestaurant.model.vo.Menu;
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
		int mjFLevel = 7;
		int rvFlevel = 5;
		
		System.out.println("mjSelectOne mjNo : " + mjNo);
		
		// 조회한 식당 한개 정보
		MRestaurantService service = new MRestaurantService();
		MRestaurant mj = service.selectOne(mjNo);
		
		// 해당 식당의 리뷰 리스트 불러오기 
		ReviewService reviewService = new ReviewService();
		ArrayList<Review> rlist = reviewService.selectList(mjNo);
		
		// 해당 식당 Attachment 불러오기 
		AttachmentService aService = new AttachmentService();
		ArrayList<Attachment> mjAttList = aService.selectList(mjNo, mjFLevel);
		
		
		
		// 해당 식당의 리뷰 Attachment 불러오기
		AttachmentService rvAttService = new AttachmentService();
		
		
		
//		for (Review r : rlist) {
//			ArrayList<Attachment> reviewAttList = rvAttService.selectList(r.getrNo(), rvFlevel);
//			
//		}
		
		ArrayList<Attachment> reviewAttList = new ArrayList<>();
		
		for ( int i = 0; i < rlist.size(); i ++) {
			
			int rNo = rlist.get(i).getrNo();
			reviewAttList = rvAttService.selectList(rNo, rvFlevel);
			
			System.out.println("MJSelectOne :: rNo ::" + rNo);
		}
		
		
		
		
		// 해당 식당 MenuList 불러오기 
		MenuService mService = new MenuService();
		ArrayList<Menu> menuList = mService.selectList(mjNo);
		
		String page = "";
		
		System.out.println("mj 결과 확인 ::: " + mj);
		System.out.println("rlist 결과 확인 ::: " + rlist);
		System.out.println("mjAttList 결과 확인 ::: " + mjAttList);
		System.out.println("reviewAttList 결과 확인 ::: " + reviewAttList);
		System.out.println("menuList 결과 확인 ::: " + menuList);
		
		
		if( mj != null ) {
			
			request.setAttribute("mj", mj);
			request.setAttribute("rlist", rlist);
			request.setAttribute("mjAttList", mjAttList);
			request.setAttribute("reviewAttList", reviewAttList);
			request.setAttribute("menuList", menuList);
			
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
