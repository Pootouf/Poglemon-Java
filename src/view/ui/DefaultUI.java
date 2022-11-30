package view.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.List;
import java.util.ArrayList;

import main.PoglemonApp;
import model.Model;

public abstract class DefaultUI {
	
	//CONSTANTES DE CLASSE
	
	public final static String SPRITE_LOC = "/sprite/UI/";
	
	public static final Color DARK_GRAY_BUTTON = new Color(100, 100, 100);
	
	public static final Color LIGHT_GRAY_BUTTON = new Color(210, 210, 210);
	
	
	//ATTRIBUTS
	private int commandNum = -1;
	private int numberOfOption;
	private Font font;
	
	private List<List<Integer>> buttonPlacement;
	
	
	//CONSTRUCTEURS
	public DefaultUI(int numberOfOption, Font font) {
		this.numberOfOption = numberOfOption;
		this.font = font;
		buttonPlacement = new ArrayList<List<Integer>>();
		for(int i = 0; i < 4; i++) {
			buttonPlacement.add(new ArrayList<Integer>());
		}
	}
	
	//REQUETES
	public Font getFont() {
		return font;
	}
	
	public int getCommandNum() {
		return commandNum;
	}
	
	public int getNumberOfOption() {
		return numberOfOption;
	}
	
	public boolean isButton(int x, int y, int i) {
		List<Integer> buttonX = buttonPlacement.get(0);
		List<Integer> buttonY = buttonPlacement.get(1);
		List<Integer> sizeX = buttonPlacement.get(2);
		List<Integer> sizeY = buttonPlacement.get(3);
		int bx = buttonX.get(i);
		int by = buttonY.get(i);
		int sx = sizeX.get(i);
		int sy = sizeY.get(i);
		return bx <= x && x <= bx + sx && by <= y && y <= by+sy;
	}
	
	//COMMANDES
	
	public void increaseCommandNum(int x) {
		commandNum += x;
		commandNum = commandNum % numberOfOption;
		if(commandNum < 0) {
			commandNum = numberOfOption - 1;
		}
	}
	
	public void setCommandNum(int x) {
		commandNum = x;
	}
	
	protected abstract void refresh(Model m);
	
	protected abstract void drawState(Graphics2D g);
	
	
	//OUTILS
	
	protected int getCenterXForText(String text, Graphics2D g) {
		int length = (int)g.getFontMetrics().getStringBounds(text, g).getWidth();
		return PoglemonApp.SCREEN_WIDTH/2 - length/2;
	}
	
	protected int getCenterXForTextBox(String text, Graphics2D g, int width, int boxX) {
		int length = (int)g.getFontMetrics().getStringBounds(text, g).getWidth();
		return boxX + width/2 - length/2;
	}
	
	protected int getLength(String text, Graphics2D g) {
		return (int)g.getFontMetrics().getStringBounds(text, g).getWidth();
	}
	
	protected int getHeight(String text, Graphics2D g) {
		return (int)g.getFontMetrics().getStringBounds(text, g).getHeight();
	}
	
	protected void createButton(Graphics2D g, int x, int y, boolean isSelect, String text, double size) {
		g.setColor(DARK_GRAY_BUTTON);
		if(isSelect == true) {
			g.setColor(LIGHT_GRAY_BUTTON);
		}
		g.fillRoundRect(x - PoglemonApp.SPRITE_SIZEX / 2, (int)(y - PoglemonApp.SPRITE_SIZEY*size/2 - getHeight(text, g) * 0.85), getLength(text, g) + PoglemonApp.SPRITE_SIZEX, getHeight(text, g) + (int)(PoglemonApp.SPRITE_SIZEY*size), 10, 10);
		g.setColor(Color.black);
		g.drawRoundRect(x - PoglemonApp.SPRITE_SIZEX / 2, (int)(y - PoglemonApp.SPRITE_SIZEY*size/2 - getHeight(text, g) * 0.85), getLength(text, g) + PoglemonApp.SPRITE_SIZEX, getHeight(text, g) + (int)(PoglemonApp.SPRITE_SIZEY*size), 10, 10);
		g.drawString(text, x, y);
		
		buttonPlacement.get(0).add(x - PoglemonApp.SPRITE_SIZEX / 2);
		buttonPlacement.get(1).add((int)(y - PoglemonApp.SPRITE_SIZEY*size/2 - getHeight(text, g) * 0.85));
		buttonPlacement.get(2).add(getLength(text, g) + PoglemonApp.SPRITE_SIZEX);
		buttonPlacement.get(3).add(getHeight(text, g) + (int)(PoglemonApp.SPRITE_SIZEY*size));
	}
	
	protected void addListButton(int x, int y, int sx, int sy) {
		buttonPlacement.get(0).add(x);
		buttonPlacement.get(1).add(y);
		buttonPlacement.get(2).add(sx);
		buttonPlacement.get(3).add(sy);
	}
}
