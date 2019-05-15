package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import model.dismod;
//import model.mod;
import model.statemod;
//import model.statemod;
import connection.connect;

public class dservice {
	Connection con=connect.getConnection();
	public int insert(dismod rm)
	{
	    try
	    {
	    	String s1="insert into district(disid,distname,stateid)values(?,?,?)";
	        PreparedStatement ps=con.prepareStatement(s1);
	        ps.setInt(1, rm.getDisid());
	        ps.setString(2,rm.getDistname());
	        ps.setLong(3,rm.getSid() );
	       
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
	public ArrayList<dismod>selectAllRegistration()
	{
		dismod rm=null;
		ArrayList<dismod>arr5=new ArrayList<dismod>();
		try
		{
			PreparedStatement p=con.prepareStatement("SELECT district.disid,district.distname,state.sname FROM `district` INNER JOIN state on district.stateid=state.sid");
			ResultSet rs=p.executeQuery();
			while(rs.next())
			{
				rm=new dismod();
				rm.setDisid(rs.getInt(1));
				rm.setDistname(rs.getString(2));
				rm.setSname(rs.getString(3));
				//rm.setDistname(rs.getString(2));
				
				arr5.add(rm);	
				
			}
			return arr5;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

	return null;
	}
	public dismod selectByid(int Id)
	{
		
		dismod rm=null;
		ArrayList<dismod>arr=new ArrayList<dismod>();
		try
		{
			String query="SELECT district.disid,district.distname,state.sname FROM `district` INNER JOIN state on district.stateid=state.sid WHERE district.disid=?";
			PreparedStatement p=con.prepareStatement(query);
		p.setInt(1, Id) ;
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{
			rm=new dismod();
			rm.setDisid(rs.getInt(1));System.out.println(rs.getInt(1));
			rm.setDistname(rs.getString(2));System.out.println(rs.getString(2));
			rm.setSname(rs.getString(3));
			
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
public int updateRegisration(dismod rm)
{
	try
	{
		PreparedStatement ps=con.prepareStatement("UPDATE district SET distname=?,stateid=? WHERE disid=?");
		ps.setInt(1,rm.getDisid());
		ps.setString(1,rm.getDistname());
		ps.setInt(2,rm.getSid());
		ps.setInt(3,rm.getDisid());
		
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
