package Fawry;
import java.time.LocalDate;

public class Item_can_Expired extends Product implements Expirable, Shippable {
	public LocalDate expiryDate;
	public double weight;
	
	Item_can_Expired(String name, int price, int quantity,LocalDate expiryDate,double weight){
		super(name, price, quantity);
		this.expiryDate = expiryDate;
		this.weight=weight;
	}
	
	@Override
	public boolean isExpired() {
		return LocalDate.now().isAfter(expiryDate);
	};
	
	@Override
	public String getName() {
		return super.getName();
	};
	
	public double getWeight() {
		return this.weight;
	}
	
	
	
	
}
