package com.ashken.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FILES")
public class UserFile {
	@Id
	@GeneratedValue
	int id;
	String name;
	boolean visible;
	@OneToOne
	@JoinColumn(name="OWNER")
	SiteUser owner;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public SiteUser getOwner() {
		return owner;
	}
	public void setOwner(SiteUser owner) {
		this.owner = owner;
	}
	
	

}
