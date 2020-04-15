package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.Client;

public class FactureTest {

	@Test
	public void testFactureNull() {
		Client client = new Client("Client");
			
		assertEquals("", client.getFacture().afficherFacture());
	}
}
