package classes;

/**
 * @author Antoine Leboucher
 */
public class Schtroumpf {

	// Déclaration des champs
	// Nom du schtroumpf
	private String nom;
	// Âge du schtroumpf
	private int age;
	// Est-ce que le schtroumpf est content ou non (true / false)
	private boolean content;
	// Village où habite le schtroumpf
	private Village habite;

	/**
	 * Rôle : Constructeur avec paramètre de la classe schtroumpf
	 * @param name IN : Nom à donner à l'instance du Schtroumpf
	 * @param age IN : Âge à donner à l'instance du Schtroumpf
	 */
	public Schtroumpf(String name, int age) {
		this.nom = name;
		this.age = age;
		this.content = true;
		this.habite = null;
	}

	/**
	 * Rôle : Constructeur surchargé de la classe classesSchtroumpf
	 * @param name IN : Nom à donner l'instance du Schtroumpf
	 * @param age IN : Âge à donner à l'instance du Schtroumpf
	 * @param village : Village dans lequel l'instance du Schtroumpf vit
	 */
	public Schtroumpf(String name, int age, Village village) {
		this.nom = name;
		this.age = age;
		this.content = true;
		this.habite = village;
	}

	/**
	 * Rôle : Retour le nom du schtroumpf
	 * @return le nom du schtroumpf
	 */
	public String getName() {
		return this.nom;
	}

	/**
	 * Rôle : Retourne l'âge du schtroumpf
	 * @return l'âge du schtroumpf
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * Rôle : Retourne si oui ou non le schtroumpf est heureux
	 * @return true s'il est heureux, false s'il ne l'est pas
	 */
	public boolean estContent() {
		return this.content;
	}

	/**
	 * Rôle : transformer les informations relatives au schtroumpf en une présentation sous forme de chaîne de caractères
	 * @return le string de la présentation du schtroumpf
	 */
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

	/**
	 * Rôle : Afficher la présentation du schtroumpf sous forme de String grâce à toString();
	 */
	public void sePresenter() {
		System.out.println(this.toString());
	}

	/**
	 * Rôle : Retourne le chant des schtroumpfs s'il est content, sinon, retourne gloups
	 * @return
	 */
	public String leChant() {
		if(this.content)
			return "la, la, la classes.Schtroumpf la, la";
		else
			return "gloups";
	}

	/**
	 * Rôle : Afficher le chant du schtroumpf sous forme de string grâce à leChant()
	 */
	public void chanter() {
		System.out.println(this.leChant());
	}

	/**
	 * Rôle : Incrémente l'âge du schtroumpf pour fêter son anniversaire
	 */
	public void anniversaire() {
		this.age++;
	}

	/**
	 * Rôle : Fait manger au schtroumpf une quantité donnéee de salsepareille. Le schtroumpf peut devenir heureux si la
	 * quantité renseignée est supérieure à 0.
	 * @param pfQte IN : Quantité de nourriture à donner au schtroumpf
	 */
	public void manger(int pfQte) {
		if(pfQte > 0)
			this.content = true;
	}

	/**
	 * Rôle : Envoie un schtroumpf travailler ce qui a pour effet de le mettre en colère
	 */
	public void allerTravailler() {
		this.content = false;
	}

	/**
	 * Rôle : Retrourne le village dans lequel vit le schtroumpf schtroumpf
	 * @return le village
	 */
	public Village getVillage() {
		return this.habite;
	}

	/**
	 * Rôle : Définir le village habite
	 * @param pfVillage IN : Nouveau village du schtroumpf
	 */
	public void setVillage(Village pfVillage) {
		this.habite = pfVillage;
	}

	/**
	 * Rôle : Envoie le schtroumpf récolter de la salsepareille. S'il habite un village, le stock de son village augmente
	 * sinon il mange tout ce qu'il trouve
	 */
	public void recolterSalsepareille() {
		final int qteRecolte = 5;
		if(this.hasVillage()) {
			this.allerTravailler();
			this.habite.addStock(qteRecolte);
		}else {
			this.manger(qteRecolte);
		}

	}

	/**
	 * Rôle : Fait dîner le schtroumpf au village en lui faisant manger 3 salsepareilles s'il y en a assez pour lui
	 */
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

	/**
	 * Rôle : Retourne si oui ou non le schtroumpf habite dans un village
	 * @return true s'il habite dans un village, false s'il ne l'est pas
	 */
	private boolean hasVillage() {
		return this.habite != null;
	}

}
