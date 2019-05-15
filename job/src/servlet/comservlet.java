package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.commod;
import model.usermod;
import services.comservice;
import services.userservice;

/**
 * Servlet implementation class comservlet
 */
@WebServlet("/comservlet")
public class comservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public comservlet() {
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
		commod rm=new commod();
		comservice rs=new comservice();
		
		String operation=request.getParameter("operation");
		if(operation.equals("Register"))
		{
			System.out.println("inside servlet");
			String nm=request.getParameter("name");
			String add=request.getParameter("add");
			String w=request.getParameter("web");
			String ds=request.getParameter("dis");
			
	        String cn=request.getParameter("con");
			String mil=request.getParameter("mail");
			String st=request.getParameter("st");
			String user=request.getParameter("user");
			String  pass=request.getParameter("pass");
			
			System.out.println(nm+add+w+ds+cn+mil+st+user+pass);
			
			rm.setCname(nm);
			rm.setCaddress(add);
			rm.setCweb(w);
			rm.setDiscription(ds);
			rm.setContact(Long.parseLong(cn));
			rm.setMailid(mil);
			rm.setStatus(st);
			rm.setUser(user);
			rm.setPass(pass);
			try
			{
				rs.senMail(rm);
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			int a=rs.insert(rm);
			if(a!=0)
			{
				response.sendRedirect("companyreg.jsp?msg=a");
				
			}
			else
			{
				response.sendRedirect("companyreg.jsp?msg=b");	
			}	
			
			
		}
		else if(operation.equals("Update"))
		{
			System.out.println("inside update");
			String nm=request.getParameter("Name");
			String add=request.getParameter("Address");
			String st=request.getParameter("web");
			String ds=request.getParameter("disc");
			
			String gn=request.getParameter("cont");
			String dob=request.getParameter("mail");
			
			
			System.out.println("servlet-inside update");
			System.out.println(nm+add+st+ds+gn+dob);
			
			rm.setCname(nm);
			rm.setCaddress(add);
			rm.setCweb(st);
			rm.setDiscription(ds);
			rm.setContact(Long.parseLong(gn));
			rm.setMailid(dob);
		
			
			System.out.println("sreeee update");
			int id=Integer.parseInt(request.getParameter("id"));
			rm.setCompanyid(id);
			rs.updateRegisration(rm);
			response.sendRedirect("comcom.jsp?msg=a");
			}
		else if(operation.equals("Change"))
	{
		int id=Integer.parseInt(request.getParameter("companyid"));
		String status=request.getParameter("status");
		System.out.println(id+status);
		rs.changeStatus(id, status);
		response.sendRedirect("compview.jsp");
		
	}
		
	}// TODO Auto-generated method stub
	}
