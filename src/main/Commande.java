package main;

import java.util.ArrayList;
import java.util.List;

public class Commande {
	private static List<Commande> listeCommandes = new ArrayList<Commande>();
	public static String erreurs = "";
	
	private Client client;
	private Plat platCommander;
	private int qteCommande;
	
	public static List<Commande> getListeCommandes() {
		return listeCommandes;
	}

	public static void setListeCommandes(List<Commande> listeCommandes) {
		Commande.listeCommandes = listeCommandes;
	}
	
	public static String validerCommande(Commande commande) {
		String messageErreurs = "Commande : " + commande.toString() + "\nDétails : \n";
		
		messageErreurs += validerQuantite(commande.getQteCommande()) 
				+ "\n\t\t" + Client.validerClient(commande.getClient()) 
				+ "\n\t\t" + Plat.validerPlat(commande.getPlatCommander()); 
		
		return messageErreurs;
	}
	
	public static String validerQuantite(int qteCommande) {		
		return qteCommande > 0 ? "" : "La quantité de plat commandé est invalide.";
	}

	public Commande(Client client, Plat platCommander, int qteCommande) {
		this.client = client;
		this.platCommander = platCommander;
		this.qteCommande = qteCommande;
		Commande.getListeCommandes().add(this);
		client.getListeCommande().add(this);
	}
	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Plat getPlatCommander() {
		return platCommander;
	}

	public void setPlatCommander(Plat platCommander) {
		this.platCommander = platCommander;
	}

	public int getQteCommande() {
		return qteCommande;
	}

	public void setQteCommande(int qteCommande) {
		this.qteCommande = qteCommande;
	}

	@Override
	public String toString() {
		return client + " " + platCommander + " " + qteCommande;
	}

	public static void creerCommandes(String contenu) {
		String[] lignesContenu = contenu.split("\n");
		int tailleListeClients = Client.getListeClients().size();
		int tailleListePlats = Plat.getListePlats().size();
		
		for(int i = tailleListeClients + tailleListePlats + 2; i < lignesContenu.length; i++) {
			String ligne = lignesContenu[i];
			if (ligne.trim().contentEquals("Fin"))
				break;
			if (!ligne.trim().contentEquals("Commandes :")) {
				String[] ligneCommande = ligne.split(" ");
				
				if(ligneCommande.length == 3) {					
					int indexClient = Client.obtenirClient(ligneCommande[0]);
					int indexPlat = Plat.obtenirPlat(ligneCommande[1]);					
					
					new Commande(Client.getListeClients().get(indexClient), 
							Plat.getListePlats().get(indexPlat), Integer.parseInt(ligneCommande[2]));
				}
			}					
		}
	}
	
}
