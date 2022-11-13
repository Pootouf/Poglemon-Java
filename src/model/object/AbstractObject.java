package model.object;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.List;

import main.PoglemonApp;

public abstract class AbstractObject {
	
	//CONSTANTES DE CLASSES
	
	public final static String SPRITE_LOC = "/sprite/object/";
	
	public static AbstractObject[][] objectTab = new AbstractObject[PoglemonApp.WORLD_TILEX][PoglemonApp.WORLD_TILEY];
	
	
	// ATTRIBUTS
	
	private int tilex;
	
	private int tiley;
	
	private boolean isSolid;
	
	
	// CONSTRUCTEURS
	
	public AbstractObject(int x, int y, boolean solid) {
		tilex = x;
		tiley = y;
		isSolid = solid;
	}
	
	// REQUETES
	
	public int getTilex() {
		return tilex;
	}
	
	public int getTiley() {
		return tiley;
	}
	
	public boolean isSolid() {
		return isSolid;
	}
	
	public abstract BufferedImage getSprite();
	
	
	//COMMANDES
	
  	public void resizeSprite() {
      	if(getSprite() == null) {
      		return;
      	}
      	BufferedImage scaledImage = new BufferedImage(PoglemonApp.SPRITE_SIZEX, PoglemonApp.SPRITE_SIZEY, getSprite().getType());
      	Graphics2D g = (Graphics2D) scaledImage.getGraphics();
      	g.drawImage(getSprite(), 0, 0, PoglemonApp.SPRITE_SIZEX, PoglemonApp.SPRITE_SIZEY, null);
      	g.dispose();
      	setSprite(scaledImage);
    }
  	
  	protected abstract void setSprite(BufferedImage s);
	
	
	
	
	//OUTILS
	
	public static void initObject(List<AbstractObject> objectList) {
		AbstractObject p = new Obj_Pokeball(1, 1);
		p.resizeSprite();
		objectList.add(p);
		objectTab[1][1] = p; 
	}
	
}
