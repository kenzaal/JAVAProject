package dauphine.csvreadwrite;

import static org.junit.Assert.assertEquals;

//import java.util.logging.Logger;
import org.junit.Test;


/**
 * Test unitaire de la classe AnonymizationRules.
 */
public class AnonymizationRulesTest{

	AnonymizationRules test = new AnonymizationRules();
	
	 //private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	@Test
	public void rondomLetterTest() throws Exception {
		String word = "Programmation";
		String randomWord = test.rondomLetter(word);
		
		assertEquals(word.equals(randomWord), false);

	}
	
	@Test
	public void randomLetterForRandomPartTest() throws Exception {
		String email = "Programmation@dauphine.eu";
		String changedemail = test.randomLetterForRandomPart(email);
		
		assertEquals(email.equals(changedemail), false);

	}

}
