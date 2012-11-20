package com.example.fanfourproject;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.LinearLayout;
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
	
	public static TextView tv1;
	
	public static Order mainOrder;
	public static String codeString;
	public static String bannerString;
	private ArrayList<Pizza> pizzas;
	private ArrayList<Pop> pops;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        
        mainOrder = new Order();
        
        //tv1 = (TextView)findViewById(R.id.text_area);

        //editTextArea();        
    }
	
	public static void addPizzaToOrder(Pizza piz){
		mainOrder.addPizza(piz);
	}
	
	public static void addPopToOrder(Pop pop){
		mainOrder.addPop(pop);
	}
	
	public static void editTextArea(){

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
    	
        pizzas = mainOrder.getPizzas();
        pops = mainOrder.getPop();
    	
    	try{
    		TextView discountDisplay = (TextView) findViewById(R.id.discount_display);
    		
        	
        	String message = "";
        	if(codeString.equals(discountCalculate.CODE_1)){
        		message = "10% Off!";
        	}
        	else if(codeString.equals(discountCalculate.CODE_2)){
        		message = "15% Off!";
        	}
        	else if(codeString.equals(discountCalculate.CODE_3)){
        		message = "20% Off!";
        	}
        	else if(codeString.equals(discountCalculate.CODE_4)){
        		message = "Only $4.00";
        	}
        	else{
        		message = "";
        	}
        	discountDisplay.setText(message);
            
            i1 = new Intent();
            i2 = new Intent();
            

        	
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    	
    	LinearLayout rlayout2 = (LinearLayout) findViewById(R.id.ll_order_2);
    	LinearLayout rlayout3 = (LinearLayout) findViewById(R.id.ll_order_3);
    	LinearLayout rlayout4 = (LinearLayout) findViewById(R.id.ll_order_4);
    	LinearLayout rlayout5 = (LinearLayout) findViewById(R.id.ll_order_5);
    	LinearLayout rlayout6 = (LinearLayout) findViewById(R.id.ll_order_6);
    	LinearLayout rlayout7 = (LinearLayout) findViewById(R.id.ll_order_7);
    	LinearLayout rlayout8 = (LinearLayout) findViewById(R.id.ll_order_8);
    	LinearLayout rlayout9 = (LinearLayout) findViewById(R.id.ll_order_9);
    	LinearLayout rlayout10 = (LinearLayout) findViewById(R.id.ll_order_10);
    	
    	TextView displayItems1 = (TextView) findViewById(R.id.TextView_order_1);
    	TextView displayItems2 = (TextView) findViewById(R.id.TextView_order_2);
    	TextView displayItems3 = (TextView) findViewById(R.id.TextView_order_3);
    	TextView displayItems4 = (TextView) findViewById(R.id.TextView_order_4);
    	TextView displayItems5 = (TextView) findViewById(R.id.TextView_order_5);
    	TextView displayItems6 = (TextView) findViewById(R.id.TextView_order_6);
    	TextView displayItems7 = (TextView) findViewById(R.id.TextView_order_7);
    	TextView displayItems8 = (TextView) findViewById(R.id.TextView_order_8);
    	TextView displayItems9 = (TextView) findViewById(R.id.TextView_order_9);
    	TextView displayItems10 = (TextView) findViewById(R.id.TextView_order_10);

    	TextView displayPrice1 = (TextView) findViewById(R.id.TextView_price_1);
    	TextView displayPrice2 = (TextView) findViewById(R.id.TextView_price_2);
    	TextView displayPrice3 = (TextView) findViewById(R.id.TextView_price_3);
    	TextView displayPrice4 = (TextView) findViewById(R.id.TextView_price_4);
    	TextView displayPrice5 = (TextView) findViewById(R.id.TextView_price_5);
    	TextView displayPrice6 = (TextView) findViewById(R.id.TextView_price_6);
    	TextView displayPrice7 = (TextView) findViewById(R.id.TextView_price_7);
    	TextView displayPrice8 = (TextView) findViewById(R.id.TextView_price_8);
    	TextView displayPrice9 = (TextView) findViewById(R.id.TextView_price_9);
    	TextView displayPrice10 = (TextView) findViewById(R.id.TextView_price_10);
    	
    	
    	ArrayList<String> top = new ArrayList<String>();
    	String type = "";
    	
    	String toppings = "";
    	
    	int numPizzas = 0;
    	int numPops = 0;
    	
    	if(numPizzas<pizzas.size() && numPizzas<6){
    		top = pizzas.get(numPizzas).getPizzaToppings();
        	
        	for(int j=0; j<top.size(); j++){
        		toppings = toppings+top.get(j)+", ";
        	}
        	
    		displayItems1.setText(pizzas.get(numPizzas).getPizzaSize() +" pizza; "+ toppings);
    		if(pizzas.get(numPizzas).getPizzaSize()=="small"){
        		displayPrice1.setText("$8.99");
    		}
    		else if(pizzas.get(numPizzas).getPizzaSize()=="medium"){
        		displayPrice1.setText("$13.99");
    		}
    		else{
        		displayPrice1.setText("$18.99");
    		}
    		numPizzas++;
    		toppings="";
    	}
    	if(numPizzas<pizzas.size() && numPizzas<6){
    		rlayout2.setVisibility(View.VISIBLE);
    		top = pizzas.get(numPizzas).getPizzaToppings();
        	
        	for(int j=0; j<top.size(); j++){
        		toppings = toppings+top.get(j)+", ";
        	}
        	
    		displayItems2.setText(pizzas.get(numPizzas).getPizzaSize() +" pizza; "+ toppings);
    		if(pizzas.get(numPizzas).getPizzaSize()=="small"){
        		displayPrice2.setText("$8.99");
    		}
    		else if(pizzas.get(numPizzas).getPizzaSize()=="medium"){
        		displayPrice2.setText("$13.99");
    		}
    		else{
        		displayPrice2.setText("$18.99");
    		}
    		numPizzas++;
    		toppings="";
    	}
    	if(numPizzas<pizzas.size() && numPizzas<6){
    		rlayout3.setVisibility(View.VISIBLE);
    		top = pizzas.get(numPizzas).getPizzaToppings();
        	
        	for(int j=0; j<top.size(); j++){
        		toppings = toppings+top.get(j)+", ";
        	}
        	
    		displayItems3.setText(pizzas.get(numPizzas).getPizzaSize() +" pizza; "+ toppings);
    		if(pizzas.get(numPizzas).getPizzaSize()=="small"){
        		displayPrice3.setText("$8.99");
    		}
    		else if(pizzas.get(numPizzas).getPizzaSize()=="medium"){
        		displayPrice3.setText("$13.99");
    		}
    		else{
        		displayPrice3.setText("$18.99");
    		}
    		numPizzas++;

    		toppings="";
    	}
    	if(numPizzas<pizzas.size() && numPizzas<6){
    		rlayout4.setVisibility(View.VISIBLE);
    		top = pizzas.get(numPizzas).getPizzaToppings();
        	
        	for(int j=0; j<top.size(); j++){
        		toppings = toppings+top.get(j)+", ";
        	}
        	
    		displayItems4.setText(pizzas.get(numPizzas).getPizzaSize() +" pizza; "+ toppings);
    		if(pizzas.get(numPizzas).getPizzaSize()=="small"){
        		displayPrice4.setText("$8.99");
    		}
    		else if(pizzas.get(numPizzas).getPizzaSize()=="medium"){
        		displayPrice4.setText("$13.99");
    		}
    		else{
        		displayPrice4.setText("$18.99");
    		}
    		numPizzas++;
    		toppings="";
    	}
    	if(numPizzas<pizzas.size() && numPizzas<6){
    		rlayout5.setVisibility(View.VISIBLE);
    		top = pizzas.get(numPizzas).getPizzaToppings();
        	
        	for(int j=0; j<top.size(); j++){
        		toppings = toppings+top.get(j)+", ";
        	}
        	
    		displayItems5.setText(pizzas.get(numPizzas).getPizzaSize() +" pizza; "+ toppings);
    		if(pizzas.get(numPizzas).getPizzaSize()=="small"){
        		displayPrice5.setText("$8.99");
    		}
    		else if(pizzas.get(numPizzas).getPizzaSize()=="medium"){
        		displayPrice5.setText("$13.99");
    		}
    		else{
        		displayPrice5.setText("$18.99");
    		}
    		numPizzas++;
    		toppings="";
    	}
    	if(numPops<pops.size() && numPops<6){
    		rlayout6.setVisibility(View.VISIBLE);
    		type = pops.get(numPops).getPopType();
        	
    		displayItems6.setText(pops.get(numPops).getPopSize() +" "+ type);
    		if(pops.get(numPops).getPopSize()=="2-Liter"){
        		displayPrice6.setText("$2.99");
    		}
    		else{
        		displayPrice6.setText("$0.99");
    		}
    		numPops++;
    	}
    	if(numPops<pops.size() && numPops<6){
    		rlayout7.setVisibility(View.VISIBLE);
    		type = pops.get(numPops).getPopType();
        	
    		displayItems7.setText(pops.get(numPops).getPopSize() +" "+ type);
    		if(pops.get(numPops).getPopSize()=="2-Liter"){
        		displayPrice7.setText("$2.99");
    		}
    		else{
        		displayPrice7.setText("$0.99");
    		}
    		numPops++;
    	}
    	if(numPops<pops.size() && numPops<6){
    		rlayout8.setVisibility(View.VISIBLE);
    		type = pops.get(numPops).getPopType();
        	
    		displayItems8.setText(pops.get(numPops).getPopSize() +" "+ type);
    		if(pops.get(numPops).getPopSize()=="2-Liter"){
        		displayPrice8.setText("$2.99");
    		}
    		else{
        		displayPrice8.setText("$0.99");
    		}
    		numPops++;
    	}
    	if(numPops<pops.size() && numPops<6){
    		rlayout9.setVisibility(View.VISIBLE);
    		type = pops.get(numPops).getPopType();
        	
    		displayItems9.setText(pops.get(numPops).getPopSize() +" "+ type);
    		if(pops.get(numPops).getPopSize()=="2-Liter"){
        		displayPrice9.setText("$2.99");
    		}
    		else{
        		displayPrice9.setText("$0.99");
    		}
    		numPops++;
    	}
    	if(numPops<pops.size() && numPops<6){
    		rlayout10.setVisibility(View.VISIBLE);
    		type = pops.get(numPops).getPopType();
        	
    		displayItems10.setText(pops.get(numPops).getPopSize() +" "+ type);
    		if(pops.get(numPops).getPopSize()=="2-Liter"){
        		displayPrice10.setText("$2.99");
    		}
    		else{
        		displayPrice10.setText("$0.99");
    		}
    		numPops++;
    	}
    	
    	TextView totalDisplay = (TextView) findViewById(R.id.total_text);
    	totalDisplay.setText("$" + mainOrder.getInitialPrice());
    }
    public void removeItem1(View view) {
    	if(pizzas.get(0) != null){
    		pizzas.remove(0);
    	}
    }
    public void removeItem2(View view) {
    	pizzas.remove(1);
	}public void removeItem3(View view) {

    	pizzas.remove(2);
	}public void removeItem4(View view) {

    	pizzas.remove(3);
    }
	public void removeItem5(View view) {

		pizzas.remove(4);
    }public void removeItem6(View view) {

    	pops.remove(0);
	}public void removeItem7(View view) {

    	pops.remove(1);
	}public void removeItem8(View view) {

    	pops.remove(2);
	}public void removeItem9(View view) {

    	pops.remove(3);
	}public void removeItem10(View view) {

    	pops.remove(4);
	}
}
