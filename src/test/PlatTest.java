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
		
		// Cas ligne plat invalide
		String contenu = "Clients :\n" + 
				"Roger\n" + 
				"Céline\n" + 
				"Steeve\n" + 
				"Plats :\n" + 
				"Poutine\n" + 
				"Frites 2.5\n" + 
				"Repas_Poulet 15.75\n" + 
				"Commandes :\n" + 
				"Roger Poutine 1\n" + 
				"Céline Frites 2\n" + 
				"Céline Repas_Poulet 1\n" + 
				"Fin";
		Plat.creerPlat(contenu);
		Plat plat = new Plat();
		plat.setNomPlat("Poutine");
		assertFalse(Plat.getListePlats().contains(plat));
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

	@Test
	public void testEquals() {
		// Cas plats identique
		Plat plat = new Plat("Plat A", 10.5);
		assertTrue(plat.equals(plat));
		
		// Cas plat comparer a un objet qui n'est pas un plat
		String pasPlat = new String("Pas un plat");
		assertFalse(plat.equals(pasPlat));
		
		// Cas plat comparer a plat plus cher et nom identique
		Plat platCher = new Plat("Plat A", 15.00);
		assertFalse(plat.equals(platCher));
		
		// Cas plat comparer a plat moins cher et nom identique
		Plat platMoinsCher = new Plat("Plat A", 5.00);
		assertFalse(plat.equals(platMoinsCher));
		
		// Cas plat comparer a plat different avec meme nom et prix
		Plat platB = new Plat("Plat A", 10.5);
		assertTrue(plat.equals(platB));		
	}
}
