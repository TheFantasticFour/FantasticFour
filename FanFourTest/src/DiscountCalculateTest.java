import com.example.fanfourproject.discountCalculate;

import junit.framework.TestCase;


public class DiscountCalculateTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testGetDiscountAmount(){
		String code = "DISC10";
		String price = "20.00";
		discountCalculate dc = new discountCalculate(code, price);
		assertEquals(dc.getDiscountAmount(), "2.00");
		
		code = "DISC15";
		price = "20.00";
		dc = new discountCalculate(code, price);
		assertEquals(dc.getDiscountAmount(), "3.00");
		
		code = "DISC20";
		price = "20.00";
		dc = new discountCalculate(code, price);
		assertEquals(dc.getDiscountAmount(), "4.00");
		
	}
	
	public void testDiscountID(){
		String bannerID = "900194231";
		String price = "20.00";
		discountCalculate dc = new discountCalculate(null, bannerID, price);
		assertEquals(dc.discountID(), "2.00");
		
		bannerID = "0";
		price = "20.00";
		dc = new discountCalculate(null, bannerID, price);
		assertEquals(dc.discountID(), "0.00");
		
		bannerID = "words";
		price = "20.00";
		dc = new discountCalculate(null, bannerID, price);
		assertEquals(dc.discountID(), "0.00");
		
		bannerID = null;
		price = "20.00";
		dc = new discountCalculate(null, bannerID, price);
		assertEquals(dc.discountID(), "0.00");
	}

}
