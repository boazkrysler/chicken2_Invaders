package logic;

import entities.Chicken;
import entities.Shot;

public interface MainFunctions {

	
	void shoot();
	void loadGun(Shot A);
	void moveLeft();
	void moveRight();
	void hit(Chicken x);
	
	void gameOver(); //after hit check if game over
}
