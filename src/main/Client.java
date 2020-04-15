package main;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private static List<Client> listeClients = new ArrayList<Client>();
	
	private String nomClient;
	private List<Commande> listeCommande;
	private Facture facture;
	
	public static List<Client> getListeClients() {
		return listeClients;
	}

	public static void setListeClients(List<Client> listeClients) {
		Client.listeClients = listeClients;
	}
	
	public static String validerClient(Client client) {
		return Client.getListeClients().contains(client) ? "" : "Le client " + client.getNomClient() + " n'existe pas.";
	}

	public Client() {}
	
	public Client(String nomClient) {
		this.setNomClient(nomClient);
		this.listeCommande = new ArrayList<>();
		Client.getListeClients().add(this);
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
	
	public Facture getFacture() {
		return this.facture;
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
	
	public static void creerClients(String contenu) {
		String[] lignesContenu = contenu.split("\n");
		for(String ligne : lignesContenu) {
			if (ligne.trim().contentEquals("Plats :"))
				break;
			if (!ligne.trim().contentEquals("Clients :")) {
				new Client(ligne);				
			}					
		}
	}
	
	public static int obtenirClient(String nom) {
		int index = -1;
		int tailleListeClients = Client.getListeClients().size();
		
		for(int i = 0; i < tailleListeClients; i++) {
			if(Client.getListeClients().get(i).getNomClient().equals(nom)) {
				index = i;
				break;
			}			
		}
		
		return index;		
	}
}
