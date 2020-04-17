/**
 * Auteure : Soti
 * Fichier : OutilsLecture.java
 * Package : outilsjava
 * Date    : Automne 2019
 * Cours   : Programmation avec Java
 */

// La classe OutilsLecture fait partie du package outilsjava.

package outilsjava;

// Package du système.

import java.io.*;

/**
 * Classe qui contient certaines méthodes utilitaires de lecture.
 */

public class OutilsLecture implements OutilsConstantes {
	
	// Constantes pour les types de lecture.
	
	public static final char LECTURE_CLAVIER = 'C';
	public static final char LECTURE_FICHIER = 'F';

	// Nom logique du fichier. Par défaut, lecture du clavier.
	
	public static BufferedReader fic = new BufferedReader( new InputStreamReader( System.in ) );
	
	// Type de Lecture. Par défaut, lecture du clavier.
	
	public static char type = LECTURE_CLAVIER;

	/**
	 * On définit le constructeur private pour empêcher la création d'instances de la classe OutilsLecture.
	 */
	
	private OutilsLecture() {
	}
	
	/**
	 * La méthode publique lireChaine() permet d'afficher une question et de lire une chaîne de caractères quelconque.
	 * 
	 * @param question
	 *            La question à afficher.
	 * 
	 * @return La chaîne de caractères lue.
	 */

	public static String lireChaine( String question ) {
		String chaine = "";
		boolean valide;
		int lgChaine;

		do {
			valide = true;
			System.out.print( question );

			try {
				// Peut lire une chaîne du fichier texte des jeux d'essai ou du clavier.

				chaine = fic.readLine();

				if ( type == LECTURE_FICHIER ) {
					// Si lecture du fichier texte, on l'affiche sur la console.

					System.out.println( chaine );
				}

				lgChaine = chaine.length();

				// Erreur, si la chaîne lue est vide.

				if ( lgChaine == 0 ) {
					System.out.println( "\nErreur, l'entrée ne doit pas être vide." );
					valide = false;
				}
			}

			catch ( IOException errIO ) {
				System.out.println( "\nUne erreur d'entrée-sortie est survenue." );
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
	 * La méthode publique lireChaineValide() permet d'afficher une question et de lire une chaîne de caractères
	 * dont la longueur fait partie d'un intervalle.
	 * 
	 * @param question
	 *            La question à afficher.
	 * @param nbMinCar
	 *            Le nombre minimum de caractères à lire.
	 * @param nbMaxCar
	 *            Le nombre maximum de caractères à lire.
	 * 
	 * @return La chaîne de caractères lue.
	 */

	public static String lireChaineValide( String question, int nbMinCar, int nbMaxCar ) {
		String chaine;
		boolean valide;
		int lgChaine;

		do {
			valide = true;

			chaine = OutilsLecture.lireChaine( question );
			
			lgChaine = chaine.length();

			// Erreur, si le nombre de caractères de la chaîne lue n'est pas entre nbMinCar et nbMaxCar.

			if ( lgChaine < nbMinCar || lgChaine > nbMaxCar ) {
				System.out.println( "\nErreur, entrez entre " + nbMinCar + " et " + nbMaxCar + " caractères." );
				valide = false;
			}
		} while ( !valide );

		return chaine;
	}

	
	/**
	 * La méthode publique lireCaractere() permet d'afficher une question et de lire un caractère quelconque.
	 * 
	 * @param question
	 *            La question à afficher.
	 * 
	 * @return Le caractère lu.
	 */

	public static char lireCaractere( String question ) {
		String chaine;
		boolean valide;
		int lgChaine;

		do {
			valide = true;
			
			chaine = OutilsLecture.lireChaine( question );
			
			lgChaine = chaine.length();

			// Erreur, si le nombre de caractères de la chaîne lue n'est pas exactement 1.
			
			if ( lgChaine != 1 ) {
				System.out.println( "\nErreur, entrez un seul caractère." );
				valide = false;
			}
		} while ( !valide );

		// Retourne le premier caractère de la chaîne lue.
		
		return chaine.charAt( 0 );
	}

	/**
	 * La méthode publique lireOuiNon() permet d'afficher une question et de lire une réponse O ou N de l'utilisateur.
	 * 
	 * @param question
	 *            La question à afficher.
	 * 
	 * @return Le caractère O ou N en majuscule.
	 */

	public static char lireOuiNon( String question ) {
		char rep;
		boolean valide;

		do {
			valide = true;

			// Convertir le caractère lu en majuscule.
			
			rep = Character.toUpperCase( OutilsLecture.lireCaractere( question ) );

			// Erreur, si le caractère lu n'est pas O ou N.

			if ( rep != OUI && rep != NON ) {
				System.out.println( "\nErreur, répondez par " + OUI + " ou " + NON + " seulement." );
				valide = false;
			}
		} while ( !valide );

		return rep;
	}

}