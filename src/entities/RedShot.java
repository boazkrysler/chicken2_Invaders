package entities;

public class RedShot extends Shot {

	@Override
	public void shooting(Visitor v) {
		v.Visit(this);
	}

}
