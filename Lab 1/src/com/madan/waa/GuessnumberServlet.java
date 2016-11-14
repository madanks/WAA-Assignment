package com.madan.waa;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Madan krishna
 */
@WebServlet(urlPatterns = { "/GuessnumberServlet" })
public class GuessnumberServlet extends HttpServlet {

	/**
	 * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
	 * methods.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			/* TODO output your page here. You may use following sample code. */
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet GuessnumberServlet</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Servlet GuessnumberServlet at " + request.getContextPath() + "</h1>");
			out.println("</body>");
			out.println("</html>");
		}
	}

	// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on
	// the + sign on the left to edit the code.">
	/**
	 * Handles the HTTP <code>GET</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// processRequest(request, response);

		PrintWriter out = response.getWriter();

		out.println("<html>");
		out.println("<body>");
		out.println("<form method=POST action=GuessnumberServlet>");
		out.println("Please Enter number :=<input type=text name=number> <br>");
		out.println("<input type=submit value='Check'>");
		out.println("</form>");
		out.println("<a href=" + request.getContextPath() + "/GuessnumberServlet>Play Guess Number Game</a>");
		out.println("</body>");
		out.println("</html>");
		out.close();
	}

	/**
	 * Handles the HTTP <code>POST</code> method.
	 *
	 * @param request
	 *            servlet request
	 * @param response
	 *            servlet response
	 * @throws ServletException
	 *             if a servlet-specific error occurs
	 * @throws IOException
	 *             if an I/O error occurs
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// processRequest(request, response);
		int randomNum = (new Random().nextInt(9)) + 1;
		int num = Integer.parseInt(request.getParameter("number"));
		try (PrintWriter out = response.getWriter()) {
			if (randomNum == num) {
				out.println("Correct, congratulations! ");
				// out.println("<a
				// href="+request.getContextPath()+"/GuessnumberServlet>Play
				// Guess Number Game</a>");
			} else if (randomNum > num) {
				out.println("Too low, try again");
				// out.println("<a
				// href="+request.getContextPath()+"/GuessnumberServlet>Play
				// Guess Number Game</a>");
			} else {
				out.println(" Too high, try again");
				// out.println("<a
				// href="+request.getContextPath()+"/GuessnumberServlet>Play
				// Guess Number Game</a>");
			}
		}
	}

	/**
	 * Returns a short description of the servlet.
	 *
	 * @return a String containing servlet description
	 */
	@Override
	public String getServletInfo() {
		return "Short description";
	}// </editor-fold>

}
