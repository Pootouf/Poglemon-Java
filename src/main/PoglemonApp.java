package main;

import java.awt.Color;
import java.io.IOException;
import java.util.concurrent.Semaphore;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import controler.EventHandler;
import controler.KeyControler;
import controler.MouseControler;
import model.Model;
import view.Screen;
import view.Sprite;
import view.SpritePlayer;



public class PoglemonApp {
	
	//CONSTANTES DE CLASSE
	
	//SCREEN_SETTING
	//Taille de l'écran en case
	public static int SCREEN_TILEX = 48;
	public static int SCREEN_TILEY = 32;
	//Taille des sprites en pixel
	public static int SPRITE_SIZEX = 32;
	public static int SPRITE_SIZEY = SPRITE_SIZEX;
	//Taille de l'écran en pixel
	public static int SCREEN_WIDTH = SCREEN_TILEX * SPRITE_SIZEX;
	public static int SCREEN_HEIGHT = SCREEN_TILEY * SPRITE_SIZEY;
	// MIN = 2 (une case dans chaque direction), affiche plus de cases hors de l'écran
	public static final int INCREASE_LOADING_SIZE = 2;
	//Zone qui sera chargée
	public static int LOADING_TILEX = SCREEN_TILEX + INCREASE_LOADING_SIZE;
	public static int LOADING_TILEY = SCREEN_TILEY + INCREASE_LOADING_SIZE;
	
	//WORLD_SETTING
	//Taille du monde en case
	public static int WORLD_TILEX = 32;
	public static int WORLD_TILEY = 32;
	
	//SYSTEM SETTING
	//Attente avant de détecter un appui de touche
	public static final int WAIT_BEFORE_ACTION = 100;
	//FPS
	public static int FPS = 200;
	//Semaphore bloquant l'affichage
	public Semaphore displayMovementSemaphore;
	
	//PLAYER_SETTING
	//Définit si le joueur peut passer à travers un mur
	public static boolean CAN_PASS_WALL = false;
	//Définit la vitesse du joueur
	public static double MOVE_SPEED = 2.0;
	
	//STATE_SETTING
	public static final int NUMBER_OF_STATE = 6;
	public static int gameState;
	public static final int TITLE_STATE = 0;
	public static final int PLAY_STATE = 1;
	public static final int PAUSE_STATE = 2;
	public static final int GAMEMENU_STATE = 3;
	public static final int TEAM_STATE = 4;
	public static final int DESCRIPTOR_STATE = 5;
	
	
	
	//ATTRIBUTS
	
	//EVENT
	private EventHandler eventHandler;
	
	//AFFICHAGE
	private static JFrame mainFrame;
	private static Screen ground;
	private SpritePlayer player;
	
	//SYSTEM
	private static int fps = FPS;
	
	
	//MODEL
	private Model model;
	
	
	
	//CONSTRUCTEURS
	public PoglemonApp() {
		gameState = TITLE_STATE;
		displayMovementSemaphore = new Semaphore(1, true);
		createModel();
		createView();
		placeComponents();
		createController();
	}
	
	
	//REQUETES
	
	public static int fps() {
		return fps;
	}
	
	
	
	//COMMANDES
	public void display() {
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		refresh();
		mainFrame.setVisible(true);
	}
	
	public static void setFps(int x) {
		fps = x;
	}
	
	
	//OUTILS
	private void createModel() {
		model = new Model();
	}
	
	
	
	
	private void createView( ) {
		mainFrame = new JFrame("Poglemon");
		mainFrame.getContentPane().setBackground(Color.black);
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
		
		try {
			mainFrame.setIconImage(ImageIO.read(getClass().getResourceAsStream("/sprite/icone.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		eventHandler = new EventHandler(ground, model, displayMovementSemaphore);
		KeyControler k = new KeyControler(eventHandler);
		mainFrame.addKeyListener(k);
		MouseControler mc = new MouseControler(ground, eventHandler);
		mainFrame.getContentPane().addMouseMotionListener(mc);
		mainFrame.getContentPane().addMouseListener(mc);
	}
	
	
	private void refresh() {
		ground.refresh(model);
		mainFrame.repaint();
	}
	

	

    
    //POINT D'ENTREE
  	public static void main(String[] args) {
  		PoglemonApp game = new PoglemonApp();
  		game.display();
  		new Thread(new Runnable() {
  			public void run() {
  				double drawInterval = 1000000000/FPS;
  				double delta = 0;
  				long lastTime = System.nanoTime();
  				long currentTime;
  				int drawCount = 0;
  				int timer = 0;
  				while(this != null) {
  					currentTime = System.nanoTime();
  					delta += (currentTime - lastTime)/drawInterval;
  					timer += (currentTime - lastTime);
  					lastTime = currentTime;
  					if(delta >= 1) {
  						try {
							game.displayMovementSemaphore.acquire();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
  						game.refresh();
  						game.displayMovementSemaphore.release();
  						delta--;
  						drawCount++;
  					}
  					if(timer > 1000000000) {
  						fps = drawCount;
  						timer = 0;
  						drawCount = 0;
  					}
  				}
  			}
  		}).start();
  	}
  	
  	public static void quit() {
  		System.exit(0);
  	}
	
}