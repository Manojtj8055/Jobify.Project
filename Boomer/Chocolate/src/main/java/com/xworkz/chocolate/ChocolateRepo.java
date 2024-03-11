
package com.xworkz.chocolate;

import java.util.List;

import org.springframework.ui.Model;

public interface ChocolateRepo {

	public boolean save(ChocolateDTO dto);

	public ChocolateDTO findById(int id);

	public List<ChocolateDTO> readAll();

	public ChocolateDTO findByName(String name);

	public boolean updateQuantityByName(String name, int quantity);

	public boolean deleteById(int id, Model model);



}
