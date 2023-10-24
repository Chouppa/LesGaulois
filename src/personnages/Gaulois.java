package personnages;
import villagegaulois.Musee;

public class Gaulois {
	private String nom;
	private int effetPotion = 1;
	private int force;
	private int nbTrophees;
	private Equipement[] trophees;
	
	public Gaulois(String nom, int force) {
		this.nom = nom;
		this.force = force;
		this.trophees = new Equipement[100];
	}
	
	public String getNom() {
		return nom;
	}
	
	public void parler(String texte) {
		System.out.println(prendreParole() + "« " + texte + "»");
	}
	
	private String prendreParole() {
		return "Le gaulois " + nom + " : ";
	}
	
	public void frapper(Romain romain) {
		System.out.println(nom + " envoie un grand coup dans la mâchoire de " + romain.getNom());
		Equipement[] newTrophees = romain.recevoirCoup((force / 3) * effetPotion);
		for (int i = 0; newTrophees != null && i < newTrophees.length; i++, nbTrophees++) {
			this.trophees[nbTrophees] = newTrophees[i];
		}
	}

	public String toString() {
		return "Gaulois [nom=" + nom + ", force=" + force + ", effetPotion=" + effetPotion + "]";
	}
	
	public void boirePotion(int forcepotion) {
		this.effetPotion = forcepotion;
		this.parler("Merci Druide, je sens que ma force est " + this.effetPotion + " fois décuplée.");
	}
	
	private String listerTrophees() {
		assert(nbTrophees > 0);
		String texte = "-" + trophees[0];
		for(int i=1 ; i<nbTrophees  ; i++) {
			texte += "\n-" + trophees[i];
		}
		return texte;
	}
	
	public void faireUneDonnation(Musee musee) {
		parler("Je donne au musee tous mes trophees :\n" + listerTrophees());
		for(int i=0 ; i<nbTrophees  ; i++) {
			musee.donnerTrophees(this, trophees[i]);
		}
		trophees = null;
	}
	
	public static void main(String[] args) {
		Gaulois asterix = new Gaulois("Astérix",  8);
		Romain romano = new Romain("Romano" , 3);
		
		System.out.println(asterix);
		asterix.prendreParole();
		asterix.parler("Bonjour.");
		asterix.boirePotion(4);
		asterix.frapper(romano);
}
}