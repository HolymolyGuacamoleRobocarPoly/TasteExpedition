package com.mj.mRestaurant.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.mRestaurant.model.service.MRestaurantService;

/**
 * Servlet implementation class MJDelete
 */
@WebServlet("/delete.mj")
public class MJDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MJDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int mjNo = Integer.parseInt(request.getParameter("mjNo"));
		
		MRestaurantService service = new MRestaurantService();
		
		int result = service.deleteMRestaurant(mjNo);
		
		if ( result > 0) {
			response.sendRedirect("selectList.mj");
		} else {
			request.setAttribute("error-msg", "맛집 삭제 실패");
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
				
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
