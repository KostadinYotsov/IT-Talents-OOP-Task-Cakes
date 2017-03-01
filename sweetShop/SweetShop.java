package sweetShop;

import java.security.KeyStore.Entry;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeMap;

import sweetShop.Cake.IType;
import sweetShop.Cake.Kind;

public class SweetShop {
	
	private String name;
	private String adres;
	private String gsmNumber;
	private HashMap<Kind, HashMap<IType, TreeMap<Cake, Integer>>> vitrina;
	private HashSet<Supplier> suppliers;
	
	public SweetShop(String name, String adres, String gsmNumber) {
		this.name = name;
		this.adres = adres;
		this.gsmNumber = gsmNumber;
		this.vitrina=new HashMap<>();
		suppliers=new HashSet<>();
	}

	public void addSupplier (Supplier s) {
		if (s!=null) {
			this.suppliers.add(s);
		}
	}
	
	public void addCake (Cake c, int num) {
		if (num>0 && c!=null) {
			Kind kind=c.getKind();
			if (!vitrina.containsKey(kind)) {
				vitrina.put(kind, new HashMap<>());
			}
			IType type=c.getIType();
			if (!vitrina.get(kind).containsKey(type)) {
				vitrina.get(kind).put(type, new TreeMap<>());
			}
			vitrina.get(kind).get(type).put(c, num);
		}
	}
	
	public void printKatalog () {
		System.out.println(this.name);
		for (java.util.Map.Entry<Kind, HashMap<IType, TreeMap<Cake, Integer>>> e : vitrina.entrySet()) {
			System.out.println(e.getKey());
			HashMap<IType, TreeMap<Cake, Integer>> map=e.getValue();
			for (java.util.Map.Entry<IType, TreeMap<Cake, Integer>> e1 : map.entrySet()) {
				System.out.println("    - " + e1.getKey());
				TreeMap<Cake, Integer> mapche=e1.getValue();
				for (java.util.Map.Entry<Cake, Integer> e2 : mapche.entrySet()) {
					System.out.println("        : " + e2.getKey() + " - " + e2.getValue());
				}
			}
		}
	}
	
	public void printSupplier () {
		for (Supplier s : suppliers) {
			System.out.println(s);
		}
	}
	
	public void sellCake (Order o) {
		
	}
	
}
