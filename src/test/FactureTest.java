package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.Client;
import main.Commande;
import main.Facture;
import main.Plat;

public class FactureTest {

	@Test
	public void testFactureNull() {
		Client client = new Client("Client");
			
		assertEquals("", client.getFacture().toString());
	}
	
	@Test
	public void testAffichageErreurs() {
		Client client = new Client();
		client.setNomClient("Client");
		Plat plat = new Plat();
		plat.setNomPlat("Plat");
		Commande commande = new Commande(client, plat, 0);
		
		String contenue = Facture.creerFacture();
		
		assertTrue(contenue.contains(Commande.erreurs));
	}
	
	@Test
	public void testCalculerFactureTaxes() {
		Client client = new Client("Client A");
		Plat plat = new Plat("Plat A", 19.99);
		Commande commande = new Commande(client, plat, 1);
		
		double prixValidation = (commande.getPlatCommander().getPrixPlat() * commande.getQteCommande()) * (1.09975 + 0.05);
	
		assertEquals(prixValidation, client.getFacture().getPrix(), 0.01);
	}
	
	@Test
	public void testAucuneErreur() {
		Commande.erreurs = "\n#####################\n"
				 + "# Message d'erreurs #\n"
				 + "#####################\n";
		
		Client client = new Client("Client");
		Plat plat = new Plat("Plat", 10.00);
		Commande commande = new Commande(client, plat, 1);
		
		String contenue = Facture.creerFacture();
		
		System.out.println(contenue);
		System.out.println(Commande.erreurs);
		
		assertFalse(contenue.contains(Commande.erreurs));
	}
	
	@Test
	public void testGetClient() {
		Client client = new Client("Client");
		Plat plat = new Plat("Plat", 10.00);
		Commande commande = new Commande(client, plat, 1);
		Facture facture = new Facture(client);
		
		assertEquals(client.getFacture().getPrix(), facture.getClient().getFacture().getPrix(), 0.01);
	}
	
	@Test
	public void testCalculFactureParClient() {
		Client client = new Client("Client A");
		Plat plat = new Plat("Plat A", 19.99);
		Commande commande = new Commande(client, plat, 1);
		
		assertEquals("Client A 22,98 $\n", client.getFacture().toString());
	}
}
