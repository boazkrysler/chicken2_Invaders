package entities;

public class BlueShot extends Shot {


	@Override
	public void shooting(Visitor v) {
		v.Visit(this);
	}


}
