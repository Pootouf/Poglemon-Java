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
	
	// NUMBER_OF_ANIM doit etre multiple de sprite
	public static final int NUMBER_OF_ANIM = 128;
	
	
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
    	view.ui.UIManager ui = screen.uiManager();
    	
    	if(PoglemonApp.gameState == PoglemonApp.GAMEMENU_STATE) { 
    		if(key == KeyEvent.VK_M || key == KeyEvent.VK_ESCAPE) {
	        	PoglemonApp.gameState = PoglemonApp.PLAY_STATE;
	        	return;
	        }
    	}
    	
    	if(PoglemonApp.gameState == PoglemonApp.TITLE_STATE || PoglemonApp.gameState == PoglemonApp.GAMEMENU_STATE) {
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
    	
    	
    	
    	
    	
    	
    	if(PoglemonApp.gameState == PoglemonApp.TEAM_STATE) {
    		int num = ui.getCommandNum();
    		if(key == KeyEvent.VK_ESCAPE) {
    			screen.playSoundEffect(1);
	        	eventMenu(6);
	        }
	        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_Z) {
	        	screen.playSoundEffect(1);
	        	if(num == 0 || num == 6) {
	        		ui.increaseCommandNum(-1);
	        	} else {
	        		ui.increaseCommandNum(-2);
	        	}
	        }
	
	        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
	        	screen.playSoundEffect(1);
	        	if(num == 6 || num == 5) {
	        		ui.increaseCommandNum(1);
	        	} else {
	        		ui.increaseCommandNum(2);
	        	}
	        }
	        
	        if (key == KeyEvent.VK_LEFT|| key == KeyEvent.VK_Q) {
	        	if(num == 6) {
	        		return;
	        	}
	        	screen.playSoundEffect(1);
	        	if(num == 1 || num == 3 || num == 5) {
	        		ui.increaseCommandNum(-1);
	        	} else {
	        		ui.increaseCommandNum(1);
	        	}
	        	
	        }
	        
	        if (key == KeyEvent.VK_RIGHT|| key == KeyEvent.VK_D) {
	        	if(num == 6) {
	        		return;
	        	}
	        	screen.playSoundEffect(1);
	        	if(num == 0 || num == 2 || num == 4) {
	        		ui.increaseCommandNum(1);
	        	} else {
	        		ui.increaseCommandNum(-1);
	        	}
	        	
	        }
	        
	        if (key == KeyEvent.VK_SPACE || key == KeyEvent.VK_ENTER) {
	        	screen.playSoundEffect(1);
	        	eventMenu(num);
	        }
	        return;
    	}
    	
    	
    	
    	if(PoglemonApp.gameState == PoglemonApp.DESCRIPTOR_STATE) {
    		if (key == KeyEvent.VK_ESCAPE || key == KeyEvent.VK_SPACE || key == KeyEvent.VK_ENTER) {
    			screen.playSoundEffect(1);
    			eventMenu(0);
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
	        
	        if(key == KeyEvent.VK_M) {
	        	PoglemonApp.gameState = PoglemonApp.GAMEMENU_STATE;
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
    		try {
    			if(i % PoglemonApp.MOVE_SPEED == 0) {
    				Thread.sleep(1);
    			}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
    		if(i % (NUMBER_OF_ANIM / PoglemonApp.SPRITE_SIZEX) != 0) {
    			continue;
    		}
			switch(direction) {
				case "up":
					player.setDirection("up");
					player.moveUp(1);
					break;
				case "down":
					player.setDirection("down");
					player.moveDown(1);
					break;
				case "left":
					player.setDirection("left");
					player.moveLeft(1);
					break;
				case "right":
					player.setDirection("right");
					player.moveRight(1);
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
    	}
    }
    
    
    //OUTILS
    
    protected void eventMenu(int commandNum) {
    	//PLAYSTATE
    	if(PoglemonApp.gameState == PoglemonApp.PLAY_STATE) { 
    		switch(commandNum) {
    		case 0:
    			PoglemonApp.gameState = PoglemonApp.GAMEMENU_STATE;
    			break;
    		}
    		return;
    	}
    	//MENUSTATE
		if(PoglemonApp.gameState == PoglemonApp.TITLE_STATE) {
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
			return;
		}
		//GAMEMENUSTATE
		if(PoglemonApp.gameState == PoglemonApp.GAMEMENU_STATE) {
			switch(commandNum) {
			case 0:
				PoglemonApp.gameState = PoglemonApp.TEAM_STATE;
				break;
			case 1:
				System.out.println("no pc");
				break;
			case 2:
				System.out.println("no save");
				break;
			case 3:
				System.out.println("no option");
				break;
			case 4:
				PoglemonApp.gameState = PoglemonApp.PLAY_STATE;
				screen.uiManager().setCommandNum(-1);
				break;
			case 5:
				PoglemonApp.quit();
				
			}
			return;
		}
		//TEAMSTATE
		if(PoglemonApp.gameState == PoglemonApp.TEAM_STATE) {
			switch(commandNum) {
			case 0:
				PoglemonApp.gameState = PoglemonApp.DESCRIPTOR_STATE;
				break;
			case 1:
				PoglemonApp.gameState = PoglemonApp.DESCRIPTOR_STATE;
				break;
			case 2:
				PoglemonApp.gameState = PoglemonApp.DESCRIPTOR_STATE;
				break;
			case 3:
				PoglemonApp.gameState = PoglemonApp.DESCRIPTOR_STATE;
				break;
			case 4:
				PoglemonApp.gameState = PoglemonApp.DESCRIPTOR_STATE;
				break;
			case 5:
				PoglemonApp.gameState = PoglemonApp.DESCRIPTOR_STATE;
				break;
			case 6:
				PoglemonApp.gameState = PoglemonApp.GAMEMENU_STATE;
				break;
				
	    	}
			return;
		}
		//DESCRIPTORSTATE
    	if(PoglemonApp.gameState == PoglemonApp.DESCRIPTOR_STATE) { 
    		switch(commandNum) {
    		case 0:
    			PoglemonApp.gameState = PoglemonApp.TEAM_STATE;
    			break;
    		}
    		return;
    	}
	}

}
