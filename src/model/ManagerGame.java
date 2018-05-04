package model;

public class ManagerGame {

	private Enemy enemy;
	private Player player;
	
	public ManagerGame() {
		enemy = new Enemy();
		player = new Player();
	}
	
	public void movePlayer(Direction direction) {
		player.move(direction);
	}
	
	public Enemy getEnemy() {
		return enemy;
	}
	
	public Player getPlayer() {
		return player;
	}
}