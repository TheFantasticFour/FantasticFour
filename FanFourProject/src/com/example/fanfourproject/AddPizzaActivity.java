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
    		pizzaSize = "Small";
    	}
    	else if(checkRadioButton(R.id.size_medium)){
    		pizzaSize = "Medium";
    	}// else{\\pizza size already set to large}
    	
    }
    
    private void getPizzaCheese(){
    	if(checkCheckBox(R.id.cheese_american)){
    		pizzaCheese.add("American Cheese");
    	}
		if(checkCheckBox(R.id.cheese_cheddar)){
			pizzaCheese.add("Cheddar Cheese");	
		}
		if(checkCheckBox(R.id.cheese_mozzarella)){
			pizzaCheese.add("Mozarella Cheese");	
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

    /** Called when the user clicks the 'Finished Adding Pizza' button */
    public void donePizza(View view) {
    	//System.out.println("1");
    	getPizzaSize();
    	//System.out.println("2");
    	getPizzaCheese();
    	//System.out.println("3");
    	getPizzaMeat();
    	//System.out.println("4");
    	getPizzaVeggies();
    	//System.out.println("5");
    	
    	
    	myIntent.putExtra("PIZZA_SIZE", pizzaSize);
    	myIntent.putStringArrayListExtra("PIZZA_CHEESES", pizzaCheese);
    	myIntent.putStringArrayListExtra("PIZZA_MEATS", pizzaMeats);
    	myIntent.putStringArrayListExtra("PIZZA_VEGGIES", pizzaVeggies);
    	finish();
    }
}
