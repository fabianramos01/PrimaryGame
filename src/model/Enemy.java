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