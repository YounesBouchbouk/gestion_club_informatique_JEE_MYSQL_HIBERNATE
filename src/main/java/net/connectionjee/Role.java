package net.connectionjee;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;


@Entity
@Table(name = "role")
public class Role {
	
	@Id
	@Column(name = "roleid")    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int roleid;
	
	private String role_name;
	
	 @ManyToMany
	 @JoinTable( name = "user_role",
	             joinColumns = @JoinColumn( name = "roleid" ),
	             inverseJoinColumns = @JoinColumn( name = "userid" ) )
	 
	private List<User> users = new ArrayList<>();
	
	public Role(int roleid, String role_name) {
		this.roleid = roleid;
		this.role_name = role_name;
	}
	
	
	public Role() {
	}


	public int getRoleid() {
		return roleid;
	}
	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}
	public String getRole_name() {
		return role_name;
	}
	public void setRole_name(String role_name) {
		this.role_name = role_name;
	}
		
	 public List<User> getUsers() {
	        return users;
	    }
	 
	 
	 @Override
	    public String toString() {
	        return "[" + this.role_name + "]";
	    }
	

}
