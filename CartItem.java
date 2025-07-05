package Fawry;

public class CartItem {
	public Product product;
	public int quantity;
	
	CartItem(Product product, int quantity){
		this.product= product;
		this.quantity=quantity;
	}
	
	public Product getProduct() {
		return this.product;
	}
	
	public int getQuantity(){
		return this.quantity ;
	}
	
	public void increaseQuantity(int amount) {
        this.quantity += amount;
    }

	
	
}
