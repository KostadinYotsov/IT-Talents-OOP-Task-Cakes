package clients;

import sweetShop.Cake;

public class PrivateClient extends Client{
	
	private int numVaucher;
	private double priceVaucher;

	public PrivateClient(String name, String gsmNumber,double money, int numVaucher, double priceVaucher ) {
		super(name, gsmNumber, money +numVaucher*priceVaucher);
		if (numVaucher>0) {
			this.numVaucher=numVaucher;
		}
		else {
			this.numVaucher=3;
		}
		if (priceVaucher>0) {
			this.priceVaucher=priceVaucher;
		}
		else {
			this.priceVaucher=3;
		}
	}

	@Override
	public void makeOreder(Cake c, int num) {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void payBill() {
		// TODO Auto-generated method stub
		
	}

}
