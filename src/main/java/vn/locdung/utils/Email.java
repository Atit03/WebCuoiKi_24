package vn.locdung.utils;

import java.util.Properties;
import java.util.Random;

import com.mysql.cj.Session;

import jakarta.mail.*;
import jakarta.mail.Transport;
import jakarta.mail.internet.*;
import vn.locdung.models.UserModel;

public class Email {
	
	public String getRandom() {
		Random rnd = new Random();
		int number = rnd.nextInt(999999);
		return String.format("%06d", number);
	}
	public boolean sendEmail(UserModel user) {
		boolean test = false;
		
		String toEmail = user.getEmail();
		String fromEmail = "21110897@student.hcmute.edu.vn";
		String password = "Locyen123@@@";
		
		try {
			Properties pr = configEmail(new Properties());
			// get session to authenticate the host email address and password
			jakarta.mail.Session session = jakarta.mail.Session.getInstance(pr, new Authenticator() {
			    @Override
			    protected PasswordAuthentication getPasswordAuthentication() {
			        return new PasswordAuthentication(fromEmail, password);
			    }
			});

			// set email message details
			Message mess = new MimeMessage(session);
			mess.setHeader("Content-Type", "text/plain; charset=UTF-8");
			// set from email address
			mess.setFrom(new InternetAddress(fromEmail));
			// set to email address or destination email address
			mess.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

			// set email subject
			mess.setSubject("Confirm Code");
			
			mess.setText("Your coed is: "+ user.getCode());
			Transport.send(mess);
			test = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
	public Properties configEmail(Properties pr) {
	    // your host email smtp server details
	    pr.setProperty("mail.smtp.host", "smtp.gmail.com");
	    pr.setProperty("mail.smtp.port", "587");
	    pr.setProperty("mail.smtp.auth", "true");
	    pr.setProperty("mail.smtp.starttls.enable", "true");
	    pr.put("mail.smtp.socketFactory.port", "587");
	    pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

	    return pr;
	}

}
