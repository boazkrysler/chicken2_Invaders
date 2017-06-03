package graphics;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Random;

import javax.swing.Box;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import logic.*;
import entities.*;

public class ScoreBoardGui extends JFrame  {


	public static void main(String[] args)
	{
		String alphabet="abcdefghijklmnopqrstuvwxyz";
	    Random r = new Random();
	    /*
		for(int i=0;i<50;i++)
		{
			String name="";
			int time= (int) (100*Math.random());
			int score=(int) (500*Math.random());
			for(int j=0;j<7;j++)
				name=name+alphabet.charAt(r.nextInt(alphabet.length()));
			Player p1=new Player(name,time,score);
			ScoreBoard.SavePlayer(p1);
		}
		*/
		ScoreBoardGui g1=new ScoreBoardGui();
	



		g1.show();
	}

	public ScoreBoardGui()
	{
        super("Reversi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.BLUE);

		List<Player> scores=ScoreBoard.LoadListOfPlayers();
		
		JScrollPane Panel = new JScrollPane();
		Panel.setBackground(Color.BLUE);
		getContentPane().add(Panel);
		DefaultListModel<Player> model=new DefaultListModel<Player>();
		JList list=new JList(model);
		Panel.setViewportView(list);
		for(Player p:scores)
		{
			model.addElement(p);
		}
		
		setSize(600,600);
		setVisible(true);

	}
}