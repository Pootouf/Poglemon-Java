package model.tile;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class DirtTile extends Tile implements ITile {
	
	//ATTRIBUTS
	
    private static BufferedImage sprite;
	
	
    //CONSTRUCTEURS
   
    public DirtTile() {
    	super(false);
    	try {
    		if (sprite == null) {
    			sprite = ImageIO.read(getClass().getResourceAsStream(SPRITE_LOC + "ground.png"));
    		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    //REQUETES

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
