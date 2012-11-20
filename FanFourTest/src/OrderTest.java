import java.util.ArrayList;

import com.example.fanfourproject.Pizza;
import com.example.fanfourproject.Pop;

import junit.framework.TestCase;

public class OrderTest extends TestCase {

	
	public void testAddPizza() {
		Order o = new Order();
		ArrayList a = new ArrayList<String>();  
		a.add("cheese");
		  Pizza p = new Pizza("large", a);
		  o.addPizza(p);
		  ArrayList plist = new ArrayList<String>();
		  plist = o.getPizzas();
		  assertEquals(plist.size(), 1);
		  

	}
	public void testAddPop() {
		Order o1 = new Order();
		 Pop g = new Pop("small","coke");
		  o1.addPizza(g);
		  ArrayList plist = new ArrayList<String>();
		  plist = o1.getPop();
		  assertEquals(plist.size(), 1);
		  
	}
}
