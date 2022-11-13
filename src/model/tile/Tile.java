package model.tile;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import main.PoglemonApp;

public abstract class Tile implements ITile {
	
	//CONSTANTES DE CLASSES
	
	public final static String SPRITE_LOC = "/sprite/tile/";
	
	
    //ATTRIBUTS
    
    private boolean isWall;
    
    
    
    //CONSTRUCTEURS
    
    public Tile(boolean wall)
    {   
        isWall = wall;
    }
    
    

    //REQUETES
    
    public int getWidth() {
    	if(getSprite() == null) {
    		return 0;
    	}
    	return getSprite().getWidth(null);
    }
    
    public int getHeight() {
    	if(getSprite() == null) {
    		return 0;
    	}
    	return getSprite().getHeight(null);
    }
    
    public abstract BufferedImage getSprite();
    
    public boolean isWall(){
        return isWall;
    }
    
    public int getIncreaseSizex() {
    	return 1;
    }
    
    public int getIncreaseSizey() {
    	return 1;
    }
    
    
    
    //COMMANDES
	
  	public void resizeSprite() {
      	if(getSprite() == null) {
      		return;
      	}
      	BufferedImage scaledImage = new BufferedImage(PoglemonApp.SPRITE_SIZEX * getIncreaseSizex(), PoglemonApp.SPRITE_SIZEY * getIncreaseSizey(), getSprite().getType());
      	Graphics2D g = (Graphics2D) scaledImage.getGraphics();
      	g.drawImage(getSprite(), 0, 0, PoglemonApp.SPRITE_SIZEX * getIncreaseSizex(), PoglemonApp.SPRITE_SIZEY * getIncreaseSizey(), null);
      	g.dispose();
      	setSprite(scaledImage);
    }
  	
  	protected abstract void setSprite(BufferedImage s);
    
    
}
