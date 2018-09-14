package com.codechobo;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MembershipAction")
public class MembershipAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	void addcookies(Cookie cookies[], HttpServletResponse response, int ma, String... values) {
		for (int i = 0; i < cookies.length; i++) {
			if (values.length == 0)
				cookies[i] = new Cookie(cookies[i].getName(), "");
			else
				cookies[i] = new Cookie(cookies[i].getName(), values[i]);
			cookies[i].setMaxAge(ma);
			response.addCookie(cookies[i]);
		}
	}

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

		HttpSession session = request.getSession();
		UserDao udao = UserDao.getInstance();
		
		for (int i = 0; i < u.getUser_id().length(); i++) {
			if (!(((u.getUser_id().charAt(i) >= 'A' && u.getUser_id().charAt(i) <= 'Z')
					|| (u.getUser_id().charAt(i) >= 'a' && u.getUser_id().charAt(i) <= 'z')
					|| (u.getUser_id().charAt(i) >= '0' && u.getUser_id().charAt(i) <= '9'))
					&& u.getUser_id().length() >= 4)) {
				forward(request, response, "id는 4글자 이상의 영문 및 숫자만 가능합니다.");
				return;
			}
		}

		if (!(u.getPassword().equals(u.getPassword2()))) {
			request.setAttribute("password", "");
			request.setAttribute("password2", "");
			forward(request, response, "비밀번호가 다릅니다.");
			return;
		}

		for (int i = 0; i < u.getPassword().length(); i++) {
			if (!(((u.getPassword().charAt(i) >= 'A' && u.getPassword().charAt(i) <= 'Z')
					|| (u.getPassword().charAt(i) >= 'a' && u.getPassword().charAt(i) <= 'z')
					|| (u.getPassword().charAt(i) >= '0' && u.getPassword().charAt(i) <= '9'))
					&& u.getPassword().length() >= 4)) {
				forward(request, response, "비밀번호는 4글자 이상의 영문 및 숫자만 가능합니다.");
				return;
			}
		}

		if (!(u.getEmails().length == 3)) {
			forward(request, response, "이메일 형식이 맞지 않습니다.");
			return;
		} else if (udao.insertUser(new User(u.getUser_id(), u.getPassword(), u.getName(), u.getEmail(), u.getReg_num(),
				u.getZip(), u.getAddress(), u.getJob(), u.getHobby(), u.getPr())) == -1) {
			forward(request, response, "이미 등록된 아이디입니다.");
			return;
		} else {
			session.setAttribute("MEMBERID", u.getUser_id());
			RequestDispatcher reqDis = request.getRequestDispatcher("complete.jsp");
			reqDis.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

	}

}
