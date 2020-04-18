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
		
		Plat plat = new Plat();
		plat.setNomPlat("Poutine");
		plat.setPrixPlat(10.5);
		
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
		Plat.creerPlat(contenu);
	//	assertEquals(contenu, Plat.validerPlat(plat));
		assertTrue(Plat.getListePlats().get(0).getNomPlat()==plat.getNomPlat());
		
	}	
}
