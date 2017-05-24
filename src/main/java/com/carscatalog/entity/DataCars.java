package com.carscatalog.entity;

import javax.persistence.*;

@Entity
public class DataCars implements DomainObject {

	@Id
	@SequenceGenerator(name = "cars_generator", sequenceName = "cars_sequence", initialValue = 15)
	@GeneratedValue(generator = "cars_generator")
	private Integer id;
	private String model;
	private String mark;
	private Integer year;
	private Double scope;
	private Integer mileage;
	private String typeFuel;
	private Integer price;

	@ManyToMany
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public String getTypeFuel() {
		return typeFuel;
	}

	public void setTypeFuel(String typeFuel) {
		this.typeFuel = typeFuel;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}
}
