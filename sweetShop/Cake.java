package sweetShop;


public abstract class Cake {
	
	public interface IType {} 
	
	enum Kind { STANDART, WEDDING, SPECIAL, KID }
	
	private String name;
	private String description;
	protected double price;
	protected int numPieces;
	private Kind kind;
	
	
	public Cake(String name, String description, double price, int numPieces, Kind kind) {
		if (!name.trim().isEmpty() && name!=null) {
			this.name = name;
		}
		else {
			this.name="Phantom cake";
		}
		if (!description.trim().isEmpty() && description!=null) {
			this.description = description;
		}
		else {
			this.description="Nqma takava torta.";
		}
		if (this.price>0) {
			this.price = price;	
		}
		else {
			this.price=5;
		}
		if (this.numPieces>0) {
			this.numPieces = numPieces;	
		}
		else {
			this.numPieces=5;
		}
		this.kind = kind;
	}


	public Kind getKind() {
		return kind;
	}
	
	public abstract IType getIType();
	
	@Override
	public String toString() {
		return this.name;
	}

}
