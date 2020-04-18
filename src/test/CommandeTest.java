package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Client;
import main.Commande;
import main.Plat;

public class CommandeTest {
	
	@Test
	public void testValiderQuantite() {
		Commande.erreurs = "\n#####################\n"
				 + "# Message d'erreurs #\n"
				 + "#####################\n";

		Client client = new Client("Client A");
		Plat plat = new Plat("Plat A", 19.99);
		int quantite = 0;
		Commande commande = new Commande(client, plat, quantite);
		
		assertEquals("La quantité de plat commandé est invalide.", Commande.validerQuantite(quantite));
	}
	
	@Test
	public void testValiderCommande() {
		Commande.erreurs = "\n#####################\n"
				 + "# Message d'erreurs #\n"
				 + "#####################\n";

		Client client = new Client();
		client.setNomClient("gorge");
		Plat plat = new Plat();
		plat.setNomPlat("kimchi");
		Commande commande = new Commande(client, plat, -4);
		
		String chaineValidation = "\n#####################\n" + 
				"# Message d'erreurs #\n" + 
				"#####################\n" + 
				"\n" + 
				"Commande : gorge kimchi -4\n" + 
				"Détails : \n" + 
				"	La quantité de plat commandé est invalide.\n" + 
				"	Le client gorge n'existe pas.\n" + 
				"	Le plat kimchi n'existe pas.";
		
				
		
		assertEquals(chaineValidation, Commande.erreurs);
	}

	@Test
	public void testCreerCommandes() {
		// Cas creerCommandes fonctionnel
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
		Client.creerClients(contenu);
		Plat.creerPlat(contenu);
		Commande.creerCommandes(contenu);
		
		Client cli = new Client();
		cli.setNomClient("Roger");
		Plat plat = new Plat();
		plat.setNomPlat("Poutine");
		plat.setPrixPlat(10.5);
		Commande com = new Commande();
		com.setClient(cli);
		com.setPlatCommander(plat);
		com.setQteCommande(1);
		
		assertTrue(Commande.getListeCommandes().contains(com));
		
		
		// Cas creerCommande ou ligneCommande != 3
		Commande.getListeCommandes().clear();
		Plat.getListePlats().clear();
		Client.getListeClients().clear();
		contenu = "Clients :\n" + 
				"Roger\n" + 
				"Céline\n" + 
				"Steeve\n" + 
				"Plats :\n" + 
				"Poutine 10.5\n" + 
				"Frites 2.5\n" + 
				"Repas_Poulet 15.75\n" + 
				"Commandes :\n" + 
				"Roger 1\n" + 
				"Céline Frites 2\n" + 
				"Céline Repas_Poulet 1\n" + 
				"Fin";
		Client.creerClients(contenu);
		Plat.creerPlat(contenu);
		Commande.creerCommandes(contenu);
		
		assertFalse(Commande.getListeCommandes().contains(com));
		
		// Cas ou le client et le plat n'existe pas
		Commande.getListeCommandes().clear();
		Plat.getListePlats().clear();
		Client.getListeClients().clear();
		contenu = "Clients :\n" + 
				"Roger\n" + 
				"Céline\n" + 
				"Steeve\n" + 
				"Plats :\n" + 
				"Poutine 10.5\n" + 
				"Frites 2.5\n" + 
				"Repas_Poulet 15.75\n" + 
				"Commandes :\n" + 
				"George Jus_Pomme 1\n" + 
				"Céline Frites 2\n" + 
				"Céline Repas_Poulet 1\n" + 
				"Fin";
		cli.setNomClient("George");
		com.setClient(cli);
		plat.setNomPlat("Jus_Pomme");
		plat.setPrixPlat(0);
		com.setPlatCommander(plat);
		
		
		Client.creerClients(contenu);
		Plat.creerPlat(contenu);
		Commande.creerCommandes(contenu);
		
		assertTrue(Commande.getListeCommandes().contains(com));
				
	}

	@Test
	public void testEquals() {
		Client client = new Client("George");
		Plat plat = new Plat("Poulet", 12.5);
		Commande commande = new Commande(client, plat, 2);
		
		// Cas commande compare avec elle meme
		assertTrue(commande.equals(commande));
		
		// Cas commande compare avec objet pas de type commande
		assertFalse(commande.equals(new String("Pas une commande")));
		
		// Cas commande compare avec commande plat different et qte plus petite
		Plat plat2 = new Plat("Coke", 2.5);
		Commande commande2 = new Commande(client, plat2, 1);
		
		assertFalse(commande.equals(commande2));
		
		// Cas commande compare avec commande qte plus grande
		Commande commande3 = new Commande(client, plat, 5);
		
		assertFalse(commande.equals(commande3));
		
	}
}