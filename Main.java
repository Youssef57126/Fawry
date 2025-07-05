package Fawry;
import java.time.LocalDate;
public class Main {

	public static void main(String[] args) {
		Product cheese = new Item_can_Expired("Cheese", 100, 2, LocalDate.of(2025, 7, 6), 0.4);
        Product biscuits = new Item_can_Expired("Biscuits", 150, 3, LocalDate.of(2025, 7, 6), 0.7); 
        Product tv = new Item_can_not_Expired("TV", 1000, 2, 10.0);
        Product scratchCard = new Product("ScratchCard", 50, 10);

        Customer customer = new Customer("Ahmed", 2000);

        Cart cart = new Cart();
        
        cart.addProduct(cheese, 2);
        cart.addProduct(biscuits, 1);
        CheckoutService.checkout(customer, cart);
        
        
	}

}
