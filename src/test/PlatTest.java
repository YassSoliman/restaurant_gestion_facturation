package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import main.Plat;

public class PlatTest {

	@Test
	public void testValiderPlat() {
		
		Plat plat = new Plat();
			
		String chaineValidation = "Le plat " + plat.getNomPlat() + " n'existe pas.";
		
		assertEquals(chaineValidation, Plat.validerPlat(plat));
	}	
	
	@Test
	public void testCreerPlat() {
		Plat.getListePlats().clear();
		// Cas contenu vide
		Plat.creerPlat("");
		assertTrue(Plat.getListePlats().isEmpty());
	}
	
	@Test
	public void testConstructeurPlat() {
		Plat plat = new Plat("Plat", 10.00);
		
		assertTrue(Plat.getListePlats().contains(plat));
	}
	
	@Test
	public void testToString() {
		Plat plat = new Plat("Plat", 10.00);
		
		assertEquals(plat.toString(), plat.getNomPlat() + " " + plat.getPrixPlat());
	}
}
