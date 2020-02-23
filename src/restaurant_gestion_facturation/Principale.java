package restaurant_gestion_facturation;

import java.io.*;
import outilsjava.OutilsFichier;
import outilsjava.OutilsLecture;

public class Principale {

	public static void main(String[] args) {

		String nomFicCommandes;
		String contenuFic = "";
		
		String plats = "";
		
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
			creerFacture(tabClients);
			OutilsFichier.fermerFicTexteLecture( fic, nomFicCommandes );
		} else {
			System.out.println("Le fichier ne respecte pas le format demandé !");
		}
		
		
	}
	
	//Ecriture du fichier 
	private BufferedWriter ecrireFichier( String nomFichier, Client[] tabClient ) {

		BufferedWriter ficEcriture = null;

		ficEcriture = OutilsFichier.ouvrirFicTexteEcriture(nomFichier);

		if ( ficEcriture != null ) {
			
			try {
				System.out.println("Bienvenue chez Barette!\nFactures:\n");
				
				for (int i = 0; i < tabClient.length; i++) {
					ficEcriture.write(tabClient[i].getNomClient() + " " + tabClient[i].calculerFacture() + "$\n");
				}
			} catch (Exception e) {
				
			}

			OutilsFichier.fermerFicTexteEcriture( ficEcriture, nomFichier );
		}
		
		return ficEcriture;
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
	
	private static void creerFacture(Client[] tabClients) {
		System.out.println("\nBienvenue chez Barette!\nFactures:");
		
		for(Client cli : tabClients) {
            System.out.print(cli.getNomClient() + " " + cli.calculerFacture() + "$\n");
        }		
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
