package com.ajax.poc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmailCheckServlet
 */
public class EmailCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		process(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		process(request, response);//best practice
	}
	protected void process(HttpServletRequest request,HttpServletResponse response)
	{
		try
		{
			String uri=request.getRequestURI();
			System.out.println("URI : "+uri);
			if(uri.equals("/AJAXTest/emailCheck.do"))
			{
				String email=request.getParameter("email");
				System.out.println("Email : "+email);
				PrintWriter out=response.getWriter();
				if(email==null||email=="")
				{
					out.println("Please enter your mail Id");
				}
				else
				{
					Pattern p=Pattern.compile("[a-z]*[0-9]*@[a-z]*.[a-z]*");
					Matcher m=p.matcher(email);
					boolean b=m.matches();
					if(b==true)
					{
						out.println("Email Id is valid");
					}
					else
					{
						out.println("Email Id is Invalid");
					}
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
