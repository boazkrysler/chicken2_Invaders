package entities;

import logic.ShootingLogic;

public class PurpleChicken extends Chicken {

	public PurpleChicken(int indexX, int indexY) {
		super(indexX, indexY, 5);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Visit(BlackShot shot) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Visit(RedShot shot) {
		ShootingLogic.KillChicken(this);

	}

	@Override
	public void Visit(BlueShot shot) {
		ShootingLogic.KillChicken(this);

	}

	@Override
	public void Visit(YellowShot shot) {
		// TODO Auto-generated method stub

	}

}
