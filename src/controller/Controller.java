package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.ManagerGame;
import view.PrincipalFrame;

public class Controller implements KeyListener {

	private ManagerGame managerGame;
	private PrincipalFrame principalFrame;

	public Controller() {
		managerGame = new ManagerGame();
		principalFrame = new PrincipalFrame(this, managerGame.getPlayer(), managerGame.getEnemy());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		managerGame.movePlayer(e.getKeyCode());
		principalFrame.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		managerGame.movePlayer(e.getKeyCode());
		principalFrame.repaint();
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}