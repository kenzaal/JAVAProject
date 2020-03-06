package dauphine.csvreadwrite;

public class DescriptionRules {
	
	/**
	 * true si un String est numerique false sinon
	 * @param str
	 * @return
	 */
	public static boolean isNumeric(String str) {
	    if (str == null) {
	        return false;
	    }
	    try {
	        Double.parseDouble(str);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	public static boolean isString(String str) {
	    if (!isNumeric(str))
	    	return true;
	    else
	    	return false;
	}
	
	/**
	 * comparer le type d'un string et un type donné
	 * @param expected_type
	 * @param str
	 * @return
	 */
	public static boolean compare_type(String expected_type, String str) {
		if(expected_type == "String" && !DescriptionRules.isNumeric(str)) 
				return true;
		else
			return true;
	}

}