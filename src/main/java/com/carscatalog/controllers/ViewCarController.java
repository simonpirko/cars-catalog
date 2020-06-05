package com.carscatalog.controllers;

import com.carscatalog.entity.Car;
import com.carscatalog.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Base64;

@Controller
public class ViewCarController {
	private CarService carService;

	@Autowired
	public void setCarService(CarService carService) {
		this.carService = carService;
	}

	@RequestMapping(value = "**/car/{id}", method = RequestMethod.GET)
	public String showCar(@PathVariable Long id, Model model, Car car) throws IOException {
		model.addAttribute("car", carService.getCarById(id));
		return "viewcar";
	}

	@RequestMapping("**/car/edit/{id}")
	public String editCar(@PathVariable Long id, Model model) {
		model.addAttribute("car", carService.getCarById(id));
		return "editcar";
	}

	@RequestMapping(value = "**/car", method = RequestMethod.POST)
	public String saveCar(@RequestParam("imageFile") MultipartFile imageFile, Car car) throws IOException {
		try {
			byte[] imgBytes = imageFile.getBytes();
			byte[] encode = Base64.getEncoder().encode(imgBytes);
			String base64 = new String(encode, "UTF-8");
			car.setImage(base64);
		} catch (IOException e) {
			e.printStackTrace();
		}
		carService.saveCar(car);
		return "redirect:/car/" + car.getId();
	}

	@RequestMapping("**/car/delete/{id}")
	public String deleteCar(@PathVariable Long id) {
		carService.deleteCar(id);
		return "redirect:/";
	}
}
