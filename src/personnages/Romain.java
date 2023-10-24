package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement;
	
	public Romain(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
		this.nbEquipement = 0;
		assert(force > 0);
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}
	
	public void recevoirCoup(int forceCoup) {
		assert(force>0);
		int force_initiale = force;
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		}
		else {
			parler("J'abandonne...");
		}
		assert(force_initiale!=force);
	}
	
	private void ajoutEquip(Equipement equip) {
		System.out.println("Le soldat " + this.nom + " s’équipe avec un " + equip);
		this.equipements[this.nbEquipement] = equip;
		this.nbEquipement++;
	}
	public void sEquiper(Equipement equip) {
		switch(this.nbEquipement) {
			case 2:
				System.out.println("Le soldat " + this.nom + " est déjà bien protégé !");
				break;
			case 1:
				if (this.equipements[0] == equip) {
					System.out.println("Le soldat " + this.nom + " possède déjà un " + equip);
				} else {
					this.ajoutEquip(equip);
				}
				break;
			default:
				this.ajoutEquip(equip);
				break;
		}
	}
	
	public static void main(String[] args) {
		Romain minus = new Romain("Minus" , 6);
		Equipement casque = Equipement.CASQUE;
		Equipement bouclier = Equipement.BOUCLIER;
		
		minus.prendreParole();
		minus.parler("Bonsoir.");
		minus.recevoirCoup(4);
		
		System.out.println(casque);
		System.out.println(bouclier);

		minus.sEquiper(casque);
		minus.sEquiper(casque);
		minus.sEquiper(bouclier);
		minus.sEquiper(casque);
	}
}
