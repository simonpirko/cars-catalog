package com.carscatalog.entity;

import javax.persistence.metamodel.SingularAttribute;

@javax.persistence.metamodel.StaticMetamodel(com.carscatalog.entity.Cars.class)
public class Cars_ {
	public static volatile SingularAttribute<Cars, String> mark;
	public static volatile SingularAttribute<Cars, String> model;
	public static volatile SingularAttribute<Cars, String> fuel;
	public static volatile SingularAttribute<Cars, String> transmission;
	public static volatile SingularAttribute<Cars, Double> scope;
	public static volatile SingularAttribute<Cars, Integer> mileage;
	public static volatile SingularAttribute<Cars, Integer> year;
}
