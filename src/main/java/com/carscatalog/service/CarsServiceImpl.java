package com.carscatalog.service;

import com.carscatalog.entity.Cars;
import com.carscatalog.entity.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CarsServiceImpl implements CarsService {
	private CarsRepository carsRepository;

	@Autowired
	public void setCarRepository(CarsRepository carsRepository) {
		this.carsRepository = carsRepository;
	}

	@Override
	public Cars getCarById(Long id) {
		return carsRepository.findOne(id);
	}

	@Override
	public Cars saveCar(Cars cars) {
		return carsRepository.save(cars);
	}

	@Override
	public void deleteCar(Long id) {
		carsRepository.delete(id);
	}

	@Override
	public Page<Cars> findAll(Pageable pageable) {
		return carsRepository.findAll(pageable);
	}
}
