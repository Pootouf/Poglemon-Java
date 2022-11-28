package controler;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputAdapter;

import view.Screen;

public class MouseControler extends MouseInputAdapter {
	
	//ATTRIBUTS
	private KeyControler controler;
	private Screen screen;
	
	
	
	
	//CONSTRUCTEURS
	public MouseControler(KeyControler k, Screen s) {
		controler = k;
		screen = s;
	}
		
	
	
	
	//COMMANDES
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
		int mouseX = e.getX();
		int mouseY = e.getY();
		view.ui.UIManager ui = screen.uiManager();
		
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
		view.ui.UIManager ui = screen.uiManager();
		
		int i = ui.isButton(mouseX, mouseY);
		if(i != -1 && ui.getCommandNum() != i) {
			screen.playSoundEffect(1);
		}
		ui.setCommandNum(i);
		controler.eventMenu(i);
	}

}
