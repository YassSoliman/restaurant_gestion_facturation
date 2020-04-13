package main;

import java.util.ArrayList;
import java.util.List;

public class Client {

	private String nomClient;
	private List<Commande> listeCommande;
	
	public Client() {}
	
	public Client(String nomClient) {
		this.setNomClient(nomClient);
		this.listeCommande = new ArrayList<>();
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
	
	public void ajouterCommande(Commande commande) {
		listeCommande.add(commande);
	}
	
	public List<Commande> getListeCommande() {
		return listeCommande;
	}
	
	public double calculerFacture() {
		double prixFacture = 0;
		
		for (int i = 0; i < listeCommande.size(); i++) {
			prixFacture += listeCommande.get(i).getPlatCommander().getPrixPlat() * 
					listeCommande.get(i).getQteCommande();
		}
		
		return prixFacture;
	}
	
	public void afficherCommandes() {
		for(Commande com : listeCommande) {
			System.out.println(com);
		}
	}
	
	@Override
	public String toString() {
		return this.nomClient;
	}
	
	public static Client[] creerClients(String contenu) {
		List<Client> listeClient = new ArrayList<Client>();
		
		String[] lignesContenu = contenu.split("\n");
		for(String ligne : lignesContenu) {
			if (ligne.trim().contentEquals("Plats :"))
				break;
			if (!ligne.trim().contentEquals("Clients :")) {
				listeClient.add(new Client(ligne));				
			}					
		}
		
		return listeClient.toArray(new Client[listeClient.size()]);
	}
	
	public static int obtenirClient(String nom, Client[] tabClient) {
		int index = -1;
		
		for(int i = 0; i < tabClient.length; i++) {
			if(tabClient[i].getNomClient().equals(nom)) {
				index = i;
				break;
			}			
		}
		
		return index;		
	}
}
