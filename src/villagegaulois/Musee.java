package villagegaulois;
import personnages.Equipement;
import personnages.Gaulois;
import personnages.Trophee;

public class Musee {
	private Trophee[] trophees;
	private int nbTrophee;
	
	public Musee() {
		this.trophees = new Trophee[200];
		this.nbTrophee = 0;
	}
	
	public void donnerTrophees(Gaulois gaulois, Equipement equipement) {
		final Trophee trophee = new Trophee(gaulois, equipement);
		trophees[nbTrophee] = trophee;
		nbTrophee++;
	}
	
	public String extraireInstructionsOCaml() {
		assert(nbTrophee > 0);
		String instruction = "let musee = \n\t[\"" + trophees[0].donnerNom() + "\", \"" + trophees[0].getEquipement() + "\"";
		for(int i=1 ; i<nbTrophee ; i++) {
			instruction += ";\n\t \"" + trophees[i].donnerNom() + "\", \"" + trophees[i].getEquipement() + "\"";
		}
		instruction += "]";
		return instruction;
	}
}
