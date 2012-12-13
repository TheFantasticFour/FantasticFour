/**
 * This class is an extension of an order and is created when the
 * user presses the 'Add Pizza' button on the MainMenuActivity page.
 * It is responsible having the user input a pizza with various toppings,
 * creating the Pizza object and adding that Pizza to the main order. 
 * 
 * 
 * @author FantasticFour
 */
package com.example.fanfourproject;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class AddPizzaActivity extends Activity {
	
	private static final String LARGE = "Large";
	private static final String MEDIUM = "Medium";
	private static final String SMALL = "Small";
	
	private String pizzaSize = "";
	
	private ArrayList<String> pizzaCheese = new ArrayList<String>();
	private ArrayList<String> pizzaMeats = new ArrayList<String>();
	private ArrayList<String> pizzaVeggies = new ArrayList<String>();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pizza);
    }
    
    /** 
     * Called when the user clicks the 'Finished Adding Pizza' button, gathers the chosen information for a particular pizza.
     * 
     * 
     */
    public void donePizza(View view) {
    	getPizzaSize();
    	getPizzaCheese();
    	getPizzaMeat();
    	getPizzaVeggies();
    	
    	ArrayList<String> allToppings = new ArrayList<String>();
    	for(String singleCheese: pizzaCheese){
    		allToppings.add(singleCheese);
    	}
    	
    	for(String singleMeat: pizzaMeats){
    		allToppings.add(singleMeat);
    	}
    	
    	for(String singleVeggie: pizzaVeggies){
    		allToppings.add(singleVeggie);
    	}
    	
    	Pizza tempPizza = new Pizza(pizzaSize, allToppings);
    	MainMenuActivity.addPizzaToOrder(tempPizza);
    	
    	finish();
    }
    /**
     * A simple method which finds the size chosen for the pizza. 
     * 
     *       
     */
    
    private void getPizzaSize(){
    	if(checkRadioButton(R.id.size_small)){
    		pizzaSize = SMALL;
    	}
    	else if(checkRadioButton(R.id.size_medium)){
    		pizzaSize = MEDIUM;
    	}
    	else{
    		pizzaSize = LARGE;
    	}    	
    }
    /**
     * A simple method which finds the cheeses chosen for the pizza. 
     * 
     */
    
    private void getPizzaCheese(){
    	if(checkCheckBox(R.id.cheese_american)){
    		pizzaCheese.add("American");
    	}
		if(checkCheckBox(R.id.cheese_cheddar)){
			pizzaCheese.add("Cheddar");	
		}
		if(checkCheckBox(R.id.cheese_mozzarella)){
			pizzaCheese.add("Mozarella");	
		}
    }
    /**
     * A simple method which finds the meats chosen for the pizza.
     * 
     */
    
    private void getPizzaMeat(){
    	if(checkCheckBox(R.id.meat_pepperoni)){
			pizzaMeats.add("Pepperoni");	
		}
		if(checkCheckBox(R.id.meat_sausage)){
			pizzaMeats.add("Sausage");	
		}
    	if(checkCheckBox(R.id.meat_bacon)){
    		pizzaMeats.add("Bacon");
    	}
		if(checkCheckBox(R.id.meat_beef)){
			pizzaMeats.add("Beef");	
		}
		if(checkCheckBox(R.id.meat_chicken)){
			pizzaMeats.add("Chicken");	
		}		
    }
    /**
     * Finds the Vegetables chosen for the pizza. 
     * 
     */
    
    private void getPizzaVeggies(){
    	if(checkCheckBox(R.id.veggie_tomato)){
			pizzaVeggies.add("Tomato");	
		}
    	if(checkCheckBox(R.id.veggie_olives)){
			pizzaVeggies.add("Olives");	
		}
    	if(checkCheckBox(R.id.veggie_onions)){
			pizzaVeggies.add("Onions");	
		}
    	if(checkCheckBox(R.id.veggie_peppers)){
			pizzaVeggies.add("Peppers");	
    	}
    	if(checkCheckBox(R.id.veggie_jalapeno)){
			pizzaVeggies.add("Jalapeno");	
		}
    }
    /**
     * A helper method for CheckBox which aids in finding the value of a check box. 
     * 
     * @param idName The ID for a particular box.
     * @return Returns a boolean whether or not a particular box is checked.
     */
    private boolean checkCheckBox(int idName){
    	CheckBox myCheckBox1 = (CheckBox) findViewById(idName);    	
    	return myCheckBox1.isChecked();
    }
    /**
     * A helper method for Radio Buttons which aids in finding the value of a check box. 
     * 
     * @param idName The ID for a particular button.
     * @return Returns a boolean whether or not a particular button is checked.
     */
    private boolean checkRadioButton(int idName){
    	RadioButton myButton1 = (RadioButton) findViewById(idName);    	
    	return myButton1.isChecked();
    }
}
