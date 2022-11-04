package controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.TestGame;
import model.ITile;
import model.Model;
import model.Player;
import view.Screen;

public class PlayerControler implements KeyListener {
	
	//ATTRIBUTS

	private long lastPressProcessed = 0;
	
	private Model model;
	
	private Screen screen;
	
	
	//CONSTRUCTEURS
	public PlayerControler(Model m, Screen s) {
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
   	 if(System.currentTimeMillis() - lastPressProcessed > TestGame.WAIT_BEFORE_ACTION) {
   		 onKeyPressed(e.getKeyCode());
   		 lastPressProcessed = System.currentTimeMillis();
   	 }
    }
    
    public void onKeyPressed(int key) { 
    	Player player = model.getPlayer();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_Q) {
            ITile c = model.getTile(player.getTileX() - 1, player.getTileY());
            if(c == null){
            	move("left");
                return;
            }
            if(c.isWall() && TestGame.CAN_PASS_WALL == false){
               return;
            }
            move("left");
        }

        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) {
            ITile c = model.getTile(player.getTileX() + 1, player.getTileY());
            if(c == null){
            	move("right");
                return;
            }
            if(c.isWall() && TestGame.CAN_PASS_WALL == false){
                return;
            }
            move("right");
        }

        if (key == KeyEvent.VK_UP || key == KeyEvent.VK_Z) {
            ITile c = model.getTile(player.getTileX(), player.getTileY() - 1);
            if(c == null){
            	move("up");
                return;
            }
            if(c.isWall() && TestGame.CAN_PASS_WALL == false){
               return;
            }
            move("up");
        }

        if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
            ITile c = model.getTile(player.getTileX(), player.getTileY() + 1);
            if(c == null){
                move("down");
                return;
            }
            if(c.isWall() && TestGame.CAN_PASS_WALL == false){
                return;
            }
            move("down");
        }
    }
    
    //OUTILS
    
    private void move(String direction) {
    	Player player = model.getPlayer();
    	for (int i = 0; i < TestGame.SPRITE_SIZEX; i++) {
			switch(direction) {
				case "up":
					player.moveUp();
					break;
				case "down":
					player.moveDown();
					break;
				case "left":
					player.moveLeft();
					break;
				case "right":
					player.moveRight();
					break;
			}
			screen.refresh(model);
			screen.paintImmediately(0, 0, screen.getWidth(), screen.getWidth());
    	}
    }

}
