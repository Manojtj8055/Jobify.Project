package com.xworkz.chocolate;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class ChocolateServiceImpl implements ChocolateService {
	@Autowired
	private ChocolateRepo repo;

	@Override
	public boolean validateAndSave(ChocolateDTO dto, Model model) {
		if (dto != null) {
			if (dto.getName() != null && !dto.getName().isEmpty()) {
				if (dto.getBrand() != null && !dto.getBrand().isEmpty()) {
					if (dto.getPrice() > 20) {
						if(dto.getQuantity()>1){

						System.out.println("Entered Valid Data...");
						boolean saved = isExists(dto.getName());
						if (!saved) {
							return repo.save(dto);
						}
					boolean updatedQ=	updateQuantityByName(dto.getQuantity() + findByName(dto.getName(), model).getQuantity(), dto.getName());
					if(updatedQ) {
						model.addAttribute("exists", "Chocolate quantity updated");
						return true;
					}
						return false;
					}
				}
			}
			}	
		}
		return false;
	}

	@Override
	public ChocolateDTO findById(int id) {
		if (id > 0) {
			return repo.findById(id);
		}
		return null;
	}

	@Override
	public List<ChocolateDTO> readAll() {

		return repo.readAll();
	}

	@Override
	public ChocolateDTO findByName(String name, Model model) {
		if (name != null && !name.isEmpty()) {
			return repo.findByName(name);
		}
		model.addAttribute("nameValid", "Chocolate is not valid");
		return null;
	}

	public boolean isExists(String name) {
		ChocolateDTO find = repo.findByName(name);
		if (find != null) {
			return true;
		}
		return false;
	}
	
	@Override
	public boolean updateQuantityByName(int quantity,String name) {
		if(quantity>0 && !name.isEmpty() && name!=null) {
			return repo.updateQuantityByName(name, quantity);
		}
		return false;
		}

	@Override
	public boolean deleteById(int id, Model model) {
		if(id>0) {
			return repo.deleteById(id,model);
		}
		return false;
	}


}
















