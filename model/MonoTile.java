package model;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MonoTile extends Tile implements ITile {
	
	//REQUETES
	
    private static Image sprite;
	
	
    //CONSTRUCTEURS
   
    public MonoTile() {
    	super(false);
    	try {
    		if (sprite == null) {
    			sprite = ImageIO.read(getClass().getResourceAsStream("/sprite/monokuma.png"));
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
