package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import services.loginservice;

import model.loginmod;

/**
 * Servlet implementation class loginservlet
 */
@WebServlet("/loginservlet")
public class loginservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginservlet() {
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
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(password);
		System.out.println(username);
		loginmod lm=new loginmod();
		loginservice ls=new loginservice();
		lm=ls.logincheck(username, password);
		String usertype=null;
		if(lm!=null)
		{
			System.out.println("inside");
			String a=lm.getStatus();
			if(a.equals("ACTIVE"))
			{
				usertype=lm.getType();
				System.out.println("usertype="+usertype);
				String pwd=lm.getPassword();
				HttpSession  session=request.getSession();
				session.setAttribute("username", lm);
				session.setAttribute("password", pwd);
				
				
					if(usertype.equals("admin"))
				{
					response.sendRedirect("admin.jsp");
				}
				else if(usertype.equals("company"))
				{
					response.sendRedirect("comppof.jsp");
				}
				else if(usertype.equals("User"))
				{
					response.sendRedirect("userpro.jsp");
				}
				else 
				{
					response.sendRedirect("login.jsp");
				}
			}
				if(lm==null)
				{
					response.sendRedirect("login.jsp?msg=1");
				}
			}
		}
		// TODO Auto-generated method stub
	}


