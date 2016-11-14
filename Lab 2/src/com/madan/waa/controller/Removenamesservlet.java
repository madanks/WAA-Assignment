package com.madan.waa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.madan.waa.names.Person;

/**
 * Servlet implementation class removenamesservlet
 */
@WebServlet("/servlet/removenameservlet")
public class Removenamesservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Removenamesservlet() {
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
		List<Person> listPerson = new ArrayList<>();
		HttpSession session = request.getSession();
		String key = request.getParameter("key");

		if (null != session.getAttribute("listPerson")) {

			listPerson = (List<Person>) session.getAttribute("listPerson");
			Iterator<Person> ite = listPerson.iterator();

			while (ite.hasNext()) {
				Person p = ite.next();
				String nkey = p.getKey();
				if (nkey.equals(key)) {
					ite.remove();
					session.removeAttribute("listPerson");
					session.setAttribute("listPerson", listPerson);
				}

			}

		}
		out.println("<html>");
		out.println("<body>");
		out.println("<form method=GET action=>");

		if (listPerson != null) {
			out.println("List Of Names </br>");
			for (Person p : listPerson) {
				out.println("Key =" + p.getKey() + " First name = " + p.getFname() + "  Last Name = " + p.getLname()
						+ "</br></br></br>");
			}
		}
		out.println("<input type=submit value='Show All Names'>");
		out.println("</form>");

		out.println("<form method=GET action=addnameservlet>");
		out.println("Key=<input type=text name=key> ");
		out.println("First Name=<input type=text name=fname>");
		out.println("Last Name=<input type=text name=lname>");
		out.println("<input type=submit value='Add'>");
		out.println("</form>");

		out.println("<form method=GET action=removenameservlet>");
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
