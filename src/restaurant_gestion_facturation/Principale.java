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
		
		// TODO : Enlever cette ligne
		System.out.println(contenuFic);
		OutilsFichier.fermerFicTexteLecture( fic, nomFicCommandes );
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
}
