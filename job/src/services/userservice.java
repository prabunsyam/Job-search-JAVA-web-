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

import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.sun.org.apache.regexp.internal.recompile;

import model.commod;
import model.dismod;
//import model.mod;
import model.usermod;
import connection.connect;

public class userservice {
	Connection con=connect.getConnection();
	public int insert(usermod rm)
	{
		int k,id=0;
	    try
	    {
	    	String s1="insert into reg(name,address,state,district,gen,dob,age,ph,qualification,yearofpass,workexp,mail,status)values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    	String s2="insert into login (id,username,password,type,status)values(?,?,?,?,?)";
	    	PreparedStatement ps=con.prepareStatement(s1);
	        ps.setString(1,rm.getName());
	        ps.setString(2,rm.getAdd());
	        ps.setString(3,rm.getState());
	        ps.setString(4,rm.getDist());
	      
	        ps.setString(5,rm.getGen());
	        ps.setString(6,rm.getDob());
	        ps.setLong(7,rm.getAge());
	        ps.setLong(8,rm.getPh());
	        ps.setString(9,rm.getQl());
	        ps.setLong(10,rm.getYrp());
	        ps.setString(11,rm.getWorkexp());
	      //  ps.setString(12,rm.getResume());

	        ps.setString(12,rm.getMail());
	        ps.setString(13,"ACTIVE");
	        k=ps.executeUpdate();
	        if(k!=0)
	        {
	        ResultSet rs=ps.getGeneratedKeys();
	        while(rs.next())
	        {
	        	id= rs.getInt(1);
	        	
	        }
	    ps=con.prepareStatement(s2);
	    ps.setInt(1,id);
	    ps.setString(2,rm.getUsername());
	    ps.setString(3,rm.getPassword());
	    ps.setString(4,"User");
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
	
	public ArrayList<usermod>selectAllRegistration()
	{
		usermod rm=null;
		ArrayList<usermod>arr1=new ArrayList<usermod>();
		try
		{
			PreparedStatement p=con.prepareStatement("SELECT reg.userid,reg.name,reg.address,state.sname,district.distname,reg.gen,reg.dob,reg.age,reg.ph,qualification.qualification,reg.yearofpass,reg.workexp,reg.mail,reg.status From reg INNER JOIN state on reg.state=state.sid INNER JOIN district on reg.district=district.disid INNER JOIN qualification on reg.qualification=qualification.qualificationid ");
			
			ResultSet rs=p.executeQuery();
			while(rs.next())
			{
				rm=new usermod();
				rm.setUseid(rs.getInt(1));			System.out.println("a"+rs.getInt(1));
				rm.setName(rs.getString(2));
				rm.setAdd(rs.getString(3));
				rm.setState(rs.getString(4));
				rm.setDist(rs.getString(5));
				rm.setGen(rs.getString(6));
				rm.setDob(rs.getString(7));
				rm.setAge(rs.getLong(8));
				rm.setPh(rs.getLong(9));
				rm.setQl(rs.getString(10));
				rm.setYrp(rs.getLong(11));
				rm.setWorkexp(rs.getString(12));
				rm.setMail(rs.getString(13));
				rm.setStatus(rs.getString(14));
				
				
				arr1.add(rm);	
				
			}
			return arr1;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

	return null;
	}//for  user
	
	public ArrayList<usermod>selectuser(int userid)
	{
		usermod rm=null;
		ArrayList<usermod>ar=new ArrayList<usermod>();
		try
		{
			PreparedStatement p=con.prepareStatement("SELECT reg.userid,reg.name,reg.address,state.sname,district.distname,reg.gen,reg.dob,reg.age,reg.ph,qualification.qualification,reg.yearofpass,reg.workexp,reg.mail,reg.status From reg INNER JOIN state on reg.state=state.sid INNER JOIN district on reg.district=district.disid INNER JOIN qualification on reg.qualification=qualification.qualificationid WHERE reg.userid=? ");
			p.setInt(1,userid );
			ResultSet rs=p.executeQuery();
			while(rs.next())
			{System.out.println("gettttt");
				rm=new usermod();
				rm.setUseid(rs.getInt(1));System.out.println(rs.getInt(1));
				rm.setName(rs.getString(2));System.out.println(rs.getString(2));
				rm.setAdd(rs.getString(3));System.out.println(rs.getString(3));
				rm.setState(rs.getString(4));System.out.println(rs.getString(4));
				rm.setDist(rs.getString(5));System.out.println(rs.getString(5));
				rm.setGen(rs.getString(6));System.out.println(rs.getString(6));
				rm.setDob(rs.getString(7));System.out.println(rs.getString(7));
				rm.setAge(rs.getLong(8));System.out.println(rs.getLong(8));
				rm.setPh(rs.getLong(9));System.out.println(rs.getLong(9));
				rm.setQl(rs.getString(10));
				rm.setYrp(rs.getLong(11));
				rm.setWorkexp(rs.getString(12));
				rm.setMail(rs.getString(13));
				rm.setStatus(rs.getString(14));
				
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
	
	
	
	public usermod selectByid(int Id)
	{
		
		usermod rm=null;
		ArrayList<usermod>arr1=new ArrayList<usermod>();
		try
		{
			String query="SELECT userid,name,address,state,district,gen,dob,age,ph,qualification,yearofpass,workexp,mail FROM reg WHERE userid=?";
			PreparedStatement p=con.prepareStatement(query);
		p.setInt(1, Id) ;
		ResultSet rs=p.executeQuery();
		while(rs.next())
		{System.out.println("1232121");
			rm=new usermod();
			rm.setId(rs.getInt(1));System.out.println(rs.getInt(1));
			rm.setName(rs.getString(2));
			rm.setAdd(rs.getString(3));
			rm.setState(rs.getString(4));
			rm.setDist(rs.getString(5));
			rm.setGen(rs.getString(6));
			rm.setDob(rs.getString(7));
			rm.setAge(rs.getLong(8));
			rm.setPh(rs.getLong(9));
			rm.setQl(rs.getString(10));
			rm.setYrp(rs.getLong(11));
			rm.setWorkexp(rs.getString(12));
			rm.setMail(rs.getString(13));
			//rm.setStatus(rs.getString(14));
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
	
public int updateRegisration(usermod rm)
{
	try
	{
		PreparedStatement ps=con.prepareStatement("UPDATE reg SET name=?,address=?,state=?,district=?,gen=?,dob=?,age=?,ph=?,qualification=?,yearofpass=?,workexp=?,mail=? WHERE userid=?");
		ps.setString(1,rm.getName());
		ps.setString(2,rm.getAdd());
		ps.setString(3, rm.getState());
		ps.setString(4, rm.getDist());
		ps.setString(5,rm.getGen());
		ps.setString(6,rm.getDob());
		ps.setLong(7,rm.getAge());
		ps.setLong(8,rm.getPh());
		ps.setString(9, rm.getQl());
		ps.setLong(10, rm.getYrp());
		ps.setString(11, rm.getWorkexp());
		ps.setString(12, rm.getMail());
		ps.setInt(13,rm.getUseid());
		//rm.setStr(14,rm.get);
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
//status
public  void  changeStatus(int id,String status)
{
	if(status.equals("ACTIVE"))
	{
		try {
				PreparedStatement ps=con.prepareStatement("update reg set `status`='Inactive' where `userid`=?");
				ps.setInt(1, id);						
				System.out.println(ps);
				ps.executeUpdate();
				
				PreparedStatement ps1=con.prepareStatement("update login  set `status`='Inactive' where `id`=? and type='User'");
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
				PreparedStatement ps=con.prepareStatement("update reg  set `status`='ACTIVE' where `userid`=?");
				ps.setInt(1, id);
				System.out.println(ps);
				ps.executeUpdate();
				
				PreparedStatement ps1=con.prepareStatement("update login  set `status`='ACTIVE' where `id`=? and type='User'");
				ps1.setInt(1, id);
				ps1.executeUpdate();
			} 
		catch (SQLException e)
			{
			 	e.printStackTrace();
			}
	}
	
}
public void senMail(usermod rm) throws Exception
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
     	String to=rm.getMail();
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
     		         
      messageBodyPart.setText("Hi, "+rm.getName()+" you are Sucessfully Registerd."
				+"\n Your Username is: "+rm.getUsername()+" " 
				+"\n \t \t \t and"
				+"\n Your Password is: "+rm.getPassword());		//--------------get decrypted password-----------------
      
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
public String getmail(int userid) 
{
	usermod um=null;
	try
	{
	String s1="SELECT mail FROM reg WHERE userid=?";
	PreparedStatement ps=con.prepareStatement(s1);
	ps.setInt(1,userid);
	System.out.println(ps);
	ResultSet rs=ps.executeQuery();
	while(rs.next())
	{
		//um=new usermod();
		//um.setMail(rs.getString(1));
		String email;
		email=rs.getString(1);
		return email;
		
	}
	
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	return null;
}

}
