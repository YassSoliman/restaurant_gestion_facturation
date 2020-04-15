package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Client;
import main.Commande;
import main.Plat;

public class CommandeTest {
	
	@Test
	public void testValiderQuantite() {
		Client client = new Client("Client A");
		Plat plat = new Plat("Plat A", 19.99);
		int quantite = 0;
		Commande commande = new Commande(client, plat, quantite);
		client.ajouterCommande(commande);
				
		assertEquals("La quantit� de plat command� est invalide.", Commande.validerQuantite(quantite));
	}
	
	@Test
	public void testValiderCommande() {
		Client client = new Client();
		Plat plat = null;
		Commande commande = new Commande(client, plat, 0);
		client.ajouterCommande(commande);
		
		String chaineValidation = "Commande : " + commande.toString() + "\nD�tails : \n";
		
		chaineValidation += Commande.validerQuantite(commande.getQteCommande()) 
				+ "\n\t\t" + Client.validerClient(commande.getClient()) 
				+ "\n\t\t" + Plat.validerPlat(commande.getPlatCommander()); 		
		
		assertEquals(chaineValidation, Commande.validerCommande(commande));
	}
}