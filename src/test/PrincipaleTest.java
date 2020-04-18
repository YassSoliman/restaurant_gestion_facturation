package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.Client;
import main.Commande;
import main.Plat;
import main.Principale;

public class PrincipaleTest {
	

	
	@Test
	public void testLireClients() {
		Client client = new Client();
		Plat plat = new Plat();
		Commande commande = new Commande();
		
		String contenu = "Clients :\n" + 
				"Roger\n" + 
				"Céline\n" + 
				"Steeve\n" + 
				"Plats :\n" + 
				"Poutine 10.5\n" + 
				"Frites 2.5\n" + 
				"Repas_Poulet 15.75\n" + 
				"Commandes :\n" + 
				"Roger Poutine 1\n" + 
				"Céline Frites 2\n" + 
				"Céline Repas_Poulet 1\n" + 
				"Fin";
		
		Principale.lireClients(contenu);
		
		assertTrue(Client.getListeClients().size() > 0 && Plat.getListePlats().size() > 0 && Commande.getListeCommandes().size() > 0);
	}
	
	
}