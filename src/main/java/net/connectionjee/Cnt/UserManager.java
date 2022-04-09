package net.connectionjee.Cnt;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.eclipse.persistence.config.QueryType;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import net.connectionjee.Absence;
import net.connectionjee.Role;
import net.connectionjee.User;
import net.connectionjee.Utils.SendEmailTLS;
import utils.JPAutil;

public class UserManager {
//    private EntityManager entityManager=JPAutil.getEntityManager("HyberProjectStart");

    public User getUser(int id) {
    	EntityManager entityManager=JPAutil.getEntityManager("HyberProjectStart");
        User user = entityManager.find(User.class,id); 
    	return  user;
    }
    
    public  List<Absence> GetUserAbs(int id) {
      
        EntityManager entityManager=JPAutil.getEntityManager("HyberProjectStart");
		List<Absence> abs =
		         entityManager.createNativeQuery("select * from abscence  where THEUSER_id = ?",Absence.class)
		                       .setParameter(1, id)
		                      .getResultList(); 
			return abs;

    }
    
    public int nombreAbcence(int id ) {
    	List<Absence> abs = this.GetUserAbs(id);
    	
    	return abs.size();
    }
    
     public User create(String Fname, String Lname, String email, String password, String cIN, String cNE, String filiere, String inscription) {
    	User newuser = new  User();
    	String Token = Generatenewtoken();
    	
    	newuser.setFname(Fname);
    	newuser.setLname(Lname);
    	newuser.setCIN(cIN);
        newuser.setCNE(cNE);
        newuser.setEmail(email);
        newuser.setFiliere(filiere);
        newuser.setInscription(inscription);
        newuser.setPassword(password);
        newuser.setState(0);
        newuser.setToken(Token); 
    	EntityTransaction tx = entityManager.getTransaction();
    	tx.begin();
    	entityManager.persist(newuser);
    	tx.commit();
    	addRole(newuser.getId(),1);
    	SendTokenToEmail(Token,newuser.getId(),newuser.getEmail());
    	return newuser;

    }
    
    public String SendTokenToEmail(String Token , int id , String Email) {
    	Session emailSession = SendEmailTLS.getMailConnection();
        	 try {

             Message message = new MimeMessage(emailSession);
             message.setFrom(new InternetAddress("ClubInfo@gmail.com"));
             message.setRecipients(
                     Message.RecipientType.TO,
                     InternetAddress.parse(Email)
             );
          // Create the message part 
             MimeBodyPart messageBodyPart = new MimeBodyPart();

             // Fill the message
             messageBodyPart.setText("<h1>Dear User, </h1>"
                     + "<div>Please Confirm Your Email By Clicking this Link : </div>"
                     + "<div> <a href=\"http://localhost:8084/HyberProjectStart/confirmAccount?token="+Token+"&id="+id +"\">Click Me</a>"
                     + " </div>","UTF-8","html");

             Multipart multipart = new MimeMultipart();
             multipart.addBodyPart(messageBodyPart);
             
             message.setSubject("ClubInfo : Please Confirm your Email ");
//             message.setText("Dear  User,"
//                     + "\n\n Please Confirm Your Email By Clicking Here!" + "your Token is " + Token );
             message.setContent(multipart);
             Transport.send(message);

             System.out.println("Done");

         } catch (MessagingException e) {
             e.printStackTrace();
         }
    	 
    	 return Token;
    }
    
    public int checkIfAccountDisabled(int id) {
    	User logged = getUser(id);
    	if(logged.getState() == 2) {
    		return -1;
    	}else {
    		return 1;
    	}
    }
    
    public String Generatenewtoken() {
    	int n = 40;
    	String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

				// create StringBuffer size of AlphaNumericString
				StringBuilder sb = new StringBuilder(n);
				
				for (int i = 0; i < n; i++) {
				
				// generate a random number between
				// 0 to AlphaNumericString variable length
				int index
				= (int)(AlphaNumericString.length()
				    * Math.random());
				
				// add Character one by one in end of sb
				sb.append(AlphaNumericString
				      .charAt(index));
				}
		return sb.toString();
    	
    }
    
    public int checkifAdmin(int Id ) {
    	User Loged = getUser(Id);
    	
    	List<Role> Roles = Loged.getRoles();
    	
    	for(Role item : Roles) {
    		if(item.getRoleid() == 0) {
    			return 1;
    		}
    	}
    	
    	return -1;
    }
    
    public void addRole(int Id , int roleid) {
    	EntityManager entityManager=JPAutil.getEntityManager("HyberProjectStart");

    	EntityTransaction tx = entityManager.getTransaction();
    	if(!tx.isActive()) tx.begin();
        Query query2 = entityManager.createNativeQuery("INSERT INTO User_role (roleid, userid) VALUES (?,?)");
        query2.setParameter(1, roleid);
        query2.setParameter(2, Id);
        query2.executeUpdate();
        tx.commit();
    }
    
    public void RemoveFromAdh(int Id) {
    	EntityManager entityManager=JPAutil.getEntityManager("HyberProjectStart");

    	EntityTransaction tx = entityManager.getTransaction();
    	if(!tx.isActive()) tx.begin();
        Query query2 = entityManager.createNativeQuery("DELETE FROM User_role WHERE  roleid = 2 and userid = ? ");
        query2.setParameter(1, Id);
        query2.executeUpdate();
        tx.commit();
    }
    
    public boolean checkUserIfAdr(int id ) {
    	User user = getUser(id);
    	
    	for (Role nb : user.getRoles()) {
    		if(nb.getRoleid() == 2) {
    			return true;
    		}
    	}
    	return false;
    }
    
    public List<User> DisabledAccUsers(){
    	List<User> listusers = getAllUsers();
    	List<User> adrliste = new ArrayList<User>();
    	
    	for (User usr : listusers) {
    		if(usr.getState() == 2) {
    			adrliste.add(usr);
    		}
    	}
    	return adrliste;
    }
    
    public List<User> getNormalUsers() {
    	List<User> listusers = getAllUsers();
    	List<User> adrliste = new ArrayList<User>();
    	
    	for (User usr : listusers) {
    		if(!checkUserIfAdr(usr.getId())) {
    			adrliste.add(usr);
    		}
    	}
    	return adrliste;
    }
    
    
    
    
    public void disableAccount(int id) {
    	EntityManager entityManager=JPAutil.getEntityManager("HyberProjectStart");

    	 EntityTransaction tx = entityManager.getTransaction();
     	if(!tx.isActive()) tx.begin();
         Query query2 = entityManager.createNativeQuery("update user set state = 2 where id = ?");
         query2.setParameter(1, id);
         query2.executeUpdate();
         tx.commit();
         
    }
    
    public void ActiverAccount(int id) {
    	EntityManager entityManager=JPAutil.getEntityManager("HyberProjectStart");

   	 EntityTransaction tx = entityManager.getTransaction();
    	if(!tx.isActive()) tx.begin();
        Query query2 = entityManager.createNativeQuery("update user set state = 1 where id = ?");
        query2.setParameter(1, id);
        query2.executeUpdate();
        tx.commit();
        
   }
    
    public List<User> usersParMC(String mc) {
    	EntityManager entityManager=JPAutil.getEntityManager("HyberProjectStart");
		List<User> usrs =
		         entityManager.createQuery("select u from user u where u.CIN like :mc",User.class)
		                       .setParameter("mc", "%"+mc+"%")
		                      .getResultList(); 
			return usrs;
	}
    
    public List<User> getAllUsers(){
    	EntityManager entityManager=JPAutil.getEntityManager("HyberProjectStart");

    	EntityTransaction tx = entityManager.getTransaction();
    	if(!tx.isActive()) tx.begin();
        Query query = entityManager.createQuery("SELECT c FROM User c",User.class);
        query.setHint("javax.persistence.cache.storeMode", "REFRESH");
        List<User> users =  query.getResultList();
        
        for (User us : users) {
        	System.out.println("id " + us.getId() + " status " + us.getState());
        }
        tx.commit();
       // entityManager.close();
    	return users;
    }
    
    public List<User> getAdrOnly(){
    	List<User> listusers = getAllUsers();
    	List<User> adrliste = new ArrayList<User>();
    	
    	for (User usr : listusers) {
    		if(checkUserIfAdr(usr.getId()) && usr.getState() != 2) {
    			adrliste.add(usr);
    		}
    	}
    	return adrliste;
    	
    }
    

    public int checkifEmailConfirmed(int id) {
    	User logged = getUser(id);
    	if(logged.getState() == 1) {
    		return 1;
    	}else {
    		return -1;
    	}
    }
    
    public int confirmaccount(int id , String Token) {
    	EntityManager entityManager=JPAutil.getEntityManager("HyberProjectStart");

    	User user = getUser(id);
    	String userToken = user.getToken();
    	
    	if(Token.equals(userToken)) {
            EntityTransaction tx = entityManager.getTransaction();
            tx.begin();
            Query query2 = entityManager.createNativeQuery("update user set state = 1 where id = ?");
            query2.setParameter(1, id);
            query2.executeUpdate();
            tx.commit();
            
            return 1;
    		
    	}else {
    		return -1;
    	}
    	
    }
    
    
    public int validate(String CNE, String password) {
    	EntityManager entityManager=JPAutil.getEntityManager("HyberProjectStart");

    	EntityTransaction tx = entityManager.getTransaction();
		
		User user = new User();
		
			// start a transaction
			// get an username
			Query query = entityManager.createNativeQuery("select * from user where CNE = ? ", User.class);
			query.setParameter(1, CNE);
			
			  user = (User) query.getSingleResult();
						
			if(user != null && user.getPassword().equals(password)) {
				
			System.out.println("Salut "+ user.getId());
				return user.getId();
			}
		
	
			System.out.println("Salut NOTHING ");
		return -1;
	}
	
	 
    public User ProfilData(int id) {
  	  User userData = new User();
  	  
         Query query = entityManager.createNativeQuery("select * from user where id = ? ", User.class);
  		query.setParameter(1, id);

  		userData = (User) query.getSingleResult();
 
        	return userData;
        	
      }
    
    public int ChangePassword(String OldPasswd ,String NewPasswd, int id) {
    	
    	User newuser =getUser(id);;
    	
    	/* Query query = entityManager.createNativeQuery("select * from user where id = ? ", User.class);
		query.setParameter(1, id);
        query.executeUpdate(); */

			
		String MyPass = newuser.getPassword();

		System.out.println("2  Your password is "+MyPass); 

    	
    	if (OldPasswd.equals(MyPass)) {
    		
    		
    		 EntityTransaction tx = entityManager.getTransaction();
             tx.begin();
             Query query2 = entityManager.createNativeQuery("update user set password = ? where id = ?");
             query2.setParameter(1, NewPasswd);
             query2.setParameter(2, id);
             query2.executeUpdate();
             tx.commit();
             return 1;
          
    	} else return -1;

    	
    	
    }
    
    
}
