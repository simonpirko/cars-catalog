package com.carscatalog.service;

import com.carscatalog.entity.Cars;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarsService {

	Page<Cars> findAllByOrderByDateDesc(Pageable pageable);

	Page<Cars> findAllByOrderByMarkAsc(Pageable pageable);

	Page<Cars> findAllByOrderByScopeAsc(Pageable pageable);

	Page<Cars> findAllByOrderByYearAsc(Pageable pageable);

	Page<Cars> findAllByOrderByMileageAsc(Pageable pageable);

	Page<Cars> findAllByOrderByPriceAsc(Pageable pageable);

	Page<Cars> findAllByMark(String mark, Pageable pageable);

	Page<Cars> findBy(String search, Pageable pageable);

	Cars getCarById(Long id);

	Cars saveCar(Cars cars);

	void deleteCar(Long id);
}
