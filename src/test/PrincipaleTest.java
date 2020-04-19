package test;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.Client;
import main.Commande;
import main.Plat;
import main.Principale;

public class PrincipaleTest {
	

	
	@Test
	public void testLireClients() {
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
	
	@Test
	public void testValiderFormat() {
		// Cas format valide
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
		assertTrue(Principale.validerFormat(contenu));
		// Cas "Clients :" invalide
		contenu = "Clies :\n" + 
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
		assertFalse(Principale.validerFormat(contenu));
		
		// Cas "Fin" invalide
		contenu = "Clients :\n" + 
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
				"F";
		
		assertFalse(Principale.validerFormat(contenu));
		
		// Cas client invalide
		contenu = "Clients :\n" + 
				"Roger George\n" + 
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
		assertFalse(Principale.validerFormat(contenu));
		
		// Cas plats invalide
				contenu = "Clients :\n" + 
						"Roger\n" + 
						"Céline\n" + 
						"Steeve\n" + 
						"Plats :\n" + 
						"Poutine 10.5 Frites\n" + 
						"Frites 2.5\n" + 
						"Repas_Poulet 15.75\n" + 
						"Commandes :\n" + 
						"Roger Poutine 1\n" + 
						"Céline Frites 2\n" + 
						"Céline Repas_Poulet 1\n" + 
						"Fin";
		assertFalse(Principale.validerFormat(contenu));
		
		// Cas commande invalide
		contenu = "Clients :\n" + 
				"Roger\n" + 
				"Céline\n" + 
				"Steeve\n" + 
				"Plats :\n" + 
				"Poutine 10.5\n" + 
				"Frites 2.5\n" + 
				"Repas_Poulet 15.75\n" + 
				"Commandes :\n" + 
				"Roger Poutine 1 Frites\n" + 
				"Céline Frites 2\n" + 
				"Céline Repas_Poulet 1\n" + 
				"Fin";
		assertFalse(Principale.validerFormat(contenu));
	}

}