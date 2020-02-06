package restaurant_gestion_facturation;

public class CV {
	
	private String nom;
	private String prenom;
	private String formation;
	private int expTravail;
	private String[] competences;
	private String attentes;
	
	public CV(String nom, String prenom, String formation, int expTravail, String[] competences, String attentes) {
		this.nom = nom;
		this.prenom = prenom;
		this.formation = formation;
		this.expTravail = expTravail;
		this.competences = competences;
		this.attentes = attentes;
	}
	
	public static void main(String[] args) {
		

	}
	
	public void affiche() {
		String competencesStr = "";
		
		for (String comp : competences) {
			competencesStr += "\t*" + comp + "\n";
		}
		
		System.out.println("Nom : " + this.nom 
						+ "\nPrenom : " + this.prenom
						+ "\nFormation : " + this.formation
						+ "\nExpérience de travail : " + this.expTravail + " an(s)"
						+ "\nCompétences : \n" + competencesStr
						+ "Attentes vis à vis le cours 4B4 : " + this.attentes);
	} 

}
