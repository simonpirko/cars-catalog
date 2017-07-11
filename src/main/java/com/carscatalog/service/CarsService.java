package com.carscatalog.service;

import com.carscatalog.entity.Cars;
import com.sun.jndi.toolkit.dir.SearchFilter;
import org.springframework.cglib.core.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.math.BigDecimal;

public interface CarsService {

	Page<Cars> findAllByOrderByDateDesc(Pageable pageable);

	Page<Cars> findAllByOrderByMarkAsc(Pageable pageable);

	Page<Cars> findAllByOrderByScopeAsc(Pageable pageable);

	Page<Cars> findAllByOrderByYearAsc(Pageable pageable);

	Page<Cars> findAllByOrderByMileageAsc(Pageable pageable);

	Page<Cars> findAllByOrderByPriceAsc(Pageable pageable);

	Page<Cars> findAllByMark(String mark, Pageable pageable);

	Page<Cars> findByMarkAndModel(String mark, String model, Pageable pageable);

	Cars getCarById(Long id);

	Cars saveCar(Cars cars);

	void deleteCar(Long id);
}
