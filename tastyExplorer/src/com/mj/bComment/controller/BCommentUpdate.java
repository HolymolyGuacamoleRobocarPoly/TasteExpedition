package com.mj.bComment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.bComment.model.service.BCommentService;
import com.mj.bComment.model.vo.BComment;

/**
 * Servlet implementation class BCommentUpdate
 */
@WebServlet("/update.bc")
public class BCommentUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BCommentUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int cno = Integer.parseInt(request.getParameter("commentNo"));	// 수정할 댓글 번호		
		String content = request.getParameter("commentContent");			// 수정할 내용 받아온 값 
			
		int bno = Integer.parseInt(request.getParameter("cboardno"));	// 해당 댓글이 달린 게시글 번호
		int btype = Integer.parseInt(request.getParameter("btype"));// 해당 댓글이 달린 게시글의 타입
		
		 
		
		BComment bc = new BComment();		
		bc.setCommentNo(cno);			
		bc.setCommentContent(content);
		
		
		BCommentService service = new BCommentService();
		int result = service.updateComment(bc);
		
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
