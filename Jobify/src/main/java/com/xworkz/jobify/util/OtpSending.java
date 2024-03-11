package com.xworkz.jobify.util;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.stereotype.Component;

@Component
public class OtpSending {
	 private static final String EMAIL_USERNAME = "manoj805517@outlook.com"; // Replace with your email address
	    private static final String EMAIL_PASSWORD = "Manoj@8055"; // Replace with your email password

	
	public void sendOtpToEmail(String email) {
		String generateOtp = generateOtp();
		sendOtpEmail(email, generateOtp);
	}

	public String generateOtp() {

		Random random = new Random();
		int otpValue = 100000 + random.nextInt(900000);
		return String.valueOf(otpValue);
	}

	public void sendOtpEmail(String email, String generateOtp) {
		Properties properties = new Properties();
		properties.put("mail.smtp.host", "smtp-mail.outlook.com");        
		properties.put("mail.smtp.port", "587");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_USERNAME, EMAIL_PASSWORD);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(EMAIL_USERNAME,"Jobify"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
            message.setSubject("Your OTP for verification");
            message.setText("Your OTP is: " + generateOtp);

            Transport.send(message);
            System.out.println("OTP sent successfully to " + email);
        } catch (MessagingException e) {
            e.printStackTrace();
            // Handle the exception properly, log the error, or throw a custom exception
        } catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
		System.out.println("Sending OTP to " + email + ": " + generateOtp);

	}

}