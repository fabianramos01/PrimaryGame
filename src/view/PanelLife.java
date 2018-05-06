package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import controller.ConstantList;

public class PanelLife extends JPanel {

	private static final long serialVersionUID = 1L;
	private int life;

	public PanelLife(int life) {
		this.life = life;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.RED);
		g.fillRect(0, 0, ConstantList.WIDTH_REC * life / ConstantList.LIFE_LIM, ConstantList.HEIGHT_REC);
		g.setColor(Color.BLACK);
		g.drawRect(0, 0, ConstantList.WIDTH_REC, ConstantList.HEIGHT_REC);
		g.setFont(ConstantList.AGENCY_FB);
		g.drawString(life + " %", 60, 50);
	}
}