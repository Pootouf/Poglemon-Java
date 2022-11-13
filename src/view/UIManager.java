package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import main.PoglemonApp;
import model.Model;

public class UIManager {
	
	//ATTRIBUTS
	
	private Font font;
	private int tilex;
	private int tiley;
	private boolean isInfoOpen = false;
	private int commandNum = 0;
	
	
	//CONSTRUCTEURS
	
	public UIManager() {
		InputStream is = null;
		try {
			is = new FileInputStream("res/font/Minecraft.ttf");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		font = font.deriveFont((float) PoglemonApp.SPRITE_SIZEX / 2);
	}
	
	
	//REQUETES
	
	public boolean getInfoOpen() {
		return isInfoOpen;
	}
	
	public int getCommandNum() {
		return commandNum;
	}
	
	
	
	//COMMANDES
	
	public void refresh(Model m) {
		if(isInfoOpen) {
			tilex = m.getPlayer().getTileX();
			tiley = m.getPlayer().getTileY(); 
		}
	}
	
	public void setInfoOpen(boolean b) {
		isInfoOpen = b;
	}
	
	public void increaseCommandNum(int x) {
		commandNum += x;
		commandNum = commandNum % 4;
		if(commandNum < 0) {
			commandNum = 3;
		}
	}
	
	
	
	protected void draw(Graphics2D g) {
		//PLAYSTATE
		if(PoglemonApp.gameState == PoglemonApp.PLAY_STATE) {
			drawPlayState(g);
		}
		//MENUSTATE
		if(PoglemonApp.gameState == PoglemonApp.MENU_STATE) {
			drawTitleState(g);
		}
		//PAUSESTATE
		if(PoglemonApp.gameState == PoglemonApp.PAUSE_STATE) {
			drawPauseState(g);
		}
				
	}
	
	//OUTILS
	
	private void drawPlayState(Graphics2D g) {
		g.setFont(font);
		g.setColor(Color.black);
		
		//INFO MENU
		if(isInfoOpen) {
			g.drawString("fps: " + PoglemonApp.fps(), PoglemonApp.SPRITE_SIZEX / 2, PoglemonApp.SPRITE_SIZEY / 2);
			g.drawString("X: " + tilex, PoglemonApp.SPRITE_SIZEX / 2, PoglemonApp.SPRITE_SIZEY);
			g.drawString("Y: " + tiley, PoglemonApp.SPRITE_SIZEX / 2, (int) (PoglemonApp.SPRITE_SIZEY * 1.5));
		}
	}
	
	
	
	
	private void drawTitleState(Graphics2D g) {
		
		//BACKGROUND
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, PoglemonApp.SCREEN_WIDTH, PoglemonApp.SCREEN_HEIGHT);
		
		
		//TITLE NAME
		g.setFont(font.deriveFont(Font.BOLD, (float)PoglemonApp.SPRITE_SIZEX * 2));
		String title = "Poglemon";
		int x = getCenterXForText(title, g);
		int y = PoglemonApp.SPRITE_SIZEY * 4;
		//SHADOW
		g.setColor(Color.black);
		g.drawString(title, x + 7, y + 7);
		//TEXT
		g.setColor(Color.white);
		g.drawString(title, x, y);
		
		
		//MENU
		g.setFont(font.deriveFont(Font.BOLD, (float)PoglemonApp.SPRITE_SIZEX));
		g.setColor(Color.black);
		
		String text = "Nouvelle Partie";
		x = getCenterXForText(text, g);
		y += PoglemonApp.SPRITE_SIZEY * 5;
		g.drawString(text, x, y);
		if(commandNum == 0) {
			g.drawString(">", x - PoglemonApp.SPRITE_SIZEX, y);
		}
		
		text = "Charger une partie";
		x = getCenterXForText(text, g);
		y += PoglemonApp.SPRITE_SIZEY * 1.5;
		g.drawString(text, x, y);
		if(commandNum == 1) {
			g.drawString(">", x - PoglemonApp.SPRITE_SIZEX, y);
		}
		
		text = "Options";
		x = getCenterXForText(text, g);
		y += PoglemonApp.SPRITE_SIZEY * 1.5;
		g.drawString(text, x, y);
		if(commandNum == 2) {
			g.drawString(">", x - PoglemonApp.SPRITE_SIZEX, y);
		}
		
		text = "Quitter";
		x = getCenterXForText(text, g);
		y += PoglemonApp.SPRITE_SIZEY * 1.5;
		g.drawString(text, x, y);
		if(commandNum == 3) {
			g.drawString(">", x - PoglemonApp.SPRITE_SIZEX, y);
		}
		
	}
	
	
	
	
	private void drawPauseState(Graphics2D g) {
		g.setFont(font.deriveFont(Font.BOLD, (float)PoglemonApp.SPRITE_SIZEX * 3));
		g.setColor(Color.black);
		String text = "Jeu en pause";
		int x = getCenterXForText(text, g);
		int y = PoglemonApp.SCREEN_HEIGHT / 2;
		g.drawString(text, x, y);
	}
	
	
	
	
	
	private int getCenterXForText(String text, Graphics2D g) {
		int length = (int)g.getFontMetrics().getStringBounds(text, g).getWidth();
		return PoglemonApp.SCREEN_WIDTH/2 - length/2;
	}
}
