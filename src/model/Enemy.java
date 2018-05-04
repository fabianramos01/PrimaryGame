package model;

import java.util.Random;

import controller.ConstantList;

public class Enemy extends MyThread{

	private int id;
	private int positionX;
	private int positionY;
	
	public Enemy() {
		super("", ConstantList.SLEEP);
		Random random = new Random();
		id = random.nextInt((int) ConstantList.WIDTH);
		positionX = random.nextInt((int) ConstantList.WIDTH);
		positionY = random.nextInt((int) ConstantList.HEIGHT);
	}
	
	public void move(Direction direction) {
		switch (direction) {
		case DOWN:
			positionY += ConstantList.MOVE_UNITS;
			break;
		case LEFT:
			positionX -= ConstantList.MOVE_UNITS;
			break;
		case RIGHT:
			positionX += ConstantList.MOVE_UNITS;
			break;
		case UP:
			positionY -= ConstantList.MOVE_UNITS;
			break;
		}
	}
	
	@Override
	public void run() {
		
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