package logic;


import entities.*;
public class IntBoards {

	static int[][] firstLevel=new int[][]{{1,2,3,1,1,3,2,1},{3,1,2,2,2,2,1,3},{2,3,1,3,3,1,3,2},{1,2,3,4,4,3,2,1}};
	static int[][] secondLevel=new int[][]{{5,5,5,6,6,4,4,4},{3,9,1,1,1,1,9,3},{3,1,2,2,2,2,1,3},{6,5,4,3,3,4,5,6}};
	static int[][] thirdLevel=new int[][]{{5,5,5,3,3,4,4,4},{5,8,5,2,2,6,6,6},{5,5,5,1,1,6,8,6},{4,4,4,8,4,6,6,6}};
	static int[][] fourthLevel=new int[][]{{5,5,4,4,5,5,4,4},{6,7,6,7,6,7,6,7},{4,3,5,2,4,3,5,2},{1,1,1,1,1,1,1,1}};
	static int CurrentLevel=1;
	static Chicken[][] ChickBoard;
	static int[][] intBoard;
	public static  Chicken[][] ChickenBoardInit(int[][] level)

	{
		intBoard=level;
		Chicken[][] ChickBoard =new Chicken[level.length][level[0].length];
		for(int i=0;i<level.length;i++)
			for(int j=0;j<level[i].length;j++)
			{
				int ChickNum=level[i][j];
				switch (ChickNum)
				{
				case 0: ChickBoard[i][j]=null;break;
				case 1:	ChickBoard[i][j]=new RedChicken(j,i);break;
				case 2:	ChickBoard[i][j]=new BlueChicken(j,i);break;
				case 3:	ChickBoard[i][j]=new YellowChicken(j,i);break;
				case 4:	ChickBoard[i][j]=new OrangeChicken(j,i);break;
				case 5:	ChickBoard[i][j]=new PurpleChicken(j,i);break;
				case 6:	ChickBoard[i][j]=new GreenChicken(j,i);break;
				case 7:	ChickBoard[i][j]=new ChickenX(j,i);break;
				case 8:	ChickBoard[i][j]=new ChickenPlus(j,i);break;
				case 9:	ChickBoard[i][j]=new ChickenCircle(j,i);	break;

				}
			}
		return ChickBoard;
		
	}
	public static int[][] GetIntBoard(int level)
	{
		if(intBoard!=null) return intBoard;
		int[][] board=null;
		CurrentLevel=level;
		switch(level)
		{
			case 1:board=firstLevel;
			case 2:board=secondLevel;
			case 3:board=thirdLevel;
			case 4:board=fourthLevel;		
		}
		intBoard=board;
		return board;
	}
	public static int[][] changeLevel(int level)
	{
		int[][] board=null;
		CurrentLevel=level;
		switch(level)
		{
			case 1:board=firstLevel;
			case 2:board=secondLevel;
			case 3:board=thirdLevel;
			case 4:board=fourthLevel;		
		}
		intBoard=board;
		return board;
	}
	public static Chicken[][] GetChickenBoard()
	{
		int[][] board=null;
		
		switch(CurrentLevel)
		{
			case 1:board=firstLevel;
			case 2:board=secondLevel;
			case 3:board=thirdLevel;
			case 4:board=fourthLevel;		
		}
		return ChickenBoardInit(board);
	}
	public static int[][] getCurrentIntBoard()
	{
		return GetIntBoard(CurrentLevel);
	}
	
}
