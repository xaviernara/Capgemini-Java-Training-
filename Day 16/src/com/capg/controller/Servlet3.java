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
 * Servlet implementation class Servlet3
 */
@WebServlet("/Servlet3")
public class Servlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		String firstName = request.getParameter("firstname");
//		String lastName = request.getParameter("lasttname");
//		String moblie = request.getParameter("mobile");
//		String email = request.getParameter("email");
//    	ServletConfig config = getServletConfig();
//		ServletContext context = config.getServletContext();
//		
//    	String moblie = (String) context.getAttribute("mobile");
//		String email = (String) context.getAttribute("email");
//		String firstName = (String) context.getAttribute("firstname");
//		String lastName = (String) context.getAttribute("lasttname");
//    	String city = request.getParameter("city");
//		String country = request.getParameter("country");
//		
    	
    	
    	HttpSession session =request.getSession();
		String firstName = (String) session.getAttribute("firstname");
		String lastName = (String) session.getAttribute("lasttname");
		String moblie = (String) session.getAttribute("moblie");
		String email = (String) session.getAttribute("email");
		String city = (String) session.getAttribute("city");
		String country = (String) session.getAttribute("country");
		
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().write("text/html");
		response.getWriter().write("<html><head></head></body>");
		response.getWriter().write("<h1>Servlet 3</h1> <hr/>");
		response.getWriter().write("<p>Session ID: " + session.getId() + "<p>");
		response.getWriter().write("<p>First Name: " + firstName + "<p>");
		response.getWriter().write("<p>Last Name: " + lastName + "<p>");
		response.getWriter().write("<p>Moblie: " + moblie + "<p>");
		response.getWriter().write("<p>Email: " + email + "<p>");
		response.getWriter().write("<p>city: " + city + "<p>");
		response.getWriter().write("<p>country: " + country + "<p>");	
		response.getWriter().write("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
