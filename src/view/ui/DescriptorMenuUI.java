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
		g.setStroke(new BasicStroke(PoglemonApp.SPRITE_SIZEX / 16));
		
		//Affichage de la boite
		int boxx = PoglemonApp.SPRITE_SIZEX;
		int boxy = PoglemonApp.SPRITE_SIZEY;
		int width = PoglemonApp.SCREEN_WIDTH - PoglemonApp.SPRITE_SIZEX * 2;
		int height = PoglemonApp.SCREEN_HEIGHT - PoglemonApp.SPRITE_SIZEY * 2;
		g.fillRoundRect(boxx, boxy, width, height, 10, 10);
		
		
		
		g.setFont(font.deriveFont(Font.BOLD, (PoglemonApp.SCREEN_TILEX < PoglemonApp.SCREEN_TILEY ? getResizeX(1) : getResizeY(1))));
		//Affichage du bouton revenir
		String text = "Revenir";
		int textX = getCenterXForTextBox(text, g, width, boxx);
		int textY = boxy + height - getResizeY(1);
		createButton(g, textX, textY, commandNum == 0, text, 0.2);
		
		
		//Affichage de la bordure
		g.drawRoundRect(boxx, boxy, width, height, 10, 10);

	}

}
