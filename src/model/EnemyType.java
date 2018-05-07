package model;

public enum EnemyType {

	NORMAL("NORMAL", 1, 60), MASTER("MASTER", 5, 330);

	private String type;
	private int life;
	private int size;
	
	private EnemyType(String type, int life, int size) {
		this.type = type;
		this.life = life;
		this.size = size;
	}
	
	public int getLife() {
		return life;
	}
	
	public String getType() {
		return type;
	}
	
	public int getSize() {
		return size;
	}
}