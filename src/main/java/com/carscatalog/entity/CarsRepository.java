package com.carscatalog.entity;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface CarsRepository extends CrudRepository<Cars, Long>, QueryByExampleExecutor<Cars> {

	Page<Cars> findAllByOrderByDateDesc(Pageable pageable);

	Page<Cars> findAllByOrderByMarkAsc(Pageable pageable);

	Page<Cars> findAllByOrderByScopeAsc(Pageable pageable);

	Page<Cars> findAllByOrderByYearAsc(Pageable pageable);

	Page<Cars> findAllByOrderByMileageAsc(Pageable pageable);

	Page<Cars> findAllByOrderByPriceAsc(Pageable pageable);

	Page<Cars> findAllByMark(String mark, Pageable pageable);

}