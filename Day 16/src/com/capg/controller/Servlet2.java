package com.capg.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet2() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
//		ServletConfig config = getServletConfig();
//		ServletContext context = config.getServletContext();
		// String firstName = request.getParameter("firstname");
		// String lastName = request.getParameter("lasttname");
//		String moblie = request.getParameter("mobile");
//		String email = request.getParameter("email");
//
//		String firstName = (String) context.getAttribute("firstname");
//		String lastName = (String) context.getAttribute("lasttname");

		
		HttpSession session =request.getSession();
		String firstName = (String) session.getAttribute("firstname");
		String lastName = (String) session.getAttribute("lasttname");
		String moblie = (String) session.getAttribute("moblie");
		String email = (String) session.getAttribute("email");
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().write("text/html");
		response.getWriter().write("<html><head></head></body>");
		response.getWriter().write("<h1>Servlet 2</h1> <hr/>");
		response.getWriter().write("<p>Session ID: " + session.getId() + "<p>");
		response.getWriter().write("<p>First Name: " + firstName + "<p>");
		response.getWriter().write("<p>Last Name: " + lastName + "<p>");
		response.getWriter().write("<p>Moblie: " + moblie + "<p>");
		response.getWriter().write("<p>Email: " + email + "<p>");
		response.getWriter().write("<form action = 'Servlet3'>");
		response.getWriter().write("<input type ='text' placeholder='city' name='city'>");
		response.getWriter().write("<input type ='text' placeholder='country' name='country'>");
		response.getWriter().write("<input type ='submit' placeholder='next servlet 3' name='button3'>");

		response.getWriter().write("</body></html>");
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
