package Fawry;

import java.util.List;

public class CheckoutService {

    public static void checkout(Customer customer, Cart cart) {
        List<CartItem> items = cart.getItems();

        if (items.isEmpty()) {
            System.out.println("Error: Cart is empty.");
            return;
        }

        double subtotal = 0;
        List<Shippable> shippables = cart.getShippableItems();

        for (CartItem item : items) {
            Product product = item.getProduct();
            int quantity = item.getQuantity();

            if (product instanceof Expirable) {
                if (((Expirable) product).isExpired()) {
                    System.out.println("Error: Product " + product.getName() + " is expired.");
                    return;
                }
            }

            
            if (quantity > product.getQuantity()) {
                System.out.println("Error: Not enough stock for " + product.getName());
                return;
            }

            subtotal += product.getPrice() * quantity;
        }

        
        double shippingFee = shippables.isEmpty() ? 0 : 30;
        double total = subtotal + shippingFee;

        
        if (customer.getBalance() < total) {
            System.out.println("Error: Insufficient balance.");
            return;
        }

        customer.deductBalance(total);
        for (CartItem item : items) {
            item.getProduct().reduceQuantity(item.getQuantity());
        }

        if (!shippables.isEmpty()) {
            ShippingService.shipItems(shippables);
        }
        System.out.println("----------------------");
        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.println(item.getQuantity() + "x " + item.getProduct().getName() + " " + item.getProduct().getPrice() * item.getQuantity());
        }

        System.out.println("----------------------");
        System.out.println("Subtotal: " + subtotal);
        System.out.println("Shipping: " + shippingFee);
        System.out.println("Total Paid: " + total);
    }
}
