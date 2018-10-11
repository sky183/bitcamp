package test;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NowServlet extends HttpServlet {
	// HttpServlet 클래스를 상속받아 클래스 작성
	// 처리하고자 하는 HTTP 방식(method)에 따라 알맞게 메서드를 오버라이딩 해주어야 함.
	// do get, do post
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// httpservletreques와 httpservletresponse 파라미터는 jsp에서의 request와 response와 같다.

		response.setContentType("text/html; charset=euc-kr");
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>현재시간</title></head>");
		out.println("<body>");
		out.println("현재 시간은");
		out.println(new Date());
		out.println("입니다.");
		out.println("</body></html>");
	}

}
