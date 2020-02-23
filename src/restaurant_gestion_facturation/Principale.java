package restaurant_gestion_facturation;

import java.io.*;

import outilsjava.OutilsFichier;

public class Principale {

	public static void main(String[] args) {
		
	}
	
	
	//Ecriture du fichier 
	private BufferedWriter ecrireFichier( String nomFichier, Client client ) {

		BufferedWriter ficEcriture = null;

		ficEcriture = OutilsFichier.ouvrirFicTexteEcriture(nomFichier);

		if ( ficEcriture != null ) {
			
			try {
				ficEcriture.write("Bienvenue chez Barette!\nFactures:\n" + client.getNomClient() + " " + client.calculerFacture() + "$");
			} catch (Exception e) {
				// TODO: handle exception
			}

			OutilsFichier.fermerFicTexteEcriture( ficEcriture, nomFichier );
		}
		
		return ficEcriture;
	}
}
