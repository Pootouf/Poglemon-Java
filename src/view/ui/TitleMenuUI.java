package view.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.PoglemonApp;
import model.Model;

public class TitleMenuUI extends DefaultUI {

	public TitleMenuUI(int numberOfOption, Font font) {
		super(numberOfOption, font);
	}

	@Override
	protected void refresh(Model m) {
		return;
	}

	@Override
	protected void drawState(Graphics2D g) {
		Font font = getFont();
		int commandNum = getCommandNum();
		
		//BACKGROUND
		g.setColor(Color.GRAY);
		g.fillRect(0, 0, PoglemonApp.SCREEN_WIDTH, PoglemonApp.SCREEN_HEIGHT);
		
		
		//TITLE NAME
		g.setFont(font.deriveFont(Font.BOLD, (float)PoglemonApp.SPRITE_SIZEX * 2));
		String title = "Poglemon";
		int x = getCenterXForText(title, g);
		int y = PoglemonApp.SPRITE_SIZEY * (PoglemonApp.SCREEN_TILEY / 4);
		//SHADOW
		g.setColor(Color.black);
		g.drawString(title, x + 7, y + 7);
		//TEXT
		g.setColor(Color.white);
		g.drawString(title, x, y);
		
		
		//MENU
		g.setFont(font.deriveFont(Font.BOLD, (float)PoglemonApp.SPRITE_SIZEX));
		g.setStroke(new BasicStroke(PoglemonApp.SPRITE_SIZEX / 8));
		
		String text = "Nouvelle Partie";
		x = getCenterXForText(text, g);
		y += PoglemonApp.SPRITE_SIZEY * (PoglemonApp.SCREEN_TILEY / 4);
		createButton(g, x, y, commandNum == 0, text, 0.5);
		
		text = "Charger une partie";
		x = getCenterXForText(text, g);
		y += PoglemonApp.SPRITE_SIZEY * (PoglemonApp.SCREEN_TILEY / 8);
		createButton(g, x, y, commandNum == 1, text, 0.5);
		
		text = "Options";
		x = getCenterXForText(text, g);
		y += PoglemonApp.SPRITE_SIZEY * (PoglemonApp.SCREEN_TILEY / 8);
		createButton(g, x, y, commandNum == 2, text, 0.5);
		
		text = "Quitter";
		x = getCenterXForText(text, g);
		y += PoglemonApp.SPRITE_SIZEY * (PoglemonApp.SCREEN_TILEY / 8);
		createButton(g, x, y, commandNum == 3, text, 0.5);
		
	}
	
	

}
