package model.tile;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class NothingTile extends Tile implements ITile {
	
	//ATTRIBUTS
	
	private BufferedImage sprite;
	
	
    //CONSTRUCTEURS
   
    public NothingTile() {
    	super(true);
    	try {
    		if (sprite == null) {
    			sprite = ImageIO.read(getClass().getResourceAsStream(SPRITE_LOC + "nothing.png"));
    		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    //REQUETES
	
	@Override
	public int getIncreaseSizex() {
    	return 1;
    }
	
	@Override
	public int getIncreaseSizey() {
    	return 1;
    }
	
	@Override
	public BufferedImage getSprite() {
		return sprite;
	}
	
	//COMMANDES
	
	@Override
	protected void setSprite(BufferedImage s) {
		sprite = s;
	}
}
