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
	/*
	public static void main(String[] args) {
		System.out.println("Bienvenue chez Barette!\n");
		
		CV cvYasser = new CV("Soliman", "Yasser", "DEC en informatique", 50, new String[] {"HTML", "Java", "JavaScript", "C#"}, "Apprendre beaucoup sur JUnit." );
		CV cvAnass = new CV("Soliman", "Anass", "DEC en informatique", 87, new String[] {"CSS", "MySQL", "TypeScript", "C#"}, "Maitriser le logiciel de gestion de vesrion GIT." );
		
		cvYasser.affiche();
		cvAnass.affiche();
	}
	*/
	
	public void affiche() {
		String competencesStr = "";
		
		for (String comp : competences) {
			competencesStr += "\t\t\t\t* " + comp + "\n";
		}
		
		System.out.println("Nom : \t\t\t\t" + this.nom 
						+ "\nPrenom : \t\t\t" + this.prenom
						+ "\nFormation : \t\t\t" + this.formation
						+ "\nExpérience de travail : \t" + this.expTravail + " an(s)"
						+ "\nCompétences : \n" + competencesStr
						+ "Attentes envers 4B4 : \t\t" + this.attentes + "\n");
	} 
	
}
