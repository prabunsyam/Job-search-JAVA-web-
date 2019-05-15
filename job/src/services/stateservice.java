package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

//import model.feedmod;
//import model.dismod;
import model.dismod;
import model.statemod;
import connection.connect;

public class stateservice {
	Connection con=connect.getConnection();
	public int insert(statemod rm)
	{
	    try
	    {
	    	String s1="insert into state(sname)values(?)";
	        PreparedStatement ps=con.prepareStatement(s1);
	        ps.setString(1,rm.getState());
	       
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
public ArrayList<statemod>selectAllRegistration()
{
	statemod rm=null;
	ArrayList<statemod>arr=new ArrayList<statemod>();
	try
	{
		PreparedStatement p=con.prepareStatement("SELECT * FROM state");
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			rm=new statemod();
			rm.setSid(rs.getInt(1));
			rm.setState(rs.getString(2));
			arr.add(rm);	
			
		}
		return arr;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}

return null;
}
public statemod selectByid(int Id)
{
	
	statemod rm=null;
	ArrayList<statemod>arr=new ArrayList<statemod>();
	try
	{
		String query="SELECT sid,sname FROM`state` WHERE sid=?";
		PreparedStatement p=con.prepareStatement(query);
	p.setInt(1, Id) ;
	ResultSet rs=p.executeQuery();
	while(rs.next())
	{
		rm=new statemod();
		rm.setSid(rs.getInt(1));System.out.println(rs.getInt(1));
		rm.setState(rs.getString(2));System.out.println(rs.getString(2));
		
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
public int updateRegisration(statemod rm)
{
try
{
	PreparedStatement ps=con.prepareStatement("UPDATE state SET sname=? WHERE sid=?");
	ps.setString(1,rm.getState());
	ps.setInt(2,rm.getSid());
	
	
	
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