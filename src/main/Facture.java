package main;

public class Facture {
	
	private Client client;
	
	public Client getClient() {
		return this.client;
	}

	public double calculerFacture() {
		double prixFacture = 0;
		
		for (int i = 0; i < client.getListeCommande().size(); i++) {
			prixFacture += client.getListeCommande().get(i).getPlatCommander().getPrixPlat() * 
					client.getListeCommande().get(i).getQteCommande();
		}
		
		return prixFacture;
	}

	public String afficherFacture() {
		String facture = "";
		
		if (calculerFacture() != 0) {
			facture = client.getNomClient() + " " + calculerFacture() + " $";
		}
		
		return facture;
	}
}
