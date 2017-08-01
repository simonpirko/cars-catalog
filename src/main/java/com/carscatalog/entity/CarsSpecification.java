package com.carscatalog.entity;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public final class CarsSpecification {
	public static Specification<Cars> markOrModelOrFuelOrTransmission(final String search) {
		return new Specification<Cars>() {
			@Override
			public Predicate toPredicate(Root<Cars> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

				Predicate markPredicate = builder.like(root.get(Cars_.mark), search);
				Predicate modelPredicate = builder.like(root.get(Cars_.model), search);
				Predicate fuelPredicate = builder.like(root.get(Cars_.fuel), search);
				Predicate transmissionPredicate = builder.like(root.get(Cars_.transmission), search);

				return builder.or(markPredicate, modelPredicate, fuelPredicate, transmissionPredicate);
			}
		};
	}
}
