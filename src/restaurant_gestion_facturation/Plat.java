package restaurant_gestion_facturation;

public class Plat {
	String nomPlat;
	double prixPlat;

	public Plat(String nom, double prix) {
		this.nomPlat = nom;
		this.prixPlat = prix;
	}
	
	// Methode pour afficher le nom du plat avec son prix
	@Override
	public String toString() {
		return this.nomPlat + " " + this.prixPlat;
	}
}
