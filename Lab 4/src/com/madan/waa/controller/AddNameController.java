package com.madan.waa.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.madan.waa.dao.PersonDAO;
import com.madan.waa.model.Person;

/**
 * Servlet implementation class AddNameController
 */
@WebServlet("/addNameController")
public class AddNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PersonDAO personDAO = null;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddNameController() {
		personDAO = new PersonDAO();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		if (session.getAttribute("personDAO") == null) {
			session.setAttribute("personDAO", personDAO);
		}

		request.getRequestDispatcher("addname.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Person person = new Person(Integer.parseInt(request.getParameter("key")), request.getParameter("firstName"),
				request.getParameter("lastName"));

		personDAO.add(person);
		doGet(request, response);
	}

}
