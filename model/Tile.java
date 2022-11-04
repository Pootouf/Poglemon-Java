package model;

import java.awt.Image;

public abstract class Tile implements ITile {
	
	
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
    
    public abstract Image getSprite();
    
    public boolean isWall(){
        return isWall;
    }
    
}
