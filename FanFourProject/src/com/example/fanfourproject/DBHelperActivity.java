package com.example.fanfourproject;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.util.Log;

public class DBHelperActivity extends Activity {

	private static String url_add_order = "http://www.users.csbsju.edu/~pghardy/fan4Connect/add_order.php";
	private static String url_get_order = "http://www.users.csbsju.edu/~pghardy/fan4Connect/get_order.php";
	private JSONParser jsonParser = new JSONParser();
	private static final String TAG_SUCCESS = "success";
	
	private String confID = "";
	private String phoneNumber = "";
	private String street = "";
	private String city = "";
	private String state = "";
	private String zipCode = "";
	private String email = "";
	private String paymentType = "";
	private String cardNum = "";
	private String discountCode = "";
	private Order order = null;

	
	public DBHelperActivity(){
		
	}
	
    //@Override
    //public void onCreate(Bundle savedInstanceState) {
    //    super.onCreate(savedInstanceState);
    //    setContentView(R.layout.activity_dbhelper);
    //}
    
    public ArrayList<Object> getOrderFromDatabase(String confirmationID){
    	ArrayList<Object> returnOrder = new ArrayList<Object>();
    	new CreateNewOrder().execute();
    	
    	
    	return returnOrder;
    }
    
    public void addOrderToDatabase(	String confID, 
    								String phoneNumber, 
    								String street, 
    								String city, 
    								String state, 
    								String zipCode,
    								String email,
    								String paymentType,
    								String cardNum,
    								String discountCode,
    								Order order){ 
    	this.confID = confID;
    	this.phoneNumber = phoneNumber;
    	this.street = street;
    	this.city = city;
    	this.state = state;
    	this.zipCode = zipCode;
    	this.email = email;
    	this.paymentType = paymentType;
    	this.cardNum = cardNum;
    	this.discountCode = discountCode;
    	this.order = order;
    	new CreateNewOrder().execute();
    	
    	
    }
    
    public Order convertOrderFromDatabase(String fullOrder){
    	Order myOrder = new Order();
    	
    	String[] pizzaAndPop = fullOrder.split("?");
    	String pizzaString = pizzaAndPop[0];
    	String popString = pizzaAndPop[1];
    	
    	String[] pizzaSplit = pizzaString.split("|");
    	String[] popSplit = popString.split("|");
    	
    	for(String s: pizzaSplit){
    		myOrder.addPizza(convertStringToPizza(s));
    	}
    	for(String s: popSplit){
    		myOrder.addPop(convertStringToPop(s));
    	}    	
    	
    	return myOrder;    	
    }
    
    public String convertOrderToDatabase(Order fullOrder){
    	ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    	ArrayList<Pop> pops = new ArrayList<Pop>();
    	pizzas = fullOrder.getPizzas();
    	pops = fullOrder.getPop();
    	String s = "";	
    	if(pizzas != null && pizzas.size() > 0){
    		for(int i = 0; i < pizzas.size()-1; i++){
    			s = s + convertPizzaToString(pizzas.get(i)) + "|";
    		}
    		s = s + convertPizzaToString(pizzas.get(pizzas.size()-1)) + "?";
    	}
    	if(pops != null && pops.size() > 0){
    		for(int j = 0; j < pops.size()-1;j++){
    			s = s + convertPopToString(pops.get(j)) + "|";
    		}
    		s = s + convertPopToString(pops.get(pizzas.size()-1));
    	}
    	return s;
    }
    
    public Pizza convertStringToPizza(String databasePizza){
    	ArrayList<String> toppings = new ArrayList<String>();
    	
    	String[] sentence = databasePizza.split(" ");
    	if(sentence.length == 2){
    		return new Pizza(sentence[0], new ArrayList<String>());
    	}
    	else if(sentence.length == 4){
    		toppings.add(sentence[3]);
    		return new Pizza(sentence[0], toppings);
    	}
    	else if(sentence.length == 6){
    		toppings.add(sentence[3]);
    		toppings.add(sentence[5]);
    		return new Pizza(sentence[0], toppings);
    	}
    	else if(sentence.length >= 7){
    		for(int i = 3; i < sentence.length-3; i++){
    			sentence[i] = sentence[i].substring(0,sentence[i].length()-2);
    			toppings.add(sentence[i]);
    		}
    		toppings.add(sentence[sentence.length-3]);
			toppings.add(sentence[sentence.length-1]);
    		return new Pizza(sentence[0], toppings);    		
    		//String s = "Large pizza with tomato, chicken, beef and onions";
    	}
    	
    	return null;
    }
    
    public Pop convertStringToPop(String databasePop){
    	String[] sentence = databasePop.split(" ");
    	if(sentence.length == 3){
    		return new Pop(sentence[0], sentence[2]);
    	}
    	else{
    		return new Pop(sentence[0], sentence[2] + " " + sentence[3]);
    	}
    }
    
    public String convertPizzaToString(Pizza orderPizza){
    	return orderPizza.toString();
    }
    
    public String convertPopToString(Pop orderPop){
    	return orderPop.toString();
    }
    
    class RetrieveOrder extends AsyncTask<String, String, String>{

		protected String doInBackground(String... args) {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			
			JSONObject json = jsonParser.makeHttpRequest(url_get_order, "GET", params);
			
			Log.d("All Products: ", json.toString());
			
			return null;
		}    	
    }
    
	class CreateNewOrder extends AsyncTask<String, String, String> {

		protected String doInBackground(String... args) {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("confID", confID));
			params.add(new BasicNameValuePair("phoneNumber", phoneNumber));
			params.add(new BasicNameValuePair("street", street));
			params.add(new BasicNameValuePair("city", city));
			params.add(new BasicNameValuePair("state", state));
			params.add(new BasicNameValuePair("zipCode", zipCode));
			params.add(new BasicNameValuePair("email", email));
			params.add(new BasicNameValuePair("paymentType", paymentType));
			params.add(new BasicNameValuePair("creditCard", cardNum));
			params.add(new BasicNameValuePair("discountCode", discountCode));
			params.add(new BasicNameValuePair("myOrder", convertOrderToDatabase(order)));

			JSONObject json = jsonParser.makeHttpRequest(url_add_order, "POST",	params);
			Log.d("Create Response", json.toString());

			try {
				int success = json.getInt(TAG_SUCCESS);

				if (success == 1) {
					// successfully created product
					//Intent i = new Intent(getApplicationContext(), ConfirmationPageActivity.class);
					//startActivity(i);
					// closing this screen
					System.out.println("MADE IT HERE");
					finish();
				} else {
					// failed to create product
				}
			} catch (JSONException e) {
				System.out.println("HERE:J1");
				e.printStackTrace();
				System.out.println("HERE:J2");
			}
			return null;

		}
	}
}
