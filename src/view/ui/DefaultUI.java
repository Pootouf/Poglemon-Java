package view.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.PoglemonApp;
import model.Model;

public abstract class DefaultUI {
	
	//CONSTANTES DE CLASSE
	
	public static final Color DARK_GRAY_BUTTON = new Color(100, 100, 100);
	
	public static final Color LIGHT_GRAY_BUTTON = new Color(210, 210, 210);
	
	//ATTRIBUTS
	private int commandNum = 0;
	private int numberOfOption;
	private Font font;
	
	
	//CONSTRUCTEURS
	public DefaultUI(int numberOfOption, Font font) {
		this.numberOfOption = numberOfOption;
		this.font = font;
	}
	
	//REQUETES
	public Font getFont() {
		return font;
	}
	
	public int getCommandNum() {
		return commandNum;
	}
	
	//COMMANDES
	
	public void increaseCommandNum(int x) {
		commandNum += x;
		commandNum = commandNum % numberOfOption;
		if(commandNum < 0) {
			commandNum = numberOfOption - 1;
		}
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
	}
}
