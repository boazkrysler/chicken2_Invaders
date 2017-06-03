package entities;

import logic.ShootingLogic;

public class ChickenXor extends Chicken {

	public ChickenXor(int indexX, int indexY) {
		super(indexX, indexY, 7);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void Visit(BlackShot shot) {
		ShootingLogic.KillXorChicken(this);
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
