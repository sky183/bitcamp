package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowServlet extends HttpServlet {
	// HttpServlet Ŭ������ ��ӹ޾� Ŭ���� �ۼ�
	// ó���ϰ��� �ϴ� HTTP ���(method)�� ���� �˸°� �޼��带 �������̵� ���־�� ��.
	// do get, do post
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// httpservletreques�� httpservletresponse �Ķ���ʹ� jsp������ request�� response�� ����.

		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>����ð�</title></head>");
		out.println("<body>");
		out.println("���� �ð���");
		out.println(new Date());
		out.println("�Դϴ�.");
		out.println("</body></html>");
	}

}
