package logic;

import entities.Chicken;

public class ShootingLogic {

	public static void KillChicken(Chicken c)
	{
		int[][] board=IntBoards.getCurrentIntBoard();
		int x=c.getIndexX();
		int y=c.getIndexY();
		board[y][x]=0;
		IntBoards.ChickenBoardInit(board);
	}
	public static void KillTwoNumChickens(int num)
	{
		int[][] board=IntBoards.getCurrentIntBoard();
		int counter=0;
		for(int i=0;i<board.length;i++)
		{
			for(int j=0;j<board[0].length;j++)
			{
				if(counter<2)
				{
					if(board[i][j]==num){
						board[i][j]=0;
						counter++;
					}
					
				}
				else
				{
					break;
				}
			}
			if(counter>=2) break;
		}
		IntBoards.ChickenBoardInit(board);
		
	}
	public static void KillXChicken(Chicken c) {
		int[][] board=IntBoards.getCurrentIntBoard();
		int x=c.getIndexX();
		int y=c.getIndexY();
		//chicken blow up
		board[y][x]=0;

		int xTemp=x;
		int yTemp=y;
		//first diagonal up left
		while(xTemp>=0&&yTemp>=0)
		{
			board[yTemp][xTemp]=0;
			yTemp=yTemp-1;
			xTemp=xTemp-1;
		}
		xTemp=x;
		yTemp=y;
		//second diagonal up right
		while(xTemp<board[0].length&&yTemp>=0)
		{
			board[yTemp][xTemp]=0;
			yTemp=yTemp-1;
			xTemp=xTemp+1;
		}
		xTemp=x;
		yTemp=y;
		//third diagonal down left
		while(xTemp>=0&&yTemp<board.length)
		{
			board[yTemp][xTemp]=0;
			yTemp=yTemp+1;
			xTemp=xTemp-1;
		}
		xTemp=x;
		yTemp=y;
		//fourth diagonal down right
		while(xTemp<board[0].length&&yTemp<board.length)
		{
			board[yTemp][xTemp]=0;
			yTemp=yTemp+1;
			xTemp=xTemp+1;
		}	
		
		IntBoards.ChickenBoardInit(board);
	}
	public static void KillPlusChicken(Chicken c) {
		
		
		int[][] board=IntBoards.getCurrentIntBoard();
		int x=c.getIndexX();
		int y=c.getIndexY();
		board[y][x]=0;
		for(int i=0;i<board.length;i++)
			board[i][x]=0;
		for(int i=0;i<board[0].length;i++)
			board[y][i]=0;
		IntBoards.ChickenBoardInit(board);

		
	}
	public static void KillCircleChicken(Chicken c)
	{
		int[][] board=IntBoards.getCurrentIntBoard();
		int x=c.getIndexX();
		int y=c.getIndexY();
		board[y][x]=0;
		if(x+1!=board[0].length)
		{
			if(y-1!=-1)
				board[x+1][y-1]=0;
			if(y+1!=board.length)
				board[x+1][y+1]=0;
			board[x+1][y]=0;
		}
		if(x-1!=-1)
		{
			if(y-1!=-1)
				board[x-1][y-1]=0;
			if(y+1!=board.length)
				board[x-1][y+1]=0;
			board[x-1][y]=0;	
		}
		if(y-1!=-1)
			board[x][y-1]=0;
		if(y+1!=board.length)
			board[x][y+1]=0;
		board[x][y]=0;
		IntBoards.ChickenBoardInit(board);
	}
	public static void KillRowChicken(Chicken c) {
		int[][] board=IntBoards.getCurrentIntBoard();
		int x=c.getIndexX();
		int y=c.getIndexY();
		board[y][x]=0;
		for(int i=0;i<board[0].length;i++)
			board[y][i]=0;	
		IntBoards.ChickenBoardInit(board);

	}
	public static void KillColChicken(Chicken c) {
		int[][] board=IntBoards.getCurrentIntBoard();
		int x=c.getIndexX();
		int y=c.getIndexY();
		board[y][x]=0;
		for(int i=0;i<board.length;i++)
			board[i][x]=0;	
		IntBoards.ChickenBoardInit(board);		
	}
	public static void KillXorChicken(Chicken c) {
		KillColChicken(c);
		KillRowChicken(c);
		KillCircleChicken(c);
	}
	public static void KillAllChickens(Chicken c) {
		int[][] board=IntBoards.getCurrentIntBoard();
		int x=c.getIndexX();
		int y=c.getIndexY();
		for(int i=0;i<board.length;i++)
			for(int j=0;j<board.length;j++)
				board[y][x]=0;
		IntBoards.ChickenBoardInit(board);	
	}
	
}
