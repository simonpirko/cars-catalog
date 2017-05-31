package com.carscatalog.controllers;

import com.carscatalog.entity.Cars;
import com.carscatalog.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ViewCarController {
	private CarsService carsService;

	@Autowired
	public void setCarsService(CarsService carsService) {
		this.carsService = carsService;
	}

	@RequestMapping("car/{id}")
	public String showCar(@PathVariable Long id, Model model) {
		model.addAttribute("car", carsService.getCarById(id));
		return "viewcar";
	}

	@RequestMapping("car/edit/{id}")
	public String editCar(@PathVariable Long id, Model model) {
		model.addAttribute("car", carsService.getCarById(id));
		return "editcar";
	}

	@RequestMapping(value = "car", method = RequestMethod.POST)
	public String saveCar(Cars cars){
		carsService.saveCar(cars);
		return "redirect:/car/" + cars.getId();
	}

	@RequestMapping("car/delete/{id}")
	public String deleteCar(@PathVariable Long id){
		carsService.deleteCar(id);
		return "redirect:/";
	}
}
