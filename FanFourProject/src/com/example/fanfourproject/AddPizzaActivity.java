package com.example.fanfourproject;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;

public class AddPizzaActivity extends Activity {

	//public final static String NUMBER_PIZZAS = "com.example.mytenthapp.NUMBER_PIZZAS";
	
	private String pizzaSize = "Large Pizza";
	private ArrayList<String> pizzaCheese = new ArrayList<String>();
	private ArrayList<String> pizzaMeats = new ArrayList<String>();
	private ArrayList<String> pizzaVeggies = new ArrayList<String>();
	
	Intent myIntent = MainMenuActivity.i1;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pizza);
    }
    
    public boolean checkCheckBox(int idName){
    	CheckBox myCheckBox1 = (CheckBox) findViewById(idName);    	
    	return myCheckBox1.isChecked();
    }
    
    public boolean checkRadioButton(int idName){
    	RadioButton myButton1 = (RadioButton) findViewById(idName);    	
    	return myButton1.isChecked();
    }
    
    private void getPizzaSize(){
    	if(checkRadioButton(R.id.size_small)){
    		pizzaSize = "Small Pizza";
    	}
    	else if(checkRadioButton(R.id.size_medium)){
    		pizzaSize = "Medium Pizza";
    	}// else{\\pizza size already set to large}   
    }
    
    private void getPizzaCheese(){
    	if(checkRadioButton(R.id.cheese_american)){
    		pizzaCheese.add("American Cheese");
    	}
		if(checkRadioButton(R.id.cheese_cheddar)){
			pizzaCheese.add("Cheddar Cheese");	
		}
		if(checkRadioButton(R.id.cheese_mozzarella)){
			pizzaCheese.add("Mozarella Cheese");	
		}
    }
    
    private void getPizzaMeat(){
    	if(checkRadioButton(R.id.meat_pepperoni)){
			pizzaMeats.add("Pepperoni");	
		}
		if(checkRadioButton(R.id.meat_sausage)){
			pizzaMeats.add("Sausage");	
		}
    	if(checkRadioButton(R.id.meat_bacon)){
    		pizzaMeats.add("Bacon");
    	}
		if(checkRadioButton(R.id.meat_beef)){
			pizzaMeats.add("Beef");	
		}
		if(checkRadioButton(R.id.meat_chicken)){
			pizzaMeats.add("Chicken");	
		}		
    }
    
    private void getPizzaVeggies(){
    	if(checkRadioButton(R.id.veggie_tomato)){
			pizzaVeggies.add("Tomato");	
		}
    	if(checkRadioButton(R.id.veggie_olives)){
			pizzaVeggies.add("Olives");	
		}
    	if(checkRadioButton(R.id.veggie_onions)){
			pizzaVeggies.add("Onions");	
		}
    	if(checkRadioButton(R.id.veggie_peppers)){
			pizzaVeggies.add("Peppers");	
    	}
    	if(checkRadioButton(R.id.veggie_jalapeno)){
			pizzaVeggies.add("Jalapeno");	
		}
    }

    /** Called when the user clicks the 'Finished Adding Pizza' button */
    public void donePizza(View view) {
    	getPizzaSize();
    	getPizzaCheese();
    	getPizzaMeat();
    	getPizzaVeggies();
    	
    	myIntent.putExtra("PIZZA_SIZE", pizzaSize);
    	myIntent.putStringArrayListExtra("PIZZA_CHEESES", pizzaCheese);
    	myIntent.putStringArrayListExtra("PIZZA_MEATS", pizzaMeats);
    	myIntent.putStringArrayListExtra("PIZZA_VEGGIES", pizzaVeggies);
    	finish();
    }
}
