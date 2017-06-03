package logic;
import entities.BlackShot;
import entities.Chicken;
import entities.Shot;

public class ImpMainFunction implements MainFunctions {
	private int SpaceShipX;
	
	Shot CurrentShot=new BlackShot();
	@Override
	public void shoot() {
		
	}

	@Override
	public void loadGun(Shot A) {
		CurrentShot=A;
	}

	@Override
	public void moveLeft() {
		SpaceShipX=SpaceShipX-5;
	}

	@Override
	public void moveRight() {
		SpaceShipX=SpaceShipX+5;

	}

	@Override
	public void hit(Chicken x) {
		CurrentShot.shooting(x);
		gameOver();
	}

	@Override
	public void gameOver() {
		boolean finish=true;
		int[][] board=IntBoards.getCurrentIntBoard();
		for(int i=0;i<board.length;i++)
			for(int j=-0;j<board[0].length;j++)
				if(board[i][j]!=0)
					finish=false;
		if(finish)
			NextLevel();
					
	}

	private void NextLevel() {
		
	}public int getSpaceShipX() {
		return SpaceShipX;
	}

	public Shot getCurrentShot() {
		return CurrentShot;
	}

	public void setSpaceShipX(int spaceShipX) {
		SpaceShipX = spaceShipX;
	}

	public void setCurrentShot(Shot currentShot) {
		CurrentShot = currentShot;
	}


}
