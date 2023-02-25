package classes;

import java.util.ArrayList;
/**
 * @author Antoine Leboucher
 */
public class Village {

	// Déclaration des champs
	// Nom du village
	private String nom;
	// Liste des habitants du village
	private ArrayList<Schtroumpf> habitants;
	// Nombre d'habitants du village
	private int nbHabitants;
	// Stock de salsepareille du village
	private int stock;

	/**
	 * Rôle : constructeur avec paramètres de la classe village
	 * @param name IN : nom que l'on veut donner à l'instance du village
	 * @param qte : IN : quantité de salsepareille que l'on veut attribuer au stock du village
	 * @param nomsHabitants IN : liste de nom des habitants avec lesquels on créera de nouvelles instances de Schtroumpf
	 */
	public Village(String name, int qte, String[] nomsHabitants) {
		this.nom = name;
		this.stock = qte;
		this.habitants = new ArrayList<Schtroumpf>();
		for (String s : nomsHabitants) {
			this.habitants.add(
					new Schtroumpf(s,
							(int) (Math.random() * 150),
							this)
			);
			this.nbHabitants++;
		}
	}

	/**
	 * Rôle : Retourne le nom du village
	 * @return le nom du village
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Rôle : Retourne le nombre d'habitants du village
	 * @return le nombre d'habitants
	 */
	public int getNbSchtroumpf() {
		return this.nbHabitants;
	}

	/**
	 * Rôle : Retourne le stock de salsepareille du village
	 * @return le stock de salsepareille
	 */
	public int getStockSalepareille() {
		return this.stock;
	}

	/**
	 * Rôle : Fait se présenter et chanter les schtroumpfs tout en comptant le nombre d'entre eux étant contents
	 */
	public void solstice_d_ete() {
		int nbSchtroumpfContents = 0;
		for(Schtroumpf s : this.habitants) {
			s.sePresenter();
			s.chanter();
			if(s.estContent())
				nbSchtroumpfContents++;
		}
		System.out.println(this.nom);
		System.out.println(this.nbHabitants + " habitants");
		System.out.println(nbSchtroumpfContents + " schtroumpfs sont contents.");
	}

	/**
	 * Rôle : Détermine le chef du village en parcourant la liste des habitants et en prenant le plus vieux d'entre eux.
	 * @return le chef du village
	 */
	public Schtroumpf chefDuVillage() {
		Schtroumpf chef = null;
		for(int i = 0; i < this.nbHabitants-1; i++) {
			if(this.habitants.get(i+1).getAge() > this.habitants.get(i).getAge()) {
				chef = this.habitants.get(i+1);
			}
		}
		return chef;
	}

	/**
	 * Rôle : Envoyer au travail la moitié des schtroumpfs heureux.
	 */
	public void envoyerAuTravail() {
		int nbContent = 0;
		for(int i = 0; i < this.nbHabitants; i++) {
			if(this.habitants.get(i).estContent()) {
				nbContent++;
				if(nbContent % 2 == 0)
					this.habitants.get(i).allerTravailler();
			}

		}
	}

	/**
	 * Rôle : Envoyer la moitié des schtroumpfs heureux cueillir de la salsepareille pour le village
	 */
	public void envoyerCueuillirSalsepareille() {
		int nbContent = 0;
		for(int i = 0; i < this.nbHabitants; i++) {
			if(this.habitants.get(i).estContent()) {
				nbContent++;
				if(nbContent % 2 == 0)
					this.habitants.get(i).recolterSalsepareille();
			}
		}
	}

	/**
	 * Rôle : Faire chanter tous les schtroumpfs heureux.
	 */
	public void schtroumpfsHeureux() {
		for(Schtroumpf s : this.habitants) {
			if(s.estContent())
				s.chanter();
		}
	}

	/**
	 * Rôle : permet d'ajouter une certaine quantité de salsepareille au stock du village
	 * @param qte IN : Quantité à ajouter
	 */
	public void addStock(int qte) {
		this.stock += qte;
	}

	/**
	 * Rôle : Permet de retirer une certaine quantité de salsepareille au stock du village
	 * @param qte IN : Quantité à retirer
	 */
	public void removeStock(int qte) {
		this.stock -= qte;
	}

	/**
	 * Rôle : Faire diner tous les schtroumpfs du village ensemble
	 */
	public void dinerTousEnsemble() {
		for(Schtroumpf s : this.habitants) {
			s.dinerAuVillage();
		}
	}




}
