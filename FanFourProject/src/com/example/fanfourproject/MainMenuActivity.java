package com.example.fanfourproject;

import java.text.DecimalFormat;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainMenuActivity extends Activity {
	
	private static final Double SMALL_PIZZA_COST = 8.99;
	private static final Double MEDIUM_PIZZA_COST = 13.99;
	private static final Double LARGE_PIZZA_COST = 18.99;
	
	private static final String SMALL_TAG = "Small";
	private static final String MEDIUM_TAG = "Medium";
	private static final String LARGE_TAG = "Large";
	
	private static final String CAN_TAG = "$0.99";
	private static final String LITER_TAG = "$2.99";
	
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
        codeString = null;
        bannerString = null;       
    }
	
    /** Called when the user clicks the 'Add Pizza' button */
    public void addPizza(View view) {
        Intent intent = new Intent(this, AddPizzaActivity.class);
        startActivity(intent);
    }
    
    /** Called when the user clicks the 'Add Pop' button */
    public void addPop(View view) {
    	Intent intent = new Intent(this, AddPopActivity.class);
        startActivity(intent);
    }
    
    /** Called when the user clicks the 'Add Discounts' button */
    public void addDiscount(View view) {
    	Intent intent = new Intent(this, AddDiscountActivity.class);
        startActivity(intent);
    }
    
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
        	if(codeString.equals(DiscountCalculate.CODE_1)){
        		message = "10% Off!";
        	}
        	else if(codeString.equals(DiscountCalculate.CODE_2)){
        		message = "15% Off!";
        	}
        	else if(codeString.equals(DiscountCalculate.CODE_3)){
        		message = "20% Off!";
        	}
        	else if(codeString.equals(DiscountCalculate.CODE_4)){
        		message = "Only $4.00";
        	}
        	else{
        		message = "";
        	}
        	discountDisplay.setText(message);
    	}
    	catch(Exception e){
    		System.out.println(e);
    	}
    	
    	ArrayList<LinearLayout> linearLayoutArray = new ArrayList<LinearLayout>();
    	
    	linearLayoutArray.add((LinearLayout) findViewById(R.id.ll_order_1));
    	linearLayoutArray.add((LinearLayout) findViewById(R.id.ll_order_2));
    	linearLayoutArray.add((LinearLayout) findViewById(R.id.ll_order_3));
    	linearLayoutArray.add((LinearLayout) findViewById(R.id.ll_order_4));
    	linearLayoutArray.add((LinearLayout) findViewById(R.id.ll_order_5));
    	linearLayoutArray.add((LinearLayout) findViewById(R.id.ll_order_6));
    	linearLayoutArray.add((LinearLayout) findViewById(R.id.ll_order_7));
    	linearLayoutArray.add((LinearLayout) findViewById(R.id.ll_order_8));
    	linearLayoutArray.add((LinearLayout) findViewById(R.id.ll_order_9));
    	linearLayoutArray.add((LinearLayout) findViewById(R.id.ll_order_10));
    	
    	ArrayList<TextView> itemArray = new ArrayList<TextView>();
    	
    	itemArray.add((TextView) findViewById(R.id.TextView_order_1));
    	itemArray.add((TextView) findViewById(R.id.TextView_order_2));
    	itemArray.add((TextView) findViewById(R.id.TextView_order_3));
    	itemArray.add((TextView) findViewById(R.id.TextView_order_4));
    	itemArray.add((TextView) findViewById(R.id.TextView_order_5));
    	itemArray.add((TextView) findViewById(R.id.TextView_order_6));
    	itemArray.add((TextView) findViewById(R.id.TextView_order_7));
    	itemArray.add((TextView) findViewById(R.id.TextView_order_8));
    	itemArray.add((TextView) findViewById(R.id.TextView_order_9));
    	itemArray.add((TextView) findViewById(R.id.TextView_order_10));

    	ArrayList<TextView> priceArray = new ArrayList<TextView>();
    	priceArray.add((TextView) findViewById(R.id.TextView_price_1));
    	priceArray.add((TextView) findViewById(R.id.TextView_price_2));
    	priceArray.add((TextView) findViewById(R.id.TextView_price_3));
    	priceArray.add((TextView) findViewById(R.id.TextView_price_4));
    	priceArray.add((TextView) findViewById(R.id.TextView_price_5));
    	priceArray.add((TextView) findViewById(R.id.TextView_price_6));
    	priceArray.add((TextView) findViewById(R.id.TextView_price_7));
    	priceArray.add((TextView) findViewById(R.id.TextView_price_8));
    	priceArray.add((TextView) findViewById(R.id.TextView_price_9));
    	priceArray.add((TextView) findViewById(R.id.TextView_price_10));
    	
    	for(int i = 0; i < 10; i++){
    		linearLayoutArray.get(i).setVisibility(View.INVISIBLE);
    	}   	
    	
    	ArrayList<String> top = new ArrayList<String>();
    	String type;
    	
    	String toppings = "";
    	
    	int numPizzas = 0;
    	int numPops = 0;
    	
    	if(numPizzas<pizzas.size() && numPizzas<6){
    		linearLayoutArray.get(0).setVisibility(View.VISIBLE);
    		top = pizzas.get(numPizzas).getPizzaToppings();
        	
        	for(int j=0; j<top.size(); j++){
        		toppings = toppings+top.get(j)+", ";
        	}
        	
        	itemArray.get(0).setText(pizzas.get(numPizzas).toString());
    		if(pizzas.get(numPizzas).getPizzaSize().equals(SMALL_TAG)){
        		priceArray.get(0).setText("$" + roundTwoDecimals(Double.valueOf((SMALL_PIZZA_COST+top.size()))).toString());
    		}
    		else if(pizzas.get(numPizzas).getPizzaSize().equals(MEDIUM_TAG)){
        		priceArray.get(0).setText("$" + roundTwoDecimals(Double.valueOf((MEDIUM_PIZZA_COST+top.size()))).toString());
    		}
    		else{
        		priceArray.get(0).setText("$" + roundTwoDecimals(Double.valueOf((LARGE_PIZZA_COST+top.size()))).toString());
    		}
    		numPizzas++;
    		toppings="";
    	}
    	if(numPizzas<pizzas.size() && numPizzas<6){
    		linearLayoutArray.get(1).setVisibility(View.VISIBLE);
    		top = pizzas.get(numPizzas).getPizzaToppings();
        	
        	for(int j=0; j<top.size(); j++){
        		toppings = toppings+top.get(j)+", ";
        	}
        	
        	itemArray.get(1).setText(pizzas.get(numPizzas).toString());
    		if(pizzas.get(numPizzas).getPizzaSize().equals(SMALL_TAG)){
        		priceArray.get(1).setText("$" + roundTwoDecimals(Double.valueOf((SMALL_PIZZA_COST+top.size()))).toString());
    		}
    		else if(pizzas.get(numPizzas).getPizzaSize().equals(MEDIUM_TAG)){
        		priceArray.get(1).setText("$" + roundTwoDecimals(Double.valueOf((MEDIUM_PIZZA_COST+top.size()))).toString());
    		}
    		else{
        		priceArray.get(1).setText("$" + roundTwoDecimals(Double.valueOf((LARGE_PIZZA_COST+top.size()))).toString());
    		}
    		numPizzas++;
    		toppings="";
    	}
    	if(numPizzas<pizzas.size() && numPizzas<6){
    		linearLayoutArray.get(2).setVisibility(View.VISIBLE);
    		top = pizzas.get(numPizzas).getPizzaToppings();
        	
        	for(int j=0; j<top.size(); j++){
        		toppings = toppings+top.get(j)+", ";
        	}
        	
        	itemArray.get(2).setText(pizzas.get(numPizzas).toString());
    		if(pizzas.get(numPizzas).getPizzaSize().equals(SMALL_TAG)){
        		priceArray.get(2).setText("$" + roundTwoDecimals(Double.valueOf((SMALL_PIZZA_COST+top.size()))).toString());
    		}
    		else if(pizzas.get(numPizzas).getPizzaSize().equals(MEDIUM_TAG)){
        		priceArray.get(2).setText("$" + roundTwoDecimals(Double.valueOf((MEDIUM_PIZZA_COST+top.size()))).toString());
    		}
    		else{
        		priceArray.get(2).setText("$" + roundTwoDecimals(Double.valueOf((LARGE_PIZZA_COST+top.size()))).toString());
    		}
    		numPizzas++;

    		toppings="";
    	}
    	if(numPizzas<pizzas.size() && numPizzas<6){
    		linearLayoutArray.get(3).setVisibility(View.VISIBLE);
    		top = pizzas.get(numPizzas).getPizzaToppings();
        	
        	for(int j=0; j<top.size(); j++){
        		toppings = toppings+top.get(j)+", ";
        	}
        	
        	itemArray.get(3).setText(pizzas.get(numPizzas).toString());
    		if(pizzas.get(numPizzas).getPizzaSize().equals(SMALL_TAG)){
        		priceArray.get(3).setText("$" + roundTwoDecimals(Double.valueOf((SMALL_PIZZA_COST+top.size()))).toString());
    		}
    		else if(pizzas.get(numPizzas).getPizzaSize().equals(MEDIUM_TAG)){
        		priceArray.get(3).setText("$" + roundTwoDecimals(Double.valueOf((MEDIUM_PIZZA_COST+top.size()))).toString());
    		}
    		else{
        		priceArray.get(3).setText("$" + roundTwoDecimals(Double.valueOf((LARGE_PIZZA_COST+top.size()))).toString());
    		}
    		numPizzas++;
    		toppings="";
    	}
    	if(numPizzas<pizzas.size() && numPizzas<6){
    		linearLayoutArray.get(4).setVisibility(View.VISIBLE);
    		top = pizzas.get(numPizzas).getPizzaToppings();
        	
        	for(int j=0; j<top.size(); j++){
        		toppings = toppings+top.get(j)+", ";
        	}
        	
        	itemArray.get(4).setText(pizzas.get(numPizzas).toString());
    		if(pizzas.get(numPizzas).getPizzaSize().equals(SMALL_TAG)){
        		priceArray.get(4).setText("$" + roundTwoDecimals(Double.valueOf((SMALL_PIZZA_COST+top.size()))).toString());
    		}
    		else if(pizzas.get(numPizzas).getPizzaSize().equals(MEDIUM_TAG)){
        		priceArray.get(4).setText("$" + roundTwoDecimals(Double.valueOf((MEDIUM_PIZZA_COST+top.size()))).toString());
    		}
    		else{
        		priceArray.get(4).setText("$" + roundTwoDecimals(Double.valueOf((LARGE_PIZZA_COST+top.size()))).toString());
    		}
    		numPizzas++;
    		toppings="";
    	}
    	if(numPops<pops.size() && numPops<6){
    		linearLayoutArray.get(5).setVisibility(View.VISIBLE);
    		type = pops.get(numPops).getPopType();
        	
    		itemArray.get(5).setText(pops.get(numPops).toString());
    		if(pops.get(numPops).getPopSize()=="2-Liter"){
        		priceArray.get(5).setText(LITER_TAG);
    		}
    		else{
        		priceArray.get(5).setText(CAN_TAG);
    		}
    		numPops++;
    	}
    	if(numPops<pops.size() && numPops<6){
    		linearLayoutArray.get(6).setVisibility(View.VISIBLE);
    		type = pops.get(numPops).getPopType();
        	
    		itemArray.get(6).setText(pops.get(numPops).toString());
    		if(pops.get(numPops).getPopSize()=="2-Liter"){
        		priceArray.get(6).setText(LITER_TAG);
    		}
    		else{
        		priceArray.get(6).setText(CAN_TAG);
    		}
    		numPops++;
    	}
    	if(numPops<pops.size() && numPops<6){
    		linearLayoutArray.get(7).setVisibility(View.VISIBLE);
    		type = pops.get(numPops).getPopType();
        	
    		itemArray.get(7).setText(pops.get(numPops).toString());
    		if(pops.get(numPops).getPopSize()=="2-Liter"){
        		priceArray.get(7).setText(LITER_TAG);
    		}
    		else{
        		priceArray.get(7).setText(CAN_TAG);
    		}
    		numPops++;
    	}
    	if(numPops<pops.size() && numPops<6){
    		linearLayoutArray.get(8).setVisibility(View.VISIBLE);
    		type = pops.get(numPops).getPopType();
        	
    		itemArray.get(8).setText(pops.get(numPops).toString());
    		if(pops.get(numPops).getPopSize()=="2-Liter"){
        		priceArray.get(8).setText(LITER_TAG);
    		}
    		else{
        		priceArray.get(8).setText(CAN_TAG);
    		}
    		numPops++;
    	}
    	if(numPops<pops.size() && numPops<6){
    		linearLayoutArray.get(9).setVisibility(View.VISIBLE);
    		type = pops.get(numPops).getPopType();
        	
    		itemArray.get(9).setText(pops.get(numPops).toString());
    		if(pops.get(numPops).getPopSize()=="2-Liter"){
        		priceArray.get(9).setText(LITER_TAG);
    		}
    		else{
        		priceArray.get(9).setText(CAN_TAG);
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
	
	public static void addPizzaToOrder(Pizza piz){
		mainOrder.addPizza(piz);
	}
	
	public static void addPopToOrder(Pop pop){
		mainOrder.addPop(pop);
	}
	
	//Helper method for formatting
	private Double roundTwoDecimals(double d) {
    	DecimalFormat twoDForm = new DecimalFormat("#.##");
    	return Double.valueOf(twoDForm.format(d));
	}
}
