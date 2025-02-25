package com.backend;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	public static void sendingMail(String recipient,String c){
		Properties properties =new Properties();
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port", 587);
		//properties.put("mail.debug","true");
	
	String info =c;
	String username ="ponnulinga333@gmail.com";
	//Here we have to use that email which is used as a sender email by us.
	String password ="app password";
	//We need app password for that particular email to run this code.
	 
   Session session =Session.getInstance(properties,new javax.mail.Authenticator() {
	   protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
	           return new javax.mail.PasswordAuthentication(username,password);}});

   Message message =prepareMessage(session,username,recipient,info);
	   try {
		   Transport.send(message);
	   System.out.println("email sent successfully");
	   }
  catch(Exception e) {
	  e.printStackTrace();
  }
	   }
	
   public static Message prepareMessage(Session session,String username,String recipient,String info) {
	   Message message = new MimeMessage(session);
	   try {
		   message.setFrom(new InternetAddress(username));
		   message.setRecipient (Message.RecipientType.TO,new InternetAddress(recipient));
		   message.setSubject("Success Bank");
		   message.setText(info);
	   }
	   catch(Exception e) {
		   e.printStackTrace();
	   }
	   return message;
   
	}
 
	
	}




