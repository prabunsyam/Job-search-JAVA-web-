package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.skillmod;
import model.statemod;
import services.skservice;
import services.stateservice;

/**
 * Servlet implementation class skservlet
 */
@WebServlet("/skservlet")
public class skservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public skservlet() {
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
		skillmod rm=new skillmod();
		skservice rs=new skservice();
		String operation=request.getParameter("post");
		if(operation.equals("POST"))
		{
			System.out.println("inside");
			String nm=request.getParameter("sk");
			//String ss=request.getParameter("st");
			
			System.out.println(nm);
			rm.setSkill(nm);
			//rm.setStatus(ss);
			
			int a=rs.insert(rm);
			if(a!=0)
			{
				response.sendRedirect("skil.jsp?msg=a");
				
			}
			else
			{
				response.sendRedirect("skil.jsp?msg=b");	
			}	
			
			
		}
		else if(operation.equals("Update"))
		{
			String name=request.getParameter("Name");
			
			
			System.out.println("servlet-inside update");
			System.out.println(name);
			
			rm.setSkill(name);
			//rm.setSid(Integer.parseInt(st));
			
			int id=Integer.parseInt(request.getParameter("id"));
			rm.setSkillid(id);
			rs.updateRegisration(rm);
			response.sendRedirect("skillview.jsp?msg=a");
			}	
		// TODO Auto-generated method stub
	}

}
