/**
 * Auteure : Soti
 * Fichier : OutilsLecture.java
 * Package : outilsjava
 * Date    : Automne 2019
 * Cours   : Programmation avec Java
 */

// La classe OutilsLecture fait partie du package outilsjava.

package outilsjava;

// Package du syst�me.

import java.io.*;

/**
 * Classe qui contient certaines m�thodes utilitaires de lecture.
 */

public class OutilsLecture implements OutilsConstantes {
	
	// Constantes pour les types de lecture.
	
	public static final char LECTURE_CLAVIER = 'C';
	public static final char LECTURE_FICHIER = 'F';

	// Nom logique du fichier. Par d�faut, lecture du clavier.
	
	public static BufferedReader fic = new BufferedReader( new InputStreamReader( System.in ) );
	
	// Type de Lecture. Par d�faut, lecture du clavier.
	
	public static char type = LECTURE_CLAVIER;

	/**
	 * On d�finit le constructeur private pour emp�cher la cr�ation d'instances de la classe OutilsLecture.
	 */
	
	private OutilsLecture() {
	}
	
	/**
	 * La m�thode publique lireChaine() permet d'afficher une question et de lire une cha�ne de caract�res quelconque.
	 * 
	 * @param question
	 *            La question � afficher.
	 * 
	 * @return La cha�ne de caract�res lue.
	 */

	public static String lireChaine( String question ) {
		String chaine = "";
		boolean valide;
		int lgChaine;

		do {
			valide = true;
			System.out.print( question );

			try {
				// Peut lire une cha�ne du fichier texte des jeux d'essai ou du clavier.

				chaine = fic.readLine();

				if ( type == LECTURE_FICHIER ) {
					// Si lecture du fichier texte, on l'affiche sur la console.

					System.out.println( chaine );
				}

				lgChaine = chaine.length();

				// Erreur, si la cha�ne lue est vide.

				if ( lgChaine == 0 ) {
					System.out.println( "\nErreur, l'entr�e ne doit pas �tre vide." );
					valide = false;
				}
			}

			catch ( IOException errIO ) {
				System.out.println( "\nUne erreur d'entr�e-sortie est survenue." );
				valide = false;
			}

			catch ( Exception err ) {
				System.out.println( "\nUne erreur de lecture est survenue." );
				valide = false;
			}
		} while ( !valide );

		return chaine;
	}

	/**
	 * La m�thode publique lireChaineValide() permet d'afficher une question et de lire une cha�ne de caract�res
	 * dont la longueur fait partie d'un intervalle.
	 * 
	 * @param question
	 *            La question � afficher.
	 * @param nbMinCar
	 *            Le nombre minimum de caract�res � lire.
	 * @param nbMaxCar
	 *            Le nombre maximum de caract�res � lire.
	 * 
	 * @return La cha�ne de caract�res lue.
	 */

	public static String lireChaineValide( String question, int nbMinCar, int nbMaxCar ) {
		String chaine;
		boolean valide;
		int lgChaine;

		do {
			valide = true;

			chaine = OutilsLecture.lireChaine( question );
			
			lgChaine = chaine.length();

			// Erreur, si le nombre de caract�res de la cha�ne lue n'est pas entre nbMinCar et nbMaxCar.

			if ( lgChaine < nbMinCar || lgChaine > nbMaxCar ) {
				System.out.println( "\nErreur, entrez entre " + nbMinCar + " et " + nbMaxCar + " caract�res." );
				valide = false;
			}
		} while ( !valide );

		return chaine;
	}

	
	/**
	 * La m�thode publique lireCaractere() permet d'afficher une question et de lire un caract�re quelconque.
	 * 
	 * @param question
	 *            La question � afficher.
	 * 
	 * @return Le caract�re lu.
	 */

	public static char lireCaractere( String question ) {
		String chaine;
		boolean valide;
		int lgChaine;

		do {
			valide = true;
			
			chaine = OutilsLecture.lireChaine( question );
			
			lgChaine = chaine.length();

			// Erreur, si le nombre de caract�res de la cha�ne lue n'est pas exactement 1.
			
			if ( lgChaine != 1 ) {
				System.out.println( "\nErreur, entrez un seul caract�re." );
				valide = false;
			}
		} while ( !valide );

		// Retourne le premier caract�re de la cha�ne lue.
		
		return chaine.charAt( 0 );
	}

	/**
	 * La m�thode publique lireOuiNon() permet d'afficher une question et de lire une r�ponse O ou N de l'utilisateur.
	 * 
	 * @param question
	 *            La question � afficher.
	 * 
	 * @return Le caract�re O ou N en majuscule.
	 */

	public static char lireOuiNon( String question ) {
		char rep;
		boolean valide;

		do {
			valide = true;

			// Convertir le caract�re lu en majuscule.
			
			rep = Character.toUpperCase( OutilsLecture.lireCaractere( question ) );

			// Erreur, si le caract�re lu n'est pas O ou N.

			if ( rep != OUI && rep != NON ) {
				System.out.println( "\nErreur, r�pondez par " + OUI + " ou " + NON + " seulement." );
				valide = false;
			}
		} while ( !valide );

		return rep;
	}

}