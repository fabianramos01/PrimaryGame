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
		setIconImage(new ImageIcon(getClass().getResource(ConstantList.ICON_GAME)));
		panelGame = new PanelGame(listener, player, enemy);
		setLocationRelativeTo(null);
		setVisible(true);
	}

}
