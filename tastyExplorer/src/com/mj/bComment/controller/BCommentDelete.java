package com.mj.bComment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.bComment.model.service.BCommentService;

/**
 * Servlet implementation class BCommentDelete
 */
@WebServlet("/delete.bc")
public class BCommentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BCommentDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int cno = Integer.parseInt(request.getParameter("cno"));	// 삭제할 댓글 번호 
		
		int bno = Integer.parseInt(request.getParameter("bno"));	// 댓글이 달린 해당 게시글
		int btype = Integer.parseInt(request.getParameter("btype"));// 분류를 위한 게시글 type
		
		BCommentService service = new BCommentService();
		
		int result = service.deleteComment(cno);
		
		if( result > 0) {
			
			if(btype == 1) response.sendRedirect("selectOne.em?bno="+bno); 		// eventMember 로 연결
			else if(btype == 2) response.sendRedirect("selectOne.co?bno="+bno);	// community 로 연결
			
		} else {
			
			request.setAttribute("error-msg", "댓글 수정 실패");
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
