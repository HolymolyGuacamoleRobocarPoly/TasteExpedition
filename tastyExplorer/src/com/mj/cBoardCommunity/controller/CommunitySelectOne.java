package com.mj.cBoardCommunity.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.bComment.model.service.BCommentService;
import com.mj.bComment.model.vo.BComment;
import com.mj.cBoardCommunity.model.service.CommunityService;
import com.mj.cBoardCommunity.model.vo.Community;
import com.mj.common.model.service.AttachmentService;
import com.mj.common.model.vo.Attachment;

/**
 * Servlet implementation class CommunitySelectOne
 */
@WebServlet("/selectOne.co")
public class CommunitySelectOne extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunitySelectOne() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//조회
		int cboardno = Integer.parseInt(request.getParameter("cboardno"));
		int fLevel = 6;
		
		System.out.println("cboardno ::::::::::::::::::"+cboardno);
		
	
		// 게시글 서비스 객체 생성
		CommunityService service = new CommunityService();
		
		// 댓글 조회
		BCommentService commentService = new BCommentService();
		
		// 게시글 조회서비스 시작
		Community c = service.selectOne(cboardno);
		
		// 댓글 리스트
		ArrayList<BComment> clist = commentService.selectList(cboardno);
		
		// 커뮤니티 파일ATT 불러오기
		AttachmentService aService = new AttachmentService();
		ArrayList<Attachment> cAttList = aService.selectList(cboardno, fLevel);
		
		System.out.println("communityselect cboardno : " + cboardno);
		String page = "";
		
		
		System.out.println("communityselect c : " + c);
		System.out.println("communityselectOne clist :::: " + clist);
		System.out.println("communityselect cAttList : " + cAttList);
		
		if (c != null) {
			request.setAttribute("Community", c);
			request.setAttribute("clist", clist);
			request.setAttribute("cAttList", cAttList);
			
			page = "views/cBoardCommunity/communityDetail.jsp";
			
			//System.out.println(page);
			
		} else {
			request.setAttribute("error-msg",  "게시물 조회 실패");
			
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
