package Fawry;

public class Customer {
	public String name;
	public double balance;
	
	Customer(String name, double balance){
		this.balance=balance;
		this.name=name;
	}
	
	
	public double getBalance() {
		return this.balance;
	}
	
	public void deductBalance(double amount) {
		this.balance -= amount;
	}

}
