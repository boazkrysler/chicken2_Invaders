package graphics;

import entities.Chicken;

public interface Board {
	
	void createBoard(); // call createBoard from logic

	void updateToolBar();
	void updateBoard();  //repaint chicken, shot
	
	//listeners:
	void hit(Chicken x); //when listener receive a hit he send it to logic
	void move(); //spaceship   call moveLeft/moveRight at mainFunctions
	void updateShot(); // if press space update shot
	void loadGun();
	
	//check gameOver:
	void endGame(); // Receive if gameOver
	void EndLevelDialog();
	}
