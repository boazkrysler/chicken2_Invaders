package entities;

import logic.ShootingLogic;

public class ChickenPlus extends Chicken {

	public ChickenPlus(int indexX, int indexY) {
		super(indexX, indexY, 8);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Visit(BlackShot shot) {
		ShootingLogic.KillPlusChicken(this);
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
