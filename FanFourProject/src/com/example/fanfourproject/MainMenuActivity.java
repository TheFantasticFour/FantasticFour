package com.example.fanfourproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class MainMenuActivity extends Activity {
	
	public static Intent i1,i2;
//	public static Integer currentLargePizzaCount;
//	public static Integer currentMediumPizzaCount;
//	public static Integer currentSmallPizzaCount;
//	public static Integer currentPopCount;
	
	//private String pizzaSize = "Large";
	//private ArrayList<String> pizzaCheese = new ArrayList<String>();
	//private ArrayList<String> pizzaMeats = new ArrayList<String>();
	//private ArrayList<String> pizzaVeggies = new ArrayList<String>();
	
	TextView tv1;
	
	public static Order mainOrder;
	public static String codeString;
	public static String bannerString;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        
        mainOrder = new Order();
        
        i1 = new Intent();
        i2 = new Intent();
        
        //tv1 = (TextView)findViewById(R.id.text_area);

        //editTextArea();        
    }
	
	public static void addPizzaToOrder(Pizza piz){
		mainOrder.addPizza(piz);
	}
	
	public static void addPopToOrder(Pop pop){
		mainOrder.addPop(pop);
	}
	
	private void editTextArea(){

        String s = "";

        s = s + mainOrder.toString();
                        
        tv1.setMovementMethod(new ScrollingMovementMethod());
        
        if(!s.equals("")){
        	tv1.setText(s);
        }
        else{
        	tv1.setText("No Items Ordered");
        }
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
    
    /** Called when the user clicks the 'Add Discounts' button */
    public void addDiscount(View view) {
    	Intent intent = new Intent(this, AddDiscountActivity.class);
        startActivity(intent);
    }
//    private String printArray(ArrayList<String> array){
//    	String s = "";
//    	for(String st: array){
//    		s = s + st + ", ";
//    	}
//    	
//    	return s;
//    }
    
    public void finalizeOrder(View view){
    	Intent intent = new Intent(this, PaymentOptionActivity.class);
        startActivity(intent);
    }
    
    public void onResume(){
    	super.onResume();
    	try{
    		//pizzaSize = i1.getStringExtra("PIZZA_SIZE");
    		//pizzaCheese = i1.getStringArrayListExtra("PIZZA_CHEESES");
    		//pizzaMeats = i1.getStringArrayListExtra("PIZZA_MEATS");
    		//pizzaVeggies = i1.getStringArrayListExtra("PIZZA_VEGGIES");
    			
    		//editTextArea();
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    }
    
}
