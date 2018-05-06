package model;

public enum EnemyType {

	NORMAL("NORMAL", 1), MASTER("MASTER", 5);

	private String type;
	private int life;
	
	private EnemyType(String type, int life) {
		this.type = type;
		this.life = life;
	}
	
	public int getLife() {
		return life;
	}
	
	public String getType() {
		return type;
	}
}