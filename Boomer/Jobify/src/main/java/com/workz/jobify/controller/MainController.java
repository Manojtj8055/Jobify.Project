package com.workz.jobify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.workz.jobify.dto.JobifyDTO;
import com.xworkz.jobify.service.JobifyService;
import com.xworkz.jobify.service.JobifyServiceImpl;

@ComponentScan("com.xworkz.jobify")
@Controller
@RequestMapping(value = "/jobify")
public class MainController {

	@Autowired
	private JobifyServiceImpl service;


	@RequestMapping(value = "/save",method = RequestMethod.POST)
	public String save(JobifyDTO dto, Model model) {
		System.out.println(dto);
		boolean saved = service.validateAndSave(dto, model);
		if (saved) {
			model.addAttribute("save", "Registered Succesfully");
			return "Front";
		}
		return "Front";
	}

}
