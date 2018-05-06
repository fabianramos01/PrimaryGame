package view;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.ConstantList;
import controller.Controller;
import model.Enemy;
import model.Player;
import model.Shoot;

public class PanelGame extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon playerImage;
	private ImageIcon enemyImage;
	private ImageIcon shootImage;
	private Player player;
	private ArrayList<Enemy> enemyList;
	private ArrayList<Shoot> shootList;

	public PanelGame(Controller listener, Player player, ArrayList<Enemy> enemyList, ArrayList<Shoot> shootList) {
		this.player = player;
		this.enemyList = enemyList;
		this.shootList = shootList;
		setFocusable(true);
		addKeyListener(listener);
		addMouseListener (listener);
		playerImage = new ImageIcon(getClass().getResource(ConstantList.PLAYER_IMG));
		playerImage = UtilityList.scaledImage(playerImage, ConstantList.PLAYER_SIZE_IMG, ConstantList.PLAYER_SIZE_IMG);
		enemyImage = new ImageIcon(getClass().getResource(ConstantList.ENEMY_IMG));
		enemyImage = UtilityList.scaledImage(enemyImage, ConstantList.ENEMY_SIZE_IMG, ConstantList.ENEMY_SIZE_IMG);
		shootImage = new ImageIcon(getClass().getResource(ConstantList.ATTACK_IMG));
		shootImage = UtilityList.scaledImage(shootImage, ConstantList.ATTACK_SIZE_IMG, ConstantList.ATTACK_SIZE_IMG);
		setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
				new ImageIcon(getClass().getResource(ConstantList.CURSOR_IMG)).getImage(), new Point(0, 0), ""));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(playerImage.getImage(), player.getPositionX(), player.getPositionY(), null);
		for (Enemy enemy : enemyList) {
			g.drawImage(enemyImage.getImage(), enemy.getPositionX(), enemy.getPositionY(), null);
		}
		for (Shoot shoot : shootList) {
			g.drawImage(shootImage.getImage(), shoot.getPositionX(), shoot.getPositionY(), null);
		}
	}
}