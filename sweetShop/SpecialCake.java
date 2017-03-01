package sweetShop;

import sweetShop.Cake.IType;

public class SpecialCake extends Cake implements Comparable<SpecialCake> {
	
	public enum SpecialCakeType implements IType { ANNIVERSARY, FIRM, ADVERSTING }
	
	private String event;
	private SpecialCakeType type;

	public SpecialCake(SpecialCakeType type, String name, String description, double price, int numPieces, String event) {
		super(name, description, price, numPieces, Kind.SPECIAL);
		this.type=type;
		this.event=event;
	}

	@Override
	public int compareTo(SpecialCake o) {
		double razlika=this.price-o.price;
		if ( razlika>0) {
			return 1;
		}
		if ( razlika<0) {
			return -1;
		}
		// za da moje dve torti s ednkva cena da vlqzat v treemapa
		return 2;
	}

	@Override
	public IType getIType() {
		return this.type;
	}

}
