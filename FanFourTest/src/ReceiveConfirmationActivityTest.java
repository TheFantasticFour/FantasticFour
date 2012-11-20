import com.example.fanfourproject.ReceiveConfirmationActivity;

import junit.framework.TestCase;


public class ReceiveConfirmationActivityTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testGenerateConfID(){
		//Tests to confirm the random confirmation id generator is creating
		//strings of length 10 and with 0's and O's.
		ReceiveConfirmationActivity rca = new ReceiveConfirmationActivity();
		
		String confirmationCode = rca.generateConfID();
		assertTrue(confirmationCode.length() == 10);
		
		assertFalse(confirmationCode.contains("0"));
		assertFalse(confirmationCode.contains("O"));
	}
	
	

}
