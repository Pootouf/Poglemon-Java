package model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.PoglemonApp;

public class Player{
	
	//CONSTANTES
	
	public int NUMBER_SPRITE = 4;
	public final static String SPRITE_LOC = "/sprite/player/";
	public final static int WAIT_ANIM = PoglemonApp.FPS / 4;
	

	//ATTRIBUTS
	
    private BufferedImage spriteup[];
    private BufferedImage spritedown[];
    private BufferedImage spriteleft[];
    private BufferedImage spriteright[];
    private int pixelX;
    private int pixelY;
    private String direction;
    private int spriteCounter;
    private int spriteNum = 0;
    
    
    
    //CONSTRUCTEURS
    
    public Player() {
    	direction = "down";
        try {
			initSprites();
		} catch (IOException e) {
			e.printStackTrace();
		}
        resizeSprite();
        int tileX = 3;
        int tileY = 3;
        pixelX = tileX * PoglemonApp.SPRITE_SIZEX;
        pixelY = tileY * PoglemonApp.SPRITE_SIZEY;
    } 
    
    
    
    
    //REQUETES
    
    public BufferedImage getSprite(){
    	BufferedImage image = null;
        switch(direction) {
        	case "down":
        		image = spritedown[spriteNum];
        		break;
        	case "up":
        		image = spriteup[spriteNum];
        		break;
        	case "left":
        		image = spriteleft[spriteNum];
        		break;
        	case "right":
        		image = spriteright[spriteNum];
        		break;
        }
        spriteCounter++;
        if(spriteCounter > WAIT_ANIM) {
        	spriteNum = (spriteNum + 1) % NUMBER_SPRITE;
        	spriteCounter = 0;
        }
        return image;
    }
    
    
    public int getTileX(){
        return pixelX / PoglemonApp.SPRITE_SIZEX;
    }
    
    public int getTileY(){
        return pixelY / PoglemonApp.SPRITE_SIZEY;
    }
    
    public int getPixelX(){
        return pixelX;
    }
    
    public int getPixelY(){
        return pixelY;
    }
    
    //COMMANDES
    
    public void moveLeft(int x){
    	pixelX -= x;
    }
    
    public void moveRight(int x){
    	pixelX += x;
    }
    
    public void moveUp(int x){
    	pixelY -= x;
    }
    
    public void moveDown(int x){
    	pixelY += x;
    }
    
    public void setDirection(String s) {
    	direction = s;
    }
    
    public void resizeSprite() {
    	for(int i = 0; i < NUMBER_SPRITE; i++) {
	      	resizeDirection(spriteup, i);
	      	resizeDirection(spritedown, i);
	      	resizeDirection(spriteleft, i);
	      	resizeDirection(spriteright, i);
    	}
    }
    
    
    //OUTILS
    
    private void initSprites() throws IOException {
    	spriteup = new BufferedImage[NUMBER_SPRITE];
    	spritedown = new BufferedImage[NUMBER_SPRITE];
    	spriteleft = new BufferedImage[NUMBER_SPRITE];
    	spriteright = new BufferedImage[NUMBER_SPRITE];
    	for(int i = 1; i <= NUMBER_SPRITE; i++) {
    		spriteup[i - 1] = ImageIO.read(getClass().getResourceAsStream(SPRITE_LOC + "player-up" + i + ".png"));
    		spritedown[i - 1] = ImageIO.read(getClass().getResourceAsStream(SPRITE_LOC + "player" + i + ".png"));
    		spriteleft[i - 1] = ImageIO.read(getClass().getResourceAsStream(SPRITE_LOC + "player-left" + i + ".png"));
    		spriteright[i - 1] = ImageIO.read(getClass().getResourceAsStream(SPRITE_LOC + "player-right" + i + ".png"));
    	}
    }
    
    private void resizeDirection(BufferedImage[] sprite, int i) {
    	BufferedImage scaledImage = new BufferedImage(PoglemonApp.SPRITE_SIZEX, PoglemonApp.SPRITE_SIZEY, sprite[i].getType());
      	Graphics2D g = (Graphics2D) scaledImage.getGraphics();
      	g.drawImage(sprite[i], 0, 0, PoglemonApp.SPRITE_SIZEX, PoglemonApp.SPRITE_SIZEY, null);
      	g.dispose();
      	sprite[i] = scaledImage;
    }

}
