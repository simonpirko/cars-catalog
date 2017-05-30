package com.carscatalog.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private String city;
	private Integer bornDate;
	private Integer regDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getBornDate() {
		return bornDate;
	}

	public void setBornDate(Integer bornDate) {
		this.bornDate = bornDate;
	}

	public Integer getRegDate() {
		return regDate;
	}

	public void setRegDate(Integer regDate) {
		this.regDate = regDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
