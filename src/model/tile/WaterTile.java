package model.tile;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class WaterTile extends Tile implements ITile {
	
	//CONSTANTES DE CLASSE
	
	public static int WATER_TILE_NUMBER = 14;
	
	//ATTRIBUTS
	
    private static BufferedImage[] sprite;
    
    private int type;
	
	
    //CONSTRUCTEURS
   
    public WaterTile(int type) {
    	super(true);
    	this.type = type;
    	sprite = new BufferedImage[WATER_TILE_NUMBER];
    	try {
    		for (int i = 0; i < WATER_TILE_NUMBER; i++) {
				if (sprite[i ] == null) {
					sprite[i ] = ImageIO.read(getClass().getResourceAsStream(SPRITE_LOC + "water/" + "water-" + i + ".png"));
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
