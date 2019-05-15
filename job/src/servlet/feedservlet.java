package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.feedmod;
//import model.usermod;
import services.feedservice;
//import services.userservice;

/**
 * Servlet implementation class feedservlet
 */
@WebServlet("/feedservlet")
public class feedservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public feedservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("inside servlet");
		feedmod rm=new feedmod();
		feedservice rs=new feedservice();
		String operation=request.getParameter("post");
		if(operation.equals("POST"))
		{
			System.out.println("inside");
			String nm=request.getParameter("name");
			String mail=request.getParameter("mail");
			String fd=request.getParameter("feed");
			System.out.println(nm+mail+fd);
			rm.setName(nm);
			rm.setMail(mail);
			rm.setFeed(fd);
			int a=rs.insert(rm);
			if(a!=0)
			{
				response.sendRedirect("feedback.jsp?msg=a");
				
			}
			else
			{
				response.sendRedirect("feedback.jsp?msg=b");	
			}	
			
			
		}
		
	}}
			
	


