package view.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.PoglemonApp;
import model.Model;

public class GameMenuUI extends DefaultUI{

	
	
	public GameMenuUI(int numberOfOption, Font font) {
		super(numberOfOption, font);
	}
	
	@Override
	protected void drawState(Graphics2D g) {
		Font font = getFont();
		int commandGameMenuNum = getCommandNum();
		
		//Affichage de la boite
		g.setColor(Color.LIGHT_GRAY);
		int boxx = PoglemonApp.SCREEN_WIDTH - PoglemonApp.SPRITE_SIZEX * 8;
		int boxy = PoglemonApp.SPRITE_SIZEY;
		int width = PoglemonApp.SPRITE_SIZEX * 7;
		int height = PoglemonApp.SCREEN_HEIGHT - PoglemonApp.SPRITE_SIZEY * 5;
		g.fillRoundRect(boxx, boxy, width, height, 10, 10);
		
		//Affichage des textes
		g.setColor(Color.black);
		g.setFont(font.deriveFont(Font.BOLD, (float)(PoglemonApp.SPRITE_SIZEX*1.5)));
		g.setStroke(new BasicStroke(PoglemonApp.SPRITE_SIZEX / 8));
		
	    String text = "Menu";
		int y = boxy + (int)(PoglemonApp.SPRITE_SIZEY*1.5);
		int x = getCenterXForTextBox(text, g, width, boxx);
		g.drawString(text, x, y);
		
		g.setFont(font.deriveFont(Font.BOLD, (float)(PoglemonApp.SPRITE_SIZEX/1.3)));
		
		text = "Equipe";
		y += (int)(PoglemonApp.SPRITE_SIZEY*1.5);
		x = getCenterXForTextBox(text, g, width, boxx);
		createButton(g, x, y, commandGameMenuNum == 0, text, 0.2);
		
		text = "PC";
		y += (int)(PoglemonApp.SPRITE_SIZEY*1.5);
		x = getCenterXForTextBox(text, g, width, boxx);
		createButton(g, x, y, commandGameMenuNum == 1, text, 0.2);
		
		text = "Sauvegarder";
		y += (int)(PoglemonApp.SPRITE_SIZEY*1.5);
		x = getCenterXForTextBox(text, g, width, boxx);
		createButton(g, x, y, commandGameMenuNum == 2, text, 0.2);
		
		text = "Options";
		y += (int)(PoglemonApp.SPRITE_SIZEY*1.5);
		x = getCenterXForTextBox(text, g, width, boxx);
		createButton(g, x, y, commandGameMenuNum == 3, text, 0.2);
		
		text = "Revenir";
		y += (int)(PoglemonApp.SPRITE_SIZEY*1.5);
		x = getCenterXForTextBox(text, g, width, boxx);
		createButton(g, x, y, commandGameMenuNum == 4, text, 0.2);
		
		text = "Quitter";
		y += (int)(PoglemonApp.SPRITE_SIZEY*1.5);
		x = getCenterXForTextBox(text, g, width, boxx);
		createButton(g, x, y, commandGameMenuNum == 5, text, 0.2);
		
		
		//Affichage de la bordure
		g.setStroke(new BasicStroke(PoglemonApp.SPRITE_SIZEX / 16));
		g.drawRoundRect(boxx, boxy, width, height, 10, 10);
	}

	@Override
	protected void refresh(Model m) {
		return;
	}
	
}
