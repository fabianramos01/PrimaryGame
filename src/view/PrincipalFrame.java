package view;

import java.awt.BorderLayout;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.ConstantList;
import model.Enemy;
import model.Player;

public class PrincipalFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelGame panelGame;
	private JLabel labelTime;
	
	public PrincipalFrame(KeyListener listener, Player player, Enemy enemy) {
		setTitle(ConstantList.TITLE);
		setLayout(new BorderLayout());
		setIconImage(new ImageIcon(getClass().getResource(ConstantList.ICON_GAME)).getImage());
		panelGame = new PanelGame(listener, player, enemy);
		add(panelGame, BorderLayout.CENTER);
		labelTime = new JLabel("0" + ConstantList.TIME_UNIT);
		labelTime.setHorizontalAlignment(JLabel.CENTER);
		add(labelTime, BorderLayout.SOUTH);
		setLocationRelativeTo(null);
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public void refreshTime(int time) {
		labelTime.setText(time + ConstantList.TIME_UNIT);
		revalidate();
	}
	
	public void gameOver() {
		JDialog jDialog = new JDialog();
		ImageIcon imageIcon = new ImageIcon(getClass().getResource(ConstantList.GAME_OVER_IMG));
		jDialog.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight());
		jDialog.add(new JLabel(imageIcon));
		jDialog.setVisible(true);
	}
}
