package com.example.fanfourproject;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class MainMenuActivity extends Activity {
	
	public static Intent i1,i2;
//	public static Integer currentLargePizzaCount;
//	public static Integer currentMediumPizzaCount;
//	public static Integer currentSmallPizzaCount;
//	public static Integer currentPopCount;
	
	private String pizzaSize = "Large Pizza";
	private ArrayList<String> pizzaCheese = new ArrayList<String>();
	private ArrayList<String> pizzaMeats = new ArrayList<String>();
	private ArrayList<String> pizzaVeggies = new ArrayList<String>();
	
	TextView tv1;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        i1 = new Intent();
        i2 = new Intent();
        
        tv1 = (TextView)findViewById(R.id.text_area);

        editTextArea();
        
    }
	private void editTextArea(){

        String s = "";

        s = s + "You current have:" + "\n";
        s = s + "1 " + pizzaSize + " Pizza with: " + "\n";
        s = s + printArray(pizzaCheese) + " and" + "\n";
        s = s + printArray(pizzaMeats) + " and" + "\n";
        s = s + printArray(pizzaVeggies);
                        
        tv1.setMovementMethod(new ScrollingMovementMethod());

        tv1.setText(s);
    }
	
    /** Called when the user clicks the 'Add Pizza' button */
    public void addPizza(View view) {
        i1 = new Intent(this, AddPizzaActivity.class);
        startActivity(i1);
    }
    
    /** Called when the user clicks the 'Add Pop' button */
    public void addPop(View view) {
    	i2 = new Intent(this, AddPopActivity.class);
        startActivity(i2);
    }
    
    private String printArray(ArrayList<String> array){
    	String s = "";
    	for(String st: array){
    		s = s + "st, ";
    	}
    	
    	return s;
    }
    
    public void onResume(){
    	super.onResume();
    	
    	
    	try{
    		pizzaSize = i1.getStringExtra("PIZZA_SIZE");
    		pizzaCheese = i1.getStringArrayListExtra("PIZZA_CHEESES");
    		pizzaMeats = i1.getStringArrayListExtra("PIZZA_MEATS");
    		pizzaVeggies = i1.getStringArrayListExtra("PIZZA_VEGGIES");
    			
    		editTextArea();
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
}
