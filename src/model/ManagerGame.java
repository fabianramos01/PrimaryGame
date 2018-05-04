package model;

import controller.ConstantList;

public class ManagerGame extends MyThread {

	private Enemy enemy;
	private Player player;

	public ManagerGame() {
		super("");
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

	private void validateCrash() {
		if (((enemy.getPositionX() <= player.getPositionX()
				&& player.getPositionX() <= enemy.getPositionX() + ConstantList.ENEMY_SIZE)
				|| (enemy.getPositionX() <= player.getPositionX() + ConstantList.PLAYER_SIZE && player.getPositionX()
						+ ConstantList.PLAYER_SIZE <= enemy.getPositionX() + ConstantList.ENEMY_SIZE))
				&& ((enemy.getPositionY() <= player.getPositionY()
						&& player.getPositionY() <= enemy.getPositionY() + ConstantList.ENEMY_SIZE)
						|| (enemy.getPositionY() <= player.getPositionY() + ConstantList.PLAYER_SIZE
								&& player.getPositionY() + ConstantList.PLAYER_SIZE <= enemy.getPositionY()
										+ ConstantList.ENEMY_SIZE))) {
			stop();
		}
	}

	private void moveEnemy() {
		if (player.getPositionX() <= enemy.getPositionX()) {
			enemy.move(Direction.LEFT);
		} else {
			enemy.move(Direction.RIGHT);
		}
		if (player.getPositionY() <= enemy.getPositionY()) {
			enemy.move(Direction.UP);
		} else {
			enemy.move(Direction.DOWN);
		}
	}

	@Override
	public void run() {
		boolean crash = false;
		while (!crash) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
			validateCrash();
			moveEnemy();
			crash = isStop();
		}
	}
}