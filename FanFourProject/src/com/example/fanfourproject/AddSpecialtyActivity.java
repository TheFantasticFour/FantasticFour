package com.example.fanfourproject;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.TextView;

public class AddSpecialtyActivity extends Activity {

	private static String pizzaA = "";
	private static String pizzaB = ""; 
	private static String pizzaC = ""; 
	private static String pizzaD = ""; 
	private static String pizzaE = ""; 
	private static String pizzaF = "";
	private static String pizzaG = ""; 
	
	private DBHelperActivity dbHelper = new DBHelperActivity();
	ArrayList<Review> reviewArray = new ArrayList<Review>();
	ArrayList<String> orderedArray = new ArrayList<String>();
	ReviewCalculator revCalc = new ReviewCalculator();
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_specialty);
        
        reviewArray = dbHelper.getAllReviewsFromDatabase();
        orderedArray = new ArrayList<String>();
        System.out.println(reviewArray);
        System.out.println(orderedArray);
        orderedArray = revCalc.calculatePizzaOrder(reviewArray);
        System.out.println(orderedArray); 		        
        pizzaA = setPizzaType(Integer.valueOf(orderedArray.get(0)));
        pizzaB = setPizzaType(Integer.valueOf(orderedArray.get(1)));
        pizzaC = setPizzaType(Integer.valueOf(orderedArray.get(2)));
        pizzaD = setPizzaType(Integer.valueOf(orderedArray.get(3)));
        pizzaE = setPizzaType(Integer.valueOf(orderedArray.get(4)));
        pizzaF = setPizzaType(Integer.valueOf(orderedArray.get(5)));
        pizzaG = setPizzaType(Integer.valueOf(orderedArray.get(6)));
        
        TextView pizza1 = (TextView) findViewById(R.id.textView1);
        TextView pizza2 = (TextView) findViewById(R.id.textView2);
        TextView pizza3 = (TextView) findViewById(R.id.textView3);
        TextView pizza4 = (TextView) findViewById(R.id.textView4);
        TextView pizza5 = (TextView) findViewById(R.id.textView5);
        TextView pizza6 = (TextView) findViewById(R.id.textView6);
        TextView pizza7 = (TextView) findViewById(R.id.textView7);
        
        pizza1.setText(pizzaA);
        pizza2.setText(pizzaB);
        pizza3.setText(pizzaC);
        pizza4.setText(pizzaD);
        pizza5.setText(pizzaE);
        pizza6.setText(pizzaF);
        pizza7.setText(pizzaG);
        
    }
    
    public void addPizzaA(View view){
    	Pizza tempPizza = new Pizza(Integer.valueOf(orderedArray.get(0)));
    	MainMenuActivity.addPizzaToOrder(tempPizza);
    	finish();
    }
    
    public void addPizzaB(View view){
    	Pizza tempPizza = new Pizza(Integer.valueOf(orderedArray.get(1)));
    	MainMenuActivity.addPizzaToOrder(tempPizza);
    	finish();
    }

	public void addPizzaC(View view){
		Pizza tempPizza = new Pizza(Integer.valueOf(orderedArray.get(2)));
    	MainMenuActivity.addPizzaToOrder(tempPizza);
    	finish();
	}
	
	public void addPizzaD(View view){
		Pizza tempPizza = new Pizza(Integer.valueOf(orderedArray.get(3)));
    	MainMenuActivity.addPizzaToOrder(tempPizza);
    	finish();
    }
    
    public void addPizzaE(View view){
    	Pizza tempPizza = new Pizza(Integer.valueOf(orderedArray.get(4)));
    	MainMenuActivity.addPizzaToOrder(tempPizza);
    	finish();
    }

	public void addPizzaF(View view){
		Pizza tempPizza = new Pizza(Integer.valueOf(orderedArray.get(5)));
    	MainMenuActivity.addPizzaToOrder(tempPizza);
    	finish();
	}
	
	public void addPizzaG(View view){
		Pizza tempPizza = new Pizza(Integer.valueOf(orderedArray.get(6)));
    	MainMenuActivity.addPizzaToOrder(tempPizza);
    	finish();
	}
	
	 /**
     * A helper method to take an integer and convert it to the
     * corresponding pizza type 
     * 
     * @param pizzaType An integer 1-7 corresponding to each pizza type. 
     * @return Returns a String with the name of the pizza
     */
    private String setPizzaType(Integer pizzaType){
    	switch (pizzaType){
        	case 1:  return "Meat-Lovers Pizza";
        	case 2:  return "Taco Pizza";
        	case 3:  return "Veggie Pizza";
        	case 4:  return "Fajita Pizza";
        	case 5:  return "Buffalo-Chicken Pizza";
        	case 6:  return "Bacon-Cheeseburger Pizza";
        	case 7:  return "Dessert Pizza";
		}
    	return null;
    }
}
