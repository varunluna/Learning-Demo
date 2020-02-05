package com.example.tryfw;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.security.core.GrantedAuthority;

@Entity
public class Permissions implements GrantedAuthority{

	private static final long serialVersionUID = -6578203193237188492L;
	@Id
	@GeneratedValue
	private Integer id;
	private String permission;
	@ManyToOne
	private User user;
	
	
	@Override
	public String getAuthority() {
		return permission;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Permissions [id=" + id + ", permission=" + permission;
	}

}
