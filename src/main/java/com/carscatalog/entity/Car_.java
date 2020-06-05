package com.carscatalog.entity;

import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel(Car.class)
public class Car_ {
	public static volatile SingularAttribute<Car, String> mark;
	public static volatile SingularAttribute<Car, String> model;
	public static volatile SingularAttribute<Car, String> fuel;
	public static volatile SingularAttribute<Car, String> transmission;
	public static volatile SingularAttribute<Car, Double> scope;
	public static volatile SingularAttribute<Car, Integer> mileage;
	public static volatile SingularAttribute<Car, Integer> year;
}
