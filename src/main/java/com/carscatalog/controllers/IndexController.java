package com.carscatalog.controllers;

import com.carscatalog.entity.DataCars;
import com.carscatalog.repository.CarsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
	@Autowired
	private CarsRepository carsRepository;

	@GetMapping("/")
	@Transactional
	public ModelAndView index() {
		List<DataCars> dataCars = this.carsRepository.findAll();
		ModelAndView modelAndView = new ModelAndView("index");
		modelAndView.addObject("cars", dataCars);
		return modelAndView;
	}
}
