package net.connectionjee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_role")
public class Userstatus {
	
	@Id
	@Column(name = "idStatus")    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int idStatus;
	private String Description;
	public Userstatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Userstatus(int idStatus, String description) {
		super();
		this.idStatus = idStatus;
		Description = description;
	}
	public int getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(int idStatus) {
		this.idStatus = idStatus;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	
}
