package com.example.fanfourproject;

import java.text.DecimalFormat;
import java.util.ArrayList;

import android.app.Activity;
import android.app.ProgressDialog;
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
	
	private static final Double SMALL_PIZZA_COST = 8.99;
	private static final Double MEDIUM_PIZZA_COST = 13.99;
	private static final Double LARGE_PIZZA_COST = 18.99;
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        
        //ProgressDialog pDialog;
        
        //pDialog = new ProgressDialog(MainMenuActivity.this);
		//pDialog.setMessage("Creating Product..");
		//pDialog.setIndeterminate(false);
		//pDialog.setCancelable(true);
		//pDialog.show();
		//pDialog.wait(3000);
		//pDialog.dismiss();
        
        mainOrder = new Order();
        codeString = null;
        bannerString = null;
        
        //tv1 = (TextView)findViewById(R.id.text_area);

        //editTextArea();        
    }
	
	public static void addPizzaToOrder(Pizza piz){
		mainOrder.addPizza(piz);
	}
	
	public static void addPopToOrder(Pop pop){
		mainOrder.addPop(pop);
	}
	
//	private static void editTextArea(){
//
//        String s = "";
//
//        s = s + mainOrder.toString();
//                        
//        tv1.setMovementMethod(new ScrollingMovementMethod());
//        
//        if(!s.equals("")){
//        	tv1.setText(s);
//        }
//        else{
//        	tv1.setText("No Items Ordered");
//        }
//    }
	
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
    
    /** Called when the user clicks the 'Finalize Order' button */
    public void finalizeOrder(View view){
    	Intent intent = new Intent(this, PaymentOptionActivity.class);
        startActivity(intent);
    }
        
    /** Called when the user clicks removes or adds an item */
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
    	
    	LinearLayout rlayout1 = (LinearLayout) findViewById(R.id.ll_order_1);
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
    	
    	rlayout1.setVisibility(View.INVISIBLE);
    	rlayout2.setVisibility(View.INVISIBLE);
    	rlayout3.setVisibility(View.INVISIBLE);
    	rlayout4.setVisibility(View.INVISIBLE);
    	rlayout5.setVisibility(View.INVISIBLE);
    	rlayout6.setVisibility(View.INVISIBLE);
    	rlayout7.setVisibility(View.INVISIBLE);
    	rlayout8.setVisibility(View.INVISIBLE);
    	rlayout9.setVisibility(View.INVISIBLE);
    	rlayout10.setVisibility(View.INVISIBLE);
    	
    	
    	
    	ArrayList<String> top = new ArrayList<String>();
    	String type = "";
    	
    	String toppings = "";
    	
    	int numPizzas = 0;
    	int numPops = 0;
    	
    	if(numPizzas<pizzas.size() && numPizzas<6){
    		rlayout1.setVisibility(View.VISIBLE);
    		top = pizzas.get(numPizzas).getPizzaToppings();
        	
        	for(int j=0; j<top.size(); j++){
        		toppings = toppings+top.get(j)+", ";
        	}
        	
    		displayItems1.setText(pizzas.get(numPizzas).toString());
    		if(pizzas.get(numPizzas).getPizzaSize().equals("Small")){
        		displayPrice1.setText("$" + roundTwoDecimals(Double.valueOf((SMALL_PIZZA_COST+top.size()))).toString());
    		}
    		else if(pizzas.get(numPizzas).getPizzaSize().equals("Medium")){
        		displayPrice1.setText("$" + roundTwoDecimals(Double.valueOf((MEDIUM_PIZZA_COST+top.size()))).toString());
    		}
    		else{
        		displayPrice1.setText("$" + roundTwoDecimals(Double.valueOf((LARGE_PIZZA_COST+top.size()))).toString());
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
        	
    		displayItems2.setText(pizzas.get(numPizzas).toString());
    		if(pizzas.get(numPizzas).getPizzaSize().equals("Small")){
        		displayPrice2.setText("$" + roundTwoDecimals(Double.valueOf((SMALL_PIZZA_COST+top.size()))).toString());
    		}
    		else if(pizzas.get(numPizzas).getPizzaSize().equals("Medium")){
        		displayPrice2.setText("$" + roundTwoDecimals(Double.valueOf((MEDIUM_PIZZA_COST+top.size()))).toString());
    		}
    		else{
        		displayPrice2.setText("$" + roundTwoDecimals(Double.valueOf((LARGE_PIZZA_COST+top.size()))).toString());
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
        	
    		displayItems3.setText(pizzas.get(numPizzas).toString());
    		if(pizzas.get(numPizzas).getPizzaSize().equals("Small")){
        		displayPrice3.setText("$" + roundTwoDecimals(Double.valueOf((SMALL_PIZZA_COST+top.size()))).toString());
    		}
    		else if(pizzas.get(numPizzas).getPizzaSize().equals("Medium")){
        		displayPrice3.setText("$" + roundTwoDecimals(Double.valueOf((MEDIUM_PIZZA_COST+top.size()))).toString());
    		}
    		else{
        		displayPrice3.setText("$" + roundTwoDecimals(Double.valueOf((LARGE_PIZZA_COST+top.size()))).toString());
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
        	
    		displayItems4.setText(pizzas.get(numPizzas).toString());
    		if(pizzas.get(numPizzas).getPizzaSize().equals("Small")){
        		displayPrice4.setText("$" + roundTwoDecimals(Double.valueOf((SMALL_PIZZA_COST+top.size()))).toString());
    		}
    		else if(pizzas.get(numPizzas).getPizzaSize().equals("Medium")){
        		displayPrice4.setText("$" + roundTwoDecimals(Double.valueOf((MEDIUM_PIZZA_COST+top.size()))).toString());
    		}
    		else{
        		displayPrice4.setText("$" + roundTwoDecimals(Double.valueOf((LARGE_PIZZA_COST+top.size()))).toString());
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
        	
    		displayItems5.setText(pizzas.get(numPizzas).toString());
    		if(pizzas.get(numPizzas).getPizzaSize().equals("Small")){
        		displayPrice5.setText("$" + roundTwoDecimals(Double.valueOf((SMALL_PIZZA_COST+top.size()))).toString());
    		}
    		else if(pizzas.get(numPizzas).getPizzaSize().equals("Medium")){
        		displayPrice5.setText("$" + roundTwoDecimals(Double.valueOf((MEDIUM_PIZZA_COST+top.size()))).toString());
    		}
    		else{
        		displayPrice5.setText("$" + roundTwoDecimals(Double.valueOf((LARGE_PIZZA_COST+top.size()))).toString());
    		}
    		numPizzas++;
    		toppings="";
    	}
    	if(numPops<pops.size() && numPops<6){
    		rlayout6.setVisibility(View.VISIBLE);
    		type = pops.get(numPops).getPopType();
        	
    		displayItems6.setText(pops.get(numPops).toString());
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
        	
    		displayItems7.setText(pops.get(numPops).toString());
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
        	
    		displayItems8.setText(pops.get(numPops).toString());
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
        	
    		displayItems9.setText(pops.get(numPops).toString());
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
        	
    		displayItems10.setText(pops.get(numPops).toString());
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
    		mainOrder.getPizzas().remove(0);
    		onResume();
    	}
    }

	public void removeItem2(View view) {
		mainOrder.getPizzas().remove(1);
		onResume();
	}

	public void removeItem3(View view) {

		mainOrder.getPizzas().remove(2);
		onResume();
	}

	public void removeItem4(View view) {

		mainOrder.getPizzas().remove(3);
		onResume();
	}

	public void removeItem5(View view) {

		mainOrder.getPizzas().remove(4);
		onResume();
	}

	public void removeItem6(View view) {

		mainOrder.getPop().remove(0);
		onResume();
	}

	public void removeItem7(View view) {

		mainOrder.getPop().remove(1);
		onResume();
	}

	public void removeItem8(View view) {

		mainOrder.getPop().remove(2);
		onResume();
	}

	public void removeItem9(View view) {

		mainOrder.getPop().remove(3);
		onResume();
	}

	public void removeItem10(View view) {

		mainOrder.getPop().remove(4);
		onResume();
	}
	
	Double roundTwoDecimals(double d) {
    	DecimalFormat twoDForm = new DecimalFormat("#.##");
    	return Double.valueOf(twoDForm.format(d));
	}
}
