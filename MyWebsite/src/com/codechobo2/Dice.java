package com.codechobo2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/Dice")
public class Dice extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int Dice1 = 0;
	int Dice2 = 0;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dice() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		String id = request.getParameter("id");
//		String pwd = request.getParameter("pwd");
		Dice1 = (int)(Math.random()*6+1);
		Dice2 = (int)(Math.random()*6+1);
		
		PrintWriter out = response.getWriter();
	      out.println("<!DOCTYPE html>");
	      out.println("<html>");
	      out.println("<head>");
	      out.println("</head>");
	      out.println("<body>");
	      out.println("<img src='/dice/dice"+ Dice1 +".jpg'>");
	      out.println("<img src='/dice/dice"+ Dice2 +".jpg'>");
	      out.println("</body>");
	      out.println("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
