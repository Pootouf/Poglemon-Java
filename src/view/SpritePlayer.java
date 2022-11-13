package view;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.PoglemonApp;


public class SpritePlayer{
	
	//ATTRIBUTS

	private BufferedImage sprite;
	private final int tiley;
	private final int tilex;
	
	
	
	//CONSTRUCTEURS
	
	public SpritePlayer(BufferedImage img, int x, int y) {
		setSprite(img);
		tilex = x;
		tiley = y;
	}
	
	
	//REQUETES
	
	public BufferedImage getSprite() {
		return sprite;
	}
	
	public int getTileScreenX() {
		return tilex;
	}
	
	public int getTileScreenY() {
		return tiley;
	}
	
	public int getScreenX() {
		return tilex * PoglemonApp.SPRITE_SIZEX;
	}
	
	public int getScreenY() {
		return tiley * PoglemonApp.SPRITE_SIZEY;
	}
	
	//COMMANDES
	
	public void setSprite(BufferedImage img) {
		if(img == null) {
			return;
		}
		sprite = img;
	}
	
	protected void draw(Graphics2D g) { 
		if(sprite == null) {
			return;
		}
		g.drawImage(sprite, getScreenX(), getScreenY(), null);
	}
	
}
