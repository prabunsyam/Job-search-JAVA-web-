package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dismod;
import model.statemod;
import services.dservice;
import services.stateservice;

/**
 * Servlet implementation class dservlet
 */
@WebServlet("/dservlet")
public class dservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public dservlet() {
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
		dismod rm=new dismod();
		dservice rs=new dservice();
		String operation=request.getParameter("post");
		if(operation.equals("POST"))
		{
			System.out.println("inside");
			String nm=request.getParameter("name");
			String sid=request.getParameter("state");
			
			System.out.println(nm+sid);
			rm.setDistname(nm);
			rm.setSid(Integer.parseInt(sid));
			
			int a=rs.insert(rm);
			if(a!=0)
			{
				response.sendRedirect("district.jsp?msg=a");
				
			}
			else
			{
				response.sendRedirect("district.jsp?msg=b");	
			}	
			
			
		}
		else if(operation.equals("Update"))
		{
			String name=request.getParameter("Name");
			String st=request.getParameter("state");
			
			System.out.println("servlet-inside update");
			System.out.println(name+st);
			
			rm.setDistname(name);
			rm.setSid(Integer.parseInt(st));
			
			int id=Integer.parseInt(request.getParameter("id"));
			rm.setDisid(id);
			rs.updateRegisration(rm);
			response.sendRedirect("districtview.jsp?msg=a");
			}
	
	}}
	


