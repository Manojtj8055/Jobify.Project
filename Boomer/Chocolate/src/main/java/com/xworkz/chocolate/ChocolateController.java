package com.xworkz.chocolate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/chocolate")
public class ChocolateController {
	@Autowired
	private ChocolateService service;

	@PostMapping("/save")
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(ChocolateDTO dto, Model model) {
		boolean saved = service.validateAndSave(dto, model);
		if (saved) {
			return "Success";
		}
		return "Chocolate";
	}

	@RequestMapping("/find")
	public String find(@RequestParam int id, Model model) {
		ChocolateDTO dto = service.findById(id);

		if (dto != null) {
			model.addAttribute("dto", dto);
			return "Success";
		} else {
			model.addAttribute("dto", "Chocolate not found");
			return "Chocolate";
		}
	}

	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public String readAll(Model model) {
		List<ChocolateDTO> data = service.readAll();

		if (data != null) {
			model.addAttribute("list", data);
			return "Read";

		} else {
			model.addAttribute("list", "Issues in reading data");
			return "Chocolate";

		}
	}

	@RequestMapping(value = "/findByName", method = RequestMethod.GET)
	public String findByName(@RequestParam String name, Model model) {
		ChocolateDTO found = service.findByName(name, model);
		if (found != null) {
			model.addAttribute("foundData", found);
			return "Find";
		} else {
			model.addAttribute("foundData", "Issues finding this data");
			return "Chocolate";
		}

	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String updateQuantityByName(@RequestParam int quantity, @RequestParam String name, Model model) {
		boolean update = service.updateQuantityByName(quantity, name);
		if (update) {
			model.addAttribute("update", "Quantity updated");
			return "Chocolate";
		} else {
			model.addAttribute("update", "Quantity not updated");
			return "Chocolate";
		}

	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteById(@RequestParam int id,Model model) {
		boolean delete=service.deleteById(id,model);
		if(delete) {
			model.addAttribute("delete", "deleted dto");
			return "Chocolate";
		}else {
			model.addAttribute("delete","dto not present to delete..");
			return "Chocolate";
		}

		
	}

}
