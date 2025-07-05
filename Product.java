package Fawry;

public class Product {
	
	public String name;
	public int price;
	public int quantity;    
	
	Product(String name, int price, int quantity) {
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	public int getQuantity() {
		return this.quantity;
	}
	
	public void reduceQuantity(int amount) {
		if (this.quantity <amount){
			System.out.println("Not enough quantity available.");
		}
		else {
			this.quantity -= amount;
		}
	}
}
	
	
