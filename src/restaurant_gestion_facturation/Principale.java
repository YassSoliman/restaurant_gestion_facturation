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
		
		Client[] tabClients = lireClients(contenuFic);
		creerFacture(tabClients);
		OutilsFichier.fermerFicTexteLecture( fic, nomFicCommandes );
	}
	
	//Ecriture du fichier 
	private static void ecrireFichier( String nomFichier, Client[] tabClient ) {

		BufferedWriter ficEcriture = null;

		ficEcriture = OutilsFichier.ouvrirFicTexteEcriture(nomFichier);

		if ( ficEcriture != null ) {
			try {
				ficEcriture.write("\nBienvenue chez Barette!\nFactures:");;
				
				for (int i = 0; i < tabClient.length; i++) {
					ficEcriture.write(tabClient[i].getNomClient() + " " + tabClient[i].calculerFacture() + "$\n");
				}
			} catch (Exception e) {
				
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
	
	private static void creerFacture(Client[] tabClients) {
		//System.out.println("\nBienvenue chez Barette!\nFactures:");
		ecrireFichier("factureTestSortie.txt", tabClients);
	}
}
