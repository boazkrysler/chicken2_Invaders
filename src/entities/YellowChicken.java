package entities;

import logic.ShootingLogic;

public class YellowChicken extends Chicken {

	public YellowChicken(int indexX, int indexY) {
		super(indexX, indexY, 3);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Visit(BlackShot shot) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Visit(RedShot shot) {
		ShootingLogic.KillTwoNumChickens(4);

	}

	@Override
	public void Visit(BlueShot shot) {
		ShootingLogic.KillTwoNumChickens(6);

	}

	@Override
	public void Visit(YellowShot shot) {
		ShootingLogic.KillChicken(this);

	}

}
