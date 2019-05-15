package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
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

import model.passmod;

//import model.commod;

import connection.connect;

public class fgpservice {
	Connection con=connect.getConnection();
	public String selectpass(String email)
	{
		String password=null;
		try
		{
			String s1="SELECT password FROM login WHERE username=?";
			PreparedStatement ps=con.prepareStatement(s1);
			ps.setString(1,email);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				password=rs.getString(1);
			}
			return password;
			
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void senMail(passmod rm) throws Exception
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
	        	String to=rm.getUesrname();
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
	        		         
	         messageBodyPart.setText("Hi,  you'r password is."
	 				
	 				
	 			+rm.getPassword());		//--------------get decrypted password-----------------
	         
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
