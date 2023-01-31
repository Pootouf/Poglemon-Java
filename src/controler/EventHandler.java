package controler;

import java.awt.event.KeyEvent;
import java.util.concurrent.Semaphore;

import main.PoglemonApp;
import model.Model;
import model.Player;
import model.object.AbstractObject;
import model.tile.ITile;
import view.Screen;

public class EventHandler {
	
	//CONSTANTES DE CLASSE
	
	// NUMBER_OF_ANIM doit etre multiple de sprite
	public static final int NUMBER_OF_ANIM = 128;
	
	//ATTRIBUTS
	
	private Screen screen;
	private Model model;
	private Semaphore sem;
	
	private long lastPressProcessed = 0;
	
	private boolean upPressed, downPressed, leftPressed, rightPressed, mPressed, escapePressed, spacePressed, enterPressed, f3Pressed;
	
	
	//CONSTRUCTEURS
	public EventHandler(Screen s, Model m, Semaphore sem) {
		screen = s;
		model = m;
		this.sem = sem;
	}
	
	
	//COMMANDES
	
	public void onKeyPressed() { 
		
		boolean upPressed = this.upPressed;
		boolean downPressed = this.downPressed;
		boolean leftPressed = this.leftPressed;
		boolean rightPressed = this.rightPressed;
		boolean mPressed = this.mPressed;
		boolean escapePressed = this.escapePressed;
		boolean spacePressed = this.spacePressed;
		boolean enterPressed = this.enterPressed;
		boolean f3Pressed = this.f3Pressed;
		
		if(System.currentTimeMillis() - lastPressProcessed <= PoglemonApp.WAIT_BEFORE_ACTION) {
	   		 return;
	   	}
		lastPressProcessed = System.currentTimeMillis();
    	Player player = model.getPlayer();
    	view.ui.UIManager ui = screen.getUIManager();
    	
    	if(PoglemonApp.gameState == PoglemonApp.GAMEMENU_STATE) { 
    		if(mPressed|| escapePressed) {
	        	PoglemonApp.gameState = PoglemonApp.PLAY_STATE;
	        	return;
	        }
    	}
    	
    	if(PoglemonApp.gameState == PoglemonApp.TITLE_STATE || PoglemonApp.gameState == PoglemonApp.GAMEMENU_STATE) {
	        if (upPressed) {
	        	screen.playSoundEffect(1);
	        	ui.increaseCommandNum(-1);
	        }
	
	        if (downPressed) {
	        	screen.playSoundEffect(1);
	        	ui.increaseCommandNum(1);
	        }
	        
	        if (spacePressed || enterPressed) {
	        	screen.playSoundEffect(1);
	        	eventMenu(ui.getCommandNum());
	        }
	        return;
    	}
    	
    	
    	
    	
    	
    	
    	
    	if(PoglemonApp.gameState == PoglemonApp.PAUSE_STATE) { 
    		if(escapePressed) {
	        	PoglemonApp.gameState = PoglemonApp.PLAY_STATE;
	        	screen.playMusic(0);
	        }
    		return;
    	}
    	
    	
    	
    	
    	
    	
    	if(PoglemonApp.gameState == PoglemonApp.TEAM_STATE) {
    		int num = ui.getCommandNum();
    		if(escapePressed) {
    			screen.playSoundEffect(1);
    			eventMenu(6);
	        }
	        if (upPressed) {
	        	screen.playSoundEffect(1);
	        	if(num == 0 || num == 6) {
	        		ui.increaseCommandNum(-1);
	        	} else {
	        		ui.increaseCommandNum(-2);
	        	}
	        }
	
	        if (downPressed) {
	        	screen.playSoundEffect(1);
	        	if(num == 6 || num == 5) {
	        		ui.increaseCommandNum(1);
	        	} else {
	        		ui.increaseCommandNum(2);
	        	}
	        }
	        
	        if (leftPressed) {
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
	        
	        if (rightPressed) {
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
	        
	        if (spacePressed || enterPressed) {
	        	screen.playSoundEffect(1);
	        	eventMenu(num);
	        }
	        return;
    	}
    	
    	
    	
    	if(PoglemonApp.gameState == PoglemonApp.DESCRIPTOR_STATE) {
    		if (escapePressed || spacePressed || enterPressed) {
    			screen.playSoundEffect(1);
    			eventMenu(0);
    		}
    		return;
    	}
    	
    	
    	
    	
    	
    	
    	
    	if(PoglemonApp.gameState == PoglemonApp.PLAY_STATE) {
    		
	        if (leftPressed) {
	            ITile c = model.getTile(player.getTileX() - 1, player.getTileY());
	            AbstractObject o = model.getObject(player.getTileX() - 1, player.getTileY());
	            collision(c, "left", o);
	        }
	
	        if (rightPressed) {
	            ITile c = model.getTile(player.getTileX() + 1, player.getTileY());
	            AbstractObject o = model.getObject(player.getTileX() + 1, player.getTileY());
	            collision(c, "right", o);
	        }
	
	        if (upPressed) {
	            ITile c = model.getTile(player.getTileX(), player.getTileY() - 1);
	            AbstractObject o = model.getObject(player.getTileX(), player.getTileY() - 1);
	            collision(c, "up", o);
	        }
	
	        if (downPressed) {
	            ITile c = model.getTile(player.getTileX(), player.getTileY() + 1);
	            AbstractObject o = model.getObject(player.getTileX(), player.getTileY() + 1);
	            collision(c, "down", o);
	        }
	        
	        if(f3Pressed) {
				screen.getUIManager().setInfoOpen(!screen.getUIManager().getInfoOpen());
			}
	        
	        if(escapePressed) {
	        	PoglemonApp.gameState = PoglemonApp.PAUSE_STATE;
	        	screen.stopMusic();
	        }
	        
	        if(mPressed) {
	        	PoglemonApp.gameState = PoglemonApp.GAMEMENU_STATE;
	        }
	        return;
    	}
    }
	
	
	
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
				screen.getUIManager().setCommandNum(-1);
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
				screen.getUIManager().setCommandNum(-1);
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
			case 1:
			case 2:
			case 3:
			case 4:
			case 5:
				PoglemonApp.gameState = PoglemonApp.DESCRIPTOR_STATE;
				screen.getUIManager().setCommandNum(-1);
				break;
			case 6:
				PoglemonApp.gameState = PoglemonApp.GAMEMENU_STATE;
				screen.getUIManager().setCommandNum(-1);
				break;
				
	    	}
			return;
		}
		//DESCRIPTORSTATE
    	if(PoglemonApp.gameState == PoglemonApp.DESCRIPTOR_STATE) { 
    		switch(commandNum) {
    		case 0:
    			PoglemonApp.gameState = PoglemonApp.TEAM_STATE;
    			screen.getUIManager().setCommandNum(-1);
    			break;
    		}
    		return;
    	}
	}
	
	
	
	
	
	
	
	
	public void setKeyValue(boolean isActive, int key) {
    	if(key == KeyEvent.VK_UP || key == KeyEvent.VK_Z) {
  			 upPressed = isActive;
  		 }
    	if(key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
 			 downPressed = isActive;
 		 }
    	if(key == KeyEvent.VK_LEFT || key == KeyEvent.VK_Q) {
 			 leftPressed = isActive;
 		 }
    	if(key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
 			 rightPressed = isActive;
 		 }
    	if(key == KeyEvent.VK_ESCAPE) {
    		escapePressed = isActive;
    	}
    	if(key == KeyEvent.VK_M) {
    		mPressed = isActive;
    	}
    	if(key == KeyEvent.VK_SPACE) {
    		spacePressed = isActive;
    	}
    	if(key == KeyEvent.VK_F3) {
    		f3Pressed = isActive;
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
    		try {
				sem.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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
			sem.release();
    	}
    }

	
}
