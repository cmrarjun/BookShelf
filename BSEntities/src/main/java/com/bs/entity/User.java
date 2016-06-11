package com.bs.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="USER_BS")
public class User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name="userSeq", sequenceName= "user_seq", allocationSize=1)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "userSeq")
	@Column(name="USER_ID")
	private Integer userId;
	
	@Column(name="FIRST_NAME")
	private String firstName;
	
	@Column(name="LAST_NAME")
	private String lastName;
	
	@Column(name="USER_NAME")
	private String userName;
	
	@Column(name="PWD")
	private String pwd;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE_NUMBER")
	private Integer phoneNumber;
	
	@Column(name="CREATED_DT")
	private Date createdDt;
	
	@Column(name="LAST_UPDATED_DT")
	private Date lastUpdatedDt;
}
