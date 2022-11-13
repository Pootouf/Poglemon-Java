package model.tile;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class PathTile extends Tile implements ITile {
	
	//CONSTANTES DE CLASSE
	
	public static int PATH_TILE_NUMBER = 22;
	
	//ATTRIBUTS
	
    private static BufferedImage[] sprite;
    
    private int type;
	
	
    //CONSTRUCTEURS
   
    public PathTile(int type) {
    	super(false);
    	this.type = type;
    	sprite = new BufferedImage[PATH_TILE_NUMBER];
    	try {
    		for (int i = 0; i < PATH_TILE_NUMBER; i++) {
				if (sprite[i] == null) {
					sprite[i] = ImageIO.read(getClass().getResourceAsStream(SPRITE_LOC + "path/" + "path-" + i + ".png"));
				}
    		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    
    //REQUETES

	@Override
	public BufferedImage getSprite() {
		return sprite[type];
	}
	
	//COMMANDES
	
	@Override
	protected void setSprite(BufferedImage s) {
		sprite[type] = s;
	}
	
}
