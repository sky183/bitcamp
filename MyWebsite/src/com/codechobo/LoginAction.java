package com.codechobo;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/LoginAction")
public class LoginAction extends HttpServlet {
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
	};

	void forward(HttpServletRequest request, HttpServletResponse response, HttpSession session, String error)
			throws ServletException, IOException {
		session.invalidate();
		request.setAttribute("error", error);
		RequestDispatcher reqDis = request.getRequestDispatcher("login.jsp");
		reqDis.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String remember = request.getParameter("remember");
		String prevUri = request.getParameter("prevUri");
		Cookie cookies[] = { new Cookie("remember", ""), new Cookie("idck", ""), new Cookie("pwck", "") };
		addcookies(cookies, response, 0);
		HttpSession session = request.getSession();
		UserDao udao = UserDao.getInstance();
		User u = udao.selectUser(new User(id));

		if (u == null) {
			forward(request, response, session, "id가 존재하지 않습니다.");
		} else if (pwd.equals(u.getPassword())) {
			session.setAttribute("MEMBERID", id);
			if (!(remember == null) && remember.equals("on")) {
				addcookies(cookies, response, 604800, "true", id, pwd);
			}

			if (!(prevUri == null || prevUri.equals("0"))) {
				response.sendRedirect(prevUri);
			} else {
				response.sendRedirect("index.jsp");
			}
		} else {
			request.setAttribute("user_id", id);
			forward(request, response, session, "비밀번호가 틀렸습니다.");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
