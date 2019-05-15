package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dismod;
import model.postmod;
import services.dservice;
import services.postservices;

/**
 * Servlet implementation class postservelet
 */
@WebServlet("/postservelet")
public class postservelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public postservelet() {
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
		System.out.println("inside servlet");
		postmod rm=new postmod();
		postservices rs=new postservices();
		
		String operation=request.getParameter("operation");
		if(operation.equals("POST"))
		{
			System.out.println("inside");
			String id=request.getParameter("id");
			String post=request.getParameter("post");
			String status=request.getParameter("status");
			System.out.println("inside11");
			System.out.println(id+post+status);
			rm.setCompid(Integer.parseInt(id));
			rm.setPost(post);
			
			int a=rs.insert(rm);
			if(a!=0)
			{
				response.sendRedirect("post.jsp?msg=a");
				
			}
			else
			{
				response.sendRedirect("post.jsp?msg=b");	
			}	
			
			
		}
		else if(operation.equals("Update"))
		{
			System.out.println("servlet-insidghghg");
			
			String name=request.getParameter("Name");
			
			
			System.out.println("servlet-inside update");
			System.out.println(name);
			
			rm.setPost(name);
			//rm.setSid(Integer.parseInt(st));
			
			int id=Integer.parseInt(request.getParameter("id"));
			rm.setPostid(id);
			rs.updateRegisration(rm);
			response.sendRedirect("postview.jsp?msg=a");
			}	// TODO Auto-generated method stub
	}
	
	}

