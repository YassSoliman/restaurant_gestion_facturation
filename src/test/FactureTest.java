package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Client;
import main.Commande;
import main.Plat;

public class FactureTest {

	@Test
	public void testFactureNull() {
		Client client = new Client("Client");
			
		assertEquals("", client.getFacture().toString());
	}
	
	@Test
	public void testCalculerFacture() {
		Client client = new Client("Client A");
		Plat plat = new Plat("Plat A", 19.99);
		Commande commande = new Commande(client, plat, 1);
		
		double prixValidation = (commande.getPlatCommander().getPrixPlat() * commande.getQteCommande()) * (1.09975 + 0.05);
	
		assertEquals(prixValidation, client.getFacture().getPrix(), 0.01);
	}
}
