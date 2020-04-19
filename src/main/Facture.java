package main;

import java.util.ArrayList;
import java.util.List;

import outilsjava.OutilsAffichage;
import outilsjava.OutilsConstantes;

public class Facture {
	private static List<Facture> listeFactures = new ArrayList<Facture>();
	private Client unClient;
	private double prixFacture;
	
	public static List<Facture> getListeFactures() {
		return listeFactures;
	}
	
	public Client getClient() {
		return this.unClient;
	}
	
	public void setPrix(double prix) {
		this.prixFacture = prix;
	}
	
	public double getPrix() {
		return this.prixFacture;
	}
	
	public Facture(Client client) {
		this.unClient = client;
		Facture.getListeFactures().add(this);
	}

	public void calculerFacture() {
		double prixFacture = 0;
		
		for (Commande comm: unClient.getListeCommande()) {
			prixFacture += comm.getPlatCommander().getPrixPlat() * 
					comm.getQteCommande() * (OutilsConstantes.TPS + OutilsConstantes.TVQ);
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
		return unClient.getFacture().getPrix() != 0 
				? (unClient.getNomClient() + " " 
				   + OutilsAffichage.formaterMonetaire(unClient.getFacture().getPrix(), 2) + "\n") 
				: "";
	}
}
