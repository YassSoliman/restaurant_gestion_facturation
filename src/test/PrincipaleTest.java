package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Client;
import main.Commande;
import main.Plat;

public class PrincipaleTest {

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