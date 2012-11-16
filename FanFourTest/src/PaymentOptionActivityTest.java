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
	
		//reset the addresses in order to test the city
		poa.setAddressStreet("Seton11");
		poa.setAddressCity("Collegeville");
		poa.setAddressState("MN");
		poa.setAddressZip("56321");
		
		//reset the addresses in order to test the state
		poa.setAddressStreet("Seton11");
		poa.setAddressCity("Collegeville");
		poa.setAddressState("MN");
		poa.setAddressZip("56321");
		assertTrue(poa.verifyAddress());
		
		poa.setAddressState("Mn");
		assertTrue(poa.verifyAddress());
		
		poa.setAddressState("mN");
		assertTrue(poa.verifyAddress());
		
		poa.setAddressState("mn");
		assertTrue(poa.verifyAddress());
		
		poa.setAddressState("m");
		assertFalse(poa.verifyAddress());
		
		poa.setAddressState("n");
		assertFalse(poa.verifyAddress());
		
		poa.setAddressState("WI");
		assertFalse(poa.verifyAddress());
		
		poa.setAddressState("");
		assertFalse(poa.verifyAddress());
		
		poa.setAddressState(null);
		assertFalse(poa.verifyAddress());
		
		//reset the addresses in order to test the zip 
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
		
		poa.setPhoneNumber("33-66-77-1234");
		assertTrue(poa.verifyPhoneNumber());
		
		poa.setPhoneNumber("7152746");
		assertFalse(poa.verifyPhoneNumber());
		
		poa.setPhoneNumber("");
		assertFalse(poa.verifyPhoneNumber());
		
		poa.setPhoneNumber(null);
		assertFalse(poa.verifyPhoneNumber());
	}
	
	public void testVerifyEmail(){
		PaymentOptionActivity poa = new PaymentOptionActivity();
		
		poa.seteMail("pghardy@csbsju.edu");
		assertTrue(poa.verifyEmail());
		
		poa.seteMail("p@c");
		assertTrue(poa.verifyEmail());
		
		poa.seteMail("pghardy.at.csbsju.edu");
		assertFalse(poa.verifyEmail());
		
		poa.seteMail("");
		assertFalse(poa.verifyEmail());
		
		poa.seteMail(null);
		assertFalse(poa.verifyEmail());
	}
	
	public void testVerifyPayment(){
		PaymentOptionActivity poa = new PaymentOptionActivity();
		
		poa.setPayment("Cash");
		assertTrue(poa.verifyPayment());
		
		poa.setPayment("01258");
		assertTrue(poa.verifyPayment()); //accepts even numbers
		
		poa.setPayment("01257");
		assertFalse(poa.verifyPayment()); //rejects odd numbers
		
		poa.setPayment("adf");
		assertFalse(poa.verifyPayment());
		
		poa.setPayment(null);
		assertFalse(poa.verifyPayment());
		
	}
}
