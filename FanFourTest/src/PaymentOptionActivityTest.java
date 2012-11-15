import junit.framework.TestCase;
import com.example.fanfourproject.PaymentOptionActivity;


public class PaymentOptionActivityTest extends TestCase {
	
	
	
	@Override
	protected void setUp() throws Exception {
		//poa = new PaymentOptionActivity();
	}
	
	public void testVerifyAddress(){
		PaymentOptionActivity poa = new PaymentOptionActivity();
		//System.out.println(poa);
		
		poa.setAddressStreet("Seton11");
		poa.setAddressCity("Collegeville");
		poa.setAddressState("MN");
		poa.setAddressZip("56321");
		assertTrue(poa.verifyAddress());
		
		poa.setAddressZip("56374");
		assertTrue(poa.verifyAddress());
		
		poa.setAddressZip("55443");
		assertFalse(poa.verifyAddress());
		
		poa.setAddressZip("");
		assertFalse(poa.verifyAddress());
		
		poa.setAddressZip(null);
		assertFalse(poa.verifyAddress());
		
	}
	
	public void testVerifyPhoneNumber(){
		PaymentOptionActivity poa = new PaymentOptionActivity();
		
		poa.setPhoneNumber("612-715-2746");
		assertTrue(poa.verifyPhoneNumber());
		
		poa.setPhoneNumber("6127152746");
		assertTrue(poa.verifyPhoneNumber());
		
		poa.setPhoneNumber("7152746");
		assertFalse(poa.verifyPhoneNumber());
		
		poa.setPhoneNumber("33-66-77-1234");
		assertTrue(poa.verifyPhoneNumber());
	}
}
