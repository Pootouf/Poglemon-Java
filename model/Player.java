package model;

import java.awt.Image;
import java.io.IOException;
import java.util.Observable;

import javax.imageio.ImageIO;

import main.TestGame;

@SuppressWarnings("deprecation")
public class Player extends Observable{
	

	//ATTRIBUTS
	
    private Image sprite;
    private int pixelX;
    private int pixelY;
    
    
    
    
    //CONSTRUCTEURS
    
    public Player() {
        try {
			sprite = ImageIO.read(getClass().getResourceAsStream("/sprite/monomi.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
       int tileX = TestGame.SCREEN_TILEX/2;
       int tileY = TestGame.SCREEN_TILEY/2;
       pixelX = tileX * TestGame.SPRITE_SIZEX;
       pixelY = tileY * TestGame.SPRITE_SIZEY;
    }
    
    
    
    
    //REQUETES
    
    public Image getSprite(){
        return sprite;
    }
    
    
    public int getTileX(){
        return pixelX / TestGame.SPRITE_SIZEX;
    }
    
    public int getTileY(){
        return pixelY / TestGame.SPRITE_SIZEY;
    }
    
    public int getPixelX(){
        return pixelX;
    }
    
    public int getPixelY(){
        return pixelY;
    }
    
    //COMMANDES
    
    public void moveLeft(){
    	pixelX -= 1;
        afterMove("left");
    }
    
    public void moveRight(){
    	pixelX += 1;
        afterMove("right");
    }
    
    public void moveUp(){
    	pixelY -= 1;
        afterMove("up");
    }
    
    public void moveDown(){
    	pixelY += 1;
        afterMove("down");
    }
    
    
    //OUTILS
    
    private void afterMove(String arg) {
        setChanged();
        notifyObservers(arg);
    }

}
