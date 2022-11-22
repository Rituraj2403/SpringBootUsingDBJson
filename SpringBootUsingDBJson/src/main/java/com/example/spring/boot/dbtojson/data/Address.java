package com.example.spring.boot.dbtojson.data;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")

@Embeddable
@JsonPropertyOrder({ "email", "phone" })
public class Address implements Serializable {
	@JsonProperty("email")
	private String email;
	@JsonProperty("phone")
	private String phone;

	public Address() {
	}

	public Address(String email, String phone) {
		super();
		this.email = email;
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	};
}