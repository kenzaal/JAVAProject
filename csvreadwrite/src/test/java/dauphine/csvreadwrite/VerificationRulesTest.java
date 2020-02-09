package dauphine.csvreadwrite;

import org.junit.Test;

import junit.framework.TestCase;

/**
 * Test unitaire de la classe VerificationRules.
 */
public class VerificationRulesTest extends TestCase {

	VerificationRules test = new VerificationRules();
	

	@Test
	public void testAge() throws Exception {

		boolean agetest1 = this.test.age(22);
		boolean agetest2 = this.test.age(126);
		
		assertEquals(agetest1, true);
		assertEquals(agetest2, false);
	}
	
	@Test
	public void testBeAnEmail() throws Exception {

		boolean email1 = test.beAnEmail("kenzasaal@gmail.com");
		boolean email2 = test.beAnEmail("toto.com");
		boolean email3 = test.beAnEmail("@dauphine.eu");
		boolean email4 = test.beAnEmail("kenza.98@yahoo.eu");
		
		assertEquals(email1, true);
		assertEquals(email2, false);
		assertEquals(email3, false);
		assertEquals(email4, true);
	}
	
	@Test
	public void testBeADauphineEmail() throws Exception {

		boolean email1 = test.beADauphineEmail("kenzasaal@gmail.com");
		boolean email2 = test.beADauphineEmail("kenzasaal@dauphine.eu");
		boolean email3 = test.beADauphineEmail("kenza@dauphine.psl.eu");
		boolean email4 = test.beADauphineEmail("kenza@lamsade.dauphine.fr");
		
		assertEquals(email1, false);
		assertEquals(email2, true);
		assertEquals(email3, true);
		assertEquals(email4, true);
	}

}
