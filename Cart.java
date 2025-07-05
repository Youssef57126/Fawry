package Fawry;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    public List<CartItem> cart_Item;

    public Cart() {
        this.cart_Item = new ArrayList<>();
    }

    public void addProduct(Product product, int quantity) {
        if (product instanceof Expirable) {
            Expirable exp = (Expirable) product;
            if (exp.isExpired()) {
                System.out.println(product.getName() + " is expired. Cannot add to cart.");
                return;
            }
        }

       
        if (quantity > product.getQuantity()) {
            System.out.println("Not enough stock for " + product.getName());
            return;
        }


        for (CartItem item : cart_Item) {
            if (item.getProduct().equals(product)) {
                item.increaseQuantity(quantity); 
                return;
            }
        }

        cart_Item.add(new CartItem(product, quantity));
    }

    public List<CartItem> getItems() {
        return cart_Item;
    }
    
    public List<Shippable> getShippableItems() {
        List<Shippable> shippables = new ArrayList<>();

        for (CartItem item : cart_Item) {
            Product product = item.getProduct();

            if (product instanceof Shippable) {
                Shippable shippable = (Shippable) product;

                for (int i = 0; i < item.getQuantity(); i++) {
                    shippables.add(shippable);
                }
            }
        }

        return shippables;
    }

    
}

