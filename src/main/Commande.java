package main;

import java.util.ArrayList;
import java.util.List;

public class Commande {
	private static List<Commande> listeCommandes = new ArrayList<Commande>();
	public static String erreurs = "\n#####################\n"
								 + "# Message d'erreurs #\n"
								 + "#####################\n";
	
	private Client unClient;
	private Plat platCommander;
	private int qteCommande;
	
	public static List<Commande> getListeCommandes() {
		return listeCommandes;
	}
	
	public static String validerCommande(Commande commande) {
		String messageErreurs = "\nCommande : " + commande.toString() + "\nDétails : \n";
		String messageErreursTrim = "";
		String messageQuantite = validerQuantite(commande.getQteCommande());
		String messageClient = Client.validerClient(commande.getClient());
		String messagePlat = Plat.validerPlat(commande.getPlatCommander());
				
		messageErreurs += "\t" + (messageQuantite + "\n\t" + messageClient + "\n\t" + messagePlat).trim();
		messageErreursTrim = ("Commande : " + commande.toString() + "\nDétails : \n").trim();
		
		if (messageErreurs.trim().equals(messageErreursTrim)) {
			messageErreurs = "";
		}
		
		return messageErreurs;
	}
	
	public static String validerQuantite(int qteCommande) {		
		return qteCommande > 0 ? "" : "La quantité de plat commandé est invalide.";
	}

	public Commande(Client client, Plat platCommander, int qteCommande) {
		this.unClient = client;
		this.platCommander = platCommander;
		this.qteCommande = qteCommande;
		Commande.getListeCommandes().add(this);
		client.ajouterCommande(this);
		Commande.erreurs += Commande.validerCommande(this);
	}
	
	public Commande() {
		this.unClient = new Client();
		this.platCommander = new Plat();
		this.qteCommande = 0;
	}

	public Client getClient() {
		return this.unClient;
	}

	public void setClient(Client client) {
		this.unClient = client;
	}

	public Plat getPlatCommander() {
		return platCommander;
	}

	public void setPlatCommander(Plat platCommander) {
		this.platCommander = platCommander;
	}

	public int getQteCommande() {
		return this.qteCommande;
	}

	public void setQteCommande(int qteCommande) {
		this.qteCommande = qteCommande;
	}

	@Override
	public String toString() {
		return unClient + " " + this.platCommander.getNomPlat() + " " + this.qteCommande;
	}

	public static void creerCommandes(String contenu) {
		String[] lignesContenu = contenu.split("\n");
		int tailleListeClients = Client.getListeClients().size();
		int tailleListePlats = Plat.getListePlats().size();
		
		for(int i = tailleListeClients + tailleListePlats + 2; i < lignesContenu.length; i++) {
			String ligne = lignesContenu[i];
			String ligneTrim = ligne.trim();
			
			if (ligneTrim.contentEquals("Fin"))
				break;
			if (!ligneTrim.contentEquals("Commandes :")) {
				String[] ligneCommande = ligne.split(" ");
				
				if(ligneCommande.length == 3) {					
					int indexClient = Client.obtenirClient(ligneCommande[0]);
					int indexPlat = Plat.obtenirPlat(ligneCommande[1]);					
					
					Client client = new Client();
					client.setNomClient(ligneCommande[0]);
					Plat plat = new Plat();
					plat.setNomPlat(ligneCommande[1]);
					
					if (indexClient != -1) {
						client = Client.getListeClients().get(indexClient);
					}
					
					if (indexPlat != -1) {
						plat = Plat.getListePlats().get(indexPlat);
					}
					
					new Commande(client, plat, Integer.parseInt(ligneCommande[2]));
				}
			}					
		}
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}

		if (!(obj instanceof Commande)) {
			return false;
		}

		Commande com = (Commande) obj;

		return this.getClient().equals(com.getClient()) 
				&& this.getPlatCommander().equals(com.getPlatCommander()) 
				&& Integer.compare(this.getQteCommande(), com.getQteCommande()) == 0;
	}
}
