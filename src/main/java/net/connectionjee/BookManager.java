package net.connectionjee;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import org.eclipse.persistence.sessions.factories.SessionFactory;

import utils.JPAutil;

public class BookManager {
    protected SessionFactory sessionFactory;
    private EntityManager entityManager=JPAutil.getEntityManager("HyberProjectStart");

    protected void setup() {
        // code to load Hibernate Session factory
    	
    }
 
    protected void exit() {
        // code to close Hibernate Session factory
    }
 
    protected Book create() {
    	Book book = new Book();
        book.setTitle("Effective");
        book.setAuthor("Joshua");
        book.setPrice(32.f);
        
    	EntityTransaction tx = entityManager.getTransaction();
    	tx.begin();
    	entityManager.persist(book);
    	tx.commit();
    	
    	return book;

    }
 
    protected void read() {
        // code to get a book
    }
 
    protected void update() {
        // code to modify a book
    }
 
    protected void delete() {
        // code to remove a book
    }
 
    public static void main(String[] args) {
        // code to run the program
    }
}
