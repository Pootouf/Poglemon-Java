package model;

import java.util.Observable;

import main.TestGame;

@SuppressWarnings("deprecation")
public class Model extends Observable {
	
	//CONSTANTES DE CLASSES
	
	public static int SIZE_HOUSE = 8;
	
	private static Tile GROUND = new DirtTile();
	
	
	//ATTRIBUTS
	private Tile[][] map;
	private Player player;
	
	
	
	//CONSTRUCTEURS
	public Model() {
		map = new Tile[TestGame.WORLD_TILEX][TestGame.WORLD_TILEY];
		for (int i = 0; i < TestGame.WORLD_TILEX; i++) {
			for (int j = 0; j < TestGame.WORLD_TILEY; j++) { 
				map[i][j] = new DirtTile();
			}
		}
		createMap();
		player = new Player();
	}
	
	
	
	//REQUETES
	public Tile getTile(int x, int y) {
		if(x < 0 || y < 0) {
			return GROUND;
		}
		return map[x][y];
	}
	
	public Player getPlayer() {
		return player; 
	}
	
	
	//OUTILS
	
	private void createMap() {
		for(int i = 1; i < SIZE_HOUSE - 1; i++){
            for(int j = 1; j < SIZE_HOUSE - 1; j++){
            	map[i][j] = new MonoTile();
            }
        }
        for(int i = 0; i < SIZE_HOUSE; i++){
        	map[i][0] = new WallTile();
        }
        for(int i = 0; i < SIZE_HOUSE; i++){
        	map[i][SIZE_HOUSE - 1] = new WallTile();
        }
        for(int j = 0; j < SIZE_HOUSE; j++){
        	map[0][j] = new WallTile();
        }
        for(int j = 0; j < SIZE_HOUSE; j++){
        	map[SIZE_HOUSE - 1][j] = new WallTile();
        }
        map[SIZE_HOUSE - 1][SIZE_HOUSE/2] = new MonoTile();
	}
}
