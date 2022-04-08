package net.connectionjee;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import org.eclipse.persistence.annotations.Cache;

@Entity
@Table(name = "user")
//@Cacheable(false)
public class User {
	 @Id
	 @Column(name = "id")    
	 @GeneratedValue(strategy = GenerationType.SEQUENCE)
	 private int id;
	 @Column (name="email")
	 private String email;
	 
	 @Column (name="password")
	 private String password;
	 @Column (name="CIN")
	 private String CIN;
	 @Column (name="CNE")
	 private String CNE;
	 private String filiere;
	 private String inscription;
	 private String token;
	 private int state;
	 
	 @OneToMany
	 
	 private List<Absence> user_abscence;
	 
	 @ManyToMany
	    @JoinTable( name = "user_role",
	                joinColumns = @JoinColumn( name = "userid" ),
	                inverseJoinColumns = @JoinColumn( name = "roleid" ) )
	 private List<Role> roles = new ArrayList<>();
	 
	 
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public List<Absence> getAbsense() {
		return user_abscence;
	}


	public void setAbsense(List<Absence> absense) {
		this.user_abscence = absense;
	}


	public User(int id, String email, String password, String cIN, String cNE, String filiere, String inscription,
			String token, int state) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		CIN = cIN;
		CNE = cNE;
		this.filiere = filiere;
		this.inscription = inscription;
		this.token = token;
		this.state = state;
	}
	



	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCIN() {
		return CIN;
	}
	public void setCIN(String cIN) {
		CIN = cIN;
	}
	public String getCNE() {
		return CNE;
	}
	public void setCNE(String cNE) {
		CNE = cNE;
	}
	public String getFiliere() {
		return filiere;
	}
	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}
	public String getInscription() {
		return inscription;
	}
	public void setInscription(String inscription) {
		this.inscription = inscription;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	 
	 public List<Role> getRoles() {
	        return roles;
	    }
	 
	 
	 @Override
	    public String toString() {
	        return "[" + this.CIN + "]";
	    }

	 

	 
}
