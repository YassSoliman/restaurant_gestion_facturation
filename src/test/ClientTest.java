package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Client;
import main.Commande;
import main.Plat;

public class ClientTest {

	@Test
	public void testValiderClient() {
		Client client = new Client();
					
		String chaineValidation = "Le client " + client.getNomClient() + " n'existe pas.";
		
		assertEquals(chaineValidation, Client.validerClient(client));
	}
}