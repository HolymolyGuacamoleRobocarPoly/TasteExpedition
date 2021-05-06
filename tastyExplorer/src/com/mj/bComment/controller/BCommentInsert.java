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
 * Servlet implementation class BoardCommentInsert
 */
@WebServlet("/insert.bc")
public class BCommentInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BCommentInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 작성자, 게시글 번호, 댓글 내용
		String content = request.getParameter("replyContent");			// comment 내용
		int bno = Integer.parseInt(request.getParameter("cboardno"));		// comment 작성된 게시글번호(event or community)
		int mNo = Integer.parseInt(request.getParameter("mNo"));	// comment 작성자 회원번호 ( mNo ) ( 연결하고 식별하기 위한 값)
		int btype = Integer.parseInt(request.getParameter("btype"));	// 1 이면 eventMember, 2 면 community(해당 jsp 에서 btype 설정)
		
		BComment comment = new BComment(content, bno, mNo);
		
		BCommentService service = new BCommentService();
		
		int result = service.insertComment(comment);
		
		if( result > 0) {
			
			if(btype == 1) response.sendRedirect("selectOne.em?bno="+bno); 		// eventMember 로 연결
			else if(btype == 2) response.sendRedirect("selectOne.co?cboardno="+bno);	// community 로 연결
			
			
			
		} else {
			request.setAttribute("error-msg", "댓글 작성중 에러 발생");
			
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
