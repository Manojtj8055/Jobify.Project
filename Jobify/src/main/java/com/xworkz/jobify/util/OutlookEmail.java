package com.xworkz.jobify.util;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;

import org.springframework.stereotype.Component;

@Component
public class OutlookEmail {

	    public static void sendRegistrationEmail(String toEmail, String username) {
	        // Sender's email address and password
	        String fromEmail = "manoj805517@outlook.com";
	        String password = "Manoj@8055";

	        // Set up mail server properties
	        Properties properties = new Properties();
	        properties.put("mail.smtp.host", "smtp.office365.com");
	        properties.put("mail.smtp.port", "587");
	        properties.put("mail.smtp.starttls.enable", "true");
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.timeout", "50000"); // Set timeout to 5000 milliseconds (adjust as needed)
	        properties.put("mail.smtp.connectiontimeout", "50000");


	        // Create a session with the mail server
	        Session session = Session.getInstance(properties, new Authenticator() {
	            @Override
	            protected PasswordAuthentication getPasswordAuthentication() {
	                return new PasswordAuthentication(fromEmail, password);
	            }
	        });

	        try {
	            // Create a message
	            Message message = new MimeMessage(session);
	            message.setFrom(new InternetAddress(fromEmail));
	            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
	            message.setSubject("Registration Successful");
	            
	            // Customize the email content
	            String emailContent = "Dear " + username + ",\n\n"
	                    + "Thank you for registering on our website Jobify.com . Your registration was successful..."
	                    + "further things will be updated thank you";

	            message.setText(emailContent);

	            // Send the message
	            Transport.send(message);
	            
	            System.out.println(message);

	            System.out.println("Email sent successfully!");

	        } catch (MessagingException e) {
	            e.printStackTrace();
	        }
	    }
	    
}