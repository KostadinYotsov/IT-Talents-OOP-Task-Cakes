package clients;

import sweetShop.Cake;
import sweetShop.Order;
import sweetShop.SweetShop;

public  abstract class Client {
	
	private String name;
	private String gsmNumber;
	private double money;
	private SweetShop shop;
	private Order order;
	
	public Client(String name, String gsmNumber, double money) {
		if (name!= null && !name.trim().isEmpty()) {
			this.name = name;
		}
		else {
			this.name="Agent 007";
		}
		if (gsmNumber!= null && !gsmNumber.trim().isEmpty()) {
			this.gsmNumber = gsmNumber;
		}
		else {
			this.gsmNumber="0888888888";
		}
		if (money>0) {
			this.money=money;
		}
		else {
			this.money=1000;
		}
	}
	
	public void addShop (SweetShop s) {
		if (s!=null) {
			this.shop=s;
		}
	}
	
	public abstract void makeOreder(Cake c, int num);
	public abstract void payBill ();
	
	@Override
	public String toString() {
		return this.name + " - " + this.money;
	}
}
