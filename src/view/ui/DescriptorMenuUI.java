package view.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.PoglemonApp;
import model.Model;

public class DescriptorMenuUI extends DefaultUI {

	public DescriptorMenuUI(int numberOfOption, Font font) {
		super(numberOfOption, font);
	}

	@Override
	protected void refresh(Model m) {

	}

	@Override
	protected void drawState(Graphics2D g) {
		int commandNum = getCommandNum();
		Font font = getFont();
		
		g.setColor(Color.LIGHT_GRAY);
		
		//Affichage de la boite
		int boxx = getResizeX(PoglemonApp.SPRITE_SIZEX);
		int boxy = getResizeY(PoglemonApp.SPRITE_SIZEY);
		int width = PoglemonApp.SCREEN_WIDTH - getResizeX(PoglemonApp.SPRITE_SIZEX * 2);
		int height = PoglemonApp.SCREEN_HEIGHT - getResizeY(PoglemonApp.SPRITE_SIZEY * 2);
		g.fillRoundRect(boxx, boxy, width, height, 10, 10);
		
		
		g.setStroke(new BasicStroke(getResizeX(3)));
		g.setFont(font.deriveFont(Font.BOLD, getFontSize(70)));
		//Affichage du bouton revenir
		String text = "Revenir";
		int textX = getCenterXForTextBox(text, g, width, boxx);
		int textY = boxy + height - getResizeY(100);
		createButton(g, textX, textY, commandNum == 0, text, 0.2);
		
		
		//Affichage de la bordure
		g.setStroke(new BasicStroke(getResizeX(4)));
		g.drawRoundRect(boxx, boxy, width, height, 10, 10);

	}

}
