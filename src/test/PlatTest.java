package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Client;
import main.Commande;
import main.Plat;

public class PlatTest {

	@Test
	public void testValiderPlat() {
		Client client = new Client();
		Plat plat = new Plat(null, 0);
		Commande commande = null;
		client.ajouterCommande(commande);
			
		String chaineValidation = "Le plat " + plat.getNomPlat() + " n'existe pas.";
		
		assertEquals(chaineValidation, Plat.validerPlat(plat));
	}	
}
