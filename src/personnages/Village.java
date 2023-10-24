package personnages;

public class Village {
	private String nom;
	private Chef chef;
	private Gaulois [] villageois;
	private int nbVillageois = 0;
	
	public Village(String nom , int nbVillageoisMaximum) {	
		this.nom = nom;
		this.villageois = new Gaulois[nbVillageoisMaximum];
	}
	
	public void setChef(Chef chef) {
		this.chef = chef;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void ajouterHabitant(Gaulois gaulois) {
		if (this.nbVillageois == this.villageois.length) {
			System.out.println("Le village est complet!");
		} else {
			this.villageois[this.nbVillageois] = gaulois;
			++this.nbVillageois;
		}
	}
	
	public Gaulois trouverHabitant(int num) {
		return this.villageois[num];
	}
	
	public void afficherVillageois() {
		System.out.println("Dans le village du chef " + this.chef.getNom() + " vivent les légendaires gaulois :");
		for (int i = 0 ; i < this.nbVillageois ; i++) {
			System.out.println("- " + this.villageois[i].getNom());
		}
	}
	
	public static void main(String[] args) {
		Village village = new Village("Village des Irréductibles" , 30);
		Chef abraracourcix = new Chef("Abraracourcix" , 6 , village);
		Gaulois asterix = new Gaulois("Astérix" , 8);
		Gaulois obelix = new Gaulois("Obélix" , 25);

		village.setChef(abraracourcix);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		village.afficherVillageois();
	}
}
