import com.example.fanfourproject.Pop;

import junit.framework.TestCase;

public class PopTest extends TestCase {

	public void testPopSize() {
		
		//Test the setters and getters: getPopSize and setPopSize
		Pop p = new Pop("Small","Coke");	 
		assertEquals(p.getPopSize(),"Small");
		 
		p.setPopSize("Large");
		assertEquals(p.getPopSize(),"Large");
		  
	}
	public void testPopType() {
		//Test the setters and getters: getPopType and setPopType
		Pop p2 = new Pop("Small", "Pepsi");
		assertEquals(p2.getPopType(),"Pepsi");
		
		p2.setPopType("Coke");
		assertEquals(p2.getPopType(),"Coke");
	}
}
