package model;

public class ManagerGame {

	private Enemy enemy;
	private Player player;
	
	public ManagerGame() {
		enemy = new Enemy();
		player = new Player();
	}
	
	public void movePlayer(int code) {
		if (code == 37) {
			player.move(Direction.LEFT);
		} else if (code == 38) {
			player.move(Direction.UP);
		} else if (code == 39) {
			player.move(Direction.RIGHT);
		} else if (code == 40) {
			player.move(Direction.DOWN);
		}
	}
	
	public Enemy getEnemy() {
		return enemy;
	}
	
	public Player getPlayer() {
		return player;
	}
}