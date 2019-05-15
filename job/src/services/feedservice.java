package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.feedmod;
import model.skillmod;
//import model.usermod;
import connection.connect;

public class feedservice {
	Connection con=connect.getConnection();
	public int insert(feedmod rm)
	{
	    try
	    {
	    	String s1="insert into feedback(name,mailid,feedback)values(?,?,?)";
	        PreparedStatement ps=con.prepareStatement(s1);
	        ps.setString(1,rm.getName());
	        ps.setString(2,rm.getMail());
	        ps.setString(3,rm.getFeed());
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
	public ArrayList<feedmod>selectAllRegistration()
	{
		feedmod rm=null;
		ArrayList<feedmod>arr1=new ArrayList<feedmod>();
		try
		{
			PreparedStatement p=con.prepareStatement("SELECT * FROM feedback");
			ResultSet rs=p.executeQuery();
			while(rs.next())
			{
				rm=new feedmod();
				rm.setName(rs.getString(2));
				rm.setMail(rs.getString(3));
				rm.setFeed(rs.getString(4));
				
				
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

}
