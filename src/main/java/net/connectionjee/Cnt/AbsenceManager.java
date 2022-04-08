package net.connectionjee.Cnt;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import net.connectionjee.Absence;
import net.connectionjee.Evenement;
import utils.JPAutil;

public class AbsenceManager {
	 private EntityManager entityManager=JPAutil.getEntityManager("HyberProjectStart");

	 public Absence markAbsence(int Userid) {
		 Date date = Calendar.getInstance().getTime();  
         DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
         String strDate = dateFormat.format(date);  
         System.out.println("Converted String: " + strDate);  
         Absence abs = new Absence();
         
         UserManager user = new UserManager();         
         abs.setTheuser(user.getUser(Userid));;
         abs.setDate_abscence(strDate);
         
         EntityTransaction tx = entityManager.getTransaction();
	    	if(!tx.isActive()) tx.begin();
	    	entityManager.persist(abs);
	    	tx.commit();

		 return abs;
	 }

}
