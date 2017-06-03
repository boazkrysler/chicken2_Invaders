package entities;

public class BlackShot extends Shot {


	@Override
	public void shooting(Visitor v) {
		v.Visit(this);
	}


}
