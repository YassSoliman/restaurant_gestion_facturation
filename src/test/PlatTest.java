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
	public void testCreerPlat() {
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
		// Cas creerPlat fonctionnel
		Plat.getListePlats().clear();
		Plat.creerPlat(contenu);
		Plat plat = new Plat();
		plat.setNomPlat("Frites");
		plat.setPrixPlat(2.5);		
		
		assertTrue(Plat.getListePlats().contains(plat));
		
		// Cas contenu vide
		Plat.getListePlats().clear();
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
