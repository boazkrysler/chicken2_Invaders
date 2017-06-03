package entities;

import logic.ShootingLogic;

public class ChickenCircle extends Chicken {

	public ChickenCircle(int indexX, int indexY) {
		super(indexX, indexY,9);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Visit(BlackShot shot) {
		ShootingLogic.KillCircleChicken(this);
	}

	@Override
	public void Visit(RedShot shot) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Visit(BlueShot shot) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Visit(YellowShot shot) {
		// TODO Auto-generated method stub

	}

}
