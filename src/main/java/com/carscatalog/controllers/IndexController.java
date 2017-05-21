package com.carscatalog.controllers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Map;

@Controller
public class IndexController {

//	//    @RequestMapping("/")
////    public String helloWorld(@RequestParam(value = "username", required = false, defaultValue = "World") String username, Model model) {
////        model.addAttribute("username", username);
////        return "index";
////    }
//	// inject via application.properties
//	@Value("${welcome.message:test}")
//	private String message = "Hello World";

	@RequestMapping("/")
	public String index(Model model){
		model.addAttribute("hello","Hello Guest");
		return "index";
	}
}