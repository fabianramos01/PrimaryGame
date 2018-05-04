package view;

import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import controller.ConstantList;
import model.Enemy;
import model.Player;

public class PrincipalFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelGame panelGame;
	
	public PrincipalFrame(KeyListener listener, Player player, Enemy enemy) {
		setTitle(ConstantList.TITLE);
		setIconImage(new ImageIcon(getClass().getResource(ConstantList.ICON_GAME)).getImage());
		panelGame = new PanelGame(listener, player, enemy);
		add(panelGame);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void loadPanel() {
		panelGame.repaint();
	}
}
