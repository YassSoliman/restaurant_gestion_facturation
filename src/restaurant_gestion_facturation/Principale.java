package restaurant_gestion_facturation;

import java.io.*;
import outilsjava.OutilsFichier;
import outilsjava.OutilsLecture;

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
			Client[] tabClients = lireClients(contenuFic);
			creerFacture(tabClients, nomFicCommandes);
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
	
	private static Client[] lireClients(String contenu) {
		Client[] tabClients = new Client[0];
		Plat[] tabPlats = new Plat[0];
		Commande[] tabCommande = new Commande[0];
		
		tabClients = Client.creerClients(contenu);
		tabPlats = Plat.creerPlat(tabClients, contenu);
		tabCommande = Commande.creerCommandes(tabClients, tabPlats, contenu);
		
		return tabClients;
	}
	
	private static void creerFacture(Client[] tabClients, String nomFic) {
		String message = "Bienvenue chez Barette!\nFactures:\n";
		
		for (Client cli : tabClients) {
			message += cli.getNomClient() + " " + cli.calculerFacture() + "$\n";
		}
		
		System.out.print("\n" + message);
		
		String[] nomFicSplit = nomFic.split("\\.");
		
		ecrireFichier(nomFicSplit[0] + "Sortie.txt", message);
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
