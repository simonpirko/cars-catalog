package com.carscatalog.service;

import com.carscatalog.entity.Cars;
import com.carscatalog.entity.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class CarsServiceImpl implements CarsService {
	private CarsRepository carsRepository;

	@Autowired
	public void setCarRepository(CarsRepository carsRepository) {
		this.carsRepository = carsRepository;
	}

	@Override
	public Page<Cars> findAllByOrderByDateDesc(Pageable pageable) {
		return carsRepository.findAllByOrderByDateDesc(pageable);
	}

	@Override
	public Page<Cars> findAllByOrderByMarkAsc(Pageable pageable) {
		return carsRepository.findAllByOrderByMarkAsc(pageable);
	}

	@Override
	public Page<Cars> findAllByOrderByScopeAsc(Pageable pageable) {
		return carsRepository.findAllByOrderByScopeAsc(pageable);
	}

	@Override
	public Page<Cars> findAllByOrderByYearAsc(Pageable pageable) {
		return carsRepository.findAllByOrderByYearAsc(pageable);
	}

	@Override
	public Page<Cars> findAllByOrderByMileageAsc(Pageable pageable) {
		return carsRepository.findAllByOrderByMileageAsc(pageable);
	}

	@Override
	public Page<Cars> findAllByOrderByPriceAsc(Pageable pageable) {
		return carsRepository.findAllByOrderByPriceAsc(pageable);
	}

	@Override
	public Page<Cars> findAllByMark(String mark, Pageable pageable) {
		return carsRepository.findAllByMark(mark, pageable);
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
}
