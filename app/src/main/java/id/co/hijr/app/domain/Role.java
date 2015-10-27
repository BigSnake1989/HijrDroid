package id.co.hijr.app.domain;

import id.co.hijr.app.core.Metadata;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Role extends Metadata implements Serializable {
	
	private String name;
	private String description;
	
	private List<User> users = new ArrayList<User>();
	
	public Role() {
			
	}
	public Role(int id) {
		super(id);	
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
}


