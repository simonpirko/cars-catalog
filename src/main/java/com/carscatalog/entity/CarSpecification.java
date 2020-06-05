package com.carscatalog.entity;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public final class CarSpecification {
	public static Specification<Car> markOrModelOrFuelOrTransmission(final String search) {
		return (root, query, builder) -> {
			String content = getContainsLikePattern(search);
			Predicate markPredicate = builder.like(builder.lower(root.get(Car_.mark)), content);
			Predicate modelPredicate = builder.like(builder.lower(root.get(Car_.model)), content);
			Predicate fuelPredicate = builder.like(builder.lower(root.get(Car_.fuel)), content);
			Predicate transmissionPredicate = builder.like(builder.lower(root.get(Car_.transmission)), content);
			return builder.or(markPredicate, modelPredicate, fuelPredicate, transmissionPredicate);
		};
	}

	public static Specification<Car> yearOrMileage(final Integer searchInt) {
		return (root, query, builder) -> {
			Predicate yearPredicate = builder.equal(root.get(Car_.year), searchInt);
			Predicate mileagePredicate = builder.equal(root.get(Car_.mileage), searchInt);
			return builder.or(yearPredicate, mileagePredicate);
		};
	}

	public static Specification<Car> scope(final Double searchDo) {
		return (root, query, builder) -> {
			Predicate scopePredicate = builder.equal(root.get(Car_.scope), searchDo);
			return builder.or(scopePredicate);
		};
	}

	private static String getContainsLikePattern(String searchTerm) {
		if (searchTerm == null || searchTerm.isEmpty()) {
			return "%";
		} else {
			return "%" + searchTerm.toLowerCase() + "%";
		}
	}
}
