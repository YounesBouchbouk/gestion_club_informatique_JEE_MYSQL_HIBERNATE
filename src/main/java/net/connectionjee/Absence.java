package net.connectionjee;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Absence
 *
 */
@Entity
@Table(name = "abscence")
public class Absence   {

	@Id
	@Column(name = "id_abscence")    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_abscence;
	
	private String date_abscence;


	@ManyToOne
	private User theuser;
	
	
	public int getId_abscence() {
		return id_abscence;
	}

	public void setId_abscence(int id_abscence) {
		this.id_abscence = id_abscence;
	}

	public String getDate_abscence() {
		return date_abscence;
	}

	public void setDate_abscence(String date_abscence) {
		this.date_abscence = date_abscence;
	}

	public User getTheuser() {
		return theuser;
	}

	public void setTheuser(User theuser) {
		this.theuser = theuser;
	}

	
//	public int getIdUser() {
//		return idUser;
//	}

//	public void setIdUser(int idUser) {
//		this.idUser = idUser;
//	}
	
	
	
	
   
}
