package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Timer;

import model.ManagerGame;
import view.PrincipalFrame;

public class Controller implements KeyListener, MouseListener, ActionListener {

	private ManagerGame managerGame;
	private PrincipalFrame principalFrame;
	private Timer timer;
	private int time;

	public Controller() {
		managerGame = new ManagerGame();
		managerGame.enemyList(2);
		principalFrame = new PrincipalFrame(this, managerGame.getPlayer(), managerGame.getEnemyList(),
				managerGame.getShootList());
		start();
	}

	private void start() {
		timer = new Timer(ConstantList.REFRESH_TIME, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				time += ConstantList.REFRESH_TIME;
				if (time % ConstantList.MIL_SEG == 0) {
					principalFrame.refreshTime(time / ConstantList.MIL_SEG);
				}
				principalFrame.loadGame();
				if (managerGame.isStop()) {
					principalFrame.gameOver();
					timer.stop();
				}
			}
		});
		timer.start();
		managerGame.start();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		managerGame.movePlayer(e.getKeyCode());
		principalFrame.repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == 32) {
			managerGame.newShoot(0, 0, principalFrame.getSize().width, principalFrame.getSize().height);
		} else {
			managerGame.movePlayer(e.getKeyCode());
			principalFrame.repaint();
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent m) {
		managerGame.newShoot(m.getX(), m.getY(), principalFrame.getSize().width, principalFrame.getSize().height);
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
			break;
		}
	}
}