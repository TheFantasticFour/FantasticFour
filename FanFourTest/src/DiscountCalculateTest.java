import com.example.fanfourproject.discountCalculate;

import junit.framework.TestCase;


public class DiscountCalculateTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testGetDiscountAmount(){
		//tests to assure exactly 10% will be deducted from $20.00
		String code = "DISC10";
		String price = "20.00";
		discountCalculate dc = new discountCalculate(code, price);
		assertEquals(dc.getDiscountAmount(), "2.00");
		
		//tests to assure exactly 15% will be deducted from $20.00
		code = "DISC15";
		price = "20.00";
		dc = new discountCalculate(code, price);
		assertEquals(dc.getDiscountAmount(), "3.00");
		
		//tests to assure exactly 20% will be deducted from $20.00
		code = "DISC20";
		price = "20.00";
		dc = new discountCalculate(code, price);
		assertEquals(dc.getDiscountAmount(), "4.00");
		
		//tests to assure exactly 10% will be deducted from $16.79
		code = "DISC10";
		price = "16.79";
		dc = new discountCalculate(code, price);
		assertEquals(dc.getDiscountAmount(), "1.68");
				
		//tests to assure exactly 20% will be deducted from $16.79
		code = "DISC20";
		price = "16.79";
		dc = new discountCalculate(code, price);
		assertEquals(dc.getDiscountAmount(), "3.36");
		
	}
	
	public void testDiscountID(){
		//tests the Banner ID discount feature with a valid Banner ID
		String bannerID = "900194231";
		String price = "20.00";
		discountCalculate dc = new discountCalculate(null, bannerID, price);
		assertEquals(dc.discountID(), "2.00");
		
		//tests the Banner ID discount feature with an invalid Banner ID
		bannerID = "0";
		price = "20.00";
		dc = new discountCalculate(null, bannerID, price);
		assertEquals(dc.discountID(), "0.00");
		
		//tests the Banner ID discount feature with an invalid Banner ID
		bannerID = "words";
		price = "20.00";
		dc = new discountCalculate(null, bannerID, price);
		assertEquals(dc.discountID(), "0.00");
		
		//tests the Banner ID discount feature with a null Banner ID
		bannerID = null;
		price = "20.00";
		dc = new discountCalculate(null, bannerID, price);
		assertEquals(dc.discountID(), "0.00");
	}

}
