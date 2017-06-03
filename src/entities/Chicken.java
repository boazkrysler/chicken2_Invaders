package entities;

public abstract class Chicken implements Visitor{

	int indexX,indexY;
	int number;
	boolean isDead;
	String imagePath;
	
	public Chicken(int indexX,int indexY,int number) {
		this.indexX=indexX;
		this.indexY=indexY;
		this.number=number;
	}
	public void accept(Shot s)
	{
		s.shooting(this);
	}
	
	public int getIndexX() {
		return indexX;
	}
	public int getIndexY() {
		return indexY;
	}
	public int getNumber() {
		return number;
	}
	public String getImagePath() {
		return imagePath;
	}
	public void setIndexX(int indexX) {
		this.indexX = indexX;
	}
	public void setIndexY(int indexY) {
		this.indexY = indexY;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
}
