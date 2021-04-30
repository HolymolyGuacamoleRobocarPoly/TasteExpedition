package com.mj.member.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mj.member.model.service.MemberService;
import com.mj.member.model.vo.Member;

/**
 * Servlet implementation class MemberInsert
 */
@WebServlet("/insert.me")
public class MemberInsert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInsert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		String userName = request.getParameter("userName");
		String nickName = request.getParameter("nickName");
		String birthday = request.getParameter("birth_year") + request.getParameter("birth_month") + request.getParameter("birth_day");
		String phone = request.getParameter("tel1") + "-"
				     + request.getParameter("tel2") + "-"
				     + request.getParameter("tel3");
		
		String email = request.getParameter("email");
		
		String address = request.getParameter("zipCode") + ", "
					   + request.getParameter("address1") + ", "
					   + request.getParameter("address2");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyymmDD");

		Member m = null;
		try {
			m = new Member(userId, userPwd, userName, nickName, new Date(sdf.parse(birthday).getTime()), phone, email, address);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MemberService service = new MemberService();
		
		int result = service.insertMember(m);
		
		if(result >0) {
			//회원 가입 성공
			response.sendRedirect("index.jsp");
		} else {
			//회원 가입 실패
			RequestDispatcher view =
					request.getRequestDispatcher("views/common/errorPage.jsp");
			
			request.setAttribute("error-msg", "회원 가입 실패");
			
			view.forward(request, response);
			
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
