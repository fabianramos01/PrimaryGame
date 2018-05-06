package view;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JToolBar;

import controller.CommandList;

public class ToolBarAction extends JToolBar {

	private static final long serialVersionUID = 1L;
	private JButton buttonPlay;
	private PanelLife panelLife;

	public ToolBarAction(ActionListener listener, int life) {
		setOpaque(false);
		buttonPlay = UtilityList.createJButton(CommandList.COMMAND_PAUSE.getCommad(),
				CommandList.COMMAND_PAUSE.getTitle(), CommandList.COMMAND_PAUSE.getImagePath(), listener);
		buttonPlay.setFocusable(false);
		add(buttonPlay);
		JButton buttonExit = UtilityList.createJButton(CommandList.COMMAND_EXIT.getCommad(),
				CommandList.COMMAND_EXIT.getTitle(), CommandList.COMMAND_EXIT.getImagePath(), listener);
		buttonExit.setFocusable(false);
		add(buttonExit);
		panelLife = new PanelLife(life);
		add(panelLife);
	}

	public void refreshLife(int life) {
		panelLife.setLife(life);
		panelLife.repaint();
		revalidate();
	}

	public void setCommand(CommandList commandList) {
		buttonPlay.setActionCommand(commandList.getCommad());
		buttonPlay.setToolTipText(commandList.getTitle());
		buttonPlay.setIcon(commandList.getImagePath());
	}

}
