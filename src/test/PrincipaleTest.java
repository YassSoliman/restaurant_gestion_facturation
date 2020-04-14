package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Client;
import main.Commande;
import main.Plat;

public class PrincipaleTest {
	
	@Test
	public void testValiderQuantite() {
		Client client = new Client("Client A");
		Plat plat = new Plat("Plat A", 19.99);
		Commande commande = new Commande(client, plat, 0);
		client.ajouterCommande(commande);
		
		String quantite = Integer.toString(commande.getQteCommande());
		
		assertEquals("La quantité de plat commandé est invalide.", client.validerQuantite(quantite));
	}	
}
