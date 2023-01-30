package controler;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

import view.Screen;

public class MouseControler extends MouseInputAdapter {
	
	//ATTRIBUTS
	private Screen screen;
	private EventHandler eventHandler;
	
	
	
	
	//CONSTRUCTEURS
	public MouseControler(Screen s, EventHandler e) {
		screen = s;
		eventHandler = e;
	}
		
	
	
	
	//COMMANDES
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
		int mouseX = e.getX();
		int mouseY = e.getY();
		view.ui.UIManager ui = screen.getUIManager();
		
		int i = ui.isButton(mouseX, mouseY);
		if(i != -1 && ui.getCommandNum() != i) {
			screen.playSoundEffect(1);
		}
		ui.setCommandNum(i);
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		int mouseX = e.getX();
		int mouseY = e.getY();
		view.ui.UIManager ui = screen.getUIManager();
		
		int i = ui.isButton(mouseX, mouseY);
		if(i != -1 && ui.getCommandNum() != i) {
			screen.playSoundEffect(1);
		}
		ui.setCommandNum(i);
		eventHandler.eventMenu(i);
	}

}
