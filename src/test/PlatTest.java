package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Client;
import main.Commande;
import main.Plat;

public class PlatTest {

	@Test
	public void testValiderPlat() {
		
		Plat plat = new Plat();
			
		String chaineValidation = "Le plat " + plat.getNomPlat() + " n'existe pas.";
		
		assertEquals(chaineValidation, Plat.validerPlat(plat));
	}	
	
	@Test
	public void testConstructeurPlat() {
		Plat plat = new Plat("Plat", 10.00);
		
		assertTrue(Plat.getListePlats().contains(plat));
	}
}
