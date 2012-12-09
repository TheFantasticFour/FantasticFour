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
    
    /** Called when the user clicks the 'Finished Adding Pizza' button */
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
    
    //Helper method for CheckBox
    private boolean checkCheckBox(int idName){
    	CheckBox myCheckBox1 = (CheckBox) findViewById(idName);    	
    	return myCheckBox1.isChecked();
    }
    
    //Helper method for RadioButton
    private boolean checkRadioButton(int idName){
    	RadioButton myButton1 = (RadioButton) findViewById(idName);    	
    	return myButton1.isChecked();
    }
}
