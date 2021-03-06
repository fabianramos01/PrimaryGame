package model;

import java.awt.Rectangle;
import java.util.ArrayList;

import controller.ConstantList;

public class ManagerGame extends MyThread {

	private Player player;
	private ArrayList<Enemy> enemyList;
	private ArrayList<Shoot> shootList;
	private boolean crash;
	private boolean master;

	public ManagerGame() {
		super("", ConstantList.SLEEP);
		enemyList = new ArrayList<>();
		player = new Player();
		shootList = new ArrayList<>();
	}

	public void loadGame(Player player, ArrayList<Enemy> enemys, ArrayList<Shoot> shoots) {
		this.player = player;
		this.enemyList = enemys;
		this.shootList = shoots;
	}

	public void enemyList(int num) {
		for (int i = 0; i < num; i++) {
			enemyList.add(new Enemy(EnemyType.NORMAL));
		}
	}

	public void newShoot(int x, int y, int width, int height) {
		shootList.add(new Shoot(ConstantList.SLEEP_SHOOT, player.getPositionX(), player.getPositionY(), width, height));
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

	private void enemyCrash() {
		for (Enemy enemy : enemyList) {
			validateCrash(enemy);
			if (player.getLife() <= 0) {
				stop();
				break;
			}
		}
	}

	private void validateCrash(Enemy enemy) {
		Rectangle rectangleEnemy = new Rectangle(enemy.getPositionX(), enemy.getPositionY(),
				enemy.getEnemyType().getSize(), enemy.getEnemyType().getSize());
		Rectangle rectanglePlayer = new Rectangle(player.getPositionX(), player.getPositionY(),
				ConstantList.PLAYER_SIZE, ConstantList.PLAYER_SIZE);
		if (rectanglePlayer.intersects(rectangleEnemy)) {
			if (enemy.getEnemyType().getType().equals(EnemyType.NORMAL.getType())) {
				player.lessLifeEne();
			} else {
				player.lessLifeEneM();
			}
		}
	}

	private void shotEnemy() {
		for (Shoot shoot : shootList) {
			for (int i = 0; i < enemyList.size(); i++) {
				shootCrash(shoot, enemyList.get(i));
				if (enemyList.get(i).getLife() == 0) {
					enemyList.remove(i);
				}
			}
		}
	}

	private void shootCrash(Shoot shoot, Enemy enemy) {
		Rectangle rectangleEnemy = new Rectangle(enemy.getPositionX(), enemy.getPositionY(),
				enemy.getEnemyType().getSize(), enemy.getEnemyType().getSize());
		Rectangle rectangleShoot = new Rectangle(shoot.getPositionX(), shoot.getPositionY(), ConstantList.ATTACK_SIZE,
				ConstantList.ATTACK_SIZE);
		if (rectangleShoot.intersects(rectangleEnemy)) {
			shoot.stop();
			enemy.lessLife();
		}
	}

	public void shootEnemy(int x, int y) {
		for (int i = 0; i < enemyList.size(); i++) {
			Enemy enemy = enemyList.get(i);
			if ((enemy.getPositionX() <= x && x <= enemy.getPositionX() + enemy.getEnemyType().getSize())
					&& (enemy.getPositionY() <= y && y <= enemy.getPositionY() + enemy.getEnemyType().getSize())) {
				enemy.lessLife();
				if (enemy.getLife() == 0) {
					enemyList.remove(i);
					if (enemy.getEnemyType().getType().equals(EnemyType.MASTER.getType())) {
						stop();
					}
				}
			}
		}
	}

	private void deleteAttack() {
		for (int i = 0; i < shootList.size(); i++) {
			if (shootList.get(i).isStop()) {
				shootList.remove(i);
			}
		}
	}

	private void enemyListMove() {
		for (Enemy enemy : enemyList) {
			moveEnemy(enemy);
		}
	}

	private void moveEnemy(Enemy enemy) {
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

	public void pauseGame() {
		pause();
		for (Shoot shoot : shootList) {
			shoot.pause();
		}
	}

	public void resumeGame() {
		resume();
		for (Shoot shoot : shootList) {
			shoot.resume();
		}
	}

	@Override
	public void execute() {
		if (!crash) {
			enemyCrash();
			shotEnemy();
			enemyListMove();
			deleteAttack();
			if (enemyList.isEmpty() && !master) {
				enemyList.add(new Enemy(EnemyType.MASTER));
				master = true;
			}
			crash = isStop();
		}
	}

	public Player getPlayer() {
		return player;
	}

	public ArrayList<Enemy> getEnemyList() {
		return enemyList;
	}

	public ArrayList<Shoot> getShootList() {
		return shootList;
	}
}