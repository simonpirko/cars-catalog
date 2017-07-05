package com.carscatalog.controllers;

import com.carscatalog.entity.Cars;
import com.carscatalog.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Controller
public class ViewCarController {
	private CarsService carsService;

	@Autowired
	public void setCarsService(CarsService carsService) {
		this.carsService = carsService;
	}

	public static final String uploadingdir = System.getProperty("user.dir") + "/src/main/resources/static/images/";

	@RequestMapping("**/car/{id}")
	public String showCar(@PathVariable Long id, Model model) {
		model.addAttribute("car", carsService.getCarById(id));
		return "viewcar";
	}

	@RequestMapping("**/car/edit/{id}")
	public String editCar(@PathVariable Long id, Model model) {
		model.addAttribute("car", carsService.getCarById(id));
		File file = new File(uploadingdir);
		model.addAttribute("files", file.listFiles());
		return "editcar";
	}

	@RequestMapping(value = "**/car", method = RequestMethod.POST)
	public String saveCar(@RequestParam("uploadingFiles") MultipartFile[] uploadingFiles, Cars cars, Model model) throws IOException {
		for (MultipartFile uploadedFile : uploadingFiles) {
			File file = new File(uploadingdir + cars.getId() + uploadedFile.getOriginalFilename());
			uploadedFile.transferTo(file);
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
