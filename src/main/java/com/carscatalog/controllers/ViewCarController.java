package com.carscatalog.controllers;

import com.carscatalog.entity.Cars;
import com.carscatalog.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

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
		BufferedImage img = ImageIO.read(new ByteArrayInputStream(cars.getImage()));
		model.addAttribute("img", img);
		return "viewcar";
	}

	@RequestMapping("**/car/edit/{id}")
	public String editCar(@PathVariable Long id, Model model) {
		model.addAttribute("car", carsService.getCarById(id));
		return "editcar";
	}

	@RequestMapping(value = "**/car", method = RequestMethod.POST)
	public String saveCar(@RequestParam("files") MultipartFile image, RedirectAttributes redirectAttributes, String type, Cars cars) throws IOException {
		byte[] bytes = image.getBytes();
		cars.setImage(bytes);
		try {
			image.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
		carsService.saveCar(cars);
		return "redirect:/car/" + cars.getId();
	}

//		if (image.hasTileWriters()) {
//			redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//			return "redirect:/car/edit/" + cars.getId();
//		} else
//				redirectAttributes.addFlashAttribute("message",
//						"You successfully uploaded '" + files.getOriginalFilename() + "'");


	@RequestMapping("**/car/delete/{id}")
	public String deleteCar(@PathVariable Long id) {
		carsService.deleteCar(id);
		return "redirect:/";
	}
}
