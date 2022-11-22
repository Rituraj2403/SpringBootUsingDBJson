package com.example.spring.boot.dbtojson.data;

import java.io.Serializable;

import javax.persistence.Column;
//import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;



@SuppressWarnings("serial")
@Entity
public class UserDTO implements Serializable {
	@Id
	private String id;
	@Column(name="name")
	private String name;
	@Column(name="gender")
	private String gender;
	@Column(name="company")
	private String company;
	
	public UserDTO() {
	}

	public UserDTO(String id, String name, String gender, String company) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.company = company;
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}


}
