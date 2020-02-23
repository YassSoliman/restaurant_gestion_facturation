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
	
	public static Plat[] creerPlat(Client[] tabClients, String contenu) {
		List<Plat> listePlat = new ArrayList<Plat>();
		
		String[] lignesContenu = contenu.split("\n");
		
		
		for(int i = tabClients.length; i < lignesContenu.length; i++) {
			String ligne = lignesContenu[i];
			
			if (ligne.trim().contentEquals("Commandes :"))
				break;
			if (!ligne.trim().contentEquals("Plats :")) {
				String[] tabInfoPlat = ligne.split(" ");
				listePlat.add(new Plat(tabInfoPlat[0], Double.parseDouble(tabInfoPlat[1])));				
			}					
		}
		
		return listePlat.toArray(new Plat[listePlat.size()]);
	}
	
	public static int obtenirPlat(String plat, Plat[] tabPlat) {
		int index = -1;
		
		for(int i = 0; i < tabPlat.length; i++) {
			if(tabPlat[i].getNomPlat() == plat) {
				index = i;
				break;
			}			
		}
		
		return index;		
	}
}
