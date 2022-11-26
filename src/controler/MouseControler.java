package controler;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import main.PoglemonApp;
import model.Model;
import view.Screen;

public class MouseControler extends MouseAdapter {
	
	//ATTRIBUTS
	private Model model;
	private Screen screen;
	
	
	
	
	//CONSTRUCTEURS
	public MouseControler(Model m, Screen s) {
		model = m;
		screen = s;
	}
		
	
	
	
	//COMMANDES
	
	@Override
	public void mouseMoved(MouseEvent e) {
		
		int mouseX = e.getX();
		int mouseY = e.getY();
		view.ui.UIManager ui = screen.uiManager();
		
		if(PoglemonApp.gameState == PoglemonApp.MENU_STATE) {
			
		}
		
	}

}
