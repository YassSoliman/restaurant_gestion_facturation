package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import main.Client;

public class ClientTest {

	@Test
	public void testValiderClient() {
		Client client = new Client();
					
		String chaineValidation = "Le client " + client.getNomClient() + " n'existe pas.";
		
		assertEquals(chaineValidation, Client.validerClient(client));
	}
  
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testEqualsClient() {
		Client client = new Client();
		
		assertFalse(client.equals(client.getFacture()));
	}
}