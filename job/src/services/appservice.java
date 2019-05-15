package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

import model.appmod;
import model.commod;
import model.usermod;
import model.vacmod;

import connection.connect;


public class appservice {
	Connection con=connect.getConnection();
	public int appinsert(appmod am)
	{
		try
		{
			String s1="insert into application(userid,compid,vacid)values(?,?,?)";
			PreparedStatement ps=con.prepareStatement(s1);
			ps.setInt(1,am.getUid());
			ps.setInt(2,am.getCid());
			ps.setInt(3,am.getVid());
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
	public ArrayList<appmod>searchapp(int vacid )
	{
		appmod rm=null;
		ArrayList<appmod>arr8=new ArrayList<appmod>();
		try
		{
			PreparedStatement p=con.prepareStatement("SELECT reg.name,post.post,skill.skill,qualification.qualification,application.userid,application.compid,application.vacid FROM application INNER JOIN reg on application.userid=reg.userid INNER JOIN jobvacancy on application.vacid=jobvacancy.vacid INNER JOIN post on jobvacancy.postid=post.postid INNER JOIN skill on jobvacancy.skillid=skill.skillid INNER JOIN qualification on jobvacancy.quali=qualification.qualificationid WHERE application.vacid=?");
			
			p.setInt(1,vacid);
			ResultSet rs=p.executeQuery();
			while(rs.next())
			{
				rm=new appmod();
				//rm.setId(rs.getInt(1));
				rm.setName(rs.getString(1));
				rm.setPost(rs.getString(2));
				rm.setSkill(rs.getString(3));
				rm.setQuali(rs.getString(4));
				rm.setUid(rs.getInt(5));
				rm.setCid(rs.getInt(6));
				rm.setVid(rs.getInt(7));
				
				
				arr8.add(rm);
				
			}
			return arr8;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			
		}

	return null;
	}	
	
	//-------------count app------------
	public int countappl(int uid,int cid,int vid)
	{
		ResultSet rs=null;
		try
		{
			String s=("SELECT COUNT(*)FROM application WHERE  userid=? AND compid=? AND vacid=? ");
			PreparedStatement ps= con.prepareStatement(s);
			ps.setInt(1,uid);
			ps.setInt(2,cid);
			
			ps.setInt(3,vid);
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
	
	public int accept(int c,int v,int u)
	{ 
		try
		{
			PreparedStatement ps=con.prepareStatement("UPDATE application SET compid=? WHERE userid=? and  vacid=?");
			ps.setInt(1, c);
			ps.setInt(2,u );
			ps.setInt(3, v);
			System.out.println(ps);
			int a=ps.executeUpdate();
		
			
			return a;
			}

		
		catch(Exception e)
		{
			
		}
		System.out.println("not inserted");
		return 0;
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
	        		         
	         messageBodyPart.setText("Hi, you are Sucessfully applied.");		//--------------get decrypted password-----------------
	         
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
