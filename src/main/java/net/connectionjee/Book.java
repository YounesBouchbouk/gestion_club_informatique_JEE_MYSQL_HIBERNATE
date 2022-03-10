package net.connectionjee;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "book")
public class Book {
	 @Id
	 @Column(name = "book_id")    
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	 
	@Column (name="title")
    private String title;
	
	@Column (name="author")
    private String author;
	
	@Column (name="price")
    private float price;
 
    public Book() {
    }
 
   
    public long getId() {
        return id;
    }
 
    public void setId(long id) {
        this.id = id;
    }
 
    public String getTitle() {
        return title;
    }
 
    public void setTitle(String title) {
        this.title = title;
    }
 
    public String getAuthor() {
        return author;
    }
 
    public void setAuthor(String author) {
        this.author = author;
    }
 
    public float getPrice() {
        return price;
    }
 
    public void setPrice(float price) {
        this.price = price;
    }
 
}