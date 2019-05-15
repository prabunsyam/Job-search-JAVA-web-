package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.fgpservice;

import model.passmod;

/**
 * Servlet implementation class fgpservlet
 */
@WebServlet("/fgpservlet")
public class fgpservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fgpservlet() {
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
String opr=request.getParameter("operation");
		
		passmod pm=new passmod();
		fgpservice ps=new fgpservice();
		
		
		if(opr.equals("getpwd"))
		{
			
			String email=request.getParameter("name");		//..........get id from jsp page.........
						
			
			System.out.println(email);
			
			
			pm.setMail(email);
			
			String msg;
			
			String result=ps.selectpass(email);		
			
			System.out.println("Hello"+result);
				
				
			if(result!=null)
			{
				pm.setPassword(result);
				
				try
				{
					ps.senMail(pm);			//........send mail..........					
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
				
				msg="Sent Mail Successfully";
				response.sendRedirect("forgetpwd.jsp?msg=a");
			}
			else
			{
				msg="Failed";
				response.sendRedirect("forgetpwd.jsp?msg=b");
				
			}
		}
	}

	}


