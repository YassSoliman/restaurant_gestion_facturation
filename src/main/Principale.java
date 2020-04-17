package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import outilsjava.*;

public class Principale {

	public static void main(String[] args) {

		String nomFicCommandes;
		String contenuFic = "";
		
		// Assume lire les données du clavier.

		BufferedReader fic = new BufferedReader( new InputStreamReader( System.in ) );

		OutilsLecture.fic = fic;
		
		nomFicCommandes = OutilsFichier
				.lireNomFichier( "Entrez le nom du fichier d'entrée : " );

		fic = OutilsFichier.ouvrirFicTexteLecture( nomFicCommandes );
		
		String line;
		try {
			while((line = fic.readLine()) != null) {
				contenuFic += line + "\n";
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(validerFormat(contenuFic)) {
			lireClients(contenuFic);
							
			if (Commande.erreurs.length() > 67) {
				System.out.println(Commande.erreurs);
			}
						
			String message = Facture.creerFacture();
			
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH'h'mm");
			Date date = new Date();
						
			ecrireFichier("Facture-du-" + dateFormat.format(date) + ".txt", message);
			OutilsFichier.fermerFicTexteLecture( fic, nomFicCommandes );
		} else {
			System.out.println("Le fichier ne respecte pas le format demandé !");
		}				
	}
	
	//Ecriture du fichier 
	private static void ecrireFichier( String nomFichier, String contenuFacture ) {

		BufferedWriter ficEcriture = null;

		ficEcriture = OutilsFichier.ouvrirFicTexteEcriture(nomFichier);

		if ( ficEcriture != null ) {
			try {
				ficEcriture.write(contenuFacture);
			} catch (IOException e) {
				e.printStackTrace();
			}

			OutilsFichier.fermerFicTexteEcriture( ficEcriture, nomFichier );
		}
	}
	
	private static void lireClients(String contenu) {
		Client.creerClients(contenu);
		Plat.creerPlat(contenu);
		Commande.creerCommandes(contenu);
	}
	
	
	
	private static boolean validerFormat(String contenu) {
		boolean valide = true;
		boolean clientsValide = false;
		boolean platsValide = false;
		boolean commandesValide = false;
		String[] contenuLigne = contenu.split("\n");
		if(!contenuLigne[0].trim().equals("Clients :") || !contenuLigne[contenuLigne.length - 1].trim().equals("Fin")) {			
			valide = false;
		}
		if (valide) { 
			for(int i = 1; i < contenuLigne.length; i++) {
				if (contenuLigne[i].trim().contentEquals("Plats :")) {
					clientsValide = true;
					continue;
				}
				if (contenuLigne[i].trim().contentEquals("Commandes :")) {
					platsValide = true;
					continue;
				}
				if (contenuLigne[i].trim().contentEquals("Fin")) {
					commandesValide = true;
					break;
				}
				
				String[] tabLigne = contenuLigne[i].split(" ");
				
				if (tabLigne.length != 1 && !clientsValide) {
					clientsValide = false;
					break;
				}
				if (tabLigne.length != 2 && !platsValide && clientsValide) {
					platsValide = false;
					break;
				}
				if (tabLigne.length != 3 && !commandesValide && platsValide) {
					commandesValide = false;
					break;
				}								
			}
			valide = clientsValide && platsValide && commandesValide;
		}
		
		return valide;
	}
}
