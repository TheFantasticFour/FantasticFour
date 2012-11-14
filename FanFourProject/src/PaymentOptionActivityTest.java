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
//		assertTrue(poa.verifyAddress());
//		
//		poa.setAddressZip("56347");
//		assertTrue(poa.verifyAddress());
//		
//		poa.setAddressZip("55443");
//		assertFalse(poa.verifyAddress());
//		
//		poa.setAddressZip("");
//		assertFalse(poa.verifyAddress());
//		
//		poa.setAddressZip(null);
//		assertFalse(poa.verifyAddress());
		
	}
	
//	public void testVerifyPhoneNumber(){
//		if(true){
//			assertEquals(false,false);
//		}
//	}
}
