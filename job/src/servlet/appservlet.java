package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.appservice;
import services.userservice;

import model.appmod;
import model.usermod;

/**
 * Servlet implementation class appservlet
 */
@WebServlet("/appservlet")
public class appservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public appservlet() {
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
		String operation=request.getParameter("operation");
				appmod am=new appmod();
		appservice as=new appservice();
		if(operation.equals("Apply"))
		{
			System.out.println("inside servlet");
		String userid=request.getParameter("reg");
		String  vacid=request.getParameter("vac");
		System.out.println(userid+vacid);
		am.setUid(Integer.parseInt(userid));
		am.setVid(Integer.parseInt(vacid));
		int a=as.appinsert(am);
		if(a!=0)
		{
			response.sendRedirect("jobsrch.jsp?msg=a");
		}
		else
		{
			response.sendRedirect("j0bsrch.jsp?msg=b");
		}
		}
		if(operation.equals("ACCEPT"))
		{
			System.out.println("accept");
		int u=Integer.parseInt(request.getParameter("uid"));System.out.println(u);
		int c=Integer.parseInt(request.getParameter("cid"));System.out.println(c);
		int v=Integer.parseInt(request.getParameter("vid"));System.out.println(v);
		System.out.println(u+c+v);
		userservice rs=new userservice();
		usermod rm= new usermod();
		String email=rs.getmail(u);
		rm.setMail(email);
		am.setUid(u);
		am.setCid(c);
		am.setVid(v);
		int a=as.accept(c, v, u);
		if(a!=0)
		{
			try
			{
				as.senMail(rm);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			response.sendRedirect("applview.jsp?msg=a");	
		}
		else
		{
			response.sendRedirect("applview.jsp?msg=b");
		}
		
		
		}
		
		
		// TODO Auto-generated method stub
	}

}
