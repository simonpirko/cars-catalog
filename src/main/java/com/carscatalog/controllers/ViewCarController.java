package com.carscatalog.controllers;

import com.carscatalog.entity.Cars;
import com.carscatalog.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Base64;

@Controller
public class ViewCarController {
	private CarsService carsService;

	@Autowired
	public void setCarsService(CarsService carsService) {
		this.carsService = carsService;
	}

	@RequestMapping(value = "**/car/{id}", method = RequestMethod.GET)
	public String showCar(@PathVariable Long id, Model model, Cars cars) throws IOException {
		model.addAttribute("car", carsService.getCarById(id));
		return "viewcar";
	}

	@RequestMapping("**/car/edit/{id}")
	public String editCar(@PathVariable Long id, Model model) {
		model.addAttribute("car", carsService.getCarById(id));
		return "editcar";
	}

	@RequestMapping(value = "**/car", method = RequestMethod.POST)
	public String saveCar(@RequestParam("imageFile") MultipartFile imageFile, Cars cars) throws IOException {
		try {
			byte[] imgBytes = imageFile.getBytes();
			byte[] encode = Base64.getEncoder().encode(imgBytes);
			String base64 = new String(encode, "UTF-8");
			cars.setImage(base64);
		} catch (IOException e) {
			e.printStackTrace();
		}
		carsService.saveCar(cars);
		return "redirect:/car/" + cars.getId();
	}

	@RequestMapping("**/car/delete/{id}")
	public String deleteCar(@PathVariable Long id) {
		carsService.deleteCar(id);
		return "redirect:/";
	}
}
