package com.example.fanfourproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class MainMenuActivity extends Activity {
	
	public static Intent i1,i2;
	public static Integer currentPizzaCount;
	public static Integer currentPopCount;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        i1 = new Intent();
        i2 = new Intent();
        currentPizzaCount = 0;
        currentPopCount = 0;
        i1.putExtra("PIZZA_PASS_1", currentPizzaCount.toString());
        i2.putExtra("POP_PASS_1", currentPopCount.toString());
        
    }
	
	private void addPizzaCount(Integer num){
		currentPizzaCount = currentPizzaCount + num;
	}
	
	private void addPopCount(Integer num){
		currentPopCount = currentPopCount + num;
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
    
    public void onResume(){
    	super.onResume();
    	
    	
    	try{
    		String message1 = i1.getStringExtra("PIZZA_PASS_1");
    		String message2 = i2.getStringExtra("POP_PASS_1");
    		    		
    		addPizzaCount(Integer.valueOf(message1));
    		addPopCount(Integer.valueOf(message2));
    		
    		i1.putExtra("PIZZA_PASS_1", "0");
    		i2.putExtra("POP_PASS_1", "0");
    		
    		TextView myTextView1 = (TextView) findViewById(R.id.textView1);
    		TextView myTextView2 = (TextView) findViewById(R.id.textView2);
    		
    		myTextView1.setText(currentPizzaCount.toString() + " Pizzas");
    		myTextView2.setText(currentPopCount.toString() + " Pops");
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
}
