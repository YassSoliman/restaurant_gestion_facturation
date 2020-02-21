package restaurant_gestion_facturation;

public class Client {

	private String nomClient;
	
	public Client(String nomClient) {
		this.setNomClient(nomClient);
	}

	public String getNomClient() {
		return nomClient;
	}

	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}
}
