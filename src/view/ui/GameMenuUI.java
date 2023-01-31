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
		int boxx = PoglemonApp.SCREEN_WIDTH - getResizeX(350);
		int boxy = PoglemonApp.SPRITE_SIZEY;
		int width = getResizeX(300);
		int height = getResizeY(500);
		g.fillRoundRect(boxx, boxy, width, height, 10, 10);
		
		//Affichage des textes
		g.setColor(Color.black);
		g.setFont(font.deriveFont(Font.BOLD, getFontSize(50)));
		g.setStroke(new BasicStroke(getResizeX(3)));
		
	    String text = "Menu";
		int y = boxy + getResizeY(60);
		int x = getCenterXForTextBox(text, g, width, boxx);
		g.drawString(text, x, y);
		
		g.setFont(font.deriveFont(Font.BOLD, getFontSize(30)));
		
		text = "Equipe";
		y += getResizeY(90);
		x = getCenterXForTextBox(text, g, width, boxx);
		createButton(g, x, y, commandGameMenuNum == 0, text, 0.2);
		
		text = "PC";
		y += getResizeY(60);
		x = getCenterXForTextBox(text, g, width, boxx);
		createButton(g, x, y, commandGameMenuNum == 1, text, 0.2);
		
		text = "Sauvegarder";
		y += getResizeY(60);
		x = getCenterXForTextBox(text, g, width, boxx);
		createButton(g, x, y, commandGameMenuNum == 2, text, 0.2);
		
		text = "Options";
		y += getResizeY(60);
		x = getCenterXForTextBox(text, g, width, boxx);
		createButton(g, x, y, commandGameMenuNum == 3, text, 0.2);
		
		text = "Revenir";
		y += getResizeY(60);
		x = getCenterXForTextBox(text, g, width, boxx);
		createButton(g, x, y, commandGameMenuNum == 4, text, 0.2);
		
		text = "Quitter";
		y += getResizeY(60);
		x = getCenterXForTextBox(text, g, width, boxx);
		createButton(g, x, y, commandGameMenuNum == 5, text, 0.2);
		
		
		//Affichage de la bordure
		g.setStroke(new BasicStroke(getResizeX(4)));
		g.drawRoundRect(boxx, boxy, width, height, 10, 10);
	}

	@Override
	protected void refresh(Model m) {
		return;
	}
	
}
