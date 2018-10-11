package mvctest;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class URIController extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		// 1�ܰ�, HTTP ��û ����
		processRequest(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1�ܰ�, HTTP ��û ����
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		// 2�ܰ�, ��û �ľ�
		// request ��ü�κ��� ������� ��û�� �ľ��ϴ� �ڵ�
//		String type = request.getParameter("type");
		String type = request.getRequestURI();
		if (type.indexOf(request.getContextPath())==0) {
			type=type.substring(request.getContextPath().length());
		}
		
		// 3�ܰ�, ��û�� ����� �����Ѵ�.
		// ����ڿ� ��û�� ���� �˸��� �ڵ�
		Object resultObject = null;
		if (type.equals("/greeting.do")) {
			resultObject = "�ȳ��ϼ���.";
		} else if (type.equals("/date.do")) {
			resultObject = new java.util.Date();
		} else {
			resultObject = "Invalid Type";
		}

		// 4�ܰ�, request�� session�� ó�� ����� ����
		request.setAttribute("result", resultObject);

		// 5�ܰ�, RequestDispatcher�� ����Ͽ� �˸��� ��� ������
		RequestDispatcher dispatcher = request.getRequestDispatcher("/simpleView.jsp");
		dispatcher.forward(request, response);

	}

}
