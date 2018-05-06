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
		add(buttonPlay);
		add(UtilityList.createJButton(CommandList.COMMAND_EXIT.getCommad(), CommandList.COMMAND_EXIT.getTitle(),
				CommandList.COMMAND_EXIT.getImagePath(), listener));
		panelLife = new PanelLife(life);
		add(panelLife);
	}
	
	public void refreshLife() {
		panelLife.repaint();
	}

	public void setCommand(CommandList commandList) {
		buttonPlay.setActionCommand(commandList.getCommad());
		buttonPlay.setToolTipText(commandList.getTitle());
		buttonPlay.setIcon(commandList.getImagePath());
	}

}
