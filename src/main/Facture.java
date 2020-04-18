package main;

import java.util.ArrayList;
import java.util.List;

import outilsjava.OutilsAffichage;
import outilsjava.OutilsConstantes;

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
	
	public Facture(Client client) {
		this.client = client;
		Facture.getListeFactures().add(this);
	}

	public void calculerFacture() {
		double prixFacture = 0;
		int tailleListeCommande = client.getListeCommande().size();
		
		for (int i = 0; i < tailleListeCommande; i++) {
			prixFacture += client.getListeCommande().get(i).getPlatCommander().getPrixPlat() 
						* client.getListeCommande().get(i).getQteCommande() 
						* (OutilsConstantes.TPS + OutilsConstantes.TVQ);
		}
		
		this.setPrix(prixFacture);
	}
	
	public static String creerFacture() {
		String message = "Bienvenue chez Barette!\n" 
						+ ((Commande.erreurs.length() > 67) ? (Commande.erreurs + "\n") : "")
						+ "\nFactures:\n";
		
		for (Client cli : Client.getListeClients()) {
			message += cli.getFacture();				
		}
		
		System.out.print("\n" + message);
			
		return message;	
	}

	@Override
	public String toString() {
		return client.getFacture().getPrix() != 0 
				? (client.getNomClient() + " " 
				   + OutilsAffichage.formaterMonetaire(client.getFacture().getPrix(), 2) + "\n") 
				: "";
	}
}
