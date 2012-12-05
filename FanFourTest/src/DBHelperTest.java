import java.util.ArrayList;

import com.example.fanfourproject.DBHelperActivity;
import com.example.fanfourproject.Order;
import com.example.fanfourproject.Pizza;
import com.example.fanfourproject.Pop;

import junit.framework.TestCase;


public class DBHelperTest extends TestCase {

	DBHelperActivity myHelper;
	
	protected void setUp() throws Exception {
		super.setUp();
		myHelper = new DBHelperActivity();
	}

	public void testCovertOrderToDatabase(){
		ArrayList<String> toppings1 = new ArrayList<String>();
		toppings1.add("Pepperoni");
		toppings1.add("Onions");
		toppings1.add("Bacon");
		ArrayList<String> toppings2 = new ArrayList<String>();
		toppings2.add("Tomato");
		toppings2.add("Chicken");
		
		Pizza pizza1 = new Pizza("Large", toppings1);
		Pizza pizza2 = new Pizza("Medium", toppings2);
		
		Pop pop1 = new Pop("Can", "Pepsi");
		
		Order myOrder1 = new Order();
		myOrder1.addPizza(pizza1);
		myOrder1.addPizza(pizza2);
		myOrder1.addPop(pop1);
		
		myHelper = new DBHelperActivity();
		String databaseString = myHelper.convertOrderToDatabase(myOrder1);
		assertTrue(databaseString.equals("Large Pizza with Pepperoni, Onions and Bacon//Medium Pizza with Tomato and Chicken///Can of Pepsi"));
		
		pizza1 = new Pizza("Small", new ArrayList<String>());
		myOrder1 = new Order();
		myOrder1.addPizza(pizza1);
		databaseString = myHelper.convertOrderToDatabase(myOrder1);
		assertTrue(databaseString.equals("Small Pizza///"));
		
		pop1 = new Pop("2-Liter", "Mountain Dew");
		myOrder1 = new Order();
		myOrder1.addPop(pop1);
		databaseString = myHelper.convertOrderToDatabase(myOrder1);
		System.out.println(databaseString);
		System.out.println("///2-Liter of Mountain Dew");
		assertTrue(databaseString.equals("///2-Liter of Mountain Dew"));
	}
	
	public void testCovertOrderFromDatabase(){
		String databaseString = "Small Pizza with Tomato and Onions//Medium Pizza///Can of Pepsi//2-Liter of Orange Fanta";
		Order order = myHelper.convertOrderFromDatabase(databaseString);
		
		ArrayList<String> toppings1 = new ArrayList<String>();
		toppings1.add("Tomato");
		toppings1.add("Onions");
		
		Pizza pizza1 = new Pizza("Small", toppings1);
		Pizza pizza2 = new Pizza("Medium", new ArrayList<String>());
		
		Pop pop1 = new Pop("Can","Pepsi");
		Pop pop2 = new Pop("2-Liter", "Orange Fanta");
		
		Order myOrder1 = new Order();
		myOrder1.addPizza(pizza1);
		myOrder1.addPizza(pizza2);
		myOrder1.addPop(pop1);
		myOrder1.addPop(pop2);
		
		assertTrue(myOrder1.toString().equals(order.toString()));
	}
	
	public void testConvertStringToPizza(){
		String databasePizza1 = "Large Pizza with Onions and Chicken";
		Pizza pizza1 = myHelper.convertStringToPizza(databasePizza1);
		
		ArrayList<String> toppings1 = new ArrayList<String>();
		toppings1.add("Onions");
		toppings1.add("Chicken");
		Pizza pizza2 = new Pizza("Large", toppings1);
		
		assertTrue(pizza1.toString().equals(pizza2.toString()));
	}
	
	public void testConvertStringToPop(){
		String databasePop1 = "Can of Sprite";
		Pop pop1 = myHelper.convertStringToPop(databasePop1);
	
		Pop pop2 = new Pop("Can", "Sprite");
		
		assertTrue(pop1.toString().equals(pop2.toString()));
	}
	
	public void testConvertPizzaToString(){
		ArrayList<String> toppings1 = new ArrayList<String>();
		toppings1.add("Beef");
		toppings1.add("Mozarella Cheese");
		toppings1.add("Pepperoni");
		
		Pizza pizza1 = new Pizza("Medium",toppings1);
		String databaseString = myHelper.convertPizzaToString(pizza1);
		
		assertTrue(databaseString.equals("Medium Pizza with Beef, Mozarella Cheese and Pepperoni"));
	}
	
	public void testConvertPopToString(){
		Pop pop1 = new Pop("Can", "Root Beer");
		String databaseString = myHelper.convertPopToString(pop1);
		
		assertTrue(databaseString.equals("Can of Root Beer"));
	}
}
