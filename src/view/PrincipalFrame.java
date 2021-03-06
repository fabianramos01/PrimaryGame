package view;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import controller.CommandList;
import controller.ConstantList;
import controller.Controller;
import model.Enemy;
import model.Player;
import model.Shoot;

public class PrincipalFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelGame panelGame;
	private ToolBarAction toBarAction;
	private JLabel labelTime;

	public PrincipalFrame() {
		setTitle(ConstantList.TITLE);
		setLayout(new BorderLayout());
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public void loadGame(Controller listener, Player player, ArrayList<Enemy> enemyList, ArrayList<Shoot> shootList) {
		setIconImage(new ImageIcon(getClass().getResource(ConstantList.ICON_GAME)).getImage());
		panelGame = new PanelGame(listener, player, enemyList, shootList);
		add(panelGame, BorderLayout.CENTER);
		labelTime = new JLabel("0" + ConstantList.TIME_UNIT);
		labelTime.setHorizontalAlignment(JLabel.CENTER);
		labelTime.setFont(ConstantList.AGENCY_FB);
		add(labelTime, BorderLayout.SOUTH);
		toBarAction = new ToolBarAction(listener, player.getLife());
		add(toBarAction, BorderLayout.NORTH);
		setVisible(true);
	}

	public void refreshTime(int time) {
		labelTime.setText(time + ConstantList.TIME_UNIT);
		revalidate();
	}

	public void repaintGame(int life) {
		panelGame.repaint();
		toBarAction.refreshLife(life);
		revalidate();
	}

	public void changeCommand(CommandList command) {
		toBarAction.setCommand(command);
		revalidate();
	}

	public void gameOver() {
		remove(panelGame);
		JLabel labelGameOver = new JLabel(new ImageIcon(getClass().getResource(ConstantList.GAME_OVER_IMG)));
		add(labelGameOver, BorderLayout.CENTER);
		revalidate();
	}
	
	public void playerWin() {
		remove(panelGame);
		JLabel labelGameOver = new JLabel(new ImageIcon(getClass().getResource(ConstantList.YOU_WIN_IMG)));
		add(labelGameOver, BorderLayout.CENTER);
		revalidate();
	}

	public boolean lastGame() {
		return JOptionPane.showConfirmDialog(null, ConstantList.LOAD_GAME, ConstantList.TITLE,
				JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION ? true : false;
	}

	public int saveTime() {
		return Integer.parseInt(JOptionPane.showInputDialog(ConstantList.SAVE_TIME));
	}
}