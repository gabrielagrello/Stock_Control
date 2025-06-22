package entities;

import java.time.LocalDate;

import entities.enums.ProductCategory;

public class Product {

	private static Integer nextId = 1;

	private Integer id;
	private String name;
	private Double price;
	private Integer quantity;
	private ProductCategory category;
	private LocalDate registerDate;

	public Product() {
	}

	public Product(String name, Double price, Integer quantity, ProductCategory category) {
		this.id = nextId++;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		this.registerDate = LocalDate.now();
	}

	public Product(String name, Double price) {
		this.name = name;
		this.price = price;
		this.quantity = 0;
	}

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public ProductCategory getCategory() {
		return category;
	}

	public void setCategory(ProductCategory category) {
		this.category = category;
	}

	public LocalDate getRegisterDate() {
		return registerDate;
	}

	public Double TotalValueInStock() {
		return price * quantity;
	}

	public void AddProducts(Integer quantity) {

		this.quantity += quantity;
	}

	public void RemoveProducts(Integer quantity) {

		this.quantity -= quantity;
		if (quantity <= this.quantity) {
			this.quantity -= quantity;
		} else {
			System.out.println("Erro: Quantidade maior que o estoque disponível.");
		}
	}

	@Override
	public String toString() {
		return "ID: " 
	+ id 
	+ ", " 
	+ name 
	+ "( " 
	+ category 
	+ ")" 
	+ ", $ " 
	+ String.format("%.2f", price) 
	+ ", "
				
	+ quantity 
	+ " unidades, Total: $" 
	+ String.format("%.2f", TotalValueInStock()) 
	+ ", Cadastrado em: "
				
	+ registerDate;
	}
}
