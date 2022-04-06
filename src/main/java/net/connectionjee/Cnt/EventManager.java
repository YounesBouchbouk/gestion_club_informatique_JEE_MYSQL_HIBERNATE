package net.connectionjee.Cnt;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import net.connectionjee.Evenement;
import net.connectionjee.User;
import net.connectionjee.Utils.SendEmailTLS;
import utils.JPAutil;

public class EventManager {
	
	 private EntityManager entityManager=JPAutil.getEntityManager("HyberProjectStart");
	 
	 public Evenement addEvent(String title , String Date_d , String time , String Description , String url){
		 Evenement newevent = new Evenement();
		 System.out.println(time);
		 System.out.println(Date_d);
//		    Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(Date_d);  
		 
		 newevent.setDate_d(Date_d);
		 newevent.setDescription(Description);
		 newevent.setUrl(url);
		 newevent.setTitle(title);
		 newevent.setTimm_db(time);
		 
		 EntityTransaction tx = entityManager.getTransaction();
	    	if(!tx.isActive()) tx.begin();
	    	entityManager.persist(newevent);
	    	tx.commit();
	    		 
		return newevent;
		 
	 }
	 
	 public boolean comparedatewhiteLocal(String date ) throws ParseException {
		 Date date1= new SimpleDateFormat("yyyy-MM-dd").parse(date);
		 DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		 LocalDateTime now = LocalDateTime.now(); 
		 System.out.println(date1);
		 Date date2= new SimpleDateFormat("yyyy-MM-dd").parse(dtf.format(now));

		 System.out.println(date2);
		 
		 if(date1.after(date2)) {
			 System.out.println("jdiiiiide");
				return true;
		 }else {
			 System.out.println("9diiiiime");
				return false;
		 }
		 
	 }
	 public List<Evenement> getAllEvent(){
		 	EntityTransaction tx = entityManager.getTransaction();
	    	if(!tx.isActive()) tx.begin();
	        Query query = entityManager.createNativeQuery("SELECT * FROM evenement ",Evenement.class);
	        query.setHint("javax.persistence.cache.storeMode", "REFRESH");
	        List<Evenement> event =  query.getResultList();
	        
	        Collections.reverse(event);

	        
		 return event;
	 }
	 
	 public void notifyAdr(Evenement theEvent ) throws AddressException {
		 UserManager usrmng = new UserManager();
		 List<User> adr = usrmng.getAdrOnly();
		 InternetAddress[] recipientAddress = new InternetAddress[adr.size()];
		 //Address[] cc = new Address[]; 
//		 for(User usr :adr ) {
//			 emailListe.addRecipients(InternetAddress.parse("abc@abc.com"));
//		 }
		 int counter = 0;
		 for (User recipient : adr) {
		     recipientAddress[counter] = new InternetAddress(recipient.getEmail());
		     counter++;
		 }
		 
		 Session emailSession = SendEmailTLS.getMailConnection();
    	 try {

         Message message = new MimeMessage(emailSession);
         message.setFrom(new InternetAddress("ClubInfo@gmail.com"));
         message.setRecipients(
                 Message.RecipientType.TO,
                 recipientAddress
         );
      // Create the message part 
         MimeBodyPart messageBodyPart = new MimeBodyPart();

         // Fill the message
         messageBodyPart.setText("<h1>Dear User, </h1>"
                 + "<div>Admin has annence a new Event </div>"
                 + "<div> <h3> Title : " + theEvent.getTitle() + "<h3/>"
                 + "<div><h3> Date : " + theEvent.getDate_d() + theEvent.getTimm_db()  + "<h3/> </div>"
                 + "<div> <h3> Description : " + theEvent.getDescription() + "<h3/> </div>"
                 + "Please be there ! " 
                 + " </div>","UTF-8","html");

         Multipart multipart = new MimeMultipart();
         multipart.addBodyPart(messageBodyPart);
         
         message.setSubject("ClubInfo : New Event has Annenced ");
//         message.setText("Dear  User,"
//                 + "\n\n Please Confirm Your Email By Clicking Here!" + "your Token is " + Token );
         message.setContent(multipart);
         Transport.send(message);

         System.out.println("Done");

     } catch (MessagingException e) {
         e.printStackTrace();
     }
	 }

}
