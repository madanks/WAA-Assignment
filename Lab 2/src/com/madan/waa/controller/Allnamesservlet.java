package com.madan.waa.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class allnamesservlet
 */
@WebServlet("/names")
public class Allnamesservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Allnamesservlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<form method=GET action=>");
		out.println("<input type=submit value='Show All Names'>");
		out.println("</form>");

		out.println("<form method=GET action=servlet/addnameservlet>");
		out.println("Key=<input type=text name=key> ");
		out.println("First Name=<input type=text name=fname>");
		out.println("Last Name=<input type=text name=lname>");
		out.println("<input type=submit value='Add'>");
		out.println("</form>");

		out.println("<form method=GET action=servlet/removenameservlet>");
		out.println("Key=<input type=text name=key> ");
		out.println("<input type=submit value='Remove'>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		out.close();

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
