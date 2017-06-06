package com.carscatalog.controllers;

import com.carscatalog.entity.Cars;
import com.carscatalog.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class IndexController {

	private CarsService carsService;

	@Autowired
	public void setCarsService(CarsService carsService) {
		this.carsService = carsService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String sortDate(Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Cars> carsPage = carsService.findAllByOrderByDateDesc(pageable);
		PageWrapper<Cars> page = new PageWrapper<Cars>(carsPage, "/");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(value = "/sortmark", method = RequestMethod.GET)
	public String sortMark(Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Cars> carsPage = carsService.findAllByOrderByMarkAsc(pageable);
		PageWrapper<Cars> page = new PageWrapper<Cars>(carsPage, "/sortmark");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(value = "/sortscope", method = RequestMethod.GET)
	public String sortScope(Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Cars> carsPage = carsService.findAllByOrderByScopeAsc(pageable);
		PageWrapper<Cars> page = new PageWrapper<Cars>(carsPage, "/sortscope");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(value = "/sortyear", method = RequestMethod.GET)
	public String sortYear(Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Cars> carsPage = carsService.findAllByOrderByYearAsc(pageable);
		PageWrapper<Cars> page = new PageWrapper<Cars>(carsPage, "/sortyear");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(value = "/sortmileage", method = RequestMethod.GET)
	public String sortMileage(Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Cars> carsPage = carsService.findAllByOrderByMileageAsc(pageable);
		PageWrapper<Cars> page = new PageWrapper<Cars>(carsPage, "/sortmileage");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(value = "/sortprice", method = RequestMethod.GET)
	public String sortPrice(Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Cars> carsPage = carsService.findAllByOrderByPriceAsc(pageable);
		PageWrapper<Cars> page = new PageWrapper<Cars>(carsPage, "/sortprice");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(value = "/{mark}", method = RequestMethod.GET)
	public String filterMark(@PathVariable String mark, Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Cars> carsPage = carsService.findAllByMark(mark, pageable);
		PageWrapper<Cars> page = new PageWrapper<Cars>(carsPage, "/{mark}");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping("/car/new")
	public String newCar(Model model) {
		model.addAttribute("car", new Cars());
		return "editcar";
	}
}
