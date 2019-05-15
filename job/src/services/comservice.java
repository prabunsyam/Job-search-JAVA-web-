package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import model.commod;
import model.usermod;
//import model.usermod;
import connection.connect;

public class comservice {
	Connection con=connect.getConnection();
	public int insert(commod rm)
	{
		int h,id=0;
	
	    try
	    {
	    	String s1="insert into compregi(cname,caddress,cweb,discription,contact,mailid,status)values(?,?,?,?,?,?,?)";
	       String s2="insert into login(id,username,password,type,status)values(?,?,?,?,?)";
	    	PreparedStatement ps=con.prepareStatement(s1);
	        ps.setString(1,rm.getCname());
	        ps.setString(2,rm.getCaddress());
	        ps.setString(3,rm.getCweb());
	        ps.setString(4,rm.getDiscription());	      
	        ps.setLong(5,rm.getContact());
	        ps.setString(6,rm.getMailid());
	        ps.setString(7,"ACTIVE");
	       
	       h= ps.executeUpdate();
	        if(h!=0)
	        {
	        ResultSet rs=ps.getGeneratedKeys();
	        while(rs.next())
	        {
	        	id=rs.getInt(1);
	        	
	        }
	        
	    	ps=con.prepareStatement(s2);
	    	ps.setInt(1, id);
	    	ps.setString(2, rm.getUser());
	    	ps.setString(3, rm.getPass());
	    	ps.setString(4,"company");
	    	ps.setString(5, "ACTIVE");
	    	ps.executeUpdate();
	    	rs=ps.getGeneratedKeys();
	          if(rs.next())
	          {
	        	  return rs.getInt(1);
	        	  
	          }
	    }}
	    catch(Exception e)
	    {
	    	e.printStackTrace();
	    	
	    }
	
		
	return 0;
	}
	public ArrayList<commod>selectAllRegistration()
	{
		commod rm=null;
		ArrayList<commod>arr1=new ArrayList<commod>();
		try
		{
			PreparedStatement p=con.prepareStatement("SELECT * FROM compregi");
			ResultSet rs=p.executeQuery();
			while(rs.next())
			{
				rm=new commod();
				rm.setCompanyid(rs.getInt(1));
				rm.setCname(rs.getString(2));
				rm.setCaddress(rs.getString(3));
				rm.setCweb(rs.getString(4));
				rm.setDiscription(rs.getString(5));
				rm.setContact(rs.getLong(6));
				rm.setMailid(rs.getString(7));
				rm.setStatus(rs.getString(8));
				
				
				
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
	public ArrayList<commod>selectuser(int companyid)
	{
		commod rm=null;
		ArrayList<commod>ar=new ArrayList<commod>();
		try
		{
			PreparedStatement p=con.prepareStatement("SELECT companyid,cname,caddress,cweb,discription,contact,mailid,status  FROM compregi WHERE companyid=?");
			p.setInt(1,companyid );
			ResultSet rs=p.executeQuery();
			while(rs.next())
			{System.out.println("gettttt");
				rm=new commod();
				rm.setCompanyid(rs.getInt(1));System.out.println(rs.getInt(1));
				rm.setCname(rs.getString(2));System.out.println(rs.getString(2));
				rm.setCaddress(rs.getString(3));System.out.println(rs.getString(3));
				rm.setCweb(rs.getString(4));System.out.println(rs.getString(4));
				rm.setDiscription(rs.getString(5));System.out.println(rs.getString(5));
				rm.setContact(rs.getLong(6));System.out.println(rs.getString(6));
				rm.setMailid(rs.getString(7));System.out.println(rs.getString(7));
				rm.setStatus(rs.getString(8));
			
				
				ar.add(rm);	
				
			}
			return ar;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

	return null;
	}
	public commod selectByid(int Id)
	{
		
		commod rm=null;
		ArrayList<commod>arr1=new ArrayList<commod>();
		try
		{
			String query="SELECT companyid,cname,caddress,cweb,discription,contact,mailid FROM compregi WHERE companyid=?";
			PreparedStatement p=con.prepareStatement(query);
		p.setInt(1, Id) ;
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{System.out.println("xxxxxxxx");
			rm=new commod();
			rm.setCompanyid(rs.getInt(1));System.out.println(rs.getInt(1));
			rm.setCname(rs.getString(2));
			rm.setCaddress(rs.getString(3));
			rm.setCweb(rs.getString(4));
			rm.setDiscription(rs.getString(5));
			rm.setContact(rs.getLong(6));
			rm.setMailid(rs.getString(7));
			//rm.setStatus(rs.getString(8));
			
			System.out.println("1232121");
			arr1.add(rm);
		}
		return rm;
	}

catch(Exception e)
{
	e.printStackTrace();
}
return null;
}
public int updateRegisration(commod rm)
{
	try
	{
		PreparedStatement ps=con.prepareStatement("UPDATE compregi SET cname=?,caddress=?,cweb=?,discription=?,contact=?,mailid=? WHERE companyid=?");
		ps.setString(1,rm.getCname());
		ps.setString(2,rm.getCaddress());
		ps.setString(3, rm.getCweb());
		ps.setString(4, rm.getDiscription());
		ps.setLong(5,rm.getContact());
		ps.setString(6,rm.getMailid());
		//ps.setString(7,rm.getStatus());
		
		ps.setInt(7,rm.getCompanyid());
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
public  void  changeStatus(int id,String status)
{
	if(status.equals("ACTIVE"))
	{
		try {
				PreparedStatement ps=con.prepareStatement("update compregi set `status`='INACTIVE' where `companyid`=?");
				ps.setInt(1, id);						
				System.out.println(ps);
				ps.executeUpdate();
				
				PreparedStatement ps1=con.prepareStatement("update login  set `status`='INACTIVE' where `id`=? and type='company'");
				ps1.setInt(1, id);
				ps1.executeUpdate();
			} 
		catch (SQLException e) 
			{
			 	e.printStackTrace();
			}	
	}
	
	else 
	{
		try {
				PreparedStatement ps=con.prepareStatement("update compregi  set `status`='ACTIVE' where `companyid`=?");
				ps.setInt(1, id);
				System.out.println(ps);
				ps.executeUpdate();
				
				PreparedStatement ps1=con.prepareStatement("update login  set `status`='ACTIVE' where `id`=? and type='company'");
				ps1.setInt(1, id);
				ps1.executeUpdate();
			} 
		catch (SQLException e)
			{
			 	e.printStackTrace();
			}
	}
}
	public void senMail(commod rm) throws Exception
	   {
	       
	        final String username = "casdml2017@gmail.com";
	        final String password = "myproject";
	 
	        Properties props = new Properties();
	        props.put("mail.smtp.auth", "true");
			props.put("mail.smtp.starttls.enable", "true");
			props.put("mail.smtp.host", "smtp.gmail.com");
			props.put("mail.smtp.port", "587");
	 
			Session session = Session.getInstance(props,new javax.mail.Authenticator() {
	            @Override
	        protected PasswordAuthentication getPasswordAuthentication() {
	        return new PasswordAuthentication(username, password);}});
	    
	        try
	        {
	        	String to=rm.getMailid();
	            String toemail=to;
	            
	         // Create a default MimeMessage object.
	         MimeMessage message = new MimeMessage(session);
	        // Set From: header field of the header.
	         message.setFrom(new InternetAddress(username));
	        // Set To: header field of the header.
	         message.addRecipient(Message.RecipientType.TO,new InternetAddress(toemail));
	        // Set Subject: header field
	         String sub="Replay From Job Portal Administrator";
	         message.setSubject(sub);
	         // Create the message part 
	         BodyPart messageBodyPart = new MimeBodyPart();
	         // Fill the message
	        		         
	         messageBodyPart.setText("Hi, "+rm.getCname()+" you are Sucessfully Registerd."
	 				+"\n Your Username is: "+rm.getUser()+" " 
	 				+"\n \t \t \t and"
	 				+"\n Your Password is: "+rm.getPass());		//--------------get decrypted password-----------------
	         
	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);

	         // Part two is attachment
	         //messageBodyPart = new MimeBodyPart();
	         //String filename = file;
	         //DataSource source = new FileDataSource(filename);
	         //messageBodyPart.setDataHandler(new DataHandler(source));
	         //messageBodyPart.setFileName(filename);
	         //multipart.addBodyPart(messageBodyPart);

	         // Send the complete message parts
	         message.setContent(multipart );

	         // Send message
	         Transport.send(message);
	         System.out.println("Sent message successfully....");
	         //date and time
	         SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
	             Date d=new Date();
	             String dat=df.format(d);
	             SimpleDateFormat dft=new SimpleDateFormat("hh:mm:ss");
	             String time=dft.format(d);
	         //take backup    
	         //backup.backupemail(toemail,dat, time);
	        
	      }catch (MessagingException mex) {
	    	  System.out.println("Exception in senMail fu in serv");
	      }
	   }

}
