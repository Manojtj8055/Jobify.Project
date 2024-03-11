package com.xworkz.chocolate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
	@Table(name = "Chocolate")
	@NamedQuery(name = "findByName", query = "select dto from ChocolateDTO dto where dto.name=:nm")
	@NamedQuery(name = "updateByQuantity", query = "Update ChocolateDTO dto set dto.quantity=:qu where dto.name=:nm ")
	@NamedQuery(name = "delete", query = "Delete from ChocolateDTO dto where dto.id= :i")
	public class ChocolateDTO {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		
		private int id;
		private String name;
		private int price;
		private int quantity;
		private String brand;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public String getBrand() {
			return brand;
		}
		public void setBrand(String brand) {
			this.brand = brand;
		}
		
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		@Override
		public String toString() {
			return "ChocolateDTO [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity
					+ ", brand=" + brand + "]";
		}
		public ChocolateDTO(int id, String name, int price, String brand,int quantity) {
			super();
			this.id = id;
			this.name = name;
			this.price = price;
			this.brand = brand;
			this.quantity=quantity;
		}
		public ChocolateDTO() {
			
		}

	}
	 


