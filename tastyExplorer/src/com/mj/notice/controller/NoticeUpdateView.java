package com.mj.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.notice.model.service.NoticeService;
import com.mj.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeUpdateView
 */
@WebServlet("/updateView.no")
public class NoticeUpdateView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeUpdateView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nNo = Integer.parseInt(request.getParameter("nNo"));
		
		NoticeService service = new NoticeService();
		
		Notice n = service.updateView(nNo);
		
		String page = "";
		
		if (n != null) {
			request.setAttribute("Notice", n);
			
			page ="views/noitce/noticeUpdate.jsp";
		} else {
			
			request.setAttribute("error-msg", "게시글 수정화면을 접근할 수 없습니다.");
			
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
