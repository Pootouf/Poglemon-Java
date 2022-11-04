package model;

import java.awt.Image;

public interface ITile {
    
    public abstract int getWidth();
    
    public abstract int getHeight();
    
    public abstract Image getSprite();
    
    public abstract boolean isWall();
    
}
