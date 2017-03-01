package sweetShop;

import sweetShop.Cake.IType;
import sweetShop.SpecialCake.SpecialCakeType;

public class KidCake extends Cake implements Comparable <KidCake> {
	
	
	public enum KidCakeType implements IType { BIRTHDAY, KRUSHTENE, PROSHTAPULNIK }
	
	private String kidName;
	private KidCakeType type;
	
	public KidCake(KidCakeType type, String name, String description, double price, int numPieces, String kidName) {
		super(name, description, price, numPieces, Kind.KID);
		this.type=type;
		this.kidName=kidName;
	}

	@Override
	public int compareTo(KidCake o) {
		// za da moje v treemapa da vlqzat dve torti s ednakuv broi parcheta
		if (this.numPieces-o.numPieces==0) {
			return -1;
		}
		return this.numPieces-o.numPieces;
	}

	@Override
	public IType getIType() {
		return this.type;
	}
	
	

}
