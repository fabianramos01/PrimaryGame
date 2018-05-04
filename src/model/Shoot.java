package model;

public class Shoot {

	private int positionX;
	private int positionY;
	private int widthArea;
	private int heightArea;
	
	public Shoot(int positionX, int positionY, int widthArea, int heightArea) {
		this.positionX = positionX;
		this.positionY = positionY;
		this.widthArea = widthArea;
		this.heightArea = heightArea;
	}
	
	public void move() {
		
	}
	
	public int getPositionX() {
		return positionX;
	}
	
	public int getPositionY() {
		return positionY;
	}
}