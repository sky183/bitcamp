package jdbc;

import javax.servlet.http.HttpServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import java.util.StringTokenizer;


public class Loader extends HttpServlet {

	public void init(ServletConfig config) throws ServletException {
		try {
			String drivers = config.getInitParameter("jdbcdriver");
			StringTokenizer st = new StringTokenizer(drivers, ",");

			while (st.hasMoreTokens()) {
				String jdbcdriver = st.nextToken();
				Class.forName(jdbcdriver);
				System.out.println(drivers + "드라이버 로딩 완료");
			}
		} catch (Exception e) {
			throw new ServletException(e);
		}

	}
	
}
