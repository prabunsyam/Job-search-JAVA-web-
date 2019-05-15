package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import services.userservice;

import model.usermod;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class userservlet
 */
@WebServlet("/userservlet")
public class userservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userservlet() {
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
		String path=request.getServletContext().getRealPath("/");
		path=path.substring(0,path.indexOf("."));
		String Basepath=request.getContextPath();
		Basepath=Basepath.replace("\\","");
		String fullpath=path+Basepath+"/WebContent/resumee/";
		String encoding="ISO-8859-1";
		MultipartRequest m = new MultipartRequest(request,fullpath,20242880,encoding,new DefaultFileRenamePolicy());
		
		usermod rm=new usermod();
		userservice rs=new userservice();
		
		String operation=m.getParameter("operation");
		if(operation.equals("Register"))
		{
			System.out.println("inside servlet");
			String nm=m.getParameter("name");
			String add=m.getParameter("address");
			String st=m.getParameter("state");
			String ds=m.getParameter("district");
			
			String gn=m.getParameter("gender");
			String dob=m.getParameter("dob");
			String age=m.getParameter("age");
			String ph=m.getParameter("ph");
			String ql=m.getParameter("qlf");
			String yrp=m.getParameter("yrps");
			String wrk=m.getParameter("expr");
			//String res=m.getParameter("resume");
			String mail=m.getParameter("mail");
			String user=m.getParameter("user");
			String pass=m.getParameter("pass");
			System.out.println(nm+add+st+ds+gn+dob+age+ph+ql+yrp+wrk+mail+user+pass);
			
			rm.setName(nm);
			rm.setAdd(add);
			rm.setState(st);
			rm.setDist(ds);
			
			rm.setGen(gn);
			rm.setDob(dob);
			rm.setAge(Long.parseLong(age));
			rm.setPh(Long.parseLong(ph));
			rm.setQl(ql);
			rm.setYrp(Long.parseLong(yrp));
			rm.setWorkexp(wrk);		
			//rm.setResume(res);
			rm.setMail(mail);
			rm.setUsername(user);
			rm.setPassword(pass);
			try{
				rs.senMail(rm);
			}
			catch (Exception e) {
				e.printStackTrace();// TODO: handle exception
			}
			int a=rs.insert(rm);
			if(a==0)
			{
				response.sendRedirect("userreg.jsp?msg=a");
				
			}
			else
			{
				response.sendRedirect("userreg.jsp?msg=b");	
			}	
			
			
		}
		else if(operation.equals("Update"))
		{
			System.out.println("inside update");
			String nm=m.getParameter("Name");
			String add=m.getParameter("Address");
			String st=m.getParameter("state");
			String ds=m.getParameter("dist");
			
			String gn=m.getParameter("Gender");
			String dob=m.getParameter("date");
			String age=m.getParameter("age");
			String ph=m.getParameter("ph");
			String ql=m.getParameter("qli");
			String yrp=m.getParameter("yop");
			String wrk=m.getParameter("exp");
			//String res=m.getParameter("resume");
			String mail=m.getParameter("mail");
			
			System.out.println("servlet-inside update");
			System.out.println(nm+add+st+ds+gn+dob+age+ph+ql+yrp+wrk+mail);
			
			rm.setName(nm);
			rm.setAdd(add);
			rm.setState(st);
			rm.setDist(ds);
			rm.setGen(gn);
			rm.setDob(dob);
		rm.setAge(Integer.parseInt(age));
		rm.setPh(Long.parseLong(ph));
		rm.setQl(ql);
		rm.setYrp(Integer.parseInt(yrp));
		rm.setWorkexp(wrk);
		rm.setMail(mail);
			
			System.out.println("sreeee update");
			int id=Integer.parseInt(m.getParameter("id"));
			rm.setUseid(id);
			rs.updateRegisration(rm);
			response.sendRedirect("useruser.jsp?msg=a");
			}
		
	
		else if(operation.equals("Change"))
	{
		int id=Integer.parseInt(m.getParameter("id"));
		String status=m.getParameter("status");
		System.out.println(id+status);
		rs.changeStatus(id, status);
		response.sendRedirect("userview.jsp");
		
	}
		
	}
	}


