package restaurant_gestion_facturation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	}

}
