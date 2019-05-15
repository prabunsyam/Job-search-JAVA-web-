package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connection.connect;

import model.loginmod;

public class loginservice {
	
	Connection con=connect.getConnection();
	public loginmod logincheck(String username,String password)
	{
		System.out.println("inside login  check");
		loginmod lm=null;
		try
		{
			String s1="SELECT sino,id,username,password,type,status FROM login WHERE username=? AND password=?";
			PreparedStatement ps=con.prepareStatement(s1);
			ps.setString(1,username);
			ps.setString(2, password);
			System.out.println(ps);
			ResultSet rs= ps.executeQuery();
			System.out.println(s1);
			while(rs.next())
			{
				lm=new loginmod();
				lm.setSino(rs.getInt(1));
				lm.setId(rs.getInt(2));
				lm.setUsername(rs.getString(3));
				lm.setPassword(rs.getString(4));
				lm.setType(rs.getString(5));
				lm.setStatus(rs.getString(6));
				System.out.println("okkkk");
				return lm;
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	//change password
	public int changepwd(int id,String password,String type)
	{
		try
		{
			PreparedStatement p=con.prepareStatement("update login set password=? where id=? AND type=?" );
			p.setString(1,password);
			p.setInt(2,id);
			p.setString(3,type);
			int result=p.executeUpdate();
			return result;
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	//getting curent password
	public loginmod getpassword(int id,String type)
	{System.out.println("fffffff");
		loginmod lm=null;
		try
		{
			String sql="SELECT sino,id,username,password,type,status FROM login WHERE id=? and type=?";
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1,id);
			ps.setString(2,type);
			System.out.println(ps);
			ResultSet rs=ps.executeQuery();
			System.out.println(sql);
			
			while(rs.next())
			{
				lm=new loginmod();
				lm.setSino(rs.getInt(1));
				lm.setId(rs.getInt(2));
				lm.setUsername(rs.getString(3));
				lm.setPassword(rs.getString(4));
				lm.setType(rs.getString(5));
				lm.setStatus(rs.getString(6));
				System.out.println(rs.getString(6));
			}
			return lm;
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return null;
	}
	 
				

}
