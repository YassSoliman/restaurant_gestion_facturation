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
	
	@Test
	public void testValiderClient() {
		Client client = null;
		Plat plat = null;
		Commande commande = null;
		client.ajouterCommande(commande);
			
		String chaineValidation = "Le client " + client.getNomClient() + " n'existe pas.";
		
		assertEquals(chaineValidation, client.validerClient(client));
	}
	
	@Test
	public void testValiderPlat() {
		Client client = null;
		Plat plat = null;
		Commande commande = null;
		client.ajouterCommande(commande);
			
		String chaineValidation = "Le plat " + plat.getNomPlat() + " n'existe pas.";
		
		assertEquals(chaineValidation, client.validerPlat(plat));
	}	
}