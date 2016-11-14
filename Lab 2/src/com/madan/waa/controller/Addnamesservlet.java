package com.madan.waa.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.madan.waa.names.Person;

/**
 * Servlet implementation class addnamesservlet
 */
@WebServlet("/servlet/addnameservlet")
public class Addnamesservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Addnamesservlet() {
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
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");

		if (null == session.getAttribute("listPerson")) {
			listPerson.add(new Person(key, fname, lname));
			session.setAttribute("listPerson", listPerson);

		} else {
			
			listPerson = (List<Person>) session.getAttribute("listPerson");
			listPerson.add(new Person(key, fname, lname));
			
		}
		if (key != null && fname != null && lname != null) {

		}
		out.println("<html>");
		out.println("<body>");
		out.println("<form method=GET action=>");
		
		if(listPerson!=null){
			out.println("List Of Names </br>");
		for(Person p: listPerson){
			out.println("Key ="+ p.getKey()+" First name = "+ p.getFname()+"  Last Name = "+p.getLname()+"</br></br></br>");
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
