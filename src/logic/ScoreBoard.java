package logic;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import entities.Player;

public class ScoreBoard {

	public static List<Player> LoadListOfPlayers()
	{
		List<Player> readCase=null;
		ObjectInputStream objectinputstream = null;
			try
			{
				 	FileInputStream streamIn = new FileInputStream("c:\\ChickenInvaders\\scoreBoard.ser");
			        objectinputstream = new ObjectInputStream(streamIn);
			        readCase = (List<Player>) objectinputstream.readObject();
			        return readCase;
			       
			}
			catch(Exception e)
			{
				return null;
			}
	}
	public static void SavePlayer(Player p)
	{
		List<Player> loaded=LoadListOfPlayers();
		if(loaded!=null)
		{
			loaded.add(p);
			(new File("c:\\ChickenInvaders")).mkdirs();
			
			try {
					FileOutputStream fout = new FileOutputStream("c:\\ChickenInvaders\\scoreBoard.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fout);
					oos.writeObject(loaded);
			}
			catch (IOException e) {
		
			}
		}
		else
		{
			
			loaded=new ArrayList<Player>();
			loaded.add(p);
			(new File("c:\\ChickenInvaders")).mkdirs();
			
			try {
					FileOutputStream fout = new FileOutputStream("c:\\ChickenInvaders\\scoreBoard.ser");
					ObjectOutputStream oos = new ObjectOutputStream(fout);
					oos.writeObject(loaded);
			}
			catch (IOException e) {
		
			}
		}
		
	}
}
