package com.xworkz.maven;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonController {

	public PersonController() {
		System.out.println("Controller Created");
	}

	@RequestMapping(value = "/save", method =  RequestMethod.POST)
	public String save(@RequestParam String name, @RequestParam int age,  Model model) {
		if(!name.isEmpty()) {
			if(age > 0) {
				model.addAttribute("s", "Saved");
				return "index";
			}
		}
		model.addAttribute("s", "Not Saved");

		return "index";
	}
	
}