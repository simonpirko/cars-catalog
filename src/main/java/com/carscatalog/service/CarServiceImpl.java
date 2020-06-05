package com.carscatalog.service;

import com.carscatalog.entity.Car;
import com.carscatalog.entity.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.carscatalog.entity.CarSpecification.markOrModelOrFuelOrTransmission;
import static com.carscatalog.entity.CarSpecification.scope;
import static com.carscatalog.entity.CarSpecification.yearOrMileage;

@Transactional
@Service
public class CarServiceImpl implements CarService {
	private CarRepository carRepository;

	@Autowired
	public void setCarRepository(CarRepository carRepository) {
		this.carRepository = carRepository;
	}

	@Override
	public Page<Car> findAllByOrderByMarkAsc(Pageable pageable) {
		return carRepository.findAllByOrderByMarkAsc(pageable);
	}

	@Override
	public Page<Car> findAllByOrderByScopeAsc(Pageable pageable) {
		return carRepository.findAllByOrderByScopeAsc(pageable);
	}

	@Override
	public Page<Car> findAllByOrderByYearAsc(Pageable pageable) {
		return carRepository.findAllByOrderByYearAsc(pageable);
	}

	@Override
	public Page<Car> findAllByOrderByMileageAsc(Pageable pageable) {
		return carRepository.findAllByOrderByMileageAsc(pageable);
	}

	@Override
	public Page<Car> findAllByOrderByPriceAsc(Pageable pageable) {
		return carRepository.findAllByOrderByPriceAsc(pageable);
	}

	@Override
	public Page<Car> findAllByMark(String mark, Pageable pageable) {
		return carRepository.findAllByMark(mark, pageable);
	}

	@Override
	public Page<Car> findBy(String search, Pageable pageable) {
		Specification<Car> searchResult;
		if (search.matches("[-+]?\\d+")) {
			searchResult = yearOrMileage(Integer.valueOf(search));
		} else if (search.matches("[-+]?[0-9]*\\.d?[0-9]*")) {
			searchResult = scope(Double.valueOf(search));
		} else
			searchResult = markOrModelOrFuelOrTransmission(search);
		return carRepository.findAll(searchResult, pageable);
	}

	@Override
	public Page<Car> findAllByOrderByDateDesc(Pageable pageable) {
		return carRepository.findAllByOrderByDateDesc(pageable);
	}

	@Override
	public Car getCarById(Long id) {
		return carRepository.findOne(id);
	}

	@Override
	public Car saveCar(Car car) {
		return carRepository.save(car);
	}

	@Override
	public void deleteCar(Long id) {
		carRepository.delete(id);
	}
}
