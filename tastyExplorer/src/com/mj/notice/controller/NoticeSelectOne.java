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
 * Servlet implementation class NoticeSelectOne
 */
@WebServlet("/selectOne.no")
public class NoticeSelectOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeSelectOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int nNo = Integer.parseInt(request.getParameter("nNo"));
		
		NoticeService service = new NoticeService();
		// 공지사항에는 댓글 안들어감
		
		Notice n = service.selectOne(nNo);
		
		String page = "";
		
		if ( n != null) {
			request.setAttribute("Notice", n);
			
			page = "views/notice/noticeDetail.jsp";
		} else {
			request.setAttribute("error-msg", "게시물 조회를 실패했습니다.");
			
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
