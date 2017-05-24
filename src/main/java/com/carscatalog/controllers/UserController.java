package com.carscatalog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class UserController {

	@GetMapping("/user")
	public String user(Map<String, Object> model) {
		model.put("title","Cars Catalog | User room");
		return "/user";
	}
}
