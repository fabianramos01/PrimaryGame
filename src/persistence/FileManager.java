package persistence;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import controller.ConstantList;
import model.Enemy;
import model.Player;
import model.Shoot;

public class FileManager {

	public static void saveGame(Player player, ArrayList<Enemy> enemys, int time, ArrayList<Shoot> shoots) {
		saveEnemy(enemys);
		savePlayer(player);
		saveShoots(shoots);
		saveTime(time);
	}
	
	public static void saveTime(int time) {
	    try {
			Files.write(Paths.get(ConstantList.TIME_FILE), String.valueOf(time).getBytes());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static int loadTime() {
		try {
			return Integer.parseInt(Files.readAllLines(Paths.get(ConstantList.TIME_FILE)).get(0));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	public static ArrayList<Enemy> loadEnemy() {
		File file = new File(ConstantList.ENEMY_FILE);
		ArrayList<Enemy> list = new ArrayList<>();
		SAXBuilder builder = new SAXBuilder();
		try {
			Document document = (Document) builder.build(file);
			Element rootNode = (Element) ((org.jdom2.Document) document).getRootElement();
			List<Element> enemyList = ((org.jdom2.Element) rootNode).getChildren(ConstantList.CHILDREN_ENEMY);
			for (Element element : enemyList) {
				int id = Integer.parseInt(element.getChildTextTrim(ConstantList.ID));
				int positionX = Integer.parseInt(element.getChildTextTrim(ConstantList.POSITION_X));
				int positionY = Integer.parseInt(element.getChildTextTrim(ConstantList.POSITION_Y));
				list.add(new Enemy(id, positionX, positionY));
			}
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		return list;
	}

	public static Player loadPlayer() {
		File file = new File(ConstantList.PLAYER_FILE);
		Player player = null;
		SAXBuilder builder = new SAXBuilder();
		try {
			Document document = (Document) builder.build(file);
			Element rootNode = (Element) ((org.jdom2.Document) document).getRootElement();
			List<Element> enemyList = ((org.jdom2.Element) rootNode).getChildren(ConstantList.CHILDREN_ENEMY);
			for (Element element : enemyList) {
				int id = Integer.parseInt(element.getChildTextTrim(ConstantList.ID));
				int positionX = Integer.parseInt(element.getChildTextTrim(ConstantList.POSITION_X));
				int positionY = Integer.parseInt(element.getChildTextTrim(ConstantList.POSITION_Y));
				int life = Integer.parseInt(element.getChildTextTrim(ConstantList.LIFE));
				player = new Player(id, positionX, positionY, life);
			}
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		return player;
	}

	public static ArrayList<Shoot> loadShoot() {
		File file = new File(ConstantList.SHOOT_FILE);
		ArrayList<Shoot> shoots = new ArrayList<>();
		SAXBuilder builder = new SAXBuilder();
		try {
			Document document = (Document) builder.build(file);
			Element rootNode = (Element) ((org.jdom2.Document) document).getRootElement();
			List<Element> enemyList = ((org.jdom2.Element) rootNode).getChildren(ConstantList.CHILDREN_SHOOT);
			for (Element element : enemyList) {
				int sleep = Integer.parseInt(element.getChildTextTrim(ConstantList.SLEEP_ELEMENT));
				int positionX = Integer.parseInt(element.getChildTextTrim(ConstantList.POSITION_X));
				int positionY = Integer.parseInt(element.getChildTextTrim(ConstantList.POSITION_Y));
				shoots.add(new Shoot(sleep, positionX, positionY));
			}
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
		return shoots;
	}

	public static void saveShoots(ArrayList<Shoot> list) {
		Element root = new Element(ConstantList.ROOT_ELEMENT);
		Document doc = new Document(root);
		Element shoot = new Element(ConstantList.CHILDREN_SHOOT);
		for (Shoot actualShoot : list) {
			Element sleep = new Element(ConstantList.ID).setText(String.valueOf(actualShoot.getSleep()));
			Element positionX = new Element(ConstantList.POSITION_X)
					.setText(String.valueOf(actualShoot.getPositionX()));
			Element positionY = new Element(ConstantList.POSITION_Y)
					.setText(String.valueOf(actualShoot.getPositionY()));
			shoot.addContent(sleep);
			shoot.addContent(positionX);
			shoot.addContent(positionY);
			doc.getRootElement().addContent(shoot);
			shoot = new Element(ConstantList.CHILDREN_SHOOT);
		}
		try {
			XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
			xmlOutputter.setFormat(Format.getCompactFormat());
			xmlOutputter.output(doc, new FileWriter(ConstantList.SHOOT_FILE));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void saveEnemy(ArrayList<Enemy> list) {
		Element root = new Element(ConstantList.ROOT_ELEMENT);
		Document doc = new Document(root);
		Element enemy = new Element(ConstantList.CHILDREN_ENEMY);
		for (Enemy actualEnemy : list) {
			Element id = new Element(ConstantList.ID).setText(String.valueOf(actualEnemy.getId()));
			Element positionX = new Element(ConstantList.POSITION_X)
					.setText(String.valueOf(actualEnemy.getPositionX()));
			Element positionY = new Element(ConstantList.POSITION_Y)
					.setText(String.valueOf(actualEnemy.getPositionY()));
			enemy.addContent(id);
			enemy.addContent(positionX);
			enemy.addContent(positionY);
			doc.getRootElement().addContent(enemy);
			enemy = new Element(ConstantList.CHILDREN_ENEMY);
		}
		try {
			XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
			xmlOutputter.setFormat(Format.getCompactFormat());
			xmlOutputter.output(doc, new FileWriter(ConstantList.ENEMY_FILE));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void savePlayer(Player player) {
		Element root = new Element(ConstantList.ROOT_ELEMENT);
		Document doc = new Document(root);
		Element playerElement = new Element(ConstantList.CHILDREN_ENEMY);
		Element id = new Element(ConstantList.ID).setText(String.valueOf(player.getPositionX()));
		Element positionX = new Element(ConstantList.POSITION_X).setText(String.valueOf(player.getPositionX()));
		Element positionY = new Element(ConstantList.POSITION_Y).setText(String.valueOf(player.getPositionY()));
		Element life = new Element(ConstantList.LIFE).setText(String.valueOf(player.getLife()));
		playerElement.addContent(id);
		playerElement.addContent(positionX);
		playerElement.addContent(positionY);
		playerElement.addContent(life);
		doc.getRootElement().addContent(playerElement);
		try {
			XMLOutputter xmlOutputter = new XMLOutputter(Format.getPrettyFormat());
			xmlOutputter.setFormat(Format.getCompactFormat());
			xmlOutputter.output(doc, new FileWriter(ConstantList.PLAYER_FILE));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
