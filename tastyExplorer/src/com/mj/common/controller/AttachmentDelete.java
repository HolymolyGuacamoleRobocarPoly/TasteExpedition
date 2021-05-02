package com.mj.common.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.common.model.service.AttachmentService;

/**
 * Servlet implementation class AttachmentDelete
 */
@WebServlet("/delete.att")
public class AttachmentDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AttachmentDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int attBNo = Integer.parseInt(request.getParameter("attBNo"));
		int fLevel = Integer.parseInt(request.getParameter("attFlevel"));
		String path = "";
		AttachmentService service = new AttachmentService();
	
		int result = service.deleteAttachmentDelete(attBNo, fLevel);
		
		if (result > 0) {
			if (fLevel == 1) {
				path = "cp";
			} else if (fLevel == 2) {
				path = "tc";
			} else if (fLevel == 3) {
				path = "no";
			} else if (fLevel == 4) {
				path = "ev";
			} else if (fLevel == 5) {
				path = "review";
			} else if (fLevel == 6) {
				path = "co";
			} else if (fLevel == 7) {
				path = "mj";
			}
			
			response.sendRedirect("selectList."+ path);
		} else {
			request.setAttribute("error-msg", "첨부파일 삭제 실패");
			
			request.getRequestDispatcher("views/common/errorPage.jsp")
				   .forward(request, response);
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
