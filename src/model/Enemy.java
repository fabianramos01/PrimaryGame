package model;

import java.util.Random;

import controller.ConstantList;

public class Enemy{

	private int id;
	private int positionX;
	private int positionY;
	
	public Enemy() {
		Random random = new Random();
		id = random.nextInt((int) ConstantList.WIDTH);
		positionX = random.nextInt((int) ConstantList.WIDTH-300);
		positionY = random.nextInt((int) ConstantList.HEIGHT-300);
	}
	
	public Enemy(int id, int positionX, int positionY) {
		super();
		this.id = id;
		this.positionX = positionX;
		this.positionY = positionY;
	}



	public void move(Direction direction) {
		switch (direction) {
		case DOWN:
			positionY += ConstantList.MOVE_ENEMY;
			break;
		case LEFT:
			positionX -= ConstantList.MOVE_ENEMY;
			break;
		case RIGHT:
			positionX += ConstantList.MOVE_ENEMY;
			break;
		case UP:
			positionY -= ConstantList.MOVE_ENEMY;
			break;
		}
	}
	
	public int getPositionX() {
		return positionX;
	}
	
	public int getPositionY() {
		return positionY;
	}
	
	public int getId() {
		return id;
	}
}