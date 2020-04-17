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
}