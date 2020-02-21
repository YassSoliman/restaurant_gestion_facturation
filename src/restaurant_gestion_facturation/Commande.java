package restaurant_gestion_facturation;

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

	
	
}
