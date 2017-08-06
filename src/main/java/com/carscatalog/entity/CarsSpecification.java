package com.carscatalog.entity;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

public final class CarsSpecification {
	public static Specification<Cars> markOrModelOrFuelOrTransmission(final String search) {
		return (root, query, builder) -> {
			String content = getContainsLikePattern(search);
			Predicate markPredicate = builder.like(root.get(Cars_.mark), content);
			Predicate modelPredicate = builder.like(root.get(Cars_.model), content);
			Predicate fuelPredicate = builder.like(root.get(Cars_.fuel), content);
			Predicate transmissionPredicate = builder.like(root.get(Cars_.transmission), content);
			return builder.or(markPredicate, modelPredicate, fuelPredicate, transmissionPredicate);
		};
	}

	public static Specification<Cars> yearOrMileage(final Integer searchInt) {
		return (root, query, builder) -> {
			Predicate yearPredicate = builder.equal(root.get(Cars_.year), searchInt);
			Predicate mileagePredicate = builder.equal(root.get(Cars_.mileage), searchInt);
			return builder.or(yearPredicate, mileagePredicate);
		};
	}

	public static Specification<Cars> scope(final Double searchDo) {
		return (root, query, builder) -> {
			Predicate scopePredicate = builder.equal(root.get(Cars_.scope), searchDo);
			return builder.or(scopePredicate);
		};
	}

	private static String getContainsLikePattern(String searchTerm) {
		if (searchTerm == null || searchTerm.isEmpty()) {
			return "%";
		}
		else {
			return "%" + searchTerm.toLowerCase() + "%";
		}
	}
}
