package com.codechobo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OverlapCheck")
public class OverlapCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	void forward(HttpServletRequest request, HttpServletResponse response, String error)
			throws ServletException, IOException {
		request.setAttribute("error", error);
		RequestDispatcher reqDis = request.getRequestDispatcher("membership.jsp");
		reqDis.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UserInfo u = new UserInfo();
		u.bindRequestParams(request);
		request.setAttribute("userInfo", u);

		UserDao udao = UserDao.getInstance();
		
		if (udao.selectUser(new User(u.getUser_id())) != null) {
			forward(request, response, "이미 등록된 아이디입니다.");
			return;
		} else {
			forward(request, response, "사용 가능한 아이디입니다.");
			return;	
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
