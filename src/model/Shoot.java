package model;

import controller.ConstantList;

public class Shoot extends MyThread {

	private int positionX;
	private int positionY;
	private int widthArea;
	private int heightArea;
	
	public Shoot(int sleep, int positionX, int positionY) {
		super("", sleep);
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public Shoot(int sleep, int positionX, int positionY, int widthArea, int heightArea) {
		super("", sleep);
		this.positionX = positionX;
		this.positionY = positionY;
		this.widthArea = widthArea;
		this.heightArea = heightArea;
		start();
	}

	public void move() {
		positionX+= ConstantList.ATTACK_MOVE;
	}
	
	public void setWidthArea(int widthArea) {
		this.widthArea = widthArea;
	}

	public void setHeightArea(int heightArea) {
		this.heightArea = heightArea;
	}

	public int getPositionX() {
		return positionX;
	}

	public int getPositionY() {
		return positionY;
	}
	
	@Override
	public void execute() {
		if (positionX + ConstantList.ATTACK_SIZE_IMG < widthArea) {
			move();
		} else {
			stop();
		}
	}
}