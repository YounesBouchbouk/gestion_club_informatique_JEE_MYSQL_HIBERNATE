package net.connectionjee;

import java.util.ArrayList;
import java.util.List;

public class UserModel {
	private String motCle;
	List<User> users = new ArrayList<>();
	
	
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<User> getUser() {
		return users;
	}
	public void setUsers(List<User> usr) {
		this.users = usr;
	}
}
