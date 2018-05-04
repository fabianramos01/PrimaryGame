package view;

import java.awt.Graphics;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import controller.ConstantList;
import model.Enemy;
import model.Player;

public class PanelGame extends JPanel {

	private static final long serialVersionUID = 1L;
	private ImageIcon playerImage;
	private ImageIcon enemyImage;
	private Player player;
	private Enemy enemy;
	
	public PanelGame(KeyListener listener, Player player, Enemy enemy) {
		addKeyListener(listener);
		setFocusable(true);
		this.player = player;
		this.enemy = enemy;
		playerImage = new ImageIcon(getClass().getResource(ConstantList.PLAYER_IMG));
		playerImage = UtilityList.scaledImage(playerImage, ConstantList.PLAYER_SIZE, ConstantList.PLAYER_SIZE);
		enemyImage = new ImageIcon(getClass().getResource(ConstantList.ENEMY_IMG));
		enemyImage = UtilityList.scaledImage(enemyImage, ConstantList.ENEMY_SIZE, ConstantList.ENEMY_SIZE);
	}
	
	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.drawImage(playerImage.getImage(), player.getPositionX(), player.getPositionY(), null);
		g.drawImage(enemyImage.getImage(), enemy.getPositionX(), enemy.getPositionY(), null);
	}
}
