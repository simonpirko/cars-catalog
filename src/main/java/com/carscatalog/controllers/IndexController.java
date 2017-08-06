package com.carscatalog.controllers;

import com.carscatalog.entity.Cars;
import com.carscatalog.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

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

	@RequestMapping(value = "/sort/mark", method = RequestMethod.GET)
	public String sortMark(Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Cars> carsPage = carsService.findAllByOrderByMarkAsc(pageable);
		PageWrapper<Cars> page = new PageWrapper<Cars>(carsPage, "/sort/mark");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(value = "/sort/scope", method = RequestMethod.GET)
	public String sortScope(Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Cars> carsPage = carsService.findAllByOrderByScopeAsc(pageable);
		PageWrapper<Cars> page = new PageWrapper<Cars>(carsPage, "/sort/scope");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(value = "/sort/year", method = RequestMethod.GET)
	public String sortYear(Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Cars> carsPage = carsService.findAllByOrderByYearAsc(pageable);
		PageWrapper<Cars> page = new PageWrapper<Cars>(carsPage, "/sort/year");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(value = "/sort/mileage", method = RequestMethod.GET)
	public String sortMileage(Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Cars> carsPage = carsService.findAllByOrderByMileageAsc(pageable);
		PageWrapper<Cars> page = new PageWrapper<Cars>(carsPage, "/sort/mileage");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(value = "/sort/price", method = RequestMethod.GET)
	public String sortPrice(Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Cars> carsPage = carsService.findAllByOrderByPriceAsc(pageable);
		PageWrapper<Cars> page = new PageWrapper<Cars>(carsPage, "/sort/price");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(value = "/mark/{mark}", method = RequestMethod.GET)
	public String filterMark(@PathVariable String mark, Model model, Pageable pageable) {
		model.addAttribute("title", "Cars Catalog");
		Page<Cars> carsPage = carsService.findAllByMark(mark, pageable);
		PageWrapper<Cars> page = new PageWrapper<Cars>(carsPage, "/mark/{mark}");
		model.addAttribute("car", carsPage.getContent());
		model.addAttribute("page", page);
		return "index";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView search(@RequestParam(value = "q", required = false) String search,
							   Pageable pageable, ModelAndView modelAndView) {
		modelAndView.addObject("title", "Cars Catalog");
		Page<Cars> carsPage = carsService.findBy(search, pageable);
		PageWrapper<Cars> page = new PageWrapper<Cars>(carsPage, "/**");
		modelAndView.addObject("car", carsPage.getContent());
		modelAndView.addObject("page", page);
		modelAndView.setViewName("index");
		return modelAndView;
	}

	@RequestMapping("/car/new")
	public String newCar(Model model) {
		model.addAttribute("car", new Cars());
		return "editcar";
	}
}
