package model;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import main.PoglemonApp;

public class Poglemon {
	
	//CONSTANTES DE CLASSE
	
	public final static String SPRITE_LOC = "/sprite/poglemon/";
	public static boolean SPRITE_INIT = false;
	
	public static BufferedImage[] SPRITES = new BufferedImage[1000];
	
	
	//ATTRIBUTS
	
	private int ID;
	private String name;
    private int hp;
    private int hpTotal;
    private int atk;
    private int speatk;
    private int def;
    private int spedef;
    private int vitesse;
    private int niveau;
    private int xpNiveau;
    private int xpactuel;
    private int type1;
    private int type2;
    private int progressionXP;
    private int[] attaqueid = new int[4];
    private int[] attaquepprestant = new int[4];
    private boolean isInit;
    private BufferedImage texturePog;
    
    
    
    
    
    
    
    
    
    //CONSTRUCTEURS 
	
    public Poglemon(int ID_pog, String namePog, int niveauPog, boolean newPog) {
    	createSprites();
        if(namePog == "" || namePog == null){
            name = PoglemonIndex.STATS_POG_NAME_INDEX.get("pog" + "name" + String.valueOf(ID_pog));
        }else{
            name = namePog;
        }
        hpTotal = 0;
        atk = 0;
        speatk = 0;
        def = 0;
        spedef = 0;
        vitesse = 0;
        progressionXP = 0;
        type1 = 0;
        type2 = 0;
        xpNiveau = 0;
        xpactuel = 0;
        hp = 0;
        niveau = 1;

        for(int k = 0; k<4;k++){
            attaqueid[k] = 0;
            attaquepprestant[k] = 0;
        }

        if(newPog == true){

            initPoglemon(ID_pog, namePog, niveauPog);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    //REQUETES
    
    public boolean isInit() {
    	return isInit;
    }
    
    public int id() {
    	return ID;
    }
    
    public String name() {
    	return name;
    }
    
    public int hpTotal() {
    	return hpTotal;
    }
    
    public int atk() {
    	return atk;
    }
    
    public int speatk() {
    	return speatk;
    }
    
    public int def() {
    	return def;
    }
    
    public int spedef() {
    	return spedef;
    }
    
    public int vitesse() {
    	return vitesse;
    }
    
    public int hp() {
    	return hp;
    }
    
    public int type1() {
    	return type1;
    }
    
    public int type2() {
    	return type2;
    }
    
    public int xpLevel() {
    	return xpNiveau;
    }
    
    public int xp() {
    	return xpactuel;
    }
    
    public int niveau() {
    	return niveau;
    }
    
    public BufferedImage getSprite() {
    	return texturePog;
    }
    
    
    
    
    
    
    
    
    
    
    
    //COMMANDES
    
    public void initPoglemon(int ID_pog, String namePog, int niveauPog) {
    	isInit = true;
        ID = ID_pog;
        if(namePog == "" || namePog == null){
            name = PoglemonIndex.STATS_POG_NAME_INDEX.get("pog" + "name" + String.valueOf(ID_pog));
        }else{
            name = namePog;
        }

        levelUp(niveauPog);

        progressionXP = PoglemonIndex.STATS_POGLEMON_INDEX.get("pog" + "progressionxp" + String.valueOf(ID));

        type1 = PoglemonIndex.STATS_POGLEMON_INDEX.get("pog" + "type1" + String.valueOf(ID));
        type2 = PoglemonIndex.STATS_POGLEMON_INDEX.get("pog" + "type2" + String.valueOf(ID));

        xpNiveau = niveauProgressionXP(progressionXP);
        xpactuel = 0;
        hp = hpTotal;

        texturePog = SPRITES[ID];
    }

    private void levelUp(int niveauPog) {
    	for(int k = niveau; k <= niveauPog; k++){
    		ArrayList<Integer> list = PoglemonIndex.POGLEMON_ATTAQUE_NIV_INDEX.get("pog" + String.valueOf(ID) + "attaqueniv" + String.valueOf(k));
    		if(list == null) {
    			break;
    		}
    		for (int x = 0; x < list.size(); x++) {
    			int attaqueID = list.get(x);
    			for(int z = 0; z<4; z++){
                  if(attaqueid[z] ==0){
                      attaqueid[z] = attaqueID;
                      attaquepprestant[z] = PoglemonIndex.ATTAQUE_STATS_INDEX.get("pp" + String.valueOf(attaqueID));
                      x = 5;
                  }
              }
    		}
        }

        xpNiveau = niveauProgressionXP(progressionXP);

        niveau = niveauPog;
        
        hpTotal = (((PoglemonIndex.STATS_POGLEMON_INDEX.get("pog" + "hp" + String.valueOf(ID)) * 2) * niveau) / 100) + niveau + 10;
        atk = (((PoglemonIndex.STATS_POGLEMON_INDEX.get("pog" + "hp" + String.valueOf(ID)) * 2) * niveau) / 100) + 5;
        speatk = (((PoglemonIndex.STATS_POGLEMON_INDEX.get("pog" + "hp" + String.valueOf(ID)) * 2) * niveau) / 100) + 5;
        def = (((PoglemonIndex.STATS_POGLEMON_INDEX.get("pog" + "hp" + String.valueOf(ID)) * 2) * niveau) / 100) + 5;
        spedef = (((PoglemonIndex.STATS_POGLEMON_INDEX.get("pog" + "hp" + String.valueOf(ID)) * 2) * niveau) / 100) + 5;
        vitesse = (((PoglemonIndex.STATS_POGLEMON_INDEX.get("pog" + "hp" + String.valueOf(ID)) * 2) * niveau) / 100) + 5;
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

	//OUTILS
	
	private void createSprites() {
		if (SPRITE_INIT) {
			return;
		}
		new PoglemonIndex();
		SPRITE_INIT = true;
		for(int i = 0; i < 1000; i++) {
			String localisationTexture = PoglemonIndex.STATS_POG_NAME_INDEX.get("pog" + "name" + String.valueOf(i));
			if(localisationTexture != null) {
				try {
		    		SPRITES[i] = ImageIO.read(getClass().getResourceAsStream(SPRITE_LOC + localisationTexture + ".png"));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		resizeSprites();
	}
	
	private void resizeSprites() {
		for(int i = 0; i < 1000; i ++) {
			if (SPRITES[i] == null ) {
				continue;
			}
	      	BufferedImage scaledImage = new BufferedImage(PoglemonApp.SPRITE_SIZEX * 2, PoglemonApp.SPRITE_SIZEY * 2, SPRITES[i].getType());
	      	Graphics2D g = (Graphics2D) scaledImage.getGraphics();
	      	g.drawImage(SPRITES[i], 0, 0, PoglemonApp.SPRITE_SIZEX * 2, PoglemonApp.SPRITE_SIZEY * 2, null);
	      	g.dispose();
	      	SPRITES[i] = scaledImage;
		}
	}
	
	private int niveauProgressionXP(int progressionXP) {
		if (progressionXP == 1){
            return (int) (0.8*(niveau + 1)*(niveau+1)*(niveau+1) - 0.8*(niveau)*(niveau)*(niveau));
        }
        if (progressionXP == 2){
        	return (niveau + 1)*(niveau+1)*(niveau+1) - (niveau)*(niveau)*(niveau);
        }
        if (progressionXP == 3){
        	return (int) ((1.2*(niveau + 1)*(niveau+1)*(niveau+1) - 15*(niveau + 1)*(niveau + 1) + 100*(niveau+1) -140) - (1.2*(niveau)*(niveau)*(niveau) - 15*(niveau)*(niveau) + 100*(niveau) -140));
        }
        if (progressionXP == 4){
        	return (int) (1.25*(niveau + 1)*(niveau+1)*(niveau+1) - 1.25*(niveau)*(niveau)*(niveau));
        }
        return -1;
	}
}

