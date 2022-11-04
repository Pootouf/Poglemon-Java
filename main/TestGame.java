package main;

import java.util.Observable;
import java.util.Observer;
import java.lang.SuppressWarnings;

import javax.swing.JFrame;

import controler.PlayerControler;
import model.Model;
import view.Screen;
import view.Sprite;
import view.SpritePlayer;

@SuppressWarnings("deprecation")
public class TestGame {
	
	//CONSTANTES DE CLASSE
	
	//Taille de l'écran en case
	public static int SCREEN_TILEX = 24;
	public static int SCREEN_TILEY = 16;
	
	// MIN = 2 (une case dans chaque direction), affiche plus de cases hors de l'écran
	public static final int INCREASE_LOADING_SIZE = 2;
	
	//Zone qui sera chargée
	public static int LOADING_TILEX = SCREEN_TILEX + INCREASE_LOADING_SIZE;
	public static int LOADING_TILEY = SCREEN_TILEY + INCREASE_LOADING_SIZE;
	
	//Taille du monde en case
	public static int WORLD_TILEX = 2000;
	public static int WORLD_TILEY = 2000;
	
	//Taille des sprites en pixel
	public static int SPRITE_SIZEX = 64;
	public static int SPRITE_SIZEY = SPRITE_SIZEX;
	
	//Taille de l'écran en pixel
	public static int SCREEN_WIDTH = SCREEN_TILEX * SPRITE_SIZEX;
	public static int SCREEN_HEIGHT = SCREEN_TILEY * SPRITE_SIZEY;
	
	//Nombre de FPS
	public static int FPS = 60;
	
	//Attente avant de détecter un appui de touche
	public static final int WAIT_BEFORE_ACTION = 5;
	
	//Définit si le joueur peut passer à travers un mur
	public static boolean CAN_PASS_WALL = false;
	
	
	
	//ATTRIBUTS
	private static JFrame mainFrame;
	private static Screen ground;
	private SpritePlayer player;
	
	private Model model;
	
	
	
	//CONSTRUCTEURS
	public TestGame() {
		createModel();
		createView();
		placeComponents();
		createController();
	}
	
	
	
	//COMMANDES
	public void display() {
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		refresh();
		mainFrame.setVisible(true);
	}
	
	
	//OUTILS
	private void createModel() {
		model = new Model();
	}
	
	
	
	
	private void createView( ) {
		mainFrame = new JFrame("GameTest");
		Sprite[][] tileTab = new Sprite[LOADING_TILEX][LOADING_TILEY];
		for (int i = 0; i < LOADING_TILEX; i++) {
			for (int j = 0; j < LOADING_TILEY; j++) {
				tileTab[i][j] = new Sprite(null, i - INCREASE_LOADING_SIZE/2, j - INCREASE_LOADING_SIZE/2);
			}
		}
		player = new SpritePlayer(null, SCREEN_TILEX/2, SCREEN_TILEY/2);
		ground = new Screen(tileTab, player);
	}
	
	
	
	
	private void placeComponents() {
		mainFrame.add(ground);
		mainFrame.validate();
	}
	
	
	
	private void createController() {
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		
		mainFrame.addKeyListener(new PlayerControler(model, ground));
		
		model.addObserver(new Observer() {
			public void update(Observable o, Object arg) {
				refresh();
			}

		});
		
		model.getPlayer().addObserver(new Observer() {
			public void update(Observable o, Object arg) {
				refresh();
			}

		});
	}
	
	
	private void refresh() {
		ground.refresh(model);
		mainFrame.repaint();
	}
	

	

    
    //POINT D'ENTREE
  	public static void main(String[] args) {
  		TestGame game = new TestGame();
  		game.display();
  		new Thread(new Runnable() {
  			public void run() {
  				double drawInterval = 1000000000/FPS;
  				double delta = 0;
  				long lastTime = System.nanoTime();
  				long currentTime;
  				while(this != null) {
  					currentTime = System.nanoTime();
  					delta += (currentTime - lastTime)/drawInterval;
  					lastTime = currentTime;
  					if(delta >= 1) {
  						game.refresh();
  						delta--;
  					}
  				}
  			}
  		}).start();
  	}
	
}