package tests;

import classes.Schtroumpf;
/**
 * Classe de test de la classe Schtroumpf
 */
public class MainSchtroumpf {

	public static void main (String[] argv) {
		Schtroumpf grognon = new Schtroumpf("grognon", 135);
		grognon.sePresenter();
		grognon.chanter();
		grognon.allerTravailler();
		grognon.sePresenter();
		grognon.chanter();
		grognon.manger(10);
		grognon.sePresenter();
		grognon.anniversaire();
		grognon.sePresenter();
		grognon.chanter();
		
	}

}
