package tests;

import classes.Village;

/**
 * Classe de test de la classe Village
 */
public class MainVillage {

	public static void main (String[] argv) {
		String[] nomsSchtroumpfs = {
				"Grand Schtroumpf", "Schtroumpf courant (et pas ordinaire)", "Schtroumpf ordinaire (et pas courant)", "Schtroumpf moralisateur a lunettes",
				"Schtroumpf boudeur", "Schtroumpf volant", "Schtroumpf etonne", "Schtroumpf acrobate", "Schtroumpf paresseux"
			};	
		
		Village v = new Village("Toulouse", 150, nomsSchtroumpfs);
		v.solstice_d_ete();
		v.chefDuVillage().sePresenter();
		v.envoyerAuTravail();
		v.schtroumpfsHeureux();
		
		v.solstice_d_ete();
		v.envoyerCueuillirSalsepareille();
		v.solstice_d_ete();
		v.dinerTousEnsemble();
		v.solstice_d_ete();
	}

}
