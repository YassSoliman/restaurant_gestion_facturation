package restaurant_gestion_facturation;

import java.util.List;

public class Client {

	private String nomClient;
	private List<Commande> listeCommande;
	
	public Client(String nomClient) {
		this.setNomClient(nomClient);
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
	
	@Override
	public String toString() {
		return this.nomClient;
	}
}
