package model;

import java.util.Random;

import controller.ConstantList;

public class Player {

	private int id;
	private int positionX;
	private int positionY;
	private int life;
	
	public Player() {
		Random random = new Random();
		id = random.nextInt((int) ConstantList.WIDTH);
		positionX = random.nextInt((int) ConstantList.WIDTH);
		positionY = random.nextInt((int) ConstantList.HEIGHT);
		life = ConstantList.LIFE_LIM;
	}
	
	public Player(int id, int positionX, int positionY, int life) {
		super();
		this.id = id;
		this.positionX = positionX;
		this.positionY = positionY;
		this.life = life;
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
	
	public void lessLife() {
		life -= ConstantList.LIFE_LESS;
	}
	
	public int getPositionX() {
		return positionX;
	}
	
	public int getPositionY() {
		return positionY;
	}
	
	public int getLife() {
		return life;
	}
	
	public int getId() {
		return id;
	}
}