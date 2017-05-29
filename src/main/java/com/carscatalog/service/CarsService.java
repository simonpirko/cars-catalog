package com.carscatalog.service;

import com.carscatalog.entity.Cars;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarsService {
	Iterable<Cars> listAllCars();

	Cars getCarsById(Long id);

	Cars saveCars(Cars cars);

	void deleteCar(Long id);

	Page<Cars> findAll(Pageable pageable);
}
