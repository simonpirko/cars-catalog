package com.carscatalog.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
public class Cars {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String model;
	private String mark;
	private Integer year;
	private Double scope;
	private Integer mileage;
	private String transmission;
	private String fuel;
	private BigDecimal price;
	private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Double getScope() {
		return scope;
	}

	public void setScope(Double scope) {
		this.scope = scope;
	}

	public Integer getMileage() {
		return mileage;
	}

	public void setMileage(Integer mileage) {
		this.mileage = mileage;
	}

	public String getFuel() {
		return fuel;
	}

	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
