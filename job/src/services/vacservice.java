package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//import model.VacModel;
import model.postmod;
import model.qualimod;
import model.skillmod;
import model.vacmod;
import connection.connect;

public class vacservice {
	Connection con=connect.getConnection();
	public int insert(vacmod rm)
	{
	    try
	    {
	    	String s1="insert into jobvacancy(compid,postid,vacnumber,skillid,quali,distid,percentage)values(?,?,?,?,?,?,?)";
	        PreparedStatement ps=con.prepareStatement(s1);
	       
	      //  ps.setInt(1,rm.getVacid());
	        ps.setInt(1,rm.getComid() );
	        ps.setInt(2,rm.getPostid());
	        ps.setInt(3,rm.getVaccno());
	        ps.setInt(4,rm.getSkillid());
	        ps.setInt(5,rm.getQualf());
	        ps.setInt(6,rm.getDisid());
	        ps.setInt(7,rm.getPerc());
	        
	        
	        ps.executeUpdate();
	        ResultSet rs=ps.getGeneratedKeys();
	        if(rs.next())
	        {
	        	return rs.getInt(1);
	        	
	        }
	        
	        
	    }
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    	
	    }
	
		
	return 0;
	}
	public ArrayList<vacmod>selectAllRegistration(int comid)
	{
		vacmod rm=null;
		ArrayList<vacmod>arr6=new ArrayList<vacmod>();
		try
		{
			PreparedStatement p=con.prepareStatement("SELECT jobvacancy.vacid,compregi.cname,post.post,jobvacancy.vacnumber,skill.skill,qualification.qualification,district.distname,jobvacancy.percentage FROM jobvacancy INNER JOIN compregi on jobvacancy.compid=compregi.companyid INNER JOIN post on jobvacancy.postid=post.postid INNER JOIN skill on jobvacancy.skillid=skill.skillid INNER JOIN qualification on jobvacancy.quali=qualification.qualificationid INNER JOIN district on jobvacancy.distid=district.disid where jobvacancy.compid=?");
			p.setInt(1,comid );
			System.out.println(p);
			ResultSet rs=p.executeQuery();
			while(rs.next())
			{
				rm=new vacmod();
				rm.setVacid(rs.getInt(1));
				rm.setName(rs.getString(2));System.out.println(rs.getString(1));
				rm.setPost(rs.getString(3));System.out.println(rs.getString(2));
				rm.setVaccno(rs.getInt(4));System.out.println(rs.getString(3));
				rm.setSkill(rs.getString(5));System.out.println(rs.getString(4));
				rm.setQualification(rs.getString(6));System.out.println(rs.getString(5));
				rm.setDistrict(rs.getString(7));System.out.println(rs.getString(6));
				rm.setPercentage(rs.getString(8));
				//rm.setStatus(rs.getString(9));
				//System.out.println(rs.getString(9));
				arr6.add(rm);
				
			}
			return arr6;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

	return null;
	}	
	
	public vacmod selectByid(int id)
	{
		
		vacmod rm=null;
		ArrayList<vacmod>arr=new ArrayList<vacmod>();
		try
		{
			String query="SELECT vacid,compid,postid,vacnumber,skillid,quali,distid,percentage FROM`jobvacancy` WHERE vacid=?";
			PreparedStatement p=con.prepareStatement(query);
		p.setInt(1, id) ;
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			rm=new vacmod();
			rm.setVacid(rs.getInt(1));System.out.println(rs.getInt(1));
			rm.setName(rs.getString(2));System.out.println(rs.getString(2));
			rm.setPost(rs.getString(3));
			rm.setVaccno(rs.getInt(4));
			rm.setSkill(rs.getString(5));
			rm.setQualification(rs.getString(6));
			rm.setDistrict(rs.getString(7));
			rm.setPerc(rs.getInt(8));
			arr.add(rm);
		}
		return rm;
	}

	catch(Exception e)
	{
	e.printStackTrace();
	}
	return null;
	}
	public int updateRegisration(vacmod rm)
	{
	try
	{
		PreparedStatement ps=con.prepareStatement("UPDATE jobvacancy SET compid=?,postid=?,vacnumber=?,skillid=?,quali=?,distid=?,percentage=? WHERE vacid=?");
		ps.setInt(1,rm.getComid());
		ps.setInt(2, rm.getPostid());
		ps.setInt(3,rm.getVaccno());
		ps.setInt(4, rm.getSkillid());
		ps.setInt(5,rm.getQualf());
		ps.setInt(6, rm.getDisid());
		ps.setInt(7,rm.getPerc());
		//ps.setInt(2, rm.getPostid());
		ps.setInt(8,rm.getVacid());
		
		
		
		ps.executeUpdate();
		ResultSet rss=ps.getGeneratedKeys();
		if(rss.next())
		{
			return rss.getInt(1);
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	return 0;
	}
	//job srch
	public ArrayList<vacmod>search(int quali,int skill)
	{
		vacmod rm=null;
		ArrayList<vacmod>arr6=new ArrayList<vacmod>();
		try
		{
			PreparedStatement p=con.prepareStatement("SELECT jobvacancy.vacid,compregi.cname,post.post,jobvacancy.vacnumber,skill.skill,qualification.qualification,district.distname,jobvacancy.percentage FROM jobvacancy INNER JOIN compregi on jobvacancy.compid=compregi.companyid INNER JOIN post on jobvacancy.postid=post.postid INNER JOIN skill on jobvacancy.skillid=skill.skillid INNER JOIN qualification on jobvacancy.quali=qualification.qualificationid INNER JOIN district on jobvacancy.distid=district.disid where jobvacancy.quali=? and jobvacancy.skillid=?");
			p.setInt(1,quali );
			p.setInt(2,skill);
			
			System.out.println(p);
			ResultSet rs=p.executeQuery();
			while(rs.next())
			{
				rm=new vacmod();
				rm.setVacid(rs.getInt(1));
				rm.setName(rs.getString(2));System.out.println(rs.getString(1));
				rm.setPost(rs.getString(3));System.out.println(rs.getString(2));
				rm.setVaccno(rs.getInt(4));System.out.println(rs.getString(3));
				rm.setSkill(rs.getString(5));System.out.println(rs.getString(4));
				rm.setQualification(rs.getString(6));System.out.println(rs.getString(5));
				rm.setDistrict(rs.getString(7));System.out.println(rs.getString(6));
				rm.setPercentage(rs.getString(8));
				
				arr6.add(rm);
				
			}
			return arr6;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

	return null;
	}	
	//-------------jobsearch----------
	
	public int countbooking(int vac,int uid)
	{
		ResultSet rs=null;
		try
		{
			String s=("SELECT COUNT(*)FROM application WHERE vacid=? AND userid=? ");
			PreparedStatement ps= con.prepareStatement(s);
			ps.setInt(1,vac);
			ps.setInt(2,uid);
			System.out.println(ps);
			rs=ps.executeQuery();
			if(rs.next())
			{
				int number=rs.getInt(1);
				System.out.println("number of rows="+number);
				return number;
			}}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		return 0;
		}
	
	
	///////for apli view
	
	public ArrayList<vacmod>searchapp(int quali,int skill,int comid )
	{
		vacmod rm=null;
		ArrayList<vacmod>arr6=new ArrayList<vacmod>();
		try
		{
			PreparedStatement p=con.prepareStatement("SELECT jobvacancy.vacid,compregi.cname,post.post,jobvacancy.vacnumber,skill.skill,qualification.qualification,district.distname,jobvacancy.percentage FROM jobvacancy INNER JOIN compregi on jobvacancy.compid=compregi.companyid INNER JOIN post on jobvacancy.postid=post.postid INNER JOIN skill on jobvacancy.skillid=skill.skillid INNER JOIN qualification on jobvacancy.quali=qualification.qualificationid INNER JOIN district on jobvacancy.distid=district.disid where  jobvacancy.quali=? and jobvacancy.skillid=?  and jobvacancy.compid=?");
			p.setInt(1,quali );
			p.setInt(2,skill);
			p.setInt(3,comid);
			System.out.println(p);
			ResultSet rs=p.executeQuery();
			while(rs.next())
			{
				rm=new vacmod();
				rm.setVacid(rs.getInt(1));
				rm.setName(rs.getString(2));System.out.println(rs.getString(1));
				rm.setPost(rs.getString(3));System.out.println(rs.getString(2));
				rm.setVaccno(rs.getInt(4));System.out.println(rs.getString(3));
				rm.setSkill(rs.getString(5));System.out.println(rs.getString(4));
				rm.setQualification(rs.getString(6));System.out.println(rs.getString(5));
				rm.setDistrict(rs.getString(7));System.out.println(rs.getString(6));
				rm.setPercentage(rs.getString(8));
				//rm.setStatus(rs.getString(9));
				//System.out.println(rs.getString(9));
				arr6.add(rm);
				
			}
			return arr6;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

	return null;
	}	
	}
