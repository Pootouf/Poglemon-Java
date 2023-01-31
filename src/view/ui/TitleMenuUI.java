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
		int baseFontSize = (PoglemonApp.SCREEN_TILEX < PoglemonApp.SCREEN_TILEY ? getResizeX(300f) : getResizeY(300f));
		
		
		//TITLE NAME
		g.setFont(font.deriveFont(Font.BOLD, baseFontSize));
		String title = "Poglemon";
		int x = getCenterXForText(title, g);
		int y = getResizeY(325f);
		//SHADOW
		g.setColor(Color.black);
		g.drawString(title, x + getResizeX(7f), y + getResizeY(7f));
		//TEXT
		g.setColor(Color.white);
		g.drawString(title, x, y);
		
		
		//MENU
		g.setFont(font.deriveFont(Font.BOLD, baseFontSize/6));
		g.setStroke(new BasicStroke(getResizeX(3f)));
		
		String text = "Nouvelle Partie";
		x = getCenterXForText(text, g);
		y += getResizeY(250f);
		createButton(g, x, y, commandNum == 0, text, 1);
		
		text = "Charger une partie";
		x = getCenterXForText(text, g);
		y += getResizeY(130f);
		createButton(g, x, y, commandNum == 1, text, 1);
		
		text = "Options";
		x = getCenterXForText(text, g);
		y += getResizeY(130f);
		createButton(g, x, y, commandNum == 2, text, 1);
		
		text = "Quitter";
		x = getCenterXForText(text, g);
		y += getResizeY(130f);
		createButton(g, x, y, commandNum == 3, text, 1);
		
	}
	
	

}
