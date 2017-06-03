package entities;

import logic.ShootingLogic;

public class ChickenRow extends Chicken {

	public ChickenRow(int indexX, int indexY) {
		super(indexX, indexY, 7);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Visit(BlackShot shot) {
		ShootingLogic.KillRowChicken(this);
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
