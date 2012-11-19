import com.example.fanfourproject.Pop;

import junit.framework.TestCase;

public class PopTest extends TestCase {

	public void testPopSize() {
		 Pop p = new Pop("small","coke");	 
		 assertEquals(p.getPopSize(),"small");
		 
		 p.setPopSize("large");
		 assertEquals(p.getPopSize(),"large");
		  
	}
	public void testPopType() {
		Pop p2 = new Pop("small", "pepsi");
		assertEquals(p2.getPopType(),"pepsi");
		
		p2.setPopType("coke");
		assertEquals(p2.getPopType(),"coke");
	}
}
