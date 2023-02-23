import java.util.ArrayList;

public class Village {
	
	private String nom;
	private ArrayList<Schtroumpf> habitants; 
	private int nbHabitants;
	private int stock;
	
	public Village(String name, int qte, String[] nomsHabitants) {
		this.nom = name;
		this.stock = qte;
		this.habitants = new ArrayList<Schtroumpf>();
		for(int i = 0; i < nomsHabitants.length; i++) {
			this.habitants.add(
					new Schtroumpf(nomsHabitants[i], 
						(int)(Math.random()*150), 
						this)
					);
			this.nbHabitants++;
		}
	}
	
	public String getNom() {
		return this.nom;
	}
	
	public int getNbSchtroumpf() {
		return this.nbHabitants;
	}
	
	public int getStockSalepareille() {
		return this.stock;
	}
	
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
	
	public Schtroumpf chefDuVillage() {
		Schtroumpf chef = null;
		for(int i = 0; i < this.nbHabitants-1; i++) {
			if(this.habitants.get(i+1).getAge() > this.habitants.get(i).getAge()) {
				chef = this.habitants.get(i+1); 
			}
		}
		return chef;
	}
	
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
	
	public void schtroumpfsHeureux() {
		for(Schtroumpf s : this.habitants) {
			if(s.estContent())
				s.chanter();	
		}
	}
	
	public void addStock(int qte) {
		this.stock += qte;
	}
	
	public void removeStock(int qte) {
		this.stock -= qte;
	}
	
	public void dinerTousEnsemble() {
		for(Schtroumpf s : this.habitants) {
			s.dinerAuVillage();
		}
	}
	
	
	
	
}
