package entities;

public interface Visitor {//visitor
	   public void accept( Shot v ); // first dispatch
	   public void Visit(BlackShot shot);
	   public void Visit(RedShot shot);
	   public void Visit(BlueShot shot);
	   public void Visit(YellowShot shot);
	 
}
