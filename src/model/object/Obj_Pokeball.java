package model.object;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Obj_Pokeball extends AbstractObject {
	
	//ATTRIBUTS
	
    private static BufferedImage sprite;
	
	
    //CONSTRUCTEURS
	
	

	public Obj_Pokeball(int x, int y) {
		super(x, y, true);
		
		try {
    		if (sprite == null) {
    			sprite = ImageIO.read(getClass().getResourceAsStream(SPRITE_LOC + "pokeball.png"));
    		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
