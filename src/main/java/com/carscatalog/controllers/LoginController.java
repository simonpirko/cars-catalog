package com.carscatalog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login(Map<String, Object> model) {
		model.put("title", "Cars Catalog | Sign in");
		return "/login";
	}
}
