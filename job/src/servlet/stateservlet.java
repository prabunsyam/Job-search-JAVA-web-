package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import model.feedmod;
import model.statemod;
//import services.feedservice;
import services.stateservice;

/**
 * Servlet implementation class stateservlet
 */
@WebServlet("/stateservlet")
public class stateservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public stateservlet() {
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
		statemod rm=new statemod();
		stateservice rs=new stateservice();
		String operation=request.getParameter("post");
		if(operation.equals("POST"))
		{
			System.out.println("inside");
			String nm=request.getParameter("name");
			
			System.out.println(nm);
			rm.setState(nm);
			
			int a=rs.insert(rm);
			if(a==0)
			{
				response.sendRedirect("sate.jsp?msg=a");
				
			}
			else
			{
				response.sendRedirect("state.jsp?msg=b");	
			}	
			
			
		}
		else if(operation.equals("Update"))
		{
			String name=request.getParameter("Name");
			
			
			System.out.println("servlet-inside update");
			System.out.println(name);
			
			rm.setState(name);
			//rm.setSid(Integer.parseInt(st));
			
			int id=Integer.parseInt(request.getParameter("id"));
			rm.setSid(id);
			rs.updateRegisration(rm);
			response.sendRedirect("stateview.jsp?msg=a");
			}
	
	}}
		// TODO Auto-generated method stub
	
