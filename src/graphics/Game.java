package graphics;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.GroupLayout.Alignment;

import entities.BlackShot;
import entities.BlueShot;
import entities.RedShot;
import entities.YellowShot;
import logic.ImpMainFunction;
import logic.MainFunctions;


public class Game extends JFrame implements KeyListener{
	private JFrame mainMenu;
	private Timer timer;
	private Timer shotTimer;
	private JLabel timerLabel;
	private String Time = "00:00";
	public JLabel lblGunType;
	public JLabel lblShip;
	public JLabel shot;
	public final static int ONE_SECOND = 1000;
	public int shotCounter;
	public JLabel lblShotCounter;
	public int shoot;
	public boolean canShot = true;
	public JLabel[][] chickens = new JLabel[4][8];
	public MainFunctions s;
	public Game(){
	//super("Chicken");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		Rectangle maxBounds = GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds();		 
		setSize(maxBounds.width, maxBounds.height);				
		setVisible(true);
		
		setFocusable(true);
        addKeyListener(this);
		
		s=new ImpMainFunction();

		JPanel toolBar = new JPanel();
		this.getContentPane().add(toolBar, BorderLayout.NORTH);
		timerLabel = new JLabel(" time: "+Time);
		timerLabel.setFont(new Font("Tw Cen MT", Font.PLAIN, 20));
		shotCounter=0;
		lblShotCounter = new JLabel(" Shots: "+shotCounter);
		lblShotCounter.setFont(new Font("Urdu Typesetting", Font.PLAIN, 20));
		
		lblGunType = new JLabel("Gun Type");
		this.shoot=1;
		
		lblGunType.setFont(new Font("Ebrima", Font.PLAIN, 46));
		switchColor(Color.BLACK);
		shoot = 1;
		
		timerLabel.setLocation(timerLabel.getX()-1, timerLabel.getY());
		
		GroupLayout gl_toolBar = new GroupLayout(toolBar);
		gl_toolBar.setHorizontalGroup(
			gl_toolBar.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_toolBar.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblGunType, GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
					.addComponent(lblShotCounter)
					.addGap(800)
					.addComponent(timerLabel)
					.addGap(10))			
		);
		
		gl_toolBar.setVerticalGroup(
			gl_toolBar.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_toolBar.createSequentialGroup()
					.addGroup(gl_toolBar.createParallelGroup(Alignment.BASELINE)
						.addComponent(timerLabel)
						.addComponent(lblShotCounter)
						.addComponent(lblGunType))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		toolBar.setLayout(gl_toolBar);
		toolBar.setBackground(Color.cyan);
		
		
		JPanel chickenBoard = new JPanel();
		this.getContentPane().add(chickenBoard, BorderLayout.CENTER);
		chickenBoard.setLayout(null);
		chickenBoard.setBackground(new Color(0, 0, 128));
		
	int[][] chickensImage = logic.IntBoards.getCurrentIntBoard();
	
	for(int i=0;i<4;i++){
		for(int j=0;j<8;j++)
			{
			chickens[i][j]=new JLabel("");
			switch(chickensImage[i][j]){ 
				case 0: chickens[i][j].setIcon(null); break;
				case 1: chickens[i][j].setIcon(new ImageIcon(Game.class.getResource("/graphics/resources/chicken/chicken_red.PNG")));break;
				case 2: chickens[i][j].setIcon(new ImageIcon(Game.class.getResource("/graphics/resources/chicken/chicken_blue.PNG")));break;
				case 3: chickens[i][j].setIcon(new ImageIcon(Game.class.getResource("/graphics/resources/chicken/chicken_yellow.PNG")));break;
				case 4: chickens[i][j].setIcon(new ImageIcon(Game.class.getResource("/graphics/resources/chicken/chicken_orange.PNG")));break;
				case 5: chickens[i][j].setIcon(new ImageIcon(Game.class.getResource("/graphics/resources/chicken/chicken_purple.PNG")));break;
				case 6: chickens[i][j].setIcon(new ImageIcon(Game.class.getResource("/graphics/resources/chicken/chicken_green.PNG")));break;
				case 7: chickens[i][j].setIcon(new ImageIcon(Game.class.getResource("/graphics/resources/chicken/special/chicken_x.PNG")));break;
				case 8: chickens[i][j].setIcon(new ImageIcon(Game.class.getResource("/graphics/resources/chicken/special/chicken_plus.PNG")));break;
				case 9: chickens[i][j].setIcon(new ImageIcon(Game.class.getResource("/graphics/resources/chicken/special/chicken_circle.PNG")));break;
				case 10: chickens[i][j].setIcon(new ImageIcon(Game.class.getResource("/graphics/resources/chicken/Bonus/chicken_row.PNG")));break;
				case 11: chickens[i][j].setIcon(new ImageIcon(Game.class.getResource("/graphics/resources/chicken/Bonus/chicken_Column.PNG")));break;
				case 12: chickens[i][j].setIcon(new ImageIcon(Game.class.getResource("/graphics/resources/chicken/Bonus/chicken_xor.PNG")));break;
				case 13: chickens[i][j].setIcon(new ImageIcon(Game.class.getResource("/graphics/resources/chicken/Bonus/chicken_flu.PNG"))); break;
			}
			chickens[i][j].setBounds((int) (getContentPane().getWidth()*j/8),(int) (getContentPane().getHeight()*i/6) ,(int) chickens[i][j].getPreferredSize().getWidth(),(int) chickens[i][j].getPreferredSize().getHeight());
//			chickens[i][j].setLocation(((int) (100+j*100)) ,(int) (100+i*100));
			chickenBoard.add(chickens[i][j]);
			chickens[i][j].setVisible(true);

			System.out.println(chickens[i][j].getLocation());
			}
		}
		
	for(int i=0;i<4;i++){
		for(int j=0;j<8;j++){
		chickens[i][j].setLocation(chickens[i][j].getX()+2, chickens[i][j].getY());	
		}
	}
		this.lblShip = new JLabel("");
		this.lblShip.setIcon(new ImageIcon(Game.class.getResource("/graphics/resources/spaceship.PNG")));
		this.lblShip.setLocation(((int) ((this.getWidth()*0.5) - 0.5*(lblShip.getPreferredSize().getWidth()))) ,(int) (0.5*lblShip.getPreferredSize().getWidth()));
		this.lblShip.setBounds((int) ((this.getWidth()*0.5) - 0.5*(lblShip.getPreferredSize().getWidth())),(int) (getContentPane().getHeight()- (2*lblShip.getPreferredSize().getWidth())) ,(int)lblShip.getPreferredSize().getWidth(),(int) lblShip.getPreferredSize().getHeight());
		chickenBoard.add(lblShip);
		this.lblShip.setVisible(true);
	
		this.shot = new JLabel("");
		this.shot.setIcon(new ImageIcon(Game.class.getResource("/graphics/resources/explosion.PNG")));
		this.shot.setLocation(((int) ((this.getWidth()*0.5) - 0.5*(lblShip.getPreferredSize().getWidth()))) ,(int) (0.5*lblShip.getPreferredSize().getWidth()));
		this.shot.setBounds((int) ((this.getWidth()*0.5) - 0.5*(lblShip.getPreferredSize().getWidth())),(int) (getContentPane().getHeight()- (2*lblShip.getPreferredSize().getWidth())) ,(int)lblShip.getPreferredSize().getWidth()/4,(int) lblShip.getPreferredSize().getHeight()/2);
		chickenBoard.add(shot);
		this.shot.setVisible(false);
	
		lblShip.setLocation(lblShip.getX()+1,lblShip.getY());
		
		timer = new Timer(ONE_SECOND, new ActionListener() {
			 public void actionPerformed(ActionEvent evt) {
				 timePlusOne();				
		    }
		    });
		timer.start();
	}
	
	public boolean isHit() {

		entities.Chicken[][] whiceOne = logic.IntBoards.GetChickenBoard();
		for(int i=0;i<4;i++){
			for(int j=0;j<8;j++){	
					if(jComponentlOverlap(chickens[i][j], shot)) {
						
						int[][] pastChickens = copyMat(logic.IntBoards.getCurrentIntBoard());
						if(whiceOne[i][j]!=null){
							s.hit(whiceOne[i][j]);
							System.out.println("hit");
						
							paintChickens(pastChickens);
							return true;
						}
					}
				}

					
			}
		System.out.println("not hit");
		return false;	
	}
	
	private int[][] copyMat(int[][] currentIntBoard) {
		int[][] copied=new int[currentIntBoard.length][currentIntBoard[0].length];
		for(int i=0;i<copied.length;i++)
			for(int j=0;j<copied[0].length;j++)
				copied[i][j]=currentIntBoard[i][j];
		return copied;
	}
	

	public boolean jComponentlOverlap(JComponent  Comp2, JComponent  Comp1) {
		if(Comp1==null || Comp2==null)
			return false;
		
		Point[] Comp1_points = CompPoints(Comp1);
		Point[] Comp2_points = CompPoints(Comp2);
		int lowBound_x = Comp2_points[0].x;
		int lowBound_y = Comp2_points[0].y;
		int highBound_x= Comp2_points[3].x;
		int highBound_y= Comp2_points[3].y;		

		for(Point p : Comp1_points){
			if(lowBound_y <= p.y && p.y <= highBound_y
					&& lowBound_x <= p.x && p.x <= highBound_x)
				return true;
		}
		return false;
	}
	
	private static Point[] CompPoints(JComponent comp) {
		Point point= comp.getLocation() ;
		Dimension dim = comp.getSize();	
		
		Point[] points = new  Point[4];
		points[0]= new Point(point);
		points[1]= new Point(point.x,point.y+dim.height);
		points[2]= new Point(point.x+dim.width,point.y);
		points[3]= new Point(point.x+dim.width,point.y+dim.height);
		return points;
	}
	public void timePlusOne(){
		if(this.Time.charAt(Time.length()-1) != '9')
			this.Time=this.Time.substring(0, 4)+(Character.digit((this.Time.charAt(4)),9)+1);
			else if(this.Time.charAt(3)!='5')
				this.Time=this.Time.substring(0, 3)+(Character.digit((this.Time.charAt(3)),6)+1)+"0";
				else if(this.Time.charAt(1)!='9')
				this.Time=this.Time.substring(0, 1)+(Character.digit((this.Time.charAt(1)),9)+1+":00");
				else if(this.Time.charAt(0)!='9')
					this.Time=(Character.digit((this.Time.charAt(1)),9)+1+"0:00");
				else this.Time="00:00";
		this.timerLabel.setText(" time: "+this.Time);
	}
	public void Refresh(){				
		 this.invalidate();
		 this.validate();
		 this.repaint();				
	}
	public void keyTyped(KeyEvent e) {
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		 switch(e.getKeyCode()) {
			 case KeyEvent.VK_SPACE: moveShot(); break;
	         case KeyEvent.VK_RIGHT: move(1);break;
	         case KeyEvent.VK_LEFT: move(-1); break;
			 case KeyEvent.VK_1:
				 this.shoot=1; switchColor(Color.BLACK); break;
			 case KeyEvent.VK_2:
				 this.shoot=2; switchColor(Color.RED); break;
			 case KeyEvent.VK_3:
				 this.shoot=3; switchColor(Color.blue); break;
			 case KeyEvent.VK_4:
				 this.shoot=4; switchColor(Color.YELLOW); break;
         }	 
	}

	public void moveShot(){
		if(canShot){
			canShot = false;
			this.shotCounter++;
			this.lblShotCounter.setText(" Shots: "+shotCounter);;;
			//this.shot.setLocation(((int) ((lblShip.getWidth()*0.5) - 0.5*(lblShip.getPreferredSize().getWidth()))) ,(int) (0.5*lblShip.getPreferredSize().getWidth()));
			shot.setVisible(true);
			shot.setLocation(lblShip.getLocation());
			shot.setLocation(shot.getX() + 20, shot.getY());
			
			shotTimer = new Timer(ONE_SECOND/10, new ActionListener() {
					
				 public void actionPerformed(ActionEvent evt) {
					 shot.setLocation(shot.getX(), shot.getY()-100);
					 
					 if(isHit() || shot.getY() <20) {
						 shotTimer.stop();
						 canShot = true;
						 shot.setVisible(false);
						 shot.setLocation(lblShip.getLocation());
					 }
			    }
			    });
			shotTimer.start();
		}
	}
	
	public void paintChickens(int[][] pastChickens){
		ImageIcon img=new ImageIcon(Game.class.getResource("/graphics/resources/explosion.PNG"));
	int[][] newChickens = logic.IntBoards.getCurrentIntBoard();
		for(int i=0;i<4;i++){
			for(int j=0;j<8;j++){
				if(newChickens[i][j] != pastChickens[i][j]){
      					chickens[i][j].setIcon(null);
					chickens[i][j].setIcon(img);
				}
			}
		}
		
		Timer tempTimer = new Timer(ONE_SECOND, new ActionListener() {
			
			 public void actionPerformed(ActionEvent evt) {
				 for(int i=0;i<4;i++)
				 {
						for(int j=0;j<8;j++)
						{
							if(chickens[i][j].getIcon()==img)
			      					chickens[i][j].setIcon(null);
							
						}
					}
				 
			 }
		    });
		tempTimer.start();	
	}
	public void move(int whiceWay){  //right  = positiv, left = negetiv
	
		if(whiceWay>0 && lblShip.getX()<getContentPane().getWidth() - 60) lblShip.setLocation(lblShip.getX()+10, lblShip.getY());
		else if(whiceWay<0 && lblShip.getX() > 10) lblShip.setLocation(lblShip.getX()-10, lblShip.getY());
	}
	
		public void switchColor(Color color){
		if(canShot){
			this.lblGunType.setForeground(color);
			this.lblGunType.setText("Gun Type");
			if(color==Color.black)
				s.loadGun(new BlackShot());
			if(color==Color.red)
				s.loadGun(new RedShot());
			if(color==Color.blue)
				s.loadGun(new BlueShot());
			if(color==Color.yellow)
				s.loadGun(new YellowShot());
			this.lblGunType.repaint();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
