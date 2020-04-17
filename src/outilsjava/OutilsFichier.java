/**
 * Auteure : Soti
 * Fichier : OutilsFichier.java
 * Package : outilsjava
 * Date    : Automne 2019
 * Cours   : Programmation avec Java
 */

// La classe OutilsFichier fait partie du package outilsjava.

package outilsjava;

// Packages du syst�me.
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Classe qui contient certaines m�thodes utilitaires pour les fichiers.
 */

public class OutilsFichier implements OutilsConstantes {

	/**
	 * On d�finit le constructeur private pour emp�cher la cr�ation d'instances de
	 * la classe OutilsFichier.
	 */
	private static final int MAX_CAR_FICHIER = 250;

	private OutilsFichier() {
	}

	/**
	 * La m�thode publique lireNomFichier() permet d'afficher une question et de
	 * lire une cha�ne de caract�res repr�sentant un nom physique de fichier.
	 * 
	 * @param question La question � afficher.
	 * 
	 * @return La cha�ne de caract�res repr�sentant un nom physique de fichier.
	 */

	public static String lireNomFichier(String question) {
		String nomFic;

		nomFic = OutilsLecture.lireChaineValide(question, 1, MAX_CAR_FICHIER);

		return nomFic;
	}

	/**
	 * La m�thode publique ouvrirFicTexteLecture() permet d'ouvrir un fichier texte
	 * en mode lecture bufferis�e.
	 * 
	 * @param nomFichier Le nom physique du fichier.
	 * 
	 * @return le nom logique du fichier si l'ouverture est un succ�s ou null dans
	 *         le cas contraire.
	 */

	public static BufferedReader ouvrirFicTexteLecture(String nomFichier) {
		boolean valide = true;
		Path chemin = null;
		String cheminAbsolu;
		BufferedReader ficLecture = null;

		// Cr�ation du chemin.

		try {
			chemin = Paths.get(nomFichier);
		}

		catch (InvalidPathException errNomFichier) {
			System.out.println("\nErreur, le fichier " + nomFichier + " contient des caract�res ill�gaux.");
			valide = false;
		}

		// Si la cr�ation du chemin est valide, on peut poursuivre.

		if (valide) {
			cheminAbsolu = chemin.toAbsolutePath().toString();

			// V�rifier l'existence du fichier.

			if (Files.notExists(chemin)) {
				// Le fichier n'existe pas.

				System.out.println("\nErreur, le fichier " + cheminAbsolu + " n'existe pas.");
				valide = false;

			} else if (Files.exists(chemin)) {
				// Le fichier existe. Est-ce un fichier ordinaire ?

				if (!Files.isRegularFile(chemin)) {

					System.out.println("\nErreur, le fichier " + cheminAbsolu + " n'est pas un fichier ordinaire.");
					valide = false;
				} else {
					// C'est un fichier ordinaire. Est-ce un fichier permis en lecture ?

					if (!Files.isReadable(chemin)) {

						System.out.println("\nErreur, le fichier " + cheminAbsolu + " n'est pas permis en lecture.");
						valide = false;
					} else {
						// Le fichier existe, est ordinaire et permis en lecture.

						// Ouverture du fichier texte en mode lecture.

						try {
							ficLecture = Files.newBufferedReader(chemin, Charset.defaultCharset());
						}

						catch (IOException errIO) {
							System.out.println("\nErreur, impossible d'ouvrir le fichier " + cheminAbsolu
									+ " en mode lecture texte.");
							valide = false;
						}
					}
				}
			} else {
				System.out.println("\nErreur, impossible de v�rifier l'existence du fichier " + cheminAbsolu + ".");
				valide = false;
			}
		}

		return ficLecture;
	}

	/**
	 * La m�thode publique ouvrirFicTexteEcriture() permet d'ouvrir un fichier texte
	 * en mode �criture bufferis�e.
	 * 
	 * @param nomFichier Le nom physique du fichier.
	 * 
	 * @return le nom logique du fichier si l'ouverture est un succ�s ou null dans
	 *         le cas contraire.
	 */

	public static BufferedWriter ouvrirFicTexteEcriture(String nomFichier) {
		boolean valide = true;
		Path chemin = null;
		String cheminAbsolu = "";
		BufferedWriter ficEcriture = null;

		// Cr�ation du chemin.

		try {
			chemin = Paths.get(nomFichier);
		}

		catch (InvalidPathException errNomFichier) {
			System.out.println("\nErreur, le fichier " + nomFichier + " contient des caract�res ill�gaux.");
			valide = false;
		}

		// Si la cr�ation du chemin est valide, on peut poursuivre.

		if (valide) {
			cheminAbsolu = chemin.toAbsolutePath().toString();

			// V�rifier l'existence du fichier.

			if (Files.notExists(chemin)) {
				// Le fichier n'existe pas. On peut l'ouvrir en �criture.

				valide = true;

			} else if (Files.exists(chemin)) {
				// Le fichier existe. Est-ce un fichier ordinaire ?

				if (!Files.isRegularFile(chemin)) {

					System.out.println("\nErreur, le fichier " + cheminAbsolu + " n'est pas un fichier ordinaire.");
					valide = false;
				} else {
					// C'est un fichier ordinaire. Est-ce un fichier permis en �criture ?

					if (!Files.isWritable(chemin)) {

						System.out.println("\nErreur, le fichier " + cheminAbsolu + " n'est pas permis en �criture.");
						valide = false;
					} else {
						// Le fichier existe, est ordinaire et permis en �criture.

						// On demande une confirmation avant de l'�craser.

						System.out.println("\nLe fichier " + cheminAbsolu + " existe.");

						char conf = OutilsLecture.lireOuiNon("Voulez-vous �craser ce fichier ( O ou N ) ? ");

						valide = (conf == OUI); // valide = true ou false.
					}
				}
			} else {
				System.out.println("\nErreur, impossible de v�rifier l'existence du fichier " + cheminAbsolu + ".");
				valide = false;
			}
		}

		if (valide) {
			// Le fichier n'existe pas.
			// Ou le fichier existe, est ordinaire, est permis �criture et on veut
			// l'�craser.

			// Ouverture du fichier texte en mode �criture.

			try {
				ficEcriture = Files.newBufferedWriter(chemin, Charset.defaultCharset());
			}

			catch (IOException errIO) {
				System.out.println(
						"\nErreur, impossible d'ouvrir le fichier " + cheminAbsolu + " en mode �criture texte.");
				valide = false;
			}
		}

		return ficEcriture;
	}

	/**
	 * La m�thode publique fermerFicTexteLecture() permet de fermer un fichier texte
	 * en mode lecture bufferis�e.
	 * 
	 * @param nomLogique Le nom logique du fichier.
	 * @param nomFic     Le nom physique du fichier.
	 * 
	 * @return true si la fermeture du fichier est un succ�s ou false dans le cas
	 *         contraire.
	 */

	public static boolean fermerFicTexteLecture(BufferedReader nomLogique, String nomFic) {

		boolean fermerFic = true;

		try {
			nomLogique.close();
		}

		catch (IOException errIO) {
			System.out.println("Erreur, impossible de fermer le fichier " + nomFic + ".");
			fermerFic = false;
		}

		return fermerFic;
	}

	/**
	 * La m�thode publique fermerFicTexteEcriture() permet de fermer un fichier
	 * texte en mode �criture bufferis�e.
	 * 
	 * @param nomLogique Le nom logique du fichier.
	 * @param nomFic     Le nom physique du fichier.
	 * 
	 * @return true si la fermeture du fichier est un succ�s ou false dans le cas
	 *         contraire.
	 */

	public static boolean fermerFicTexteEcriture(BufferedWriter nomLogique, String nomFic) {

		boolean fermerFic = true;

		try {
			nomLogique.close();
		}

		catch (IOException errIO) {
			System.out.println("Erreur, impossible de fermer le fichier " + nomFic + ".");
			fermerFic = false;
		}

		return fermerFic;
	}
}