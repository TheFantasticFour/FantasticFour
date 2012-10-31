package com.example.fanfourproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddPizzaActivity extends Activity {

	//public final static String NUMBER_PIZZAS = "com.example.mytenthapp.NUMBER_PIZZAS";
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pizza);
    }
    
    /** Called when the user clicks the '+1 large pizza' button */
    public void addOneLargePizza(View view){
    	TextView myTextView = (TextView) findViewById(R.id.large_pizza_text);
    	Integer currentNum = Integer.valueOf(myTextView.getText().toString());
    	currentNum++;
    	myTextView.setText(currentNum.toString());
    }
    
    /** Called when the user clicks the '-1 large pizza' button */
    public void minusOneLargePizza(View view){
    	TextView myTextView = (TextView) findViewById(R.id.large_pizza_text);
    	Integer currentNum = Integer.valueOf(myTextView.getText().toString());
    	if(currentNum != 0){
    		currentNum--;
    	}
    	myTextView.setText(currentNum.toString());
    }
    
    /** Called when the user clicks the '+1 medium pizza' button */
    public void addOneMediumPizza(View view){
    	TextView myTextView = (TextView) findViewById(R.id.medium_pizza_text);
    	Integer currentNum = Integer.valueOf(myTextView.getText().toString());
    	currentNum++;
    	myTextView.setText(currentNum.toString());
    }
    
    /** Called when the user clicks the '-1 medium pizza' button */
    public void minusOneMediumPizza(View view){
    	TextView myTextView = (TextView) findViewById(R.id.medium_pizza_text);
    	Integer currentNum = Integer.valueOf(myTextView.getText().toString());
    	if(currentNum != 0){
    		currentNum--;
    	}
    	myTextView.setText(currentNum.toString());
    }
    
    /** Called when the user clicks the '+1 small pizza' button */
    public void addOneSmallPizza(View view){
    	TextView myTextView = (TextView) findViewById(R.id.small_pizza_text);
    	Integer currentNum = Integer.valueOf(myTextView.getText().toString());
    	currentNum++;
    	myTextView.setText(currentNum.toString());
    }
    
    /** Called when the user clicks the '-1 small pizza' button */
    public void minusOneSmallPizza(View view){
    	TextView myTextView = (TextView) findViewById(R.id.small_pizza_text);
    	Integer currentNum = Integer.valueOf(myTextView.getText().toString());
    	if(currentNum != 0){
    		currentNum--;
    	}
    	myTextView.setText(currentNum.toString());
    }

    /** Called when the user clicks the 'Finished Adding Pizza' button */
    public void donePizza(View view) {
    	
    	TextView myTextView1 = (TextView) findViewById(R.id.large_pizza_text);
    	TextView myTextView2 = (TextView) findViewById(R.id.medium_pizza_text);
    	TextView myTextView3 = (TextView) findViewById(R.id.small_pizza_text);
    	
    	String largeAmount = myTextView1.getText().toString();
    	String mediumAmount = myTextView2.getText().toString();
    	String smallAmount = myTextView3.getText().toString();
    	
    	MainMenuActivity.i1.putExtra("PIZZA_PASS_LARGE", largeAmount);
    	MainMenuActivity.i1.putExtra("PIZZA_PASS_MEDIUM", mediumAmount);
    	MainMenuActivity.i1.putExtra("PIZZA_PASS_SMALL", smallAmount);
    	
    	//EditText myEditText = (EditText) findViewById(R.id.editText1);
    	//String message = myEditText.getText().toString();
    	
        //MainMenuActivity.i1.putExtra("PIZZA_PASS_1", message);    	
    	finish();
    }
}
