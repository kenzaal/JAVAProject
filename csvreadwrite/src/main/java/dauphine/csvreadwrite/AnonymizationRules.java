/**
 * 
 */
package dauphine.csvreadwrite;

import java.util.Random;

/**
 * Cette classe contient les règles d'anonymisation de données
 * @author Kenza SAAL
 *
 */
public class AnonymizationRules {

	/**
	 * Remplace chaque lettre du mot entré en argument par une autre lettre
	 * aléatoire
	 * 
	 * @param word : chaîne de carachtère.
	 * @return chaîne de carachtère modifiée.
	 */
	public String rondomLetter(String word) {
		// Intialize a Random Number Generator with SysTime as the seed
		Random random = new Random(); 
		int wordLength = word.length();
		StringBuilder sb = new StringBuilder(wordLength);

		for (int i = 0; i < wordLength; i++) { // For each letter in the word
			char tmp = (char) ('a' + random.nextInt('z' - 'a')); // Generate a letter between a and z
			sb.append(tmp); // Add it to the String
		}

		System.out.println("word: " + word);
		System.out.println("random letter: " + sb.toString());

		return sb.toString();

	}

	/**
	 * Remplace les lettres du nom local d'un mail par d'autres lettres aléatoires. 
	 * 
	 * @param email : Chaîne de caractère qui représente l'email à modifier.
	 * @return mail modifié.
	 */
	public String randomLetterForRandomPart(String email) {
		String[] temp;
		String delimiter = "@";
		
		temp = email.split(delimiter);
		String randomDomain = this.rondomLetter(temp[0]);
		
		String res = randomDomain + "@" + temp[1];
		
		System.out.println("email: "+email);
		System.out.println("modified email: "+res);
		
		return res;
		
	}

}
