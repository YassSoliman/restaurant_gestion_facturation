package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import main.Client;
import main.Commande;
import main.Facture;
import main.Plat;

public class ClientTest {

	@Test
	public void testValiderClient() {
		Client client = new Client();
					
		String chaineValidation = "Le client " + client.getNomClient() + " n'existe pas.";
		
		assertEquals(chaineValidation, Client.validerClient(client));
	}

	@Test
	public void testAfficherCommandes() {
		

		
		
		Client client = new Client();
		client.setNomClient("Client");
		Plat plat = new Plat();
		plat.setNomPlat("Plat");
		Commande commande = new Commande(client, plat, 0);
		
	//	String chaineValidation += client.afficherCommandes();
		
	//	assertTrue(client.afficherCommandes() == Commande.getListeCommandes());
		
	//	assertEquals(chaineValidation, client.afficherCommandes());
	
	}
}