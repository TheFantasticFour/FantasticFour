/**
 * This class is called when the User selects the 'Menu' button from the HomePageActivity. Displays order page if no order is underway, else it displays options.
 * 
 *  @author FantasticFour
 */
package com.example.fanfourproject;

import java.text.DecimalFormat;
import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenuActivity extends Activity {
	
	private static final Double SMALL_PIZZA_COST = 8.99;
	private static final Double MEDIUM_PIZZA_COST = 13.99;
	private static final Double LARGE_PIZZA_COST = 18.99;
	private static final Double SPECIAL_PIZZA_COST = 21.99;
	
	private static final String SMALL_TAG = "Small";
	private static final String MEDIUM_TAG = "Medium";
	private static final String LARGE_TAG = "Large";
	
	private static final String CAN_PRICE_TAG = "$0.99";
	private static final String LITER_PRICE_TAG = "$2.99";
	
	private static final String LITER_TAG = "2-Liter";
	
	private static int TOAST_LONG = Toast.LENGTH_LONG;
	
	public static TextView tv1;
	public static Order mainOrder;
	public static String codeString;
	public static String bannerString;
	
	public static Boolean changeOrder = false;
	public static ArrayList<Object> changeArray = new ArrayList<Object>();
	
	private ArrayList<Pizza> pizzas;
	private ArrayList<Pop> pops;
	private ArrayList<TextView> priceArray;
	private ArrayList<TextView> itemArray;
	private ArrayList<LinearLayout> linearLayoutArray;
	
	private int pizzaSize;
	
	@Override
	/**
	 * Initializes the Activity. Checks to see if order has been already created. Else it creates a new one.
	 * 
	 */
    public void onCreate(Bundle savedInstanceState) {
		changeOrder = ChangeOrderActivity.changeOrder;
		System.out.println("MO: " + mainOrder);
		
		if(changeOrder!= null && changeOrder){
			super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main_menu);
	 
	        mainOrder = new Order();
	        codeString = null;
	        bannerString = null;
	        
	    	startChangedOrder(ChangeOrderActivity.mainArray);
		}
		else{
			super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_main_menu);
	        
	        mainOrder = new Order();
	        codeString = null;
	        bannerString = null;
		}
    }
	
	public void addToOrder(View view){
		Intent intent = new Intent(this, MenuInterfaceActivity.class);
        startActivity(intent);
	}
	
//    /** 
//     * Called when the user clicks the 'Add Pizza' button. Takes User to AddPizzaActivity.
//     * 
//     * @param view
//     */
//    public void addPizza(View view) {
//        Intent intent = new Intent(this, AddPizzaActivity.class);
//        startActivity(intent);
//    }
//    
//    /** 
//     * Called when the user clicks the 'Add Pop' button. Takes User to AddPopActivity.
//     * 
//     * @param view
//     */
//    public void addPop(View view) {
//    	Intent intent = new Intent(this, AddPopActivity.class);
//        startActivity(intent);
//    }
//    
//    /** 
//     * Called when the user clicks the 'Add Discounts' button. Takes User to AddDiscountActivity.
//     * 
//     * @param view
//     */
//    public void addDiscount(View view) {
//    	Intent intent = new Intent(this, AddDiscountActivity.class);
//        startActivity(intent);
//    }
    
    /** 
     * Called when the user clicks the 'Finalize Order' button. Takes user to PaymentOptionActivity.
     * 
     * @param view
     */
    public void finalizeOrder(View view){
        if(Double.valueOf(mainOrder.getInitialPrice())!=0){
        	Intent intent = new Intent(this, PaymentOptionActivity.class);
            startActivity(intent);
        }
        else{
        	String toastMessage = "Please add items!";
    		Context context = getApplicationContext();
    		Toast toast = Toast.makeText(context, toastMessage, TOAST_LONG);
    		toast.show();
        }        	
    }
        
    /** 
     * Called when the user clicks removes or adds an item. Checks the status of the order and displays it for the User.
     *
     */
    
    public void onResume(){
    	super.onResume();
    	
        pizzas = mainOrder.getPizzas();
        pops = mainOrder.getPop();
    
		TextView discountDisplay = (TextView) findViewById(R.id.discount_display);

		String message = "";
		if (codeString == null || codeString.equals("null")) {
			message = "No Discounts";
		} 
		else if (codeString.equals(DiscountCalculate.CODE_1)) {
			message = "10% Off!";
		} 
		else if (codeString.equals(DiscountCalculate.CODE_2)) {
			message = "15% Off!";
		} 
		else if (codeString.equals(DiscountCalculate.CODE_3)) {
			message = "20% Off!";
		} 
		else if (codeString.equals(DiscountCalculate.CODE_4)) {
			message = "Only $4.00";
		} 
		else {
			message = "";
		}
		discountDisplay.setText(message); 

    	linearLayoutArray = new ArrayList<LinearLayout>();
    	
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
    	
    	itemArray = new ArrayList<TextView>();
    	
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

    	priceArray = new ArrayList<TextView>();
    	
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
    	
    	ArrayList<String> toppingArray = new ArrayList<String>();
    	
    	for(int i = 0; i < pizzas.size(); i++){
    		linearLayoutArray.get(i).setVisibility(View.VISIBLE);
    		toppingArray = pizzas.get(i).getPizzaToppings();
    			
    		itemArray.get(i).setText(pizzas.get(i).toString());
    		if(pizzas.get(i).getPizzaSize().equals(SMALL_TAG)){
            	setPriceArrayText(i,SMALL_PIZZA_COST, toppingArray);
        	}
    		else if(pizzas.get(i).getPizzaSize().equals(MEDIUM_TAG)){
    			setPriceArrayText(i,MEDIUM_PIZZA_COST, toppingArray);
        	}
    		else if(pizzas.get(i).getPizzaSize().equals(LARGE_TAG)){
    			setPriceArrayText(i,LARGE_PIZZA_COST, toppingArray);
    		}
    		else{//specialty pizza
    			setPriceArrayText(i,SPECIAL_PIZZA_COST, toppingArray);
    		}
    	}
    	pizzaSize = pizzas.size();
    	
    	for(int j = pizzaSize; j-pizzaSize < pops.size(); j++){
    		int pizzaOffset =  j-pizzaSize;
    		
    		linearLayoutArray.get(j).setVisibility(View.VISIBLE);
    			
    		itemArray.get(j).setText(pops.get(pizzaOffset).toString());
    		if(pops.get(pizzaOffset).getPopSize().equals(LITER_TAG)){
            	priceArray.get(j).setText(LITER_PRICE_TAG);
        	}
    		else{
            	priceArray.get(j).setText(CAN_PRICE_TAG);
        	}
    	}
    	
    	TextView totalDisplay = (TextView) findViewById(R.id.total_text);
    	totalDisplay.setText("$" + mainOrder.getInitialPrice());
    }
    /**
     * Removes Item one from the order.
     * 
     * @param view
     */
    public void removeItem1(View view) {
    	if(pizzaSize > 0){
    		mainOrder.getPizzas().remove(0);
    	}
    	else{
    		mainOrder.getPop().remove(0-pizzaSize);
    	}    	
    	onResume();  	
    }
    /**
     * Removes Item 2 from the order.
     * 
     * @param view
     */

	public void removeItem2(View view) {
		if(pizzaSize > 1){
			mainOrder.getPizzas().remove(1);
		}
		else{
			mainOrder.getPop().remove(1-pizzaSize);
		}
		onResume();
	}
    /**
     * Removes Item 3 from the order.
     * 
     * @param view
     */
	public void removeItem3(View view) {
		if(pizzaSize > 2){
			mainOrder.getPizzas().remove(2);
		}
		else{
			mainOrder.getPop().remove(2-pizzaSize);
		}
		onResume();
	}
    /**
     * Removes Item 4 from the order.
     * 
     * @param view
     */
	public void removeItem4(View view) {
		if(pizzaSize > 3){
			mainOrder.getPizzas().remove(3);
		}
		else{
			mainOrder.getPop().remove(3-pizzaSize);
		}
		onResume();
	}
    /**
     * Removes Item 5 from the order.
     * 
     * @param view
     */
	public void removeItem5(View view) {
		if(pizzaSize > 4){
			mainOrder.getPizzas().remove(4);
		}
		else{
			mainOrder.getPop().remove(4-pizzaSize);
		}
		onResume();
	}
    /**
     * Removes Item 6 from the order.
     * 
     * @param view
     */
	public void removeItem6(View view) {
		if(pizzaSize > 5){
			mainOrder.getPizzas().remove(5);
		}
		else{
			mainOrder.getPop().remove(5-pizzaSize);
		}
		onResume();
	}
    /**
     * Removes Item 7 from the order.
     * 
     * @param view
     */
	public void removeItem7(View view) {
		if(pizzaSize > 6){
			mainOrder.getPizzas().remove(6);
		}
		else{
			mainOrder.getPop().remove(6-pizzaSize);
		}
		onResume();
	}
    /**
     * Removes Item 8 from the order.
     * 
     * @param view
     */
	public void removeItem8(View view) {
		if(pizzaSize > 7){
			mainOrder.getPizzas().remove(7);
		}
		else{
			mainOrder.getPop().remove(7-pizzaSize);
		}
		onResume();
	}
    /**
     * Removes Item 9 from the order.
     * 
     * @param view
     */
	public void removeItem9(View view) {
		if(pizzaSize > 8){
			mainOrder.getPizzas().remove(8);
		}
		else{
			mainOrder.getPop().remove(8-pizzaSize);
		}
		onResume();
	}
    /**
     * Removes Item 10 from the order.
     * 
     * @param view
     */
	public void removeItem10(View view) {
		if(pizzaSize > 9){
			mainOrder.getPizzas().remove(9);
		}
		else{
			mainOrder.getPop().remove(9-pizzaSize);
		}
		onResume();
	}
	/**
	 * Takes a Pizza as a parameter then adds it to mainOrder.
	 * 
	 * @param piz Pizza object to be added to the order.
	 */
	public static void addPizzaToOrder(Pizza piz){
		mainOrder.addPizza(piz);
	}
	/**
	 * Takes a Pop as a parameter then adds it to mainOrder.
	 * 
	 * @param pop
	 */
	public static void addPopToOrder(Pop pop){
		mainOrder.addPop(pop);
	}

	/**
	 * Takes a ArrayList of Objects as a parameter and sets the mainOrder equal to the specified order.
	 * 
	 * @param changedOrderArray The incoming order to be edited.
	 */
	public void startChangedOrder(ArrayList<Object> changedOrderArray){
		try{
			mainOrder = (Order) changedOrderArray.get(10);		
			String discountString = (String) changedOrderArray.get(9);
			int indexOfSplitter = discountString.indexOf("|");
		
			codeString = discountString.substring(0, indexOfSplitter);
			bannerString = discountString.substring(indexOfSplitter+1);

			changeArray = changedOrderArray;
			onResume();
		}
		catch(Exception e){//conf ID not found
			Intent intent = new Intent(this, ChangeOrderActivity.class);
	        startActivity(intent);
	        finish();
		}
	}
	/**
	 * Helper method for setting the price given a position, cost and array.
	 * 
	 * @param i Which text to change
	 * @param cost Cost
	 * @param toppingArray Array of toppings.
	 */
	
    public void setPriceArrayText(int i, Double cost, ArrayList<String> toppingArray){
    	priceArray.get(i).setText("$" + roundTwoDecimals(Double.valueOf((cost+toppingArray.size()))).toString());
	}
	/**
	 * Helper method for formatting
	 * 
	 * @param d The incoming double.
	 * @return The Double rounded to two decimal places.
	 */
	
	private Double roundTwoDecimals(double d) {
    	DecimalFormat twoDForm = new DecimalFormat("#.##");
    	return Double.valueOf(twoDForm.format(d));
	}
}
