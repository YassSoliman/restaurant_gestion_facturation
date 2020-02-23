package restaurant_gestion_facturation;

import java.util.ArrayList;
import java.util.List;

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
	
	public static Plat[] creerPlat(String contenu) {
		List<Plat> listePlat = new ArrayList<Plat>();
		
		String[] lignesContenu = contenu.split("\n");
		
		int indice = 0;
		
		for(String ligne : lignesContenu) {
			if (ligne.trim().contentEquals("Commandes :"))
				break;
			if (!ligne.trim().contentEquals("Plats :")) {
				String[] tabPrix = ligne.split(" ");
				listePlat.add(new Plat(ligne, Double.parseDouble(tabPrix[indice++])));				
			}					
		}
		
		return listePlat.toArray(new Plat[listePlat.size()]);
	}
}
