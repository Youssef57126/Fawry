package Fawry;

import java.time.LocalDate;

public class Item_can_not_Expired extends Product implements Shippable {
	public double weight;
	
	Item_can_not_Expired(String name, int price, int quantity,double weight){
		super(name, price, quantity);
		this.weight=weight;
	}
	
	
	@Override
	public String getName() {
		return name;
	};
	
	public double getWeight() {
		return this.weight;
	}

}
