package view.ui;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics2D;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import main.PoglemonApp;
import model.Model;

public class UIManager {
	
	//CONSTANTES DE CLASSE
	
	public static final int TITLE_MENU_OPTION = 4;
	public static final int GAME_MENU_OPTION = 6;
	public static final int TEAM_MENU_OPTION = 7;
	public static final int INFO_MENU_OPTION = 0;
	public static final int PAUSE_MENU_OPTION = 0;
	
	//ATTRIBUTS
	
	private Font font;
	
	private TitleMenuUI titleMenu;
	private GameMenuUI gameMenu;
	private TeamMenuUI teamMenu;
	private InfoMenuUI infoMenu;
	private PauseMenuUI pauseMenu;
	
	
	//CONSTRUCTEURS
	
	public UIManager() {
		//Initialisation du font
		InputStream is = null;
		try {
			is = new FileInputStream("res/font/Minecraft.ttf");
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
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
		titleMenu = new TitleMenuUI(TITLE_MENU_OPTION, font);
		gameMenu = new GameMenuUI(GAME_MENU_OPTION, font);
		teamMenu = new TeamMenuUI(TEAM_MENU_OPTION, font);
		infoMenu = new InfoMenuUI(INFO_MENU_OPTION, font);
		pauseMenu = new PauseMenuUI(PAUSE_MENU_OPTION, font);
	}
	
	
	//REQUETES
	
	public boolean getInfoOpen() {
		return infoMenu.getInfoOpen();
	}
	
	public int getCommandNum() {
		return titleMenu.getCommandNum();
	}
	
	public int getCommandGameMenuNum() {
		return gameMenu.getCommandNum();
	}
	
	public int getCommandTeamMenuNum() {
		return teamMenu.getCommandNum();
	}
		
	
	//COMMANDES
	
	public void refresh(Model m) {
		if(PoglemonApp.gameState == PoglemonApp.PLAY_STATE) {
			infoMenu.refresh(m);
		}
		if(PoglemonApp.gameState == PoglemonApp.TEAM_STATE) {
			teamMenu.refresh(m);
		}
	}
	
	public void setInfoOpen(boolean b) {
		infoMenu.setInfoOpen(b);
	}
	
	public void increaseCommandNum(int x) {
		titleMenu.increaseCommandNum(x);
	}
	
	public void increaseCommandGameMenuNum(int x) {
		gameMenu.increaseCommandNum(x);
	}
	
	public void increaseCommandTeamMenuNum(int x) {
		teamMenu.increaseCommandNum(x);
	}
	
	
	
	public void draw(Graphics2D g) {
		//PLAYSTATE
		if(PoglemonApp.gameState == PoglemonApp.PLAY_STATE) {
			infoMenu.drawState(g);
		}
		//MENUSTATE
		if(PoglemonApp.gameState == PoglemonApp.MENU_STATE) {
			titleMenu.drawState(g);
		}
		//PAUSESTATE
		if(PoglemonApp.gameState == PoglemonApp.PAUSE_STATE) {
			pauseMenu.drawState(g);
		}
		//GAMEMENUSTATE
		if(PoglemonApp.gameState == PoglemonApp.GAMEMENU_STATE) {
			gameMenu.drawState(g);
		}
		//TEAMSTATE
		if(PoglemonApp.gameState == PoglemonApp.TEAM_STATE) {
			teamMenu.drawState(g);
		}
	}
	
	
}
