package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.JComponent;

import main.TestGame;
import model.Model;
import model.Player;

public class Screen extends JComponent {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2639014668996167781L;
	
	
	
	//ATTRIBUTS
	
	private Sprite[][] spriteTab;
	
	private SpritePlayer playerSprite;
	
	private int animx;
	private int animy;
	
	
	//CONSTRUCTEURS
	
	public Screen(Sprite[][] tab, SpritePlayer playerSprite) {
		spriteTab = tab;
		this.playerSprite = playerSprite;
		this.setPreferredSize(new Dimension(TestGame.SCREEN_WIDTH, TestGame.SCREEN_HEIGHT));
		this.setDoubleBuffered(true);
	}
	
	
	//COMMANDES
	
	public void refresh(Model m) {
		Player player = m.getPlayer();
		for (int i = 0; i < TestGame.LOADING_TILEX; i++) {
			for (int j = 0; j < TestGame.LOADING_TILEY; j++) {
				int tilex = i + player.getTileX() - playerSprite.getTileScreenX() - TestGame.INCREASE_LOADING_SIZE/2;
				int tiley = j + player.getTileY() - playerSprite.getTileScreenY() - TestGame.INCREASE_LOADING_SIZE/2;
				Image sprite = m.getTile(tilex, tiley).getSprite();
				spriteTab[i][j].setSprite(sprite);
			}
		}
		Image sprite = player.getSprite();
		playerSprite.setSprite(sprite);
		animx = player.getTileX() * TestGame.SPRITE_SIZEX - player.getPixelX();
		animy = player.getTileY() * TestGame.SPRITE_SIZEY - player.getPixelY();
	}
	
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D) g;
		for (int i = 0; i < TestGame.LOADING_TILEX; i++) {
			for (int j = 0; j < TestGame.LOADING_TILEY; j++) {
				Sprite s = spriteTab[i][j];
				g2D.drawImage(s.getSprite(), s.getScreenX() + animx, s.getScreenY() + animy, TestGame.SPRITE_SIZEX, TestGame.SPRITE_SIZEY, null);
			}
		}
		g2D.drawImage(playerSprite.getSprite(), playerSprite.getScreenX(), playerSprite.getScreenY(), TestGame.SPRITE_SIZEX, TestGame.SPRITE_SIZEY, null);
	}

}