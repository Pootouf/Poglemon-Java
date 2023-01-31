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
		g.setFont(font.deriveFont(Font.BOLD, getFontSize(40)));
		g.setStroke(new BasicStroke(getResizeX(3)));
		
		//Affichage de la boite
		int boxx = getResizeX(PoglemonApp.SPRITE_SIZEX);
		int boxy = getResizeY(PoglemonApp.SPRITE_SIZEY);
		int width = PoglemonApp.SCREEN_WIDTH - getResizeX(PoglemonApp.SPRITE_SIZEX * 2);
		int height = PoglemonApp.SCREEN_HEIGHT - getResizeY(PoglemonApp.SPRITE_SIZEY * 2);
		g.fillRoundRect(boxx, boxy, width, height, 10, 10);
		
		//Affichage des boites d'équipes
		int boxWidth = (width - getResizeX(200))/2;
		int boxHeight = (height - getResizeY(200))/4;
		int[] x = { boxx + getResizeX(50), boxx + getResizeX(50) + width/2, boxx + getResizeX(50), boxx + getResizeX(50) + width/2, boxx + getResizeX(50), boxx + getResizeX(50) + width/2};
		int[] y = {boxy + getResizeY(50), boxy + getResizeY(50), boxy + getResizeY(50) + height/4, boxy + getResizeY(50) + height/4, boxy + getResizeY(50) + 2*(height/4), boxy + getResizeY(50) + 2*(height/4)};
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
			g.drawImage(spriteTeam[i], x[i] + getResizeX(10), y[i], boxWidth / 3, boxHeight, null);
			g.drawString(nameTeam[i], x[i] + getResizeX(40) + (boxWidth / 3), y[i] + getResizeY(70));
			g.drawString("Niv: " + String.valueOf(levelTeam[i]), x[i] + getResizeX(400) + (boxWidth / 3), y[i] + getResizeY(70));
			createBar(g, x[i] + getResizeX(40) + (boxWidth / 3), y[i] + getResizeY(100), 0, 5.0, hpTeam[i] / hpMaxTeam[i]);
			createBar(g, x[i] + getResizeX(40) + (boxWidth / 3), y[i] + getResizeY(140), 1, 5.0, xpTeam[i] / xpMaxTeam[i]);
		}
		
		
		g.setFont(font.deriveFont(Font.BOLD, getFontSize(70)));
		
		//Affichage du bouton revenir
		String text = "Revenir";
		int textX = getCenterXForTextBox(text, g, width, boxx);
		int textY = (int)(boxy + height - getResizeY(100));
		createButton(g, textX, textY, commandTeamNum == 6, text, 0.2);
		
		
		//Affichage de la bordure
		g.setStroke(new BasicStroke(getResizeX(4)));
		g.drawRoundRect(boxx, boxy, width, height, 10, 10);
	}
	
	//OUTILS
	
	protected void createBar(Graphics2D g, int x, int y, int xpOrLife, double size, double proportion) {
		g.drawImage(EMPTY_BAR, x , y, (int)(getResizeX(100) * size), getResizeY(30), null);
		switch(xpOrLife) {
		case 0:
			g.drawImage(LIFE_BAR, x + getResizeX(19) , y + getResizeY(8), (int)(getResizeX(94) * size * proportion), getResizeY(15), null);
			break;
		case 1:
			g.drawImage(XP_BAR, x + getResizeX(19), y + getResizeY(8), (int)(getResizeX(94) * size * proportion), getResizeY(15), null);
		}
	}

}
