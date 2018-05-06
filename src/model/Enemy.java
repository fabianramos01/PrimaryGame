package model;

import java.util.Random;

import controller.ConstantList;

public class Enemy{

	private int id;
	private EnemyType enemyType;
	private int life;
	private int positionX;
	private int positionY;
	
	public Enemy(EnemyType enemyType) {
		this.enemyType = enemyType;
		Random random = new Random();
		id = random.nextInt((int) ConstantList.WIDTH);
		positionX = random.nextInt((int) ConstantList.WIDTH-300);
		positionY = random.nextInt((int) ConstantList.HEIGHT-300);
		life = enemyType.getLife();
	}
	
	public Enemy(int id, EnemyType enemyType, int life, int positionX, int positionY) {
		this.enemyType = enemyType;
		this.id = id;
		this.life = life;
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
	
	public void lessLife() {
		life -= ConstantList.LIFE_LESS_ENEMY;
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
	
	public EnemyType getEnemyType() {
		return enemyType;
	}
	
	public int getLife() {
		return life;
	}
}