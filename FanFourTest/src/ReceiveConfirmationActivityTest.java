import com.example.fanfourproject.ReceiveConfirmationActivity;

import junit.framework.TestCase;


public class ReceiveConfirmationActivityTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testGenerateConfID(){
		ReceiveConfirmationActivity rca = new ReceiveConfirmationActivity();
		
		String confirmationCode = rca.generateConfID();
		assertTrue(confirmationCode.length() == 10);
		
		assertFalse(confirmationCode.contains("0"));
		assertFalse(confirmationCode.contains("O"));
	}
	
	

}
