package model;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class DirtTile extends Tile implements ITile {
	
	//REQUETES
	
    private static Image sprite;
	
	
    //CONSTRUCTEURS
   
    public DirtTile() {
    	super(false);
    	try {
    		if (sprite == null) {
    			sprite = ImageIO.read(getClass().getResourceAsStream("/sprite/ground.png"));
    		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    //REQUETES

	@Override
	public Image getSprite() {
		return sprite;
	}
}
