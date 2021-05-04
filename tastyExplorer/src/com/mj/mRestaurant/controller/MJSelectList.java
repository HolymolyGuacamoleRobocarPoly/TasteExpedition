package com.mj.mRestaurant.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.common.model.service.AttachmentService;
import com.mj.common.model.vo.Attachment;
import com.mj.mRestaurant.model.service.MRestaurantService;
import com.mj.mRestaurant.model.vo.MRestaurant;

/**
 * Servlet implementation class MJSelectList
 */
@WebServlet("/selectList.mj")
public class MJSelectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MJSelectList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

//		getParameter 로 index 에서 지도 주변 맛집의 주소 받아와서 dao 까지 넘기고 properties 의 ? 에 address 넣어주면 주변 맛집 list 출력 가능 
		String keyword = request.getParameter("keyword");
		int fLevel = 7;
		System.out.println("keyword 결과 확인 : " + keyword);

		// 맛집 List 불러오기 

		ArrayList<MRestaurant> mjList = new ArrayList<>();

		MRestaurantService service = new MRestaurantService();
		
		// 해당 맛집 Attachment List 불러오기
		ArrayList<Attachment> mjAttList = new ArrayList<>();
		AttachmentService aservice = new AttachmentService();
		
		// 맛집 List service 로 
		mjList = service.selectList(keyword);
		
		// 해당 맛집별로 Attachment 불러오는 반복문 
		for(int i = 0; i < mjList.size(); i ++) {
			int mjNo = mjList.get(i).getmRestaurantNo();  
			
			mjAttList.add(aservice.selectOne(mjNo, fLevel));
			
		}

		
		
		// 맛집 리스트 

		request.setAttribute("mjList", mjList);
		request.setAttribute("mjAttList", mjAttList);
		// 해당 맛집 첨부파일 리스트 
		
		
		request.getRequestDispatcher("index.jsp").forward(request, response);;
				
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
