package com.bs.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "SHELF")
public class Shelf implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="shelfSeq", sequenceName= "shelf_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "shelfSeq")
	@Column(name = "SHELF_ID")
	private Integer shelfId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "CREATED_DT")
	private Date createdDt;
	
	@Column(name = "LAST_UPDATED_DT")
	private Date lastUpdatedDt;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "USER_ID")
	private User user;

	public Integer getShelfId() {
		return shelfId;
	}

	public void setShelfId(Integer shelfId) {
		this.shelfId = shelfId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreatedDt() {
		return createdDt;
	}

	public void setCreatedDt(Date createdDt) {
		this.createdDt = createdDt;
	}

	public Date getLastUpdatedDt() {
		return lastUpdatedDt;
	}

	public void setLastUpdatedDt(Date lastUpdatedDt) {
		this.lastUpdatedDt = lastUpdatedDt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
}
