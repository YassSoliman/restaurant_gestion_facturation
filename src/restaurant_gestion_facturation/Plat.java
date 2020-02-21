package restaurant_gestion_facturation;

public class Plat {
	private String nomPlat;
	
	private double prixPlat;
	
	public Plat(String nom, double prix) {
		this.nomPlat = nom;
		this.prixPlat = prix;
	}
	
	public String getNomPlat() {
		return nomPlat;
	}

	public void setNomPlat(String nomPlat) {
		this.nomPlat = nomPlat;
	}

	public double getPrixPlat() {
		return prixPlat;
	}

	public void setPrixPlat(double prixPlat) {
		this.prixPlat = prixPlat;
	}
	
	// Methode pour afficher le nom du plat avec son prix
	@Override
	public String toString() {
		return this.nomPlat + " " + this.prixPlat;
	}
}
