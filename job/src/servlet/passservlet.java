package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.loginmod;

import services.loginservice;

/**
 * Servlet implementation class passservlet
 */
@WebServlet("/passservlet")
public class passservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public passservlet() {
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
		
		int id=Integer.parseInt(request.getParameter("use"));
		String type=request.getParameter("type");
		
		
		String oldpass=null;
		String newpass=null;
		String conpass=null;
		
		try
		{
			oldpass=request.getParameter("op");
			newpass=request.getParameter("np");
			conpass=request.getParameter("cnp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		System.out.println(oldpass+newpass+conpass+id+type);
		loginservice ls=new loginservice();
		loginmod lm=ls.getpassword(id, type);
		if(lm.getPassword().compareTo(oldpass)==0)
		{
			if(newpass.compareTo(conpass)==0)
			{
				int a=ls.changepwd(id,newpass,type);
				response.sendRedirect("passchange.jsp?msg=changed");
			}
			else
			{
				response.sendRedirect("passchange.jsp?msg=not match");	
			}
		}
		else
			response.sendRedirect("passchange.jsp?msg=not match");
		// TODO Auto-generated method stub
	}

}
