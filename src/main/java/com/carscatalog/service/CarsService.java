package com.carscatalog.service;

import com.carscatalog.entity.Cars;
import com.carscatalog.entity.CarsSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

public interface CarsService {

	Page<Cars> findAllByOrderByDateDesc(Pageable pageable);

	Page<Cars> findAllByOrderByMarkAsc(Pageable pageable);

	Page<Cars> findAllByOrderByScopeAsc(Pageable pageable);

	Page<Cars> findAllByOrderByYearAsc(Pageable pageable);

	Page<Cars> findAllByOrderByMileageAsc(Pageable pageable);

	Page<Cars> findAllByOrderByPriceAsc(Pageable pageable);

	Page<Cars> findAllByMark(String mark, Pageable pageable);

	Page<Cars> findByMarkOrModelOrFuelOrTransmission(String mark, String model, String fuel, String transmission, Pageable pageable);

	Cars getCarById(Long id);

	Cars saveCar(Cars cars);

	void deleteCar(Long id);
}
