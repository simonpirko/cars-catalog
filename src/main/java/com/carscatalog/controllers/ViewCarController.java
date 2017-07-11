package com.carscatalog.controllers;

import com.carscatalog.entity.Cars;
import com.carscatalog.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class ViewCarController {
	private CarsService carsService;

	@Autowired
	public void setCarsService(CarsService carsService) {
		this.carsService = carsService;
	}

	public static final String uploadingdir = System.getProperty("user.dir") + "/src/main/resources/static/images/";

	@RequestMapping(value = "**/car/{id}", method = RequestMethod.GET)
	public String showCar(@PathVariable Long id, Model model) {
		model.addAttribute("car", carsService.getCarById(id));
		return "viewcar";
	}

	@RequestMapping("**/car/edit/{id}")
	public String editCar(@PathVariable Long id, Model model) {
		model.addAttribute("car", carsService.getCarById(id));
//		File file = new File(uploadingdir);
//		model.addAttribute("files", file.listFiles());
		return "editcar";
	}

	@RequestMapping(value = "**/car", method = RequestMethod.POST)
	public String saveCar(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes, Cars cars) throws IOException {
		if (file.isEmpty()) {
			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
			return "editcar";
		}
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(file.getOriginalFilename());
			Files.write(path, bytes);

			redirectAttributes.addFlashAttribute("message",
					"You successfully uploaded '" + file.getOriginalFilename() + "'");

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
