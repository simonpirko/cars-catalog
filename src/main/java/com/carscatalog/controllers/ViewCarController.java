package com.carscatalog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewCarController {

	@GetMapping("/viewcar")
	public String viewcar() {
		return "/viewcar";
	}
}
