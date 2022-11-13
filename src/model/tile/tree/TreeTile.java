package model.tile.tree;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import model.tile.ITile;
import model.tile.Tile;

public class TreeTile extends Tile implements ITile {
	
	//REQUETES
	
    private static BufferedImage sprite;
	
	
    //CONSTRUCTEURS
   
    public TreeTile() {
    	super(true);
    	try {
    		if (sprite == null) {
    			sprite = ImageIO.read(getClass().getResourceAsStream(SPRITE_LOC + "tree.png"));
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
	
	@Override
	public int getIncreaseSizex() {
    	return 2;
    }
	
	@Override
	public int getIncreaseSizey() {
    	return 2;
    }
	
	
	
	//COMMANDES
	
	@Override
	protected void setSprite(BufferedImage s) {
		sprite = s;
	}
}
