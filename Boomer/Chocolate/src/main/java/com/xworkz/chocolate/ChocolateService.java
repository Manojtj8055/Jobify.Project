package com.xworkz.chocolate;

import java.util.List;

import org.springframework.ui.Model;

public interface ChocolateService {

	public boolean validateAndSave(ChocolateDTO dto, Model model);

	public ChocolateDTO findById(int id);

	public List<ChocolateDTO> readAll();

	public ChocolateDTO findByName(String name, Model model);

	public boolean isExists(String name);

	public boolean updateQuantityByName(int quantity, String name);

	public boolean deleteById(int quantity, Model model);
}
