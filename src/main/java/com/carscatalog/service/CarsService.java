package com.carscatalog.service;

import com.carscatalog.entity.Cars;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public interface CarsService {



	Cars getCarById(Long id);

	Cars saveCar(Cars cars);

	void deleteCar(Long id);

	Page<Cars> findAll(Pageable pageable);
}
