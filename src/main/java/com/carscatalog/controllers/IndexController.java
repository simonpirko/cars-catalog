package com.carscatalog.controllers;

import com.carscatalog.entity.Car;
import com.carscatalog.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	private CarService carService;

	@Autowired
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String sortDate(Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Car> carsPage = carService.findAllByOrderByDateDesc(pageable);
		PageWrapper<Car> page = new PageWrapper<Car>(carsPage, "/");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(value = "/sort/mark", method = RequestMethod.GET)
	public String sortMark(Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Car> carsPage = carService.findAllByOrderByMarkAsc(pageable);
		PageWrapper<Car> page = new PageWrapper<Car>(carsPage, "/sort/mark");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(value = "/sort/scope", method = RequestMethod.GET)
	public String sortScope(Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Car> carsPage = carService.findAllByOrderByScopeAsc(pageable);
		PageWrapper<Car> page = new PageWrapper<Car>(carsPage, "/sort/scope");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(value = "/sort/year", method = RequestMethod.GET)
	public String sortYear(Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Car> carsPage = carService.findAllByOrderByYearAsc(pageable);
		PageWrapper<Car> page = new PageWrapper<Car>(carsPage, "/sort/year");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(value = "/sort/mileage", method = RequestMethod.GET)
	public String sortMileage(Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Car> carsPage = carService.findAllByOrderByMileageAsc(pageable);
		PageWrapper<Car> page = new PageWrapper<Car>(carsPage, "/sort/mileage");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(value = "/sort/price", method = RequestMethod.GET)
	public String sortPrice(Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Car> carsPage = carService.findAllByOrderByPriceAsc(pageable);
		PageWrapper<Car> page = new PageWrapper<Car>(carsPage, "/sort/price");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(value = "/mark/{mark}", method = RequestMethod.GET)
	public String filterMark(@PathVariable String mark, Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Car> carsPage = carService.findAllByMark(mark, pageable);
		PageWrapper<Car> page = new PageWrapper<Car>(carsPage, "/mark/{mark}");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam(value = "q", required = false) String search,
							   Pageable pageable, ModelAndView modelAndView) {
		modelAndView.addObject("title", "Cars Catalog");
		Page<Car> carsPage = carService.findBy(search, pageable);
		PageWrapper<Car> page = new PageWrapper<Car>(carsPage, "/**");
		modelAndView.addObject("car", carsPage.getContent());
		modelAndView.addObject("page", page);
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping("/car/new")
	public String newCar(Model model) {
		model.addAttribute("car", new Car());
		return "editcar";
	}
}
