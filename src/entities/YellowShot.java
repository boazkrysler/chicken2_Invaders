package entities;

public class YellowShot extends Shot {

	@Override
	public void shooting(Visitor v) {
		v.Visit(this);
	}

}
