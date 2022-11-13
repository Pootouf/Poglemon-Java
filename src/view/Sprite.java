package view;

import java.awt.image.BufferedImage;

import main.PoglemonApp;


public class Sprite {
	
	
	//ATTRIBUTS
	
	private BufferedImage sprite;
	private int tilex;
	private int tiley;
	
	
	//CONSTRUCTEURS
	
	public Sprite(BufferedImage img, int x, int y) {
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
	
	public void setTileX(int x) {
		tilex = x;
	}
	
	public void setTileY(int y) {
		tiley = y;
	}

}
