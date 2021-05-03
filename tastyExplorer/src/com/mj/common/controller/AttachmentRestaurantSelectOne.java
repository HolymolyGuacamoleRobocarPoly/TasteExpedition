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
		// mjNo 를 bNo로, request.getParameter("mRestaurantNo)); 값을 bNo로
		// fLevel 과 복합키처럼 사용 가능?
		// => 이벤트도 대표 이미지 표시가 필요하다.
		/*
		 	int bNo = Integer.parseInt(request.getParameter("bNo")); // Name 을 전부 bNo 통일
			int fLevel = Integer.parseInt(request.getParameter("fLevel")); // fLevel 로 구분
			String path = "";
		 */
		
		ArrayList<Attachment> selectOne = new ArrayList<>();
		
		AttachmentService service = new AttachmentService();
		
		selectOne = service.selectOne(mjNo, fLevel);
		
		request.setAttribute("selectOne", selectOne);
		

		// if 문을 통해서 경로를 재지정 => AttachmentSelectList 와 같은 형식으로
		/*
		if (fLevel == 4) {
			path = "views/event/eventSelectList.jsp";
		} else if (fLevel == 7) {
			path = "index.jsp";
		*/
		request.getRequestDispatcher("index.jsp") 

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
