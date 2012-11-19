import java.util.ArrayList;

import com.example.fanfourproject.Pizza;
import com.example.fanfourproject.Pop;

import junit.framework.TestCase;

public class PizzaTest extends TestCase {

	
	public void testPizzaSize() {
		ArrayList a = new ArrayList<String>();  
		a.add("cheese");
		a.add("sausage");
		a.add("mushrooms");
		  Pizza p = new Pizza("large",a);
		  
		  assertEquals(p.getPizzaSize(),"large");
		  
		  p.setPizzaSize("small");
		  assertEquals(p.getPizzaSize(),"small");
	}
	public void testPizzaToppings() {
		ArrayList a = new ArrayList<String>();  
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
