package controller;

import javax.swing.ImageIcon;

public enum CommandList {

	COMMAND_PLAY("COMMAND_PLAY", "Iniciar", "/data/play.png"),
	COMMAND_PAUSE("COMMAND_PAUSE", "Pausar", "/data/pause.png"),
	COMMAND_EXIT("COMMAND_EXIT", "Salir", "/data/exit.png");

	private String commad;
	private String title;
	private String imagePath;
	
	private CommandList(String commad, String title, String imagePath) {
		this.commad = commad;
		this.title = title;
		this.imagePath = imagePath;
	}
	
	public String getCommad() {
		return commad;
	}
	
	public String getTitle() {
		return title;
	}
	
	public ImageIcon getImagePath() {
		return new ImageIcon(getClass().getResource(imagePath));
	}
}