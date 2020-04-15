package main;

public class Facture {
	
	private Client client;
	private double prix;
	
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
	
	public Facture(Client client, double prix) {
		this.client = client;
		setPrix(prix);
	}

	public double calculerFacture() {
		double prixFacture = 0;
		//TODO ajouter TPS TVQ
		for (int i = 0; i < client.getListeCommande().size(); i++) {
			prixFacture += client.getListeCommande().get(i).getPlatCommander().getPrixPlat() * 
					client.getListeCommande().get(i).getQteCommande();
		}
		
		return prixFacture;
	}

	@Override
	public String toString() {
		String facture = "";
		
		if (calculerFacture() != 0) {
			facture = client.getNomClient() + " " + calculerFacture() + " $";
		}
		
		return facture;
	}
}
