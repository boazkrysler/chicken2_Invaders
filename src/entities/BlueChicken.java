package entities;

import logic.ShootingLogic;

public class BlueChicken extends Chicken {

	public BlueChicken(int indexX, int indexY) {
		super(indexX, indexY, 2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Visit(BlackShot shot) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Visit(RedShot shot) {
		ShootingLogic.KillTwoNumChickens(5);
	}

	@Override
	public void Visit(BlueShot shot) {
		ShootingLogic.KillChicken(this);
	}

	@Override
	public void Visit(YellowShot shot) {
		ShootingLogic.KillTwoNumChickens(6);
		
	}

}
