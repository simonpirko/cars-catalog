package com.carscatalog.controllers;

import com.carscatalog.entity.Cars;
import com.carscatalog.entity.CarsSpecification;
import com.carscatalog.entity.Cars_;
import com.carscatalog.service.CarsService;
import org.aspectj.lang.annotation.RequiredTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.RequestScope;

import javax.persistence.EntityManager;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.SetJoin;
import javax.xml.ws.RequestWrapper;
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
	public String search(@RequestParam(value = "q") String search,
						 Pageable pageable, Model model) {
		model.addAttribute("title", "Cars Catalog");
		Page<Cars> carsPage = carsService.findBy(search.toLowerCase(), pageable);
		PageWrapper<Cars> page = new PageWrapper<Cars>(carsPage, "/**");
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
