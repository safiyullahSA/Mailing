package SourceCode;

import java.util.Properties;


import javax.mail.Authenticator;
import javax.mail.Message;

import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {
	public static void sendMail(String recepient) throws Exception
	{
		System.out.println("Preparing to send email");
		Properties properties = new Properties();
		properties.put("mail.smtp.auth","true");
		properties.put("mail.smtp.starttls.enable","true");
		properties.put("mail.smtp.host","smtp.gmail.com");
		properties.put("mail.smtp.port","587");
		
		String myEmailAddress = "fullstackjavadeveloper.com@gmail.com";
		String password = "Temporary";
		
		Session session = Session.getInstance(properties, new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				// TODO Auto-generated method stub
				return new PasswordAuthentication(myEmailAddress, password);
			}
		});
		Message message = prepareMessage(session , myEmailAddress, recepient);
		Transport.send(message);
		System.out.println("Message sent Successfully");
	}

	private static Message prepareMessage(Session session,String myEmailAddress,String recepient) {
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(myEmailAddress));
			message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
			message.setSubject("Java Full Stack Developer");
			message.setText("Hi Buddy,\n Welcome to Java Full Stack Developer");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return message;
	}
	

}
