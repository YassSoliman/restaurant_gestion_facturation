package restaurant_gestion_facturation;

import java.util.ArrayList;
import java.util.List;

public class Commande {
	private Client client;
	private Plat platCommander;
	private int qteCommande;
	
	public Commande(Client client, Plat platCommander, int qteCommande) {
		this.client = client;
		this.platCommander = platCommander;
		this.qteCommande = qteCommande;
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
		return "Commande [client=" + client + ", platCommander=" + platCommander + ", qteCommande=" + qteCommande + "]";
	}

	public static Commande[] creerCommandes(Client[] tabClients, Plat[] tabPlats, String contenu) {
		List<Commande> listeCommande = new ArrayList<Commande>();
		String[] lignesContenu = contenu.split("\n");
		
		for(int i = tabClients.length + tabPlats.length + 2; i < lignesContenu.length; i++) {
			String ligne = lignesContenu[i];
			if (ligne.trim().contentEquals("Fin"))
				break;
			if (!ligne.trim().contentEquals("Commandes :")) {
				String[] ligneCommande = ligne.split(" ");
				
				if(ligneCommande.length == 3) {					
					int indexClient = Client.obtenirClient(ligneCommande[0], tabClients);
					int indexPlat = Plat.obtenirPlat(ligneCommande[1], tabPlats);					
					
					Commande commande = new Commande(tabClients[indexClient], tabPlats[indexPlat], Integer.parseInt(ligneCommande[2]));
					tabClients[indexClient].getListeCommande().add(commande);
					listeCommande.add(commande);		
				}
			}					
		}
		
		return listeCommande.toArray(new Commande[listeCommande.size()]);
		
	}
	
}
