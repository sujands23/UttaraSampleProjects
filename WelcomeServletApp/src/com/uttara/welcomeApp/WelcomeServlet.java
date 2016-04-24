package com.uttara.welcomeApp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class WelcomeServlet
 */
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WelcomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Inside doGet() of WelcomeServlet");
		String name=request.getParameter("uname");
		String a=request.getParameter("age");
		int age=0;;
		String msg="";
		PrintWriter out=response.getWriter();
		if(name==null||name.trim().equals(""))
		{
			msg="Name field is null <br/>";
		}
		if(a==null||a.trim().equals(""))
			msg=msg+" Age field is null <br/>";
		else
		{
			try {
				age=Integer.parseInt(a);
				if(age>=120||age<=0)
					msg=msg+" Value of age should be between 0 and 120";
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				msg=msg+" Enter your age in numbers only";
			}
		}
		if(msg.equals(""))
		{
			if(age<18)
				out.println("<html><h1>Welcome "+name+"<br/> You are child!!</h1></html>");
			else
			{ 
				if(age<60)
					out.println("<html><h1>Welcome "+name+"<br/> You are an adult!!</h1></html>");
				else
					out.println("<html><h1>Welcome "+name+"<br/> You are a senior citizen!!</h1></html>");
			}
			
		}
		else
		{
			out.println("<h1>Error!!!<br/>"+msg+"</h1>");
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
	}

}
