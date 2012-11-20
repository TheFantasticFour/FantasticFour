import java.util.ArrayList;

import junit.framework.TestCase;

import com.example.fanfourproject.Pizza;

public class PizzaTest extends TestCase {

	
	public void testPizzaSize() {
		ArrayList<String> a = new ArrayList<String>();  
		a.add("cheese");
		a.add("sausage");
		a.add("mushrooms");
		Pizza p = new Pizza("large",a);
		  
		  assertEquals(p.getPizzaSize(),"large");
		  
		  p.setPizzaSize("small");
		  assertEquals(p.getPizzaSize(),"small");
	}
	public void testPizzaToppings() {
		ArrayList<String> a = new ArrayList<String>();  
		a.add("cheese");
		a.add("sausage");
		a.add("mushrooms");
		  Pizza p = new Pizza("large",a);
		  assertEquals(p.getPizzaToppings(),a);
		  
		  p.addPizzaToppings("peperoni");
		  a.add("peperoni");
		  assertEquals(p.getPizzaToppings(),a);
	}
}
