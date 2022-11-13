package controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.PoglemonApp;
import model.Model;
import model.Player;
import model.object.AbstractObject;
import model.tile.ITile;
import view.Screen;

public class KeyControler implements KeyListener {
	
	//CONSTANTES DE CLASSE
	
	// la taille des sprites doit etre un multiple de NUMBER_OF_ANIM
	public static final int NUMBER_OF_ANIM = PoglemonApp.SPRITE_SIZEX;
	
	public static final int BASE_SPEED = NUMBER_OF_ANIM / (PoglemonApp.SPRITE_SIZEX );
	
	
	
	//ATTRIBUTS

	private long lastPressProcessed = 0;
	
	private Model model;
	
	private Screen screen;
	
	
	
	
	//CONSTRUCTEURS
	public KeyControler(Model m, Screen s) {
		model = m;
		screen = s;
	}
	
	
	
	
	//COMMANDES

	 @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e){
   	 if(System.currentTimeMillis() - lastPressProcessed > PoglemonApp.WAIT_BEFORE_ACTION) {
   		 onKeyPressed(e.getKeyCode());
   		 lastPressProcessed = System.currentTimeMillis();
   	 }
    }
    
    public void onKeyPressed(int key) { 
    	Player player = model.getPlayer();
    	
    	
    	
    	if(PoglemonApp.gameState == PoglemonApp.MENU_STATE) {
    		view.UIManager ui = screen.uiManager();
	        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_Z) {
	        	screen.playSoundEffect(1);
	        	ui.increaseCommandNum(-1);
	        }
	
	        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
	        	screen.playSoundEffect(1);
	        	ui.increaseCommandNum(1);
	        }
	        
	        if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_ENTER) {
	        	screen.playSoundEffect(1);
	        	eventMenu(ui.getCommandNum());
	        }
	        return;
    	}
    	
    	
    	if(PoglemonApp.gameState == PoglemonApp.PAUSE_STATE) { 
    		if(key == KeyEvent.VK_ESCAPE) {
	        	PoglemonApp.gameState = PoglemonApp.PLAY_STATE;
	        	screen.playMusic(0);
	        }
    		return;
    	}
    	
    	
    	
    	
    	if(PoglemonApp.gameState == PoglemonApp.PLAY_STATE) {
    		
	        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_Q) {
	            ITile c = model.getTile(player.getTileX() - 1, player.getTileY());
	            AbstractObject o = model.getObject(player.getTileX() - 1, player.getTileY());
	            collision(c, "left", o);
	        }
	
	        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
	            ITile c = model.getTile(player.getTileX() + 1, player.getTileY());
	            AbstractObject o = model.getObject(player.getTileX() + 1, player.getTileY());
	            collision(c, "right", o);
	        }
	
	        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_Z) {
	            ITile c = model.getTile(player.getTileX(), player.getTileY() - 1);
	            AbstractObject o = model.getObject(player.getTileX(), player.getTileY() - 1);
	            collision(c, "up", o);
	        }
	
	        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
	            ITile c = model.getTile(player.getTileX(), player.getTileY() + 1);
	            AbstractObject o = model.getObject(player.getTileX(), player.getTileY() + 1);
	            collision(c, "down", o);
	        }
	        
	        if(key == KeyEvent.VK_F3) {
				screen.uiManager().setInfoOpen(!screen.uiManager().getInfoOpen());
			}
	        
	        if(key == KeyEvent.VK_ESCAPE) {
	        	PoglemonApp.gameState = PoglemonApp.PAUSE_STATE;
	        	screen.stopMusic();
	        }
	        return;
    	}
    }
    
    
    
    
    //OUTILS
    
    private void collision(ITile c, String direction, AbstractObject o) {
        if(c != null && c.isWall() && PoglemonApp.CAN_PASS_WALL == false ){
            return;
        }
        if (o != null && o.isSolid()) {
        	return;
        }
        move(direction);
    }
    
    private void move(String direction) {
    	Player player = model.getPlayer();
    	double drawInterval = 1000000000/PoglemonApp.FPS;
		double delta = 0;
		int drawCount = 0;
		int timer = 0;
		long lastTime = System.nanoTime();
		long currentTime;
    	for (int i = 0; i < NUMBER_OF_ANIM; i++) {
			switch(direction) {
				case "up":
					player.setDirection("up");
					player.moveUp(PoglemonApp.SPRITE_SIZEY / NUMBER_OF_ANIM);
					break;
				case "down":
					player.setDirection("down");
					player.moveDown(PoglemonApp.SPRITE_SIZEY / NUMBER_OF_ANIM);
					break;
				case "left":
					player.setDirection("left");
					player.moveLeft(PoglemonApp.SPRITE_SIZEX / NUMBER_OF_ANIM);
					break;
				case "right":
					player.setDirection("right");
					player.moveRight(PoglemonApp.SPRITE_SIZEX / NUMBER_OF_ANIM);
					break;
			}
			currentTime = System.nanoTime();
			delta += (currentTime - lastTime)/drawInterval;
			lastTime = currentTime;
			if(delta >= 1) {
				screen.refresh(model);
				screen.paintImmediately(0, 0, screen.getWidth(), screen.getWidth());
				delta--;
				drawCount++;
			}	
			if(timer > 1000000000) {
				PoglemonApp.setFps(drawCount);
				timer = 0;
				drawCount = 0;
			}
			try {
				Thread.sleep((int)(BASE_SPEED / PoglemonApp.MOVE_SPEED));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    	}
    }
    
    public void eventMenu(int commandNum) {
		switch(commandNum) {
			case 0:
				PoglemonApp.gameState = PoglemonApp.PLAY_STATE;
				screen.playMusic(0);
				break;
			case 1:
				System.out.println("no save");
				break;
			case 2:
				System.out.println("no option");
				break;
			case 3:
				PoglemonApp.quit();
				
		}
	}

}
