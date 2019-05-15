package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//import model.dismod;
import model.dismod;
import model.postmod;
import connection.connect;

public class postservices {
	Connection con=connect.getConnection();
	public int insert(postmod rm)
	{
	    try
	    {
	    	String s1="insert into post(compid,post,status)values(?,?,?)";
	        PreparedStatement ps=con.prepareStatement(s1);
	       
	        ps.setInt(1,rm.getCompid());
	        ps.setString(2,rm.getPost() );
	        ps.setString(3,"ACTIVE");
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
	public ArrayList<postmod>selectAllRegistration()
	{
		postmod rm=null;
		ArrayList<postmod>arr2=new ArrayList<postmod>();
		try
		{
			PreparedStatement p=con.prepareStatement("SELECT * FROM post");
			ResultSet rs=p.executeQuery();
			while(rs.next())
			{
				rm=new postmod();
				rm.setPostid(rs.getInt(1));
				rm.setCompid(rs.getInt(2));
			
				rm.setPost(rs.getString(3));
				
				//rm.setDistname(rs.getString(2));
				
				arr2.add(rm);	
				
			}
			return arr2;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

	return null;
	}
	public postmod selectByid(int Id)
	{
		
		postmod rm=null;
		ArrayList<postmod>arr=new ArrayList<postmod>();
		try
		{
			String query="SELECT postid,compid,post FROM`post` WHERE postid=?";
			PreparedStatement p=con.prepareStatement(query);
		p.setInt(1, Id) ;
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			rm=new postmod();
			rm.setPostid(rs.getInt(1));System.out.println(rs.getInt(1));
			rm.setCompid(rs.getInt(2));System.out.println(rs.getString(2));
			rm.setPost(rs.getString(3));
			
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
public int updateRegisration(postmod rm)
{
	try
	{
		PreparedStatement ps=con.prepareStatement("UPDATE post SET post=? WHERE postid=?");
		
		//ps.setInt(1,rm.getCompid());
		ps.setString(1,rm.getPost());
		ps.setInt(2,rm.getPostid());
		
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
