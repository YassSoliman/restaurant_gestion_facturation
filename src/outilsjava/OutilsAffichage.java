/**
 * Auteure : Soti
 * Fichier : OutilsAffichage.java
 * Package : outilsjava
 * Date    : Automne 2019
 * Cours   : Programmation avec Java
 */

// La classe OutilsAffichage fait partie du package outilsjava.

package outilsjava;

// Packages du syst�me.

import java.text.*;
import java.util.Locale;

/**
 * Classe qui contient certaines m�thodes utilitaires d'affichage.
 */

public class OutilsAffichage {

	/**
	 * On d�finit le constructeur private pour emp�cher la cr�ation d'instances de la classe OutilsAffichage.
	 */
	
	private OutilsAffichage() {
	}

	/**
	 * La m�thode publique formaterMonetaire() permet de formater un nombre dans le format 9 999,99 $.
	 * 
	 * @param nb
	 *            Le nombre � formater.
	 * @param dec
	 *            Le nombre de d�cimales � mettre apr�s la virgule.
	 *            
	 * @return La cha�ne de caract�res contenant le nombre format�.
	 */

	public static String formaterMonetaire( double nb, int dec ) {
		NumberFormat formatNb = NumberFormat.getCurrencyInstance( Locale.CANADA_FRENCH );

		formatNb.setMinimumIntegerDigits( 1 );
		formatNb.setMinimumFractionDigits( dec );
		formatNb.setMaximumFractionDigits( dec );

		return formatNb.format( nb );
	}
}