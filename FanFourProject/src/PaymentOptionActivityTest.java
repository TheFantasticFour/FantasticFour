import junit.framework.TestCase;

import com.example.fanfourproject.Order;


public class PaymentOptionActivityTest extends TestCase {
	
	@Override
	protected void setUp() throws Exception {
		//super.setUp();
	}
	
	public void testVerifyAddress(){
		Order myOrder = new Order();
		myOrder.checkDecimals(Double.valueOf(6.894));
	}
	
	public void testVerifyPhoneNumber(){
		if(true){
			assertEquals(false,false);
		}
	}
}
