package com.carscatalog.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Users implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)

	private Long id;
	private String email;
	private String firstName;
	private String lastName;
	private String city;
	private Integer bornDate;
	private Integer regDate;

	protected Users() {
	}

	@Override
	public String toString() {
		return "Users{" +
				", email='" + email + '\'' +
				", firstName='" + firstName + '\'' +
				", lastName='" + lastName + '\'' +
				", city='" + city + '\'' +
				", bornDate=" + bornDate +
				", regDate=" + regDate +
				'}';
	}

	public Users(String firstName, String lastName, String city, Integer bornDate, Integer regDate, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.city = city;
		this.bornDate = bornDate;
		this.regDate = regDate;
		this.email = email;
	}

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
