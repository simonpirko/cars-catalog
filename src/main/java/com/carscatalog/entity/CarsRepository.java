package com.carscatalog.entity;

import com.sun.jndi.toolkit.dir.SearchFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.math.BigDecimal;
import java.sql.Date;

public interface CarsRepository extends CrudRepository<Cars, Long> {

	Page<Cars> findAllByOrderByDateDesc(Pageable pageable);

	Page<Cars> findAllByOrderByMarkAsc(Pageable pageable);

	Page<Cars> findAllByOrderByScopeAsc(Pageable pageable);

	Page<Cars> findAllByOrderByYearAsc(Pageable pageable);

	Page<Cars> findAllByOrderByMileageAsc(Pageable pageable);

	Page<Cars> findAllByOrderByPriceAsc(Pageable pageable);

	Page<Cars> findAllByMark(String mark, Pageable pageable);

}
