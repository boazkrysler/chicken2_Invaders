package entities;

import logic.ShootingLogic;

public class OrangeChicken extends Chicken {

	public OrangeChicken(int indexX, int indexY) {
		super(indexX, indexY,4);
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
		// TODO Auto-generated method stub

	}

	@Override
	public void Visit(YellowShot shot) {
		ShootingLogic.KillChicken(this);

	}

}
