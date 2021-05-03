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
import com.mj.mRestaurant.model.vo.MRestaurant;

/**
 * Servlet implementation class MJUpdateView
 */
@WebServlet("/updateview.mj")
public class MJUpdateView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MJUpdateView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int mjNo = Integer.parseInt(request.getParameter("mjNo"));	// 식당 번호
		int fLevel = 7;
		
		// 수정할 식당 한개 정보
		MRestaurantService service = new MRestaurantService();
		MRestaurant mj = service.selectOne(mjNo);
		
		// 해당 식당 Attachment 불러오기 
		AttachmentService aService = new AttachmentService();
		ArrayList<Attachment> mjAttList = aService.selectList(mjNo, fLevel);
		
		String page = "";
		
		if ( mj != null ) {
			request.setAttribute("mj", mj);
			request.setAttribute("mjAttList", mjAttList);
			
			page = "views/mRestaurant/mRestaurantUpdate.jsp";
		} else {
			request.setAttribute("error-msg", "게시글 수정화면 접근 불가");
			
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
