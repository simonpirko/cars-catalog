package com.carscatalog.service;

import com.carscatalog.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {

	Page<Car> findAllByOrderByDateDesc(Pageable pageable);

	Page<Car> findAllByOrderByMarkAsc(Pageable pageable);

	Page<Car> findAllByOrderByScopeAsc(Pageable pageable);

	Page<Car> findAllByOrderByYearAsc(Pageable pageable);

	Page<Car> findAllByOrderByMileageAsc(Pageable pageable);

	Page<Car> findAllByOrderByPriceAsc(Pageable pageable);

	Page<Car> findAllByMark(String mark, Pageable pageable);

	Page<Car> findBy(String search, Pageable pageable);

	Car getCarById(Long id);

	Car saveCar(Car car);

	void deleteCar(Long id);
}
