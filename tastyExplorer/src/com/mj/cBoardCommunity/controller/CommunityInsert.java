package com.mj.cBoardCommunity.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.mj.bComment.model.service.BCommentService;
import com.mj.bComment.model.vo.BComment;
import com.mj.cBoardCommunity.model.service.CommunityService;
import com.mj.cBoardCommunity.model.vo.Community;
import com.mj.common.model.service.AttachmentService;
import com.mj.common.model.vo.Attachment;

/**
 * Servlet implementation class CommunityInsert
 */
@WebServlet("/insert.co")
public class CommunityInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommunityInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 파일저장 경로 
		String savePath = request.getServletContext().getRealPath("/resources/temp");
		
		int maxSize = 1024 * 1024* 10;
		
		if(! ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("error-msg", "multipart 전송이 아닙니다.");
			
			request.getRequestDispatcher("views/common/errorPage.jsp")
			       .forward(request, response);
		}
		
		
		//조회
		int cboardno = Integer.parseInt(request.getParameter("cboardno"));
		int fLevel = 6;

		// 게시글
		CommunityService service = new CommunityService();
		Community c = service.selectOne(cboardno);
		
		// 댓글 리스트
		BCommentService commentService = new BCommentService();
		ArrayList<BComment> clist = commentService.selectList(cboardno);
		//System.out.println("cINset clist : " + clist );
		
		
		// 파일 리스트
		AttachmentService aService = new AttachmentService();
		ArrayList<Attachment> cAttList = aService.selectList(cboardno, fLevel);
		//System.out.println("cINset cAttList : " + cAttList );
		
		
		System.out.println("communityinsert c : " + c);
		System.out.println("communityinsert clist : " + clist);
		System.out.println("communityinsert cAttList : " + cAttList);
		
		
//		 5. 가져오기 (제목, 내용, 닉네임)
//		String title = mr.getParameter("ctitle");
//		String content = mr.getParameter("Ccontent");
//		String mNickname = mr.getParameter("nickName");
		
		//System.out.println("확인 : " +title + ", " + content + ", " + mNickname);
		
		//6. 함께 저장된 파일의 이름 추출하기
    	//String filename = mr.getFilesystemName("file");
    	
    	// 7. VO 작성하기
    	//Community c = new Community(title, content, mNickname);
    	
 
    	
    	
    	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
