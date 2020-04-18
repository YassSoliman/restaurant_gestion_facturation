package main;

import java.util.ArrayList;
import java.util.List;

public class Plat {
	private static List<Plat> listePlats = new ArrayList<Plat>();
	
	private String nomPlat;
	
	private double prixPlat;
	
	public static List<Plat> getListePlats() {
		return listePlats;
	}

	public static void setListePlats(List<Plat> listePlats) {
		Plat.listePlats = listePlats;
	}
	
	public static String validerPlat(Plat plat) {		
		return Plat.getListePlats().contains(plat) ? "" : "Le plat " + plat.getNomPlat() + " n'existe pas.";
	}

	public Plat() {
		this.nomPlat = "";
		this.prixPlat = 0.00;
	}
	
	public Plat(String nom, double prix) {
		this.nomPlat = nom;
		this.prixPlat = prix;
		Plat.getListePlats().add(this);
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
	
	public static void creerPlat(String contenu) {		
		String[] lignesContenu = contenu.split("\n");
		int tailleListeClients = Client.getListeClients().size();
		
		for(int i = tailleListeClients + 1; i < lignesContenu.length; i++) {
			String ligne = lignesContenu[i];
			
			if (ligne.trim().contentEquals("Commandes :"))
				break;
			if (!ligne.trim().contentEquals("Plats :")) {
				String[] tabInfoPlat = ligne.split(" ");
				if (tabInfoPlat.length == 2) {
					new Plat(tabInfoPlat[0], Double.parseDouble(tabInfoPlat[1]));	
				}
						
			}					
		}
	}
	
	public static int obtenirPlat(String plat) {
		int index = -1;
		int tailleListePlats = Plat.getListePlats().size();
		
		for(int i = 0; i < tailleListePlats; i++) {
			if(Plat.getListePlats().get(i).getNomPlat().equals(plat)) {
				index = i;
				break;
			}			
		}
		
		return index;		
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Plat)) {
			return false;
		}

		Plat plat = (Plat) obj;

		return this.getNomPlat().compareTo(plat.getNomPlat()) == 0 
				&& Double.compare(this.getPrixPlat(), plat.getPrixPlat()) == 0;
	}
}
