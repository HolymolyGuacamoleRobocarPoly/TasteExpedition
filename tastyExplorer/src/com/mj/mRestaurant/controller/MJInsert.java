package com.mj.mRestaurant.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class MJInsert
 */
@WebServlet("/insert.mj")
public class MJInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MJInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String savePath = request.getServletContext().getRealPath("/resources/mRestaurant");
		
		int maxSize = 1024 * 1024 * 10;
		
		if(! ServletFileUpload.isMultipartContent(request)) {
			
			request.setAttribute("error-msg", "multipart 전송이 아닙니다.");
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		
		} 
		
		MultipartRequest mr = new MultipartRequest(request, savePath, maxSize, "UTF-8", new DefaultFileRenamePolicy());
		
		// 식당 요청자 정보 받아오기 ( 쿠폰 적용 ? ) 
		int mNo = Integer.parseInt(mr.getParameter("mNo"));
		
		// 식당 정보 받아오기 
		String mjName = mr.getParameter("mjName");		// 식당 이름
		String mjAddress = mr.getParameter("address");	// 식당 주소
		String mjTel = mr.getParameter("tel");			// 식당 전화번호
		
		// 여기꺼는 db 안거치고 바로 값을 담아 그냥 전달 
		String openTime = mr.getParameter("openTime");	// 식당 영업시간
		String brTime = mr.getParameter("brTime");		// 식당 브레이크 타임
		String holiday = mr.getParameter("holiday");	// 식당 휴무일 
		
		// 식당 편의시설 받아오기 
		String mjInfo = String.join(", ", request.getParameterValues("Convenience"));
		
		// 식당 사진 받아오기 
		
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
