public class Schtroumpf {
	private String nom;	
	private int age;
	private boolean content;
	private Village habite;
	
	public Schtroumpf(String name, int age) {
		this.nom = name;
		this.age = age;
		this.content = true;
		this.habite = null;
	}
	
	public Schtroumpf(String name, int age, Village village) {
		this.nom = name;
		this.age = age;
		this.content = true;
		this.habite = village;
	}
	
	public String getName() {
		return this.nom;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public boolean estContent() {
		return this.content;
	}
	
	public String toString() {
		String val = "Je suis " + this.nom + ", j'ai " + this.age + " ans et je suis ";
		if(this.content) 
			val += "je suis content ";	
		else 
			val += "je suis pas content ";
		if(this.habite != null) 
			val += "et j'habite le village " + this.habite.getNom();
		else 
			val += "et je suis ermite";
		
		return val;
	}
	
	public void sePresenter() {
		System.out.println(this.toString());
	}
	
	public String leChant() {
		if(this.content)
			return "la, la, la Schtroumpf la, la";
		else
			return "gloups";
	}
	
	public void chanter() {
		System.out.println(this.leChant());
	}
	
	public void anniversaire() {
		this.age++;
	}
	
	public void manger(int pfQte) {
		if(pfQte > 0)
			this.content = true;
	}
	
	public void allerTravailler() {
		this.content = false;
	}
	
	public Village getVillage() {
		return this.habite;
	}
	
	public void setVillage(Village pfVillage) {
		this.habite = pfVillage;
	}
	
	public void recolterSalsepareille() {
		final int qteRecolte = 5;
		if(this.hasVillage()) {
			this.allerTravailler();
			this.habite.addStock(qteRecolte);
		}else {
			this.manger(qteRecolte);
		}

	}
	
	public void dinerAuVillage() {
		final int qteMange = 3;
		if(this.habite.getStockSalepareille() >= qteMange) {
			if(this.hasVillage()) {
				this.manger(qteMange);
				this.habite.removeStock(qteMange);
			}
			else {
				this.content = false;
			}
		}
	}
	
	private boolean hasVillage() {
		return this.habite != null;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
