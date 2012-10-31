package com.example.fanfourproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class MainMenuActivity extends Activity {
	
	public static Intent i1,i2;
	public static Integer currentLargePizzaCount;
	public static Integer currentMediumPizzaCount;
	public static Integer currentSmallPizzaCount;
	public static Integer currentPopCount;
	
	TextView tv1;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        i1 = new Intent();
        i2 = new Intent();
        currentLargePizzaCount = 0;
        currentMediumPizzaCount = 0;
        currentSmallPizzaCount = 0;
        currentPopCount = 0;
        i1.putExtra("PIZZA_PASS_LARGE", currentLargePizzaCount.toString());
        i1.putExtra("PIZZA_PASS_MEDIUM", currentMediumPizzaCount.toString());
        i1.putExtra("PIZZA_PASS_SMALL", currentSmallPizzaCount.toString());
        i2.putExtra("POP_PASS_1", currentPopCount.toString());
        
        tv1 = (TextView)findViewById(R.id.tv1);

        editTextArea();
        
    }
	private void editTextArea(){

        String s = "";

        //for(int x=0;x<=100;x++){
        //    s += "Line: "+String.valueOf(x)+"\n";
        //}
        s = s + "$15.00 |" + currentLargePizzaCount.toString() + " Large Pizzas" + "\n";
        s = s + "$12.50 |" + currentMediumPizzaCount.toString() + " Medium Pizzas" + "\n";
        s = s + "$10.00 |" + currentSmallPizzaCount.toString() + " Small Pizzas" + "\n";
        s = s + "$3.00  |" + currentPopCount.toString() + " Pops" + "\n";
        
                
        tv1.setMovementMethod(new ScrollingMovementMethod());

        tv1.setText(s);

    }
	
	
	private void addLargePizzaCount(Integer num){
		currentLargePizzaCount = currentLargePizzaCount + num;
	}
	
	private void addMediumPizzaCount(Integer num){
		currentMediumPizzaCount = currentMediumPizzaCount + num;
	}
	
	private void addSmallPizzaCount(Integer num){
		currentSmallPizzaCount = currentSmallPizzaCount + num;
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
    		
    		
    		String message1 = i1.getStringExtra("PIZZA_PASS_LARGE");
    		String message2 = i1.getStringExtra("PIZZA_PASS_MEDIUM");
    		String message3 = i1.getStringExtra("PIZZA_PASS_SMALL");
    		
    		String message4 = i2.getStringExtra("POP_PASS_1");
    		    		
    		addLargePizzaCount(Integer.valueOf(message1));
    		addMediumPizzaCount(Integer.valueOf(message2));
    		addSmallPizzaCount(Integer.valueOf(message3));
    		addPopCount(Integer.valueOf(message4));
    		
    		i1.putExtra("PIZZA_PASS_LARGE", "0");
    		i1.putExtra("PIZZA_PASS_MEDIUM", "0");
    		i1.putExtra("PIZZA_PASS_SMALL", "0");
    		i2.putExtra("POP_PASS_1", "0");
    		
    		editTextArea();
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
}
