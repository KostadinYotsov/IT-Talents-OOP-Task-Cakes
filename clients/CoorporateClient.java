package clients;

import sweetShop.Cake;

public class CoorporateClient extends Client {
	
	private int discount;

	public CoorporateClient(String name, String gsmNumber, double money, int discount) {
		super(name, gsmNumber, money);
		if (discount>0) {
			this.discount=discount;
		}
		else {
			this.discount=10;
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
