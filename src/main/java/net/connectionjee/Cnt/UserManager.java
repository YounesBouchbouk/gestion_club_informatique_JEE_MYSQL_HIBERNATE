package net.connectionjee.Cnt;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import net.connectionjee.Role;
import net.connectionjee.User;
import utils.JPAutil;

public class UserManager {
    private EntityManager entityManager=JPAutil.getEntityManager("HyberProjectStart");

    public User getUser(int id) {
        User user = entityManager.find(User.class,id); 
    	return  user;
    }
    
    public User create(String email, String password, String cIN, String cNE, String filiere, String inscription) {
    	User newuser = new  User();
    	newuser.setCIN(cIN);
        newuser.setCNE(cNE);
        newuser.setEmail(email);
        newuser.setFiliere(filiere);
        newuser.setInscription(inscription);
        newuser.setPassword(password);
        newuser.setState(0);
        newuser.setToken(Generatenewtoken()); 
    	EntityTransaction tx = entityManager.getTransaction();
    	tx.begin();
    	entityManager.persist(newuser);
    	tx.commit();
    	addRole(newuser.getId(),2);
    	return newuser;

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
    	EntityTransaction tx = entityManager.getTransaction();
    	tx.begin();
        Query query2 = entityManager.createNativeQuery("INSERT INTO User_role (roleid, userid) VALUES (?,?)");
        query2.setParameter(1, roleid);
        query2.setParameter(2, Id);
        query2.executeUpdate();
        tx.commit();
    }
    
    public void RemoveFromAdh(int Id) {
    	EntityTransaction tx = entityManager.getTransaction();
    	tx.begin();
        Query query2 = entityManager.createNativeQuery("DELETE FROM User_role WHERE  roleid = 2 and userid = ? ");
        query2.setParameter(1, Id);
        query2.executeUpdate();
        tx.commit();
    }
    
    
    
    
    public void disableAccount(int id) {
    	
    	 EntityTransaction tx = entityManager.getTransaction();
         tx.begin();
         Query query2 = entityManager.createNativeQuery("update user set state = 2 where id = ?");
         query2.setParameter(1, id);
         query2.executeUpdate();
         tx.commit();
         
    }
    
    public List<User> getAllUsers(){
    	EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Query query = entityManager.createQuery("SELECT c FROM User c",User.class);
        List<User> users =  query.getResultList();
        
    	return users;
    }
    
    public List<User> getUsersByRoleId(int Roleid){
    	EntityTransaction tx = entityManager.getTransaction();
        tx.begin();
        Query query = entityManager.createNativeQuery("SELECT  id, email, password, CIN, CNE, filiere, inscription, token, state  FROM  User u  Join User_role r  WHERE   u.id = r.userid AND  r.roleid = ?",User.class);
        query.setParameter(1, Roleid);
        List<User> users =  query.getResultList();
		return users;
    	
    }
    

    
    public int confirmaccount(int id , String Token) {
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
    
}
