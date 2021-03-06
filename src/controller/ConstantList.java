package controller;

import java.awt.Font;

public class ConstantList {

	public static final String TITLE = "FirstGame";
	public static final String ICON_GAME = "/data/iconGame.png";
	public static final Font AGENCY_FB = new Font("Agency FB", Font.BOLD, 30);
	
	public static final double WIDTH = 1700;
	public static final double HEIGHT = 900;
	
	public static final int PLAYER_SIZE_IMG = 200;
	public static final int ENEMY_SIZE_IMG = 80;
	public static final int ENEMY_M_SIZE_IMG = 350;
	public static final int ATTACK_SIZE_IMG = 50;
	public static final int PLAYER_SIZE = 130;
//	public static final int ENEMY_SIZE = 60;
//	public static final int ENEMY_M_SIZE = 280;
	public static final int ATTACK_SIZE = 35;
	public static final int MOVE_UNITS = 10;
	public static final int SLEEP = 10;
	public static final int SLEEP_SHOOT = 5;
	
	public static final String PLAYER_IMG = "/data/player.png";
	public static final String ENEMY_IMG = "/data/primary_enemy.png";
	public static final String MASTER_ENEMY_IMG = "/data/enemy.png";
	public static final String ATTACK_IMG = "/data/attack.png";
	public static final String GAME_OVER_IMG = "/data/gameOver.jpg";
	public static final String CURSOR_IMG = "/data/cursor.png";
	public static final String YOU_WIN_IMG = "/data/youWin.jpg";
	public static final int MOVE_ENEMY = 1;
	public static final int REFRESH_TIME = 10;
	public static final String TIME_UNIT = " seg";
	protected static final int MIL_SEG = 1000;
	public static final int ATTACK_MOVE = 5;
	
	public static final String PLAYER_FILE = "lastGame/playerFile.xml";
	public static final String SHOOT_FILE = "lastGame/shootFile.xml";
	public static final String ENEMY_FILE = "lastGame/enemyFile.xml";
	public static final String TIME_FILE = "lastGame/timeFile.my";
	public static final String CHILDREN_ENEMY = "Enemy";
	public static final String CHILDREN_PLAYER = "Player";
	public static final String CHILDREN_SHOOT = "Shoot";
	public static final String ROOT_ELEMENT = "Game";
	public static final String ID = "Id";
	public static final String SLEEP_ELEMENT = "Sleep";
	public static final String POSITION_X = "PositionX";
	public static final String POSITION_Y = "PositionY";
	public static final String ENEMY_TYPE = "Type";
	public static final String LIFE = "Life";

	public static final String SAVE_TIME = "Tiempo de autoguardado (seg)";
	public static final Object LOAD_GAME = "Cargar �ltima partida";
	public static final int LIFE_LIM = 100;
	public static final int LIFE_LESS_PLAYER = 2;
	public static final int LIFE_LESS_ENEMY = 1;
	public static final int LIFE_LESS_M_PLAYER = 10;	
	public static final int HEIGHT_REC = 70;
	public static final int WIDTH_REC = 150;
}