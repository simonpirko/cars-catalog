package com.carscatalog.repository;

import com.carscatalog.entity.DataCars;

import java.util.List;

public interface CarsRepository {
	List<DataCars> findAll();
}
