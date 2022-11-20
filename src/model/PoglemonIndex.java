package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class PoglemonIndex {
	
	//Stats des poglemon
	public static Map<String, Integer> STATS_POGLEMON_INDEX;
	{
		STATS_POGLEMON_INDEX = new HashMap<String, Integer>();

	    //Stats de Nuageon

	    STATS_POGLEMON_INDEX.put("pog" + "hp" + "1", 40);
	    STATS_POGLEMON_INDEX.put("pog" + "atk" + "1", 45);
	    STATS_POGLEMON_INDEX.put("pog" + "spatk" + "1", 70);
	    STATS_POGLEMON_INDEX.put("pog" + "def" + "1", 45);
	    STATS_POGLEMON_INDEX.put("pog" + "spdef" + "1", 65);
	    STATS_POGLEMON_INDEX.put("pog" + "vit" + "1", 45);
	    STATS_POGLEMON_INDEX.put("pog" + "type1" + "1", 3);
	    STATS_POGLEMON_INDEX.put("pog" + "type2" + "1", 10);
	    STATS_POGLEMON_INDEX.put("pog" + "progressionxp" + "1", 3);
	    STATS_POGLEMON_INDEX.put("pog" + "basexp" + "1", 65);

	    //Stats de Poupinus
	    
	    STATS_POGLEMON_INDEX.put("pog" + "hp" + "4", 55);
	    STATS_POGLEMON_INDEX.put("pog" + "atk" + "4", 70);
	    STATS_POGLEMON_INDEX.put("pog" + "spatk" + "4", 45);
	    STATS_POGLEMON_INDEX.put("pog" + "def" + "4", 65);
	    STATS_POGLEMON_INDEX.put("pog" + "spdef" + "4", 50);
	    STATS_POGLEMON_INDEX.put("pog" + "vit" + "4", 40);
	    STATS_POGLEMON_INDEX.put("pog" + "type1" + "4", 4);
	    STATS_POGLEMON_INDEX.put("pog" + "type2" + "4", 0);
	    STATS_POGLEMON_INDEX.put("pog" + "progressionxp" + "4", 3);
	    STATS_POGLEMON_INDEX.put("pog" + "basexp" + "4", 65);

	    //Stats de Pingouinou
	    
	    STATS_POGLEMON_INDEX.put("pog" + "hp" + "7", 55);
	    STATS_POGLEMON_INDEX.put("pog" + "atk" + "7", 50);
	    STATS_POGLEMON_INDEX.put("pog" + "spatk" + "7", 55);
	    STATS_POGLEMON_INDEX.put("pog" + "def" + "7", 50);
	    STATS_POGLEMON_INDEX.put("pog" + "spdef" + "7", 60);
	    STATS_POGLEMON_INDEX.put("pog" + "vit" + "7", 40);
	    STATS_POGLEMON_INDEX.put("pog" + "type1" + "7", 2);
	    STATS_POGLEMON_INDEX.put("pog" + "type2" + "7", 0);
	    STATS_POGLEMON_INDEX.put("pog" + "progressionxp" + "7", 3);
	    STATS_POGLEMON_INDEX.put("pog" + "basexp" + "7", 65);

	    //Stats de Doof
	    
	    STATS_POGLEMON_INDEX.put("pog" + "hp" + "10", 65);
	    STATS_POGLEMON_INDEX.put("pog" + "atk" + "10", 60);
	    STATS_POGLEMON_INDEX.put("pog" + "spatk" + "10", 45);
	    STATS_POGLEMON_INDEX.put("pog" + "def" + "10", 45);
	    STATS_POGLEMON_INDEX.put("pog" + "spdef" + "10", 45);
	    STATS_POGLEMON_INDEX.put("pog" + "vit" + "10", 40);
	    STATS_POGLEMON_INDEX.put("pog" + "type1" + "10", 1);
	    STATS_POGLEMON_INDEX.put("pog" + "type2" + "10", 0);
	    STATS_POGLEMON_INDEX.put("pog" + "progressionxp" + "10", 1);
	    STATS_POGLEMON_INDEX.put("pog" + "basexp" + "10", 58);

	    //Stats de MultiDoof
	    
	    STATS_POGLEMON_INDEX.put("pog" + "hp" + "11", 90);
	    STATS_POGLEMON_INDEX.put("pog" + "atk" + "11", 85);
	    STATS_POGLEMON_INDEX.put("pog" + "spatk" + "11", 55);
	    STATS_POGLEMON_INDEX.put("pog" + "def" + "11", 65);
	    STATS_POGLEMON_INDEX.put("pog" + "spdef" + "11", 45);
	    STATS_POGLEMON_INDEX.put("pog" + "vit" + "11", 75);
	    STATS_POGLEMON_INDEX.put("pog" + "type1" + "11", 1);
	    STATS_POGLEMON_INDEX.put("pog" + "type2" + "11", 0);
	    STATS_POGLEMON_INDEX.put("pog" + "progressionxp" + "11", 1);
	    STATS_POGLEMON_INDEX.put("pog" + "basexp" + "11", 116);

	    //Stats de dieuGlete
	    
	    STATS_POGLEMON_INDEX.put("pog" + "hp" + "999", 90);
	    STATS_POGLEMON_INDEX.put("pog" + "atk" + "999", 130);
	    STATS_POGLEMON_INDEX.put("pog" + "spatk" + "999", 175);
	    STATS_POGLEMON_INDEX.put("pog" + "def" + "999", 90);
	    STATS_POGLEMON_INDEX.put("pog" + "spdef" + "999", 120);
	    STATS_POGLEMON_INDEX.put("pog" + "vit" + "999", 135);
	    STATS_POGLEMON_INDEX.put("pog" + "type1" + "999", 1);
	    STATS_POGLEMON_INDEX.put("pog" + "type2" + "999", 10);
	    STATS_POGLEMON_INDEX.put("pog" + "progressionxp" + "999", 4);
	    STATS_POGLEMON_INDEX.put("pog" + "basexp" + "999", 300);



	}
	
	
	
	//Nom des poglemons

	public static Map<String, String> STATS_POG_NAME_INDEX;
	{
		STATS_POG_NAME_INDEX = new HashMap<String, String>();
		
		STATS_POG_NAME_INDEX.put("pog" + "name" + "0", null);
		STATS_POG_NAME_INDEX.put("pog" + "name" + "1", "Nuageon");
		STATS_POG_NAME_INDEX.put("pog" + "name" + "4", "Poupinus");
		STATS_POG_NAME_INDEX.put("pog" + "name" + "7", "Pingouinou");
		STATS_POG_NAME_INDEX.put("pog" + "name" + "10", "Doof");
		STATS_POG_NAME_INDEX.put("pog" + "name" + "11", "MultiDoof");
		STATS_POG_NAME_INDEX.put("pog" + "name" + "999", "Dieu Glete");
		
	}

	//Listes des apprentissages d'attaque
	public static Map<String, ArrayList<Integer>> POGLEMON_ATTAQUE_NIV_INDEX;
	{
		
		POGLEMON_ATTAQUE_NIV_INDEX = new HashMap<String, ArrayList<Integer>>();
		
	    //Attaque de Nuageon
		POGLEMON_ATTAQUE_NIV_INDEX.put("pog" + "1" + "attaqueniv" + "1", listAttack(4));
		POGLEMON_ATTAQUE_NIV_INDEX.put("pog" + "1" + "attaqueniv" + "4", listAttack(6, 2));

	    //Attaque de Poupinus
		
		POGLEMON_ATTAQUE_NIV_INDEX.put("pog" + "4" + "attaqueniv" + "1", listAttack(1));
		POGLEMON_ATTAQUE_NIV_INDEX.put("pog" + "4" + "attaqueniv" + "4", listAttack(2, 3));

	    //Attaque de Pingouinou
		
		POGLEMON_ATTAQUE_NIV_INDEX.put("pog" + "7" + "attaqueniv" + "1", listAttack(1));
		POGLEMON_ATTAQUE_NIV_INDEX.put("pog" + "7" + "attaqueniv" + "4", listAttack(2, 3));

	    //Attaque de Doof
		
		POGLEMON_ATTAQUE_NIV_INDEX.put("pog" + "10" + "attaqueniv" + "1", listAttack(1));
		POGLEMON_ATTAQUE_NIV_INDEX.put("pog" + "10" + "attaqueniv" + "4", listAttack(2, 3));
		POGLEMON_ATTAQUE_NIV_INDEX.put("pog" + "10" + "attaqueniv" + "5", listAttack(4));

	    //Attaque de MultiDoof
		
		POGLEMON_ATTAQUE_NIV_INDEX.put("pog" + "10" + "attaqueniv" + "1", listAttack(1));
		POGLEMON_ATTAQUE_NIV_INDEX.put("pog" + "11" + "attaqueniv" + "4", listAttack(2, 3));
		POGLEMON_ATTAQUE_NIV_INDEX.put("pog" + "11" + "attaqueniv" + "5", listAttack(4));

	    //Attaque de DieuGlete
		
		POGLEMON_ATTAQUE_NIV_INDEX.put("pog" + "99" + "attaqueniv" + "1", listAttack(1));
		POGLEMON_ATTAQUE_NIV_INDEX.put("pog" + "99" + "attaqueniv" + "2", listAttack(2, 3));
		POGLEMON_ATTAQUE_NIV_INDEX.put("pog" + "99" + "attaqueniv" + "3", listAttack(4));
		POGLEMON_ATTAQUE_NIV_INDEX.put("pog" + "99" + "attaqueniv" + "4", listAttack(5));
		POGLEMON_ATTAQUE_NIV_INDEX.put("pog" + "99" + "attaqueniv" + "6", listAttack(7));

	}



	//Liste des attaques
	public static Map<String, Integer> ATTAQUE_STATS_INDEX;
	{
		ATTAQUE_STATS_INDEX = new HashMap<String, Integer>();

		ATTAQUE_STATS_INDEX.put("degat" + "1" , 40);
		ATTAQUE_STATS_INDEX.put("pp" + "1" , 35);
		ATTAQUE_STATS_INDEX.put("precision" + "1" , 100);
		
		ATTAQUE_STATS_INDEX.put("degat" + "2" , 90);
		ATTAQUE_STATS_INDEX.put("pp" + "2" , 25);
		ATTAQUE_STATS_INDEX.put("precision" + "2" , 90);
		
		ATTAQUE_STATS_INDEX.put("degat" + "3" , 250);
		ATTAQUE_STATS_INDEX.put("pp" + "3" , 5);
		ATTAQUE_STATS_INDEX.put("precision" + "3" , 45);
		
		ATTAQUE_STATS_INDEX.put("degat" + "4" , 999);
		ATTAQUE_STATS_INDEX.put("pp" + "4" , 10);
		ATTAQUE_STATS_INDEX.put("precision" + "4" , 1);
		
		ATTAQUE_STATS_INDEX.put("degat" + "5" , 1);
		ATTAQUE_STATS_INDEX.put("pp" + "5" , 50);
		ATTAQUE_STATS_INDEX.put("precision" + "5" , 100);
		
		ATTAQUE_STATS_INDEX.put("degat" + "6" , 60);
		ATTAQUE_STATS_INDEX.put("pp" + "6" , 15);
		ATTAQUE_STATS_INDEX.put("precision" + "6" , 95);

	}

	public static Map<String, String> ATTAQUE_NAME_INDEX;
	{
		ATTAQUE_NAME_INDEX = new HashMap<String, String>();
		
		ATTAQUE_NAME_INDEX.put("nom" + "1" , "Charge");
		ATTAQUE_NAME_INDEX.put("categorie" + "1" , "physique");

		ATTAQUE_NAME_INDEX.put("nom" + "2" , "Cochon");
		ATTAQUE_NAME_INDEX.put("categorie" + "2" , "special");
		
		ATTAQUE_NAME_INDEX.put("nom" + "3" , "Dinde");
		ATTAQUE_NAME_INDEX.put("categorie" + "3" , "special");
		
		ATTAQUE_NAME_INDEX.put("nom" + "4" , "Glete");
		ATTAQUE_NAME_INDEX.put("categorie" + "4" , "special");
		
		ATTAQUE_NAME_INDEX.put("nom" + "5" , "Pelote");
		ATTAQUE_NAME_INDEX.put("categorie" + "5" , "physique");
		
		ATTAQUE_NAME_INDEX.put("nom" + "6" , "Bourguignon");
		ATTAQUE_NAME_INDEX.put("categorie" + "6" , "physique");

	}


	//Nom des types
	public static String[] typeTab = {"", "Normal", "Feu", "Eau", "Plante", "Electrique", "Glace", "Combat", "Poison", "Sol", "Vol", "Psy", "Insecte", "Roche", "Spectre", "Dragon", "Ténèbre", "Acier", "Fée"};
	
	
	
	
	//OUTILS
	
	private static ArrayList<Integer> listAttack(Integer a) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(a);
		return result;
	}
	
	private static ArrayList<Integer> listAttack(Integer a, Integer b) {
		ArrayList<Integer> result = listAttack(a);
		result.add(b);
		return result;
	}
	
	private static ArrayList<Integer> listAttack(Integer a, Integer b, Integer c) {
		ArrayList<Integer> result = listAttack(a, b);
		result.add(c);
		return result;
	}
	
	@SuppressWarnings("unused")
	private static ArrayList<Integer> listAttack(Integer a, Integer b, Integer c, Integer d) {
		ArrayList<Integer> result = listAttack(a, b, c);
		result.add(d);
		return result;
	}
	
	
	
}
