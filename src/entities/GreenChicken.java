package entities;

import logic.ShootingLogic;

public class GreenChicken extends Chicken {

	public GreenChicken(int indexX, int indexY) {
		super(indexX, indexY,6);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Visit(BlackShot shot) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Visit(RedShot shot) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Visit(BlueShot shot) {
		ShootingLogic.KillChicken(this);

	}

	@Override
	public void Visit(YellowShot shot) {
		ShootingLogic.KillChicken(this);

	}

}
