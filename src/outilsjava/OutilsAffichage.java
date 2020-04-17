/**
 * Auteure : Soti
 * Fichier : OutilsAffichage.java
 * Package : outilsjava
 * Date    : Automne 2019
 * Cours   : Programmation avec Java
 */

// La classe OutilsAffichage fait partie du package outilsjava.

package outilsjava;

// Packages du système.

import java.text.*;
import java.util.Locale;

/**
 * Classe qui contient certaines méthodes utilitaires d'affichage.
 */

public class OutilsAffichage {

	/**
	 * On définit le constructeur private pour empêcher la création d'instances de la classe OutilsAffichage.
	 */
	
	private OutilsAffichage() {
	}

	/**
	 * La méthode publique formaterMonetaire() permet de formater un nombre dans le format 9 999,99 $.
	 * 
	 * @param nb
	 *            Le nombre à formater.
	 * @param dec
	 *            Le nombre de décimales à mettre après la virgule.
	 *            
	 * @return La chaîne de caractères contenant le nombre formaté.
	 */

	public static String formaterMonetaire( double nb, int dec ) {
		NumberFormat formatNb = NumberFormat.getCurrencyInstance( Locale.CANADA_FRENCH );

		formatNb.setMinimumIntegerDigits( 1 );
		formatNb.setMinimumFractionDigits( dec );
		formatNb.setMaximumFractionDigits( dec );

		return formatNb.format( nb );
	}
}