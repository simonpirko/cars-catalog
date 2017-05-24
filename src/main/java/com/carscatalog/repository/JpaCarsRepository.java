package com.carscatalog.repository;

import com.carscatalog.entity.DataCars;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaCarsRepository implements CarsRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<DataCars> findAll() {
		return this.entityManager.createQuery("SELECT n FROM CARS n", DataCars.class)
				.getResultList();
	}
}
