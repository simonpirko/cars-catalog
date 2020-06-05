package com.carscatalog.entity;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface CarRepository extends CrudRepository<Car, Long>,
		QueryByExampleExecutor<Car>, JpaSpecificationExecutor<Car> {

	Page<Car> findAllByOrderByDateDesc(Pageable pageable);

	Page<Car> findAllByOrderByMarkAsc(Pageable pageable);

	Page<Car> findAllByOrderByScopeAsc(Pageable pageable);

	Page<Car> findAllByOrderByYearAsc(Pageable pageable);

	Page<Car> findAllByOrderByMileageAsc(Pageable pageable);

	Page<Car> findAllByOrderByPriceAsc(Pageable pageable);

	Page<Car> findAllByMark(String mark, Pageable pageable);

	Page<Car> findAll(Specification<Car> spec, Pageable pageable);

}



