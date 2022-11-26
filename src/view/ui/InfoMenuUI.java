package view.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import main.PoglemonApp;
import model.Model;

public class InfoMenuUI extends DefaultUI {
	
	private int tilex;
	private int tiley;
	private boolean isInfoOpen = false;

	public InfoMenuUI(int numberOfOption, Font font) {
		super(numberOfOption, font);
	}
	
	public boolean getInfoOpen() {
		return isInfoOpen;
	}

	@Override
	protected void refresh(Model m) {
		if(isInfoOpen) {
			tilex = m.getPlayer().getTileX();
			tiley = m.getPlayer().getTileY(); 
		}
	}

	@Override
	protected void drawState(Graphics2D g) {
		if(isInfoOpen) {
			Font font = getFont();
			g.setFont(font.deriveFont(Font.BOLD, (float)PoglemonApp.SPRITE_SIZEX / 2));
			g.setColor(Color.black);
			g.drawString("fps: " + PoglemonApp.fps(), PoglemonApp.SPRITE_SIZEX / 2, PoglemonApp.SPRITE_SIZEY / 2);
			g.drawString("X: " + tilex, PoglemonApp.SPRITE_SIZEX / 2, PoglemonApp.SPRITE_SIZEY);
			g.drawString("Y: " + tiley, PoglemonApp.SPRITE_SIZEX / 2, (int) (PoglemonApp.SPRITE_SIZEY * 1.5));
		}
	}
	
	public void setInfoOpen(boolean b) {
		isInfoOpen = b;
	}

}
