package controler;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class KeyControler implements KeyListener {
	
	
	//ATTRIBUTS
	
	private EventHandler eventHandler;
	
	
	//CONSTRUCTEURS
	public KeyControler(EventHandler e) {
		eventHandler = e;
		new Thread(new Runnable() {
			@Override
			public void run() {
				while(true) {
					eventHandler.onKeyPressed();
				}
			}
		}).start();
	}
	
	
	
	
	//COMMANDES

	@Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
    	int key = e.getKeyCode();
  		eventHandler.setKeyValue(false, key);
    }

    @Override
    public void keyPressed(KeyEvent e){
    	 int key = e.getKeyCode();
   		 eventHandler.setKeyValue(true, key);
    }
    

}
