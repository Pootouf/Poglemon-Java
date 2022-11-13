package view;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;

import main.PoglemonApp;
import model.Model;
import model.Player;
import model.object.AbstractObject;

public class ObjectManager {
	
	//ATTRIBUTS
	
	private List<Sprite> spriteList;
	private int animx;
	private int animy;
	
	
	//CONSTRUCTEURS
	
	public ObjectManager() {
		spriteList = new ArrayList<Sprite>();
	}
	
	
	//COMMANDES
	
	public void refresh(Model m, SpritePlayer spritePlayer) {
		Player player = m.getPlayer();
		for(int i = 0; i < m.numberObject(); i++) {
			AbstractObject o = m.getObject(i);
			Sprite s;
			int tilex = o.getTilex() - player.getTileX() + spritePlayer.getTileScreenX() ;
			int tiley = o.getTiley() - player.getTileY() + spritePlayer.getTileScreenY() ;
			if (i >= spriteList.size()) {
				s = new Sprite(o.getSprite(), tilex, tiley);
				spriteList.add(s);
			} else {
				s = spriteList.get(i);
				s.setSprite(o.getSprite());
				s.setTileX(tilex);
				s.setTileY(tiley);
			}
		}
		animx = player.getTileX() * PoglemonApp.SPRITE_SIZEX - player.getPixelX();
		animy = player.getTileY() * PoglemonApp.SPRITE_SIZEY - player.getPixelY();
	}
	
	
	
	protected void draw(Graphics2D g) {
		for(int i = 0; i < spriteList.size(); i++) { 
			Sprite s = spriteList.get(i);
			if(!(s.getScreenX() + animx <  -2*PoglemonApp.SPRITE_SIZEX 
			|| s.getScreenY() + animy <  -2*PoglemonApp.SPRITE_SIZEY
			|| s.getScreenX() + animx > PoglemonApp.SCREEN_WIDTH + 2*PoglemonApp.SPRITE_SIZEX
			|| s.getScreenY() + animy > PoglemonApp.SCREEN_HEIGHT + 2*PoglemonApp.SPRITE_SIZEY)) {
				g.drawImage(s.getSprite(), s.getScreenX() + animx, s.getScreenY() + animy, null);
			}
		}
	}
}
