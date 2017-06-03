package entities;
import logic.*;

public class RedChicken extends Chicken {

	public RedChicken(int indexX, int indexY) {
		super(indexX, indexY, 1);
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
		ShootingLogic.KillTwoNumChickens(5);

	}

	@Override
	public void Visit(YellowShot shot) {
		ShootingLogic.KillTwoNumChickens(4);

	}

}
