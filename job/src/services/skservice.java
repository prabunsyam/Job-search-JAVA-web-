package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dismod;
import model.qualimod;
import model.skillmod;
//import model.statemod;
import connection.connect;

public class skservice {
	Connection con=connect.getConnection();
	public int insert(skillmod rm)
	{
	    try
	    {
	    	String s1="insert into skill(skill,status)values(?,?)";
	        PreparedStatement ps=con.prepareStatement(s1);
	        ps.setString(1,rm.getSkill());
	        ps.setString(2,"ACTIVE");
	       
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
	public ArrayList<skillmod>selectAllRegistration()
	{
		skillmod rm=null;
		ArrayList<skillmod>arr1=new ArrayList<skillmod>();
		try
		{
			PreparedStatement p=con.prepareStatement("SELECT * FROM skill");
			ResultSet rs=p.executeQuery();
			while(rs.next())
			{
				rm=new skillmod();
				rm.setSkillid(rs.getInt(1));
				rm.setSkill(rs.getString(2));
				//rm.setSid(rs.getInt(3));
				//rm.setDistname(rs.getString(2));
				
				arr1.add(rm);	
				
			}
			return arr1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

	return null;
	}	
	public skillmod selectByid(int Id)
	{
		
		skillmod rm=null;
		ArrayList<skillmod>arr=new ArrayList<skillmod>();
		try
		{
			String query="SELECT skillid,skill FROM`skill` WHERE skillid=?";
			PreparedStatement p=con.prepareStatement(query);
		p.setInt(1, Id) ;
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			rm=new skillmod();
			rm.setSkillid(rs.getInt(1));System.out.println(rs.getInt(1));
			rm.setSkill(rs.getString(2));System.out.println(rs.getString(2));
			
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
	public int updateRegisration(skillmod rm)
	{
	try
	{
		PreparedStatement ps=con.prepareStatement("UPDATE skill SET skill=? WHERE skillid=?");
		ps.setString(1,rm.getSkill());
		ps.setInt(2,rm.getSkillid());
		
		
		
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


}
