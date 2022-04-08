package net.connectionjee;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import net.connectionjee.Cnt.AbsenceManager;
import net.connectionjee.Cnt.EventManager;
import net.connectionjee.Cnt.UserManager;


public class testclass {
	public static void main(String[] args) throws Exception {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        
        // EventManager env  = new EventManager();
        //env.comparedatewhiteLocal("05-05-2022");
        
        AbsenceManager env  = new AbsenceManager();
        UserManager usermanage = new UserManager();
        
        List<Absence> abs = usermanage.GetUserAbs(3);
//        env.markAbsence(3);

        for(Absence sgn : abs) {
        	System.out.println(sgn.getDate_abscence());
        	System.out.println(sgn.getId_abscence());

        }
        


    }
}
