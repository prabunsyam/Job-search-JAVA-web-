package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import model.VacModel;
import model.vacmod;
//import service.VacService;
import services.vacservice;

/**
 * Servlet implementation class vacservlet
 */
@WebServlet("/vacservlet")
public class vacservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public vacservlet() {
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
		vacmod rm=new vacmod();
			vacservice rs=new vacservice();

				if(operation.equals("POST"))
				{
					String comid=request.getParameter("com");
					String postid=request.getParameter("post");
					 String vacno=request.getParameter("vcc");
					 String skillid=request.getParameter("skill");
					 String qlfnid=request.getParameter("qli");
					 String disid=request.getParameter("dis");
					 String percentage=request.getParameter("per");
					System.out.println(comid+postid+vacno+skillid+qlfnid+disid+percentage);
						rm.setComid(Integer.parseInt(comid));
						rm.setPostid(Integer.parseInt(postid));
						rm.setVaccno(Integer.parseInt(vacno));
						rm.setSkillid(Integer.parseInt(skillid));
						rm.setQualf(Integer.parseInt(qlfnid));
						rm.setDisid(Integer.parseInt(disid));
						rm.setPerc(Integer.parseInt(percentage));
						int a=rs.insert(rm);
						if (a!=0) 
						{
						
							response.sendRedirect("vacancy.jsp?msg=a");
						}
						else
						{
							
											response.sendRedirect("vacancy.jsp?msg=b");		
						}
	}
				else if(operation.equals("Update"))
				{
					String co=request.getParameter("com");
					String p =request.getParameter("po");
					String v=request.getParameter("vacc");
					String s=request.getParameter("sk");
					String q=request.getParameter("ql");
					String d=request.getParameter("dst");
					String pe=request.getParameter("per");
					
					System.out.println("servlet-inside update");
					System.out.println(co+p+v+s+q+d+pe);
					
					rm.setComid(Integer.parseInt(co));
					rm.setPostid(Integer.parseInt(p));
					rm.setVaccno(Integer.parseInt(v));
					rm.setSkillid(Integer.parseInt(s));
					rm.setQualf(Integer.parseInt(q));
					rm.setDisid(Integer.parseInt(d));
					rm.setPerc(Integer.parseInt(pe));
					
					System.out.println("sreeee update");
					int id=Integer.parseInt(request.getParameter("id"));
					rm.setVacid(id);
					rs.updateRegisration(rm);
					response.sendRedirect("vacview.jsp?msg=a");
					}	// TODO Auto-generated method stub
	}

}
