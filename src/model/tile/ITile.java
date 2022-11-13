package model.tile;

import java.awt.Image;

public interface ITile {
    
    int getWidth();
    
    int getHeight();
    
    Image getSprite();
    
    boolean isWall();
    
    int getIncreaseSizex();
    
    int getIncreaseSizey();
    
}
