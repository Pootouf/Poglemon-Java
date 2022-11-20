package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import main.PoglemonApp;
import model.object.AbstractObject;
import model.tile.DirtTile;
import model.tile.FlowerTile;
import model.tile.GrassTile;
import model.tile.MonoTile;
import model.tile.NothingTile;
import model.tile.PathTile;
import model.tile.PlankTile;
import model.tile.TallGrassTile;
import model.tile.Tile;
import model.tile.WallTile;
import model.tile.WaterTile;
import model.tile.tree.TreeTile;

public class Model{
	
	//CONSTANTES DE CLASSES
	
	public static int NUMBER_OF_TILE = 100;
	
	private static Tile GROUND = new GrassTile();
	
	public static Tile[] mapTile;
	{
		mapTile = new Tile[NUMBER_OF_TILE];
		for(int i = 0; i <10; i++) {
			mapTile[i] = GROUND;
		}
		mapTile[11] = new WallTile();
		mapTile[12] = new PlankTile();
		mapTile[13] = new MonoTile();
		mapTile[14] = new FlowerTile();
		mapTile[15] = new DirtTile();
		mapTile[16] = new TallGrassTile();
		mapTile[17] = new TreeTile();
		mapTile[18] = new NothingTile();
		
		for(int i = 19; i < WaterTile.WATER_TILE_NUMBER + 19; i++) {
			mapTile[i] = new WaterTile(i - 19);
		}
		
		for(int i = 33; i < PathTile.PATH_TILE_NUMBER + 33; i++) {
			mapTile[i] = new PathTile(i - 33);
		}
		mapTile[55] = new PlankTile();
		
		for(int i = 0; i < NUMBER_OF_TILE; i++) {
			if(mapTile[i] == null) {
				continue;
			}
			mapTile[i].resizeSprite();
		}
	}
	
	
	//ATTRIBUTS
	private Tile[][] map = new Tile[PoglemonApp.WORLD_TILEX][PoglemonApp.WORLD_TILEY];
	
	private Player player;
	
	private List<AbstractObject> objectList;
	
	private Poglemon poglemon = new Poglemon(1, null, 5, true);
	
	
	
	//CONSTRUCTEURS
	public Model() {
		for (int i = 0; i < PoglemonApp.WORLD_TILEX; i++) {
			for (int j = 0; j < PoglemonApp.WORLD_TILEY; j++) { 
				map[i][j] = GROUND;
			}
		}
		loadMap();
		player = new Player();
		objectList = new ArrayList<AbstractObject>();
		AbstractObject.initObject(objectList);
	}
	
	
	
	//REQUETES
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0 || x >= PoglemonApp.WORLD_TILEX || y >= PoglemonApp.WORLD_TILEY) {
			if(x % 2 == 0 && y % 2 == 0) {
				return mapTile[17];
			}
			return mapTile[18];
		}
		if(map == null) {
			return null;
		}
		Tile t = map[x][y];
		return (t == null) ? GROUND : t;
	}
	
	public Player getPlayer() {
		return player; 
	}
	
	public AbstractObject getObject(int x) {
		return objectList.get(x);
	}
	
	public int numberObject() {
		return objectList.size();
	}
	
	public AbstractObject getObject(int x, int y) {
		return AbstractObject.objectTab[x][y];
	}
	
	
	
	//COMMANDES
	
	public void loadMap() {
		InputStream is = getClass().getResourceAsStream("/save/map.txt");
		BufferedReader br = new BufferedReader(new InputStreamReader(is));
		String line = "";
		int i = 0;
		try {
			while((line = br.readLine()) != null) {
				String[] numbers = line.split(" ");
				
				for (int j = 0; j < numbers.length; j++) {
					int num = Integer.parseInt(numbers[j]);
					map[j][i] = mapTile[num];
				}
				i++;
			}
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
