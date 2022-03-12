package net.connectionjee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import net.connectionjee.Cnt.UserManager;


public class testclass {
	public static void main(String[] args) throws Exception {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        
        try {
            
            entityManagerFactory = Persistence.createEntityManagerFactory("HyberProjectStart");
            entityManager = entityManagerFactory.createEntityManager();
           // User newuser = new User();
            
           EntityTransaction tx = entityManager.getTransaction();

            tx.begin();
//            newuser.setCIN("JBTY55");
//            newuser.setCNE("C4498");
//            newuser.setEmail("younss.india@gmail.com");
//            newuser.setFiliere("BIO");
//            newuser.setInscription("2004-01-24");
//            newuser.setPassword("azerty@@");
//            newuser.setState(1);
//            newuser.setToken("FDSDFDSFDSFSDFSDFD");
            	
            UserManager bguser = new UserManager();
            
           //User newuser =  bguser.create("vebsite@gil.vb", "azertyu11", "HJHJ", "D1238475", "FG", "2022-06-01");
            
            //entityManager.persist(newuser);
            
           //int a =  bguser.confirmaccount(35, "FDSDFDSFDSFSDFSDFDKK");
           
           //System.out.println("we get this new" + a);
            
            String isadm = bguser.Generatenewtoken();
            System.out.println("wache admin " + isadm );

            
            
            tx.commit();
            
            tx.begin();

            System.out.println("blalalal " + 35 );
//            Query query2 = entityManager.createNativeQuery("INSERT INTO User_role (roleid, userid) VALUES (?,?)");
//            query2.setParameter(1, 2);
//            query2.setParameter(2, newuser.getId());

//            query2.executeUpdate();
            tx.commit();
           
            
         
            
//            User user = entityManager.find(User.class,35); 
//            Query query = entityManager.createQuery("SELECT c FROM User c WHERE c.email = :emm",User.class);
//            query.setParameter("emm", "mssawli@yahoo.com");
//            //query.setParameter("password", "azerty123");
//            
//            User user2 = (User) query.getSingleResult();             
            tx.begin();
            Query query = entityManager.createNativeQuery("SELECT  id, email, password, CIN, CNE, filiere, inscription, token, state  FROM  User u  Join User_role r  WHERE   u.id = r.userid AND  r.roleid = 2",User.class);
             List<User> users =  query.getResultList();
             tx.commit();
            //System.out.println( "Rôles associés hh  " + String.valueOf(user2.getId()));
            for( User suser : users ) {
                System.out.println( "Email : " + suser.getId() );
            }

            Role role = entityManager.find( Role.class, 1 );            
            System.out.println( "Utilisateurs possédant le rôle client" );
            for( User associatedUser : role.getUsers() ) {
                System.out.println( associatedUser.getCNE() );
            }

        } finally {
            if ( entityManager != null ) entityManager.close();
            if ( entityManagerFactory != null ) entityManagerFactory.close();
        }

    }
}
