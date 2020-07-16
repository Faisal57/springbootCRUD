package com.shop.model;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "tbl_sale_2")
public class Sales {

	@Column
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	@Size(min = 3, message="Name should have atleast 3 characters")
	private String name;
	@Column
	private int price;
	@Column
	private int quantity;

	public Sales(Integer id, String name, int price, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public Sales() {
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return "Sales [id=" + id + ", name=" + name + ", price=" + price + ", quantity=" + quantity + "]";
	}

}
