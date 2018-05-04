package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Timer;

import model.ManagerGame;
import view.PrincipalFrame;

public class Controller implements KeyListener {

	private ManagerGame managerGame;
	private PrincipalFrame principalFrame;
	private Timer timer;
	private int time;

	public Controller() {
		managerGame = new ManagerGame();
		managerGame.enemyList(2);
		principalFrame = new PrincipalFrame(this, managerGame.getPlayer(), managerGame.getEnemyList());
		start();
	}

	private void start() {
		timer = new Timer(ConstantList.REFRESH_TIME, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				time++;
				principalFrame.refreshTime(time);
				if (managerGame.isStop()) {
					principalFrame.gameOver();
					timer.stop();
				}
			}
		});
		timer.start();
		managerGame.run();
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