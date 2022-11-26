package view.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.PoglemonApp;
import model.Model;

public class PauseMenuUI extends DefaultUI {

	public PauseMenuUI(int numberOfOption, Font font) {
		super(numberOfOption, font);
	}

	@Override
	protected void refresh(Model m) {
		return;
	}

	@Override
	protected void drawState(Graphics2D g) {
		Font font = getFont();
		g.setFont(font.deriveFont(Font.BOLD, (float)PoglemonApp.SPRITE_SIZEX * 3));
		g.setColor(Color.black);
		String text = "Jeu en pause";
		int x = getCenterXForText(text, g);
		int y = PoglemonApp.SCREEN_HEIGHT / 2;
		g.drawString(text, x, y);
	}

}
