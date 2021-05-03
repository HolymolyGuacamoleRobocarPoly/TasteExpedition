package com.mj.mRestaurant.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.common.MyRenamePolicy;
import com.oreilly.servlet.MultipartRequest;

/**
 * Servlet implementation class MJUpdate
 */
@WebServlet("/update.mj")
public class MJUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MJUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String savePath = request.getServletContext().getRealPath("/resources/mjAtt");
		
		int maxSize = 1024 * 1024 * 10;
		
		if (! ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("error-msg", "멀티파트 전송이 아닙니다.");
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
		MultipartRequest mr = new MultipartRequest(request, savePath, maxSize, "UTF-8", new MyRenamePolicy());
		
		int mjNo = Integer.parseInt(request.getParameter("mjNo"));	// 수정할 식당 번호 받아오기 
		
		
		
		
		
		
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
