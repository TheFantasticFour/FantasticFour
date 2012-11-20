import java.util.ArrayList;

import com.example.fanfourproject.MainMenuActivity;
import com.example.fanfourproject.Order;
import com.example.fanfourproject.Pizza;
import com.example.fanfourproject.Pop;

import junit.framework.TestCase;


public class MainMenuActivityTest extends TestCase {

	protected void setUp() throws Exception {
		super.setUp();
	}
	
	public void testAddPizzaToOrder(){
		//Tests the use of the static Order mainOrder held in MainMenuActivity
		ArrayList<String> myToppings = new ArrayList<String>();
		myToppings.add("Tomato");
		myToppings.add("Cheddar Cheese");
		Pizza myPizza = new Pizza("Small", myToppings);
		MainMenuActivity.mainOrder = new Order();
		MainMenuActivity.addPizzaToOrder(myPizza);
		
		assertEquals(MainMenuActivity.mainOrder.getPizzas().get(0).getPizzaSize(), "Small");
	}
	
	public void testAddPopToOrder(){
		//Tests the use of the static Order mainOrder held in MainMenuActivity
		Pop myPop = new Pop("12-oz Can", "Pepsi");
		MainMenuActivity.mainOrder = new Order();
		MainMenuActivity.addPopToOrder(myPop);
		
		assertEquals(MainMenuActivity.mainOrder.getPop().get(0).getPopType(), "Pepsi");
	}


}
