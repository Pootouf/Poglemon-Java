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
		int boxx = PoglemonApp.SCREEN_WIDTH - getResizeX(9);
		int boxy = PoglemonApp.SPRITE_SIZEY;
		int width = getResizeX(8);
		int height = getResizeY(10f);
		g.fillRoundRect(boxx, boxy, width, height, 10, 10);
		
		//Affichage des textes
		g.setColor(Color.black);
		g.setFont(font.deriveFont(Font.BOLD, (PoglemonApp.SCREEN_TILEX < PoglemonApp.SCREEN_TILEY ? getResizeX(1.5f) : getResizeY(1.5f))));
		g.setStroke(new BasicStroke(PoglemonApp.SPRITE_SIZEX / 8));
		
	    String text = "Menu";
		int y = boxy + getResizeY(1.7f);
		int x = getCenterXForTextBox(text, g, width, boxx);
		g.drawString(text, x, y);
		
		g.setFont(font.deriveFont(Font.BOLD, (PoglemonApp.SCREEN_TILEX < PoglemonApp.SCREEN_TILEY ? getResizeX(0.8f) : getResizeY(0.8f))));
		
		text = "Equipe";
		y += getResizeY(1.3f);
		x = getCenterXForTextBox(text, g, width, boxx);
		createButton(g, x, y, commandGameMenuNum == 0, text, 0.2);
		
		text = "PC";
		y += getResizeY(1.3f);
		x = getCenterXForTextBox(text, g, width, boxx);
		createButton(g, x, y, commandGameMenuNum == 1, text, 0.2);
		
		text = "Sauvegarder";
		y += getResizeY(1.3f);
		x = getCenterXForTextBox(text, g, width, boxx);
		createButton(g, x, y, commandGameMenuNum == 2, text, 0.2);
		
		text = "Options";
		y += getResizeY(1.3f);
		x = getCenterXForTextBox(text, g, width, boxx);
		createButton(g, x, y, commandGameMenuNum == 3, text, 0.2);
		
		text = "Revenir";
		y += getResizeY(1.3f);
		x = getCenterXForTextBox(text, g, width, boxx);
		createButton(g, x, y, commandGameMenuNum == 4, text, 0.2);
		
		text = "Quitter";
		y += getResizeY(1.3f);
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
