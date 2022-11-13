package view;

import java.awt.Graphics2D;

import main.PoglemonApp;
import model.Model;
import model.Player;
import model.tile.Tile;

public class TileManager {
	
	
	
	//ATTRIBUTS
	
	private Sprite[][] spriteTab;
	private int animx;
	private int animy;
	
	
	
	//CONSTRUCTEURS
	
	public TileManager(Sprite[][] tab) {
		spriteTab = tab;
	}
	
	
	//COMMANDES
	
	public void refresh(Model m, SpritePlayer playerSprite) {
		Player player = m.getPlayer();
		for (int i = 0; i < PoglemonApp.LOADING_TILEX; i++) {
			for (int j = 0; j < PoglemonApp.LOADING_TILEY; j++) {
				int tilex = i + player.getTileX() - playerSprite.getTileScreenX() - PoglemonApp.INCREASE_LOADING_SIZE/2;
				int tiley = j + player.getTileY() - playerSprite.getTileScreenY() - PoglemonApp.INCREASE_LOADING_SIZE/2;
				Tile tile = m.getTile(tilex, tiley);
				spriteTab[i][j].setSprite(tile.getSprite());
			}
		}
		animx = player.getTileX() * PoglemonApp.SPRITE_SIZEX - player.getPixelX();
		animy = player.getTileY() * PoglemonApp.SPRITE_SIZEY - player.getPixelY();
	}
	
	
	
	protected void draw(Graphics2D g) {
		for (int i = 0; i < PoglemonApp.LOADING_TILEX; i++) {
			for (int j = 0; j < PoglemonApp.LOADING_TILEY; j++) {
				Sprite s = spriteTab[i][j];
				g.drawImage(s.getSprite(), s.getScreenX() + animx, s.getScreenY() + animy, null);
			}
		}
	}

}
