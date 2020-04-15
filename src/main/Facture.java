package main;

import java.util.ArrayList;
import java.util.List;

public class Facture {
	private static List<Facture> listeFactures = new ArrayList<Facture>();
	private Client client;
	private double prix;
	
	public static List<Facture> getListeFactures() {
		return listeFactures;
	}
	
	public Client getClient() {
		return this.client;
	}
	
	public void setPrix(double prix) {
		this.prix = prix;
	}
	
	public double getPrix() {
		return this.prix;
	}
	
	public Facture() {}
	
	//remove prix
	public Facture(Client client) {
		this.client = client;
		//add facture to listeFacture
		Facture.getListeFactures().add(this);
	}

	public void calculerFacture() {
		double prixFacture = 0;
		//TODO ajouter TPS TVQ
		for (int i = 0; i < client.getListeCommande().size(); i++) {
			prixFacture += client.getListeCommande().get(i).getPlatCommander().getPrixPlat() * 
					client.getListeCommande().get(i).getQteCommande();
		}
		
		setPrix(prixFacture);
	}

	@Override
	public String toString() {
		String facture = "";
		
		if (this.getPrix() != 0) {
			facture = client.getNomClient() + " " + this.getPrix() + " $";
		}
		
		return facture;
	}
}
