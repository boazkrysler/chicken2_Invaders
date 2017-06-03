package entities;

import java.io.Serializable;

public class Player implements Serializable {
	public String getName() {
		return name;
	}
	public int getTotalScore() {
		return totalScore;
	}
	@Override
	public String toString() {
		return (name+" Score: "+totalScore+" Time: "+time);
	}
	public int getTime() {
		return time;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public void setTime(int time) {
		this.time = time;
	}
	String name;
	int totalScore;
	int time;
	public Player(String name,int totalScore,int time)
	{
		this.name=name;
		this.totalScore=totalScore;
		this.time=time;
	}
	
}
