package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.qualimod;
import model.statemod;
import services.qualiservice;
import services.stateservice;

/**
 * Servlet implementation class qualiservlet
 */
@WebServlet("/qualiservlet")
public class qualiservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public qualiservlet() {
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
		qualimod rm=new qualimod();
		qualiservice rs=new qualiservice();
		String operation=request.getParameter("post");
		if(operation.equals("POST"))
		{
			System.out.println("inside");
			String nm=request.getParameter("ql");
			//String dis=request.getParameter("dt");
			//String st=request.getParameter("st");
			
			System.out.println(nm);
			rm.setQualification(nm);
			//rm.setDiscription(dis);
			//rm.setSta(st);
			
			int a=rs.insert(rm);
			if(a!=0)
			{
				response.sendRedirect("qualification.jsp?msg=a");
				
			}
			else
			{
				response.sendRedirect("qualification.jsp?msg=b");	
			}	
			
	}
		else if(operation.equals("Update"))
		{
			String name=request.getParameter("Name");
			
			
			System.out.println("servlet-inside update");
			System.out.println(name);
			
			rm.setQualification(name);
			//rm.setSid(Integer.parseInt(st));
			
			int id=Integer.parseInt(request.getParameter("id"));
			rm.setQualificationid(id);
			rs.updateRegisration(rm);
			response.sendRedirect("qualiview.jsp?msg=a");
			}	
	}

}
