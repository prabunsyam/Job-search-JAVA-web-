package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dismod;
import model.qualimod;
import model.statemod;
//import model.statemod;
import connection.connect;

public class qualiservice {
	Connection con=connect.getConnection();
	public int insert(qualimod rm)
	{
	    try
	    {
	    	String s1="insert into qualification(qualification,sta)values(?,?)";
	        PreparedStatement ps=con.prepareStatement(s1);
	        ps.setString(1,rm.getQualification());
	       
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
	public ArrayList<qualimod>selectAllRegistration()
	{
		qualimod rm=null;
		ArrayList<qualimod>arr4=new ArrayList<qualimod>();
		try
		{
			PreparedStatement p=con.prepareStatement("SELECT * FROM qualification");
			ResultSet rs=p.executeQuery();
			while(rs.next())
			{
				rm=new qualimod();
				//rm.setDistname(rs.getString(2));
				rm.setQualificationid(rs.getInt(1));
				rm.setQualification(rs.getString(2));
				
				arr4.add(rm);	
				
			}
			return arr4;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

	return null;
	}
	
	public qualimod selectByid(int Id)
	{
		
		qualimod rm=null;
		ArrayList<qualimod>arr4=new ArrayList<qualimod>();
		try
		{
			String query="SELECT qualificationid,qualification FROM`qualification` WHERE qualificationid=?";
			PreparedStatement p=con.prepareStatement(query);
		p.setInt(1, Id) ;
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			rm=new qualimod();
			rm.setQualificationid(rs.getInt(1));System.out.println(rs.getInt(1));
			rm.setQualification(rs.getString(2));System.out.println(rs.getString(2));
			
			arr4.add(rm);
		}
		return rm;
	}

	catch(Exception e)
	{
	e.printStackTrace();
	}
	return null;
	}
	public int updateRegisration(qualimod rm)
	{
	try
	{
		PreparedStatement ps=con.prepareStatement("UPDATE qualification SET qualification=? WHERE qualificationid=?");
		ps.setString(1,rm.getQualification());
		ps.setInt(2,rm.getQualificationid());
		
		
		
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
