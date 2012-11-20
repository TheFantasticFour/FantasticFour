import java.util.ArrayList;

import junit.framework.TestCase;

import com.example.fanfourproject.Pizza;

public class PizzaTest extends TestCase {

	
	public void testPizzaSize() {
		//Test the setters and getters: getPizzaSize and setPizzaSize
		ArrayList<String> myToppings = new ArrayList<String>();  
		myToppings.add("Cheese");
		myToppings.add("Sausage");
		myToppings.add("Mushrooms");
		Pizza myPizza = new Pizza("Large", myToppings);
		  
		assertEquals(myPizza.getPizzaSize(),"Large");
		  
		myPizza.setPizzaSize("Small");
		assertEquals(myPizza.getPizzaSize(),"Small");
	}
	public void testPizzaToppings() {
		//Test the setters and getters: getPizzaToppings and setPizzaToppings
		ArrayList<String> myToppings = new ArrayList<String>();  
		myToppings.add("Cheese");
		myToppings.add("Sausage");
		myToppings.add("Mushrooms");
		Pizza myPizza = new Pizza("Large", myToppings);
		assertEquals(myPizza.getPizzaToppings(),myToppings);
		  
		myPizza.addPizzaToppings("Pepperoni");
		myToppings.add("Pepperoni");
		assertEquals(myPizza.getPizzaToppings(),myToppings);
	}
}
