package view.ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.PoglemonApp;
import model.Model;

public class TeamMenuUI extends DefaultUI {
	
	//CONSTANTES DE CLASSES
	private static BufferedImage EMPTY_BAR;
	private static BufferedImage LIFE_BAR;
	private static BufferedImage XP_BAR;
	
	
	//ATTRIBUTS
	private BufferedImage[] spriteTeam = new BufferedImage[6];
	private String[] nameTeam = new String[6];
	private int[] levelTeam = new int[6];
	private double[] hpTeam = new double[6];
	private double[] hpMaxTeam = new double[6];
	private double[] xpTeam = new double[6];
	private double[] xpMaxTeam = new double[6];
	private boolean[] isInit = new boolean[6];

	
	//CONSTRUCTEURS
	public TeamMenuUI(int numberOfOption, Font font) {
		super(numberOfOption, font);
		try {
			EMPTY_BAR = ImageIO.read(getClass().getResourceAsStream(SPRITE_LOC + "empty_bar.png"));
			LIFE_BAR = ImageIO.read(getClass().getResourceAsStream(SPRITE_LOC + "life_bar.png"));
			XP_BAR = ImageIO.read(getClass().getResourceAsStream(SPRITE_LOC + "xp_bar.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	//COMMANDES
	@Override
	protected void refresh(Model m) {
		for (int i = 0; i < 6; i++) {
			if(m.getPoglemonTeam(i) == null) {
				continue;
			}
			spriteTeam[i] = m.getPoglemonTeam(i).getSprite();
			nameTeam[i] = m.getPoglemonTeam(i).name();
			levelTeam[i] = m.getPoglemonTeam(i).niveau();
			hpTeam[i] = m.getPoglemonTeam(i).hp();
			hpMaxTeam[i] = m.getPoglemonTeam(i).hpTotal();
			xpTeam[i] = m.getPoglemonTeam(i).xp();
			xpMaxTeam[i] = m.getPoglemonTeam(i).xpLevel();
			isInit[i] = m.getPoglemonTeam(i).isInit();
		}
	}

	@Override
	protected void drawState(Graphics2D g) {
		int commandTeamNum = getCommandNum();
		Font font = getFont();
		
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(font.deriveFont(Font.BOLD, (float)(PoglemonApp.SPRITE_SIZEX*((PoglemonApp.SCREEN_TILEX * 1f) / 24f))));
		g.setStroke(new BasicStroke(PoglemonApp.SPRITE_SIZEX / 16));
		
		//Affichage de la boite
		int boxx = (int)(PoglemonApp.SPRITE_SIZEX * ((PoglemonApp.SCREEN_TILEX * 1f) / 24f));
		int boxy = (int)(PoglemonApp.SPRITE_SIZEY * ((PoglemonApp.SCREEN_TILEY * 1f) / 16f));
		int width = (int)(PoglemonApp.SCREEN_WIDTH - PoglemonApp.SPRITE_SIZEX * ((PoglemonApp.SCREEN_TILEX * 2f) / 24f));
		int height = (int)(PoglemonApp.SCREEN_HEIGHT - PoglemonApp.SPRITE_SIZEY * ((PoglemonApp.SCREEN_TILEY * 1f) / 16f));
		g.fillRoundRect(boxx, boxy, width, height, 10, 10);
		
		//Affichage des boites d'équipes
		int boxWidth = (int)((width - PoglemonApp.SPRITE_SIZEX * ((PoglemonApp.SCREEN_TILEX * 4f) / 24f)) / 2);
		int boxHeight = (int)((height - PoglemonApp.SPRITE_SIZEY * ((PoglemonApp.SCREEN_TILEY * 2f) / 16f)) / 4);
		int[] x = {(int)(boxx + PoglemonApp.SPRITE_SIZEX * ((PoglemonApp.SCREEN_TILEX * 1f) / 24f)), (int)(boxx + PoglemonApp.SPRITE_SIZEX * ((PoglemonApp.SCREEN_TILEX * 1f) / 24f) + width/2), (int)(boxx + PoglemonApp.SPRITE_SIZEX * ((PoglemonApp.SCREEN_TILEX * 1f) / 24f)), (int)(boxx + PoglemonApp.SPRITE_SIZEX * ((PoglemonApp.SCREEN_TILEX * 1f) / 24f) + width/2), (int)(boxx + PoglemonApp.SPRITE_SIZEX * ((PoglemonApp.SCREEN_TILEX * 1f) / 24f)), (int)(boxx + PoglemonApp.SPRITE_SIZEX * ((PoglemonApp.SCREEN_TILEX * 1f) / 24f) + width/2)};
		int[] y = {(int)(boxy + PoglemonApp.SPRITE_SIZEY * ((PoglemonApp.SCREEN_TILEY * 1f) / 16f)), (int)(boxy + PoglemonApp.SPRITE_SIZEY * ((PoglemonApp.SCREEN_TILEY * 1f) / 16f)), (int)(boxy + PoglemonApp.SPRITE_SIZEY * ((PoglemonApp.SCREEN_TILEY * 1f) / 16f) + height/4), (int)(boxy + PoglemonApp.SPRITE_SIZEY * ((PoglemonApp.SCREEN_TILEY * 1f) / 16f) + height/4), (int)(boxy + PoglemonApp.SPRITE_SIZEY * ((PoglemonApp.SCREEN_TILEY * 1f) / 16f) + 2*(height/4)), (int)(boxy + PoglemonApp.SPRITE_SIZEY * ((PoglemonApp.SCREEN_TILEY * 1f) / 16f) + 2*(height/4))};
		for (int i = 0; i < 6; i++) {
			if (commandTeamNum == i) {
				g.setColor(Color.gray);
			} else {
				g.setColor(Color.DARK_GRAY);
			}
			g.fillRoundRect(x[i], y[i], boxWidth, boxHeight, 10, 10);
			addListButton(x[i], y[i], boxWidth, boxHeight);
		}
		g.setColor(Color.black);
		for (int i = 0; i < 6; i++) {
			g.drawRoundRect(x[i], y[i], boxWidth, boxHeight, 10, 10);
		}
		
		//Affichage des sprites
		for (int i = 0; i < 6; i++) {
			if(!isInit[i]) {
				continue;
			}
			g.drawImage(spriteTeam[i], x[i] + (int)(PoglemonApp.SPRITE_SIZEX * ((PoglemonApp.SCREEN_TILEX * 0.3f) / 24f)), y[i], boxWidth / 3, boxHeight, null);
			g.drawString(nameTeam[i], x[i] + PoglemonApp.SPRITE_SIZEX*((PoglemonApp.SCREEN_TILEX * 1f) / 24f) + boxHeight, (int)(y[i] + PoglemonApp.SPRITE_SIZEY*((PoglemonApp.SCREEN_TILEY * 1f) / 16f)));
			g.drawString("Niv: " + String.valueOf(levelTeam[i]), x[i] + PoglemonApp.SPRITE_SIZEX*((PoglemonApp.SCREEN_TILEX * 1f) / 24f) + boxHeight, (int)(y[i] + PoglemonApp.SPRITE_SIZEY*((PoglemonApp.SCREEN_TILEY * 3f) / 16f)));
			createBar(g, x[i] + (int)(PoglemonApp.SPRITE_SIZEX * ((PoglemonApp.SCREEN_TILEX * 0.8f) / 24f)) + boxHeight, (int)(y[i] + PoglemonApp.SPRITE_SIZEY*((PoglemonApp.SCREEN_TILEY * 1.3f) / 16f)), 0, 5.0, hpTeam[i] / hpMaxTeam[i]);
			createBar(g, x[i] + (int)(PoglemonApp.SPRITE_SIZEX * ((PoglemonApp.SCREEN_TILEX * 0.8f) / 24f)) + boxHeight, (int)(y[i] + PoglemonApp.SPRITE_SIZEY*((PoglemonApp.SCREEN_TILEY * 1.7f) / 16f)), 1, 5.0, xpTeam[i] / xpMaxTeam[i]);
		}
		
		
		g.setFont(font.deriveFont(Font.BOLD, (PoglemonApp.SPRITE_SIZEX*((PoglemonApp.SCREEN_TILEX * 1f) / 24f))));
		
		//Affichage du bouton revenir
		String text = "Revenir";
		int textX = getCenterXForTextBox(text, g, width, boxx);
		int textY = (int)(boxy + height - PoglemonApp.SPRITE_SIZEY* ((PoglemonApp.SCREEN_TILEY * 1f) / 16f));
		createButton(g, textX, textY, commandTeamNum == 6, text, 0.2);
		
		
		//Affichage de la bordure
		g.drawRoundRect(boxx, boxy, width, height, 10, 10);
	}
	
	//OUTILS
	
	protected void createBar(Graphics2D g, int x, int y, int xpOrLife, double size, double proportion) {
		g.drawImage(EMPTY_BAR, x , y, (int)(PoglemonApp.SPRITE_SIZEX *((PoglemonApp.SCREEN_TILEX * 1f) / 24f) * size), (int)(PoglemonApp.SPRITE_SIZEY * ((PoglemonApp.SCREEN_TILEY * 1f) / 16f))/3, null);
		switch(xpOrLife) {
		case 0:
			g.drawImage(LIFE_BAR, x + (int)(PoglemonApp.SPRITE_SIZEX*((PoglemonApp.SCREEN_TILEX * 0.2f) / 24f)) , y + (int)(PoglemonApp.SPRITE_SIZEY*((PoglemonApp.SCREEN_TILEY * 0.1f) / 16f)), (int)(PoglemonApp.SPRITE_SIZEX*((PoglemonApp.SCREEN_TILEX * 0.93f) / 24f) * size * proportion), (int)(PoglemonApp.SPRITE_SIZEY*((PoglemonApp.SCREEN_TILEY * 0.15f) / 16f)), null);
			break;
		case 1:
			g.drawImage(XP_BAR, x + (int)(PoglemonApp.SPRITE_SIZEX *((PoglemonApp.SCREEN_TILEX * 0.2f) / 24f)), y + (int)(PoglemonApp.SPRITE_SIZEY*((PoglemonApp.SCREEN_TILEY * 0.1f) / 16f)), (int)(PoglemonApp.SPRITE_SIZEX*((PoglemonApp.SCREEN_TILEX * 0.93f) / 24f) * size * proportion), (int)(PoglemonApp.SPRITE_SIZEY*((PoglemonApp.SCREEN_TILEY * 0.15f) / 16f)), null);
		}
	}

}
