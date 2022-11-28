package view.ui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.IOException;
import java.io.InputStream;

import main.PoglemonApp;
import model.Model;

public class UIManager {
	
	//CONSTANTES DE CLASSE
	
	public static final int TITLE_MENU_OPTION = 4;
	public static final int GAME_MENU_OPTION = 6;
	public static final int TEAM_MENU_OPTION = 7;
	public static final int PLAY_MENU_OPTION = 1;
	public static final int PAUSE_MENU_OPTION = 0;
	public static final int DESCRIPTOR_MENU_OPTION = 1;
	
	//ATTRIBUTS
	
	private Font font;
	
	private DefaultUI ui[] = new DefaultUI[PoglemonApp.NUMBER_OF_STATE];
	
	
	//CONSTRUCTEURS
	
	public UIManager() {
		//Initialisation du font
		InputStream is = null;
		is = getClass().getResourceAsStream("/font/Minecraft.ttf");
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, is);
		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		try {
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		font = font.deriveFont((float) PoglemonApp.SPRITE_SIZEX / 2);
		
		//Initialisation des menus
		ui[PoglemonApp.TITLE_STATE] = new TitleMenuUI(TITLE_MENU_OPTION, font);
		ui[PoglemonApp.PLAY_STATE] = new PlayMenuUI(PLAY_MENU_OPTION, font); 
		ui[PoglemonApp.PAUSE_STATE] = new PauseMenuUI(PAUSE_MENU_OPTION, font);
		ui[PoglemonApp.GAMEMENU_STATE] = new GameMenuUI(GAME_MENU_OPTION, font);
		ui[PoglemonApp.TEAM_STATE] = new TeamMenuUI(TEAM_MENU_OPTION, font); 
		ui[PoglemonApp.DESCRIPTOR_STATE] = new DescriptorMenuUI(DESCRIPTOR_MENU_OPTION, font);
	}
	
	
	//REQUETES
	
	public boolean getInfoOpen() {
		return ((PlayMenuUI)ui[PoglemonApp.PLAY_STATE]).getInfoOpen();
	}
	
	public int getCommandNum() {
		return ui[PoglemonApp.gameState].getCommandNum();
	}
	
	
	//Controle des boutons à la souris
	public int isButton(int x, int y) {
		for(int i = 0; i < ui[PoglemonApp.gameState].getNumberOfOption() ; i++) {
			if(ui[PoglemonApp.gameState].isButton(x, y, i)) {
				return i;
			}
		}
		return -1;
	}
		
	
	//COMMANDES
	
	public void refresh(Model m) {
		ui[PoglemonApp.gameState].refresh(m);
	}
	
	public void setInfoOpen(boolean b) {
		((PlayMenuUI)ui[PoglemonApp.PLAY_STATE]).setInfoOpen(b);
	}
	
	public void increaseCommandNum(int x) {
		ui[PoglemonApp.gameState].increaseCommandNum(x);
	}
	
	public void setCommandNum(int x) {
		ui[PoglemonApp.gameState].setCommandNum(x);
	}
	
	
	public void draw(Graphics2D g) {
		ui[PoglemonApp.gameState].drawState(g);
	}
	
	
}
