package controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.ManagerGame;

public class Controller implements KeyListener {

	private ManagerGame managerGame;
	
	public Controller() {
		managerGame = new ManagerGame();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		managerGame.movePlayer(e.getKeyCode());
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

}