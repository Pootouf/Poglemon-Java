package view.ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.PoglemonApp;
import model.Model;

public class PlayMenuUI extends DefaultUI {
	
	//CONSTANTES DE CLASSE
	
	private static BufferedImage ICON_MENU;
	private static BufferedImage ICON_MENU_HOVER;
	
	private int tilex;
	private int tiley;
	private boolean isInfoOpen = false;

	public PlayMenuUI(int numberOfOption, Font font) {
		super(numberOfOption, font);
		try {
			ICON_MENU = ImageIO.read(getClass().getResourceAsStream(SPRITE_LOC + "icon_menu.png"));
			ICON_MENU_HOVER = ImageIO.read(getClass().getResourceAsStream(SPRITE_LOC + "icon_menu_hover.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		int commandNum = getCommandNum();
		Font font = getFont();
		
		if(isInfoOpen) {
			float fontSize = 50f;
			g.setFont(font.deriveFont(Font.BOLD, getFontSize(fontSize - 10f)));
			g.setColor(Color.black);
			g.drawString("FPS: " + PoglemonApp.fps(), getResizeX(fontSize),  getFontSize(fontSize));
			g.drawString("X: " + tilex, getResizeX(fontSize), getFontSize(fontSize * 2));
			g.drawString("Y: " + tiley, getResizeX(fontSize), getFontSize(fontSize * 3));
		}
		
		int x = PoglemonApp.SCREEN_WIDTH - (int)(PoglemonApp.SPRITE_SIZEX * 1.5);
		int y = 0;
		BufferedImage image = (commandNum == 0 ? ICON_MENU_HOVER : ICON_MENU);
		g.drawImage(image, x, y, (int)(PoglemonApp.SPRITE_SIZEX*1.5), (int)(PoglemonApp.SPRITE_SIZEY*1.5), null);
		addListButton(x, y, (int)(PoglemonApp.SPRITE_SIZEX*1.5), (int)(PoglemonApp.SPRITE_SIZEY*1.5));
	}
	
	public void setInfoOpen(boolean b) {
		isInfoOpen = b;
	}

}
