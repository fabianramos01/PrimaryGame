package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;

import model.ManagerGame;
import persistence.FileManager;
import view.PrincipalFrame;

public class Controller implements KeyListener, MouseListener, ActionListener {

	private ManagerGame managerGame;
	private PrincipalFrame principalFrame;
	private Timer timer;
	private Timer timerSave;
	private int time;

	public Controller() {
		managerGame = new ManagerGame();
		principalFrame = new PrincipalFrame();
		init();
	}

	private void init() {
		if (principalFrame.lastGame()) {
			time = FileManager.loadTime();
			managerGame.loadGame(FileManager.loadPlayer(), FileManager.loadEnemy(), FileManager.loadShoot());
		} else {
			managerGame.enemyList(6);
		}
		save();
	}

	private void save() {
		timerSave = new Timer(principalFrame.saveTime() * ConstantList.MIL_SEG, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				FileManager.saveGame(managerGame.getPlayer(), managerGame.getEnemyList(), time,
						managerGame.getShootList());
			}
		});
		timerSave.start();
		start();
	}

	private void start() {
		principalFrame.loadGame(this, managerGame.getPlayer(), managerGame.getEnemyList(), managerGame.getShootList());
		timer = new Timer(ConstantList.REFRESH_TIME, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				time += ConstantList.REFRESH_TIME;
				if (time % ConstantList.MIL_SEG == 0) {
					principalFrame.refreshTime(time / ConstantList.MIL_SEG);
				}
				principalFrame.repaintGame(managerGame.getPlayer().getLife());
				if (managerGame.isStop()) {
					if (managerGame.getEnemyList().isEmpty()) {
						principalFrame.playerWin();
					} else {
						principalFrame.gameOver();
					}
					timer.stop();
				}
			}
		});
		timer.start();
		managerGame.start();
	}

	private void movePlayer(KeyEvent e) {
		if (!managerGame.isPause()) {
			if (e.getKeyCode() == 32) {
				managerGame.newShoot(0, 0, principalFrame.getSize().width, principalFrame.getSize().height);
			} else {
				managerGame.movePlayer(e.getKeyCode());
				principalFrame.repaint();
			}
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		movePlayer(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		// managerGame.newShoot(m.getX(), m.getY(), principalFrame.getSize().width,
		// principalFrame.getSize().height);
		managerGame.shootEnemy(m.getX(), m.getY());
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (CommandList.valueOf(e.getActionCommand())) {
		case COMMAND_PLAY:
			managerGame.resume();
			principalFrame.changeCommand(CommandList.COMMAND_PAUSE);
			timer.start();
			break;
		case COMMAND_PAUSE:
			managerGame.pause();
			principalFrame.changeCommand(CommandList.COMMAND_PLAY);
			timer.stop();
			break;
		case COMMAND_EXIT:
			System.exit(0);
			break;
		}
	}
}