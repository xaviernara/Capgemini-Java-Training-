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

import org.apache.catalina.Session;

/**
 * Servlet implementation class ServletDemo
 */
@WebServlet("/ServletDemo")
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ServletConfig config = getServletConfig();
//		ServletContext context =config.getServletContext();
		//String firstName = request.getParameter("firstname");
		//String lastName = request.getParameter("lasttname");
	String firstName = request.getParameter("firstname");
	String lastName = request.getParameter("lasttname");
		
//		context.setAttribute("firstname", firstName);
//		context.setAttribute("lastname", lastName);

		
		HttpSession session =request.getSession();
//		String firstName = (String) session.getAttribute("firstname");
//		String lastName = (String) session.getAttribute("lasttname");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		response.getWriter().write("<html><head></head></body>");
		response.getWriter().write("<h1>Servlet</h1> <hr/>");
		response.getWriter().write("<p>Session ID: " + session.getId() + "<p>");
		response.getWriter().write("<p>First Name: " + firstName + "<p>");
		response.getWriter().write("<p>Last Name: " + lastName + "<p>");
		response.getWriter().write("<form action = 'Servlet2'>");
		response.getWriter().write("<input type ='text' placeholder='email' name='email'>");
		response.getWriter().write("<input type ='text' placeholder='contact' name='moblie'>");
		response.getWriter().write("<input type ='submit' placeholder='next servlet 2' name='button2'>");
		
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
