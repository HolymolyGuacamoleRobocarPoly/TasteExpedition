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
 * Servlet implementation class AttachmentSelectList
 */
@WebServlet("/selectList.att")
public class AttachmentSelectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttachmentSelectList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int bNo = Integer.parseInt(request.getParameter("Att_M_no"));
		int fLevel = Integer.parseInt(request.getParameter("fLevel"));
		String path = "";
		
		ArrayList<Attachment> attList = new ArrayList<>();
		
		AttachmentService service = new AttachmentService();
		
		attList = service.selectList(bNo, fLevel);
		
		request.setAttribute("attList", attList);

		
		if (fLevel == 3) {
			path = "notice/noticeDetail.jsp";
		} else if (fLevel == 4) {
			path = "event/eventDetail.jsp";
		} else if (fLevel == 5) {
			path = "mRestaurant/mRestaurantDetail.jsp";
		} else if (fLevel == 6) {
			path = "cBoardCommunity/communityDetail.jsp";
		} else if (fLevel == 7) {
			path = "mRestaurant/mRestaurantDetail.jsp";
		}
			
		request.getRequestDispatcher("views/" + path)
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
