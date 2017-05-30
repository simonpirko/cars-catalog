package com.carscatalog.controllers;

import com.carscatalog.entity.Cars;
import com.carscatalog.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {

	private CarsService carsService;

	@Autowired
	public void setCarsService(CarsService carsService) {
		this.carsService = carsService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String list(Model model, Pageable pageable, Sort sort) {
		model.addAttribute("title", "Cars Catalog");
		Page<Cars> carsPage = carsService.findAll(pageable);
		PageWrapper<Cars> page = new PageWrapper<Cars>(carsPage, "/");
		model.addAttribute("car", page.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping("car/new")
	public String newCar(Model model) {
		model.addAttribute("car", new Cars());
		return "editcar";
	}
}
