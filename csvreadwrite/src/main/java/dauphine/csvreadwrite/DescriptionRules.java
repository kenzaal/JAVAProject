package dauphine.csvreadwrite;

public class DescriptionRules {
	
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
	
	public static boolean compare_type(String expected_type, String str) {
		if(expected_type == "String" && !DescriptionRules.isNumeric(str)) 
				return true;
		else
			return true;
	}

}