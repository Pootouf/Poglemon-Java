package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import main.PoglemonApp;
import main.Sound;
import model.Model;
import view.ui.UIManager;

public class Screen extends JComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2639014668996167781L;
	
	
	
	//ATTRIBUTS
	
	private SpritePlayer playerSprite;
	
	private TileManager spriteManager;
	
	private ObjectManager objectManager;
	
	private UIManager uiManager;
	
	private Sound music;
	
	private Sound soundEffect;
	
	
	//CONSTRUCTEURS
	
	public Screen(Sprite[][] tab, SpritePlayer playerSprite) {
		spriteManager = new TileManager(tab);
		objectManager = new ObjectManager();
		uiManager = new UIManager();
		music = new Sound();
		soundEffect = new Sound();
		this.playerSprite = playerSprite;
		this.setPreferredSize(new Dimension(PoglemonApp.SCREEN_WIDTH, PoglemonApp.SCREEN_HEIGHT));
		this.setDoubleBuffered(false);
	}
	
	//REQUETES
	
	public UIManager uiManager() {
		return uiManager;
	}
	
	
	//COMMANDES
	
	public void refresh(Model m) {
		if(PoglemonApp.gameState == PoglemonApp.PLAY_STATE) {
			//Rafraichissement des tuiles
			spriteManager.refresh(m, playerSprite);
			
			//Rafraichissement du joueur
			playerSprite.setSprite(m.getPlayer().getSprite());
			
			//Rafraichissement des objets
			objectManager.refresh(m, playerSprite);
		}
		
		
		//Rafraichissement de l'affichage de l'UI
		uiManager.refresh(m);
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		
		if(PoglemonApp.gameState == PoglemonApp.PLAY_STATE || PoglemonApp.gameState == PoglemonApp.PAUSE_STATE || PoglemonApp.gameState == PoglemonApp.GAMEMENU_STATE || PoglemonApp.gameState == PoglemonApp.TEAM_STATE) {
		
			spriteManager.draw(g2D);
		
			playerSprite.draw(g2D);
		
			objectManager.draw(g2D);
		}
		
		uiManager.draw(g2D);
		
		g2D.dispose();
	}
	
	
	public void playMusic(int i) {
		music.setFile(i);
		music.play();
		music.loop();
	}
	
	public void stopMusic() {
		music.stop();
	}
	
	public void playSoundEffect(int i) {
		soundEffect.setFile(i);
		soundEffect.play();
	}

}