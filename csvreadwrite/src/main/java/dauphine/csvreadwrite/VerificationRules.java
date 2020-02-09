/**
 * 
 */
package dauphine.csvreadwrite;

import java.util.regex.Matcher;
import org.apache.commons.validator.routines.EmailValidator;
import java.util.regex.Pattern;

/**
 * Cette classe contient les règles de Vérification de données
 * @author Kenza SAAL
 *
 */
public class VerificationRules {
	
	public VerificationRules() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Vérifie si un l'âge entré en argument est valide. un âge doit
	 * être un nombre entre 0 et 120.
	 * 
	 * @param a : un entier qui represente un âge.
	 * @return true si l'âge entré en paramètre est correct sinon false.
	 */
	public boolean age(int age) {
		if (age > 0 && age < 120)
			return true;
		return false;
	}

	/**
	 * Vérifie si un e-mail est de la forme XXX@YYY.ZZ..
	 * 
	 * @param email : Chaîne de caractère qui représente l'email à vérifier.
	 * @return true si le mail entré en paramètre est correct, false sinon.
	 */
	public boolean beAnEmail(String email) {

		EmailValidator validator = EmailValidator.getInstance();

		if (!validator.isValid(email)) {
			return false;
		}
		return true;
	}

	
	
	/**
	 * Vérifie si un e-mail est un e-mail Dauphine donc de la forme XXX@dauphine.eu ou XXX@dauphine.psl.eu ou XXX@lamsade.dauphine.fr
	 * pour ce faire des expréssions régulières ont été utilisées.
	 * 
	 * @param email : chaîne de caractère qui représente l'email à vérifier.
	 * @return true si le mail entré en paramètre est correct, false sinon.
	 */
	public boolean beADauphineEmail(String email) {
	
		String regex1 = "^[\\w\\+]+(\\.[\\w]+)*@dauphine\\.eu$";
		String regex2 = "^[\\w\\+]+(\\.[\\w]+)*@dauphine\\.psl\\.eu$";
		String regex3 = "^[\\w\\+]+(\\.[\\w]+)*@lamsade\\.dauphine\\.fr$";

		Pattern pattern1 = Pattern.compile(regex1);
		Pattern pattern2 = Pattern.compile(regex2);
		Pattern pattern3 = Pattern.compile(regex3);
		
		Matcher matcher1 = pattern1.matcher(email);
		Matcher matcher2 = pattern2.matcher(email);
		Matcher matcher3 = pattern3.matcher(email);
		
		if(matcher1.matches() || matcher3.matches() || matcher2.matches()) 
			return true;
		
		
		return false;
		
	}

}
