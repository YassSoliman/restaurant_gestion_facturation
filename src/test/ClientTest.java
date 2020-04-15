package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Client;
import main.Commande;
import main.Plat;

public class ClientTest {

	@Test
	public void testValiderClient() {
		Client client = new Client();
		Plat plat = null;
		Commande commande = new Commande(client, plat, 0);
		client.ajouterCommande(commande);
			
		String chaineValidation = "Le client " + client.getNomClient() + " n'existe pas.";
		
		assertEquals(chaineValidation, Client.validerClient(client));
	}
}