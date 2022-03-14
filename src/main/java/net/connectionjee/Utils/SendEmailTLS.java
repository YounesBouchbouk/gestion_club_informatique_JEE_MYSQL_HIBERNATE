package net.connectionjee.Utils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class SendEmailTLS {
	
	  
     
	public static Session getMailConnection () {
		String username = "younss.india@gmail.com";
	    String password = "shmfofnnzrylokdw";
	    
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
	    prop.put("mail.smtp.starttls.enable", "true");
		prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS
        
        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
		return session;
        
        
	}

}
