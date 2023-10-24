package personnages;

public class Romain {
	private String nom;
	private int force;
	private Equipement[] equipements;
	private int nbEquipement;
	
	public Romain(String nom, int force) {
		if (force <= 0) {throw new IllegalArgumentException("Invalid force : " + force);}
		this.nom = nom;
		this.force = force;
		this.equipements = new Equipement[2];
		this.nbEquipement = 0;
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getForce() {
		return force;
	}
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le romain " + nom + " : ";
	}

	public Equipement[] recevoirCoup(int forceCoup) {
		Equipement[] equipementEjecte = null;
		assert(force > 0);
		int oldForce = force;
		forceCoup = calculResistanceEquipement(forceCoup);
		force -= forceCoup;
		if (force > 0) {
			parler("Aïe");
		} else {
			equipementEjecte = ejecterEquipement();
			parler("J'abandonne...");
		}
		assert(force < oldForce);
		return equipementEjecte;
	}

	private int calculResistanceEquipement(int forceCoup) {
		String texte = "Ma force est de " + force + ", et la force du coup est de " + forceCoup;
		int resistanceEquipement = 0;
		if (nbEquipement != 0) {
			texte += "\nMais heureusement, grace à mon équipement sa force est diminué de ";
			for (int i = 0; i < nbEquipement;i++) {
				if (equipements[i] != null && equipements[i].equals(Equipement.BOUCLIER)) {
					resistanceEquipement += 8;
				} else {
					System.out.println("Equipement casque");
					resistanceEquipement += 5;
				}
			}
			texte += resistanceEquipement + "!";
		}
		parler(texte);
		forceCoup -= (forceCoup < resistanceEquipement) ? forceCoup : resistanceEquipement;
		return forceCoup;
	}
	
	private Equipement[] ejecterEquipement() {
		Equipement[] equipementEjecte = new Equipement[nbEquipement];
		System.out.println("L'équipement de " + nom + " s'envole sous la force du coup.");
		int nbEquipementEjecte = 0;
		for (int i = 0; i < nbEquipement; i++) {
			if (equipements[i] != null) {
				equipementEjecte[nbEquipementEjecte] = equipements[i];
				nbEquipementEjecte++;
				equipements[i] = null;
			}
		}
		return equipementEjecte;
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
