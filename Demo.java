import java.util.ArrayList;
import java.util.Random;

import clients.Client;
import clients.CoorporateClient;
import clients.PrivateClient;
import sweetShop.KidCake;
import sweetShop.KidCake.KidCakeType;
import sweetShop.SpecialCake;
import sweetShop.SpecialCake.SpecialCakeType;
import sweetShop.StandartCake;
import sweetShop.StandartCake.StandartCakeType;
import sweetShop.Supplier;
import sweetShop.SweetShop;
import sweetShop.WeddingCake;
import sweetShop.WeddingCake.WeddingCakeType;

public class Demo {

	public static void main(String[] args) {

		SweetShop nedelq=new SweetShop("Sladkarnica Nedelq", "Ul. Dolo 5", "08999875620");
		
		String [] names= {"Pesho","Toni","Moni","Tosho","Gosho"};
		String [] gsmNumbers= {"0899949505","0899949505","0899949001","0899949875","0899749502","0879969505"};
		for (int i=0; i<5; i++) {
			String name=names[new Random().nextInt(names.length)];
			String gsmNumber=gsmNumbers[new Random().nextInt(gsmNumbers.length)];
			Supplier s=new Supplier(name, gsmNumber);
			nedelq.addSupplier(s);
		}
		
		nedelq.printSupplier();
		
		String [] cakeNames  ={"Nedelq", "Subota", "Romans", "Naslada", "Celuvka","Vulshebstvo" };
		String [] opisaniq = {"Mnogo vkusna", "Neveroqtna e", "Golqma naslada" };
		for (int i=0; i<30; i++) {
			int randChislo=new Random().nextInt(100);
			String cakeName=cakeNames[new Random().nextInt(cakeNames.length)];
			String opisanie=opisaniq[new Random().nextInt(opisaniq.length)]; 
			if (randChislo<25) {
				StandartCakeType t=StandartCakeType.values()[new Random().nextInt(StandartCakeType.values().length)];
				StandartCake c=new StandartCake(t, cakeName, opisanie, new Random().nextDouble()*10 +new Random().nextInt(10), new Random().nextInt(10)+1, new Random().nextBoolean());
				nedelq.addCake(c, new Random().nextInt(5)+1);
			}
			else {
				if (randChislo>=25 && randChislo<50) {
					WeddingCakeType t=WeddingCakeType.values()[new Random().nextInt(WeddingCakeType.values().length)];
					WeddingCake c=new WeddingCake(t, cakeName, opisanie, new Random().nextDouble()*10 +new Random().nextInt(10), new Random().nextInt(10)+1, new Random().nextInt(3));
					nedelq.addCake(c, new Random().nextInt(5)+1);
				}
				else {
					if (randChislo>=50 && randChislo<75) {
						SpecialCakeType t=SpecialCakeType.values()[new Random().nextInt(SpecialCakeType.values().length)];
						SpecialCake c=new SpecialCake(t, cakeName, opisanie, new Random().nextDouble()*10 +new Random().nextInt(10), new Random().nextInt(10)+1, "Golqmo Subitie");
						nedelq.addCake(c, new Random().nextInt(5)+1);
					}
					else {
						KidCakeType t=KidCakeType.values()[new Random().nextInt(KidCakeType.values().length)];
						KidCake c=new KidCake(t, cakeName, opisanie, new Random().nextDouble()*10 +new Random().nextInt(10), new Random().nextInt(10)+1, "Goshko");
						nedelq.addCake(c, new Random().nextInt(5)+1);
					}
				}
			}
		}
		
		nedelq.printKatalog();
		String [] namesClient= {"Pesho","Toni","Moni","Tosho","Gosho", "Koko", "Misho", "Tisho"};
		String [] gsmNumbersClient= {"0899949505","0899949505","0899949001","0899949875","0899749502","0879969505"};
		
		ArrayList<Client> clients=new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			String name=namesClient[new Random().nextInt(namesClient.length)];
			String gsmNumber=gsmNumbersClient[new Random().nextInt(gsmNumbersClient.length)];
			if (new Random().nextBoolean()) {
				int numVaucher=new Random().nextInt(4)+1;
				double money=new Random().nextDouble()*10 + new Random().nextInt(500)+100;
				double priceVaucher=new Random().nextDouble()*10+new Random().nextInt(20)+1;
				PrivateClient p=new PrivateClient(name, gsmNumber, money, numVaucher, priceVaucher);
				clients.add(p);
			}
			else {
				double money=new Random().nextDouble()*10 + new Random().nextInt(1000)+500;
				int discount=new Random().nextInt(10)+5;
				CoorporateClient c= new CoorporateClient(name, gsmNumber, money, discount);
				clients.add(c);
			}
		}
		
		for (Client c: clients) {
			c.addShop(nedelq);
			System.out.println(c);
			
		}
		
	}

}
