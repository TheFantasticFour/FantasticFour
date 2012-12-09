package com.example.fanfourproject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.util.Log;

public class DBHelperActivity extends Activity {

	private static final String URL_ADD_ORDER = "http://www.users.csbsju.edu/~pghardy/fan4Connect/add_order.php";
	private static final String URL_GET_ORDER = "http://www.users.csbsju.edu/~pghardy/fan4Connect/get_order.php";
	private static final String URL_ADD_REVIEW = "http://www.users.csbsju.edu/~pghardy/fan4Connect/add_review.php";
	private static final String URL_GET_ALL_REVIEWS = "http://www.users.csbsju.edu/~pghardy/fan4Connect/get_all_reviews.php";
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_ORDER = "orderr";
	
	
	private JSONParser jsonParser = new JSONParser();
	private JSONArray reviews = null;	
	private ArrayList<Review> reviewArray = new ArrayList<Review>();
	
	private String confID = "";
	private String phoneNumber = "";
	private String street = "";
	private String city = "";
	private String state = "";
	private String zipCode = "";
	private String email = "";
	private String paymentType = "";
	private String creditCard = "";
	private String discountCode = "";
	private Order myOrder = null;
	private String timestamp = "";
	
	private String pizzaType = "";
	private Double pizzaRating = 0.0;
	private String comment = "";

	
	@SuppressLint({ "NewApi", "NewApi", "NewApi" })
	public DBHelperActivity(){
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy); 		
	}
    
    public ArrayList<Object> getOrderFromDatabase(String confirmationID){
    	confID = confirmationID; 
    	RetrieveOrder ro = new RetrieveOrder();
    	ro.execute();
    	try {
			ro.get(2000, TimeUnit.MILLISECONDS);
		} 
    	catch (Exception e) {
			e.printStackTrace();
		}
    	ArrayList<Object> returnOrder = new ArrayList<Object>();
    	returnOrder.add(confID);
    	returnOrder.add(phoneNumber);
    	returnOrder.add(street);
    	returnOrder.add(city);
    	returnOrder.add(state);
    	returnOrder.add(zipCode);
    	returnOrder.add(email);
    	returnOrder.add(paymentType);
    	returnOrder.add(creditCard);
    	returnOrder.add(discountCode);
    	returnOrder.add(myOrder);
    	returnOrder.add(timestamp);
    	return returnOrder;
    }
    
    public void addOrderToDatabase(	
    		String confID, 
    		String phoneNumber, 
    		String street, 
    		String city, 
    		String state, 
    		String zipCode,
    		String email,
    		String paymentType,
    		String creditCard,
    		String discountCode,
    		Order myOrder){ 
    	this.confID = confID;
    	this.phoneNumber = phoneNumber;
    	this.street = street;
    	this.city = city;
    	this.state = state;
    	this.zipCode = zipCode;
    	this.email = email;
    	this.paymentType = paymentType;
    	this.creditCard = creditCard;
    	this.discountCode = discountCode;
    	this.myOrder = myOrder;
    	new CreateNewOrder().execute();
    }
    
	public void addReviewToDatabase(String pizzaType, Double pizzaRating, String comment){
		this.pizzaType = pizzaType;
		this.pizzaRating = pizzaRating;
		this.comment = comment;
		
		new CreateNewReview().execute();		
	}
	
	public ArrayList<Review> getAllReviewsFromDatabase(){
		GetAllReviews gar = new GetAllReviews();
    	gar.execute();
    	try {
			gar.get(2000, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
    	    	
    	return reviewArray;    	
	}
    
    
    public Order convertOrderFromDatabase(String fullOrder){
    	Order myOrder = new Order();
    	
    	String[] pizzaAndPop = fullOrder.split("///");
    	
    	String pizzaString = pizzaAndPop[0];
    	String popString = pizzaAndPop[1];
    	
    	String[] pizzaSplit = pizzaString.split("//");
    	String[] popSplit = popString.split("//");
    	
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
    		for(int pizzaElement = 0; pizzaElement < pizzas.size(); pizzaElement++){
    			s = s + convertPizzaToString(pizzas.get(pizzaElement)) + "//";
    		}
    		s = s + "/";
    	}
    	else{
    		s = s + "///";
    	}
    	
    	if(pops != null && pops.size() > 0){
    		for(int popElement = 0; popElement < pops.size()-1;popElement++){
    			s = s + convertPopToString(pops.get(popElement)) + "//";
    		}
    		s = s + convertPopToString(pops.get(pops.size()-1));
    	}
    	return s;
    }
    
    public Pizza convertStringToPizza(String databasePizza){
    	ArrayList<String> toppings = new ArrayList<String>();
    	String[] sentence = databasePizza.split(" ");
    	
    	String pizzaSize = sentence[0];
    	if(sentence.length == 2){
    		return new Pizza(pizzaSize, new ArrayList<String>());
    	}
    	else if(sentence.length == 4){
    		toppings.add(sentence[3]);
    		return new Pizza(pizzaSize, toppings);
    	}
    	else if(sentence.length >= 6){
    		for(int i = 3; i < sentence.length-3; i++){
    			//removing the comma
    			sentence[i] = sentence[i].substring(0,sentence[i].length()-1);
    			toppings.add(sentence[i]);
    		}
    		toppings.add(sentence[sentence.length-3]);
			toppings.add(sentence[sentence.length-1]);
    		return new Pizza(pizzaSize, toppings);
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
    
/*******************************************************/
	class RetrieveOrder extends AsyncTask<String, String, String> {

		protected String doInBackground(String... args) {

			int success;
			try {
				// Building Parameters
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("confID", confID));

				// getting an order by making HTTP request
				JSONObject json = jsonParser.makeHttpRequest(URL_GET_ORDER,
						"GET", params);

				// check your log for json response
				Log.d("Single Product Details", json.toString());

				// json success tag
				success = json.getInt(TAG_SUCCESS);
				if (success == 1) {
					// successfully received product details
					JSONArray orderObj = json.getJSONArray(TAG_ORDER);

					// get first product object from JSON Array
					JSONObject order = orderObj.getJSONObject(0);

					confID = order.getString("confID");
					phoneNumber = order.getString("phoneNumber");
					street = order.getString("street");
					city = order.getString("city");
					state = order.getString("state");
					zipCode = order.getString("zipCode");
					email = order.getString("email");
					paymentType = order.getString("paymentType");
					creditCard = order.getString("creditCard");
					discountCode = order.getString("discountCode");
					myOrder = convertOrderFromDatabase(order.getString("myOrder"));
					timestamp = order.getString("timestamp");
				}
			}
			catch (JSONException e) {
				e.printStackTrace();
			}
			
			return null;
		}
	}
	
/*******************************************************/
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
			params.add(new BasicNameValuePair("creditCard", creditCard));
			params.add(new BasicNameValuePair("discountCode", discountCode));
			params.add(new BasicNameValuePair("myOrder",
					convertOrderToDatabase(myOrder)));

			JSONObject json = jsonParser.makeHttpRequest(URL_ADD_ORDER, "POST", params);
			Log.d("Create Response", json.toString());

			try {
				int success = json.getInt(TAG_SUCCESS);

				if (success == 1) {
					finish();
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return null;
		}
	}

/*******************************************************/
	class CreateNewReview extends AsyncTask<String, String, String> {

		protected String doInBackground(String... args) {
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			
			params.add(new BasicNameValuePair("pizzaType", pizzaType));
			params.add(new BasicNameValuePair("pizzaRating", pizzaRating.toString()));
			params.add(new BasicNameValuePair("comment", comment));
			
			JSONObject json = jsonParser.makeHttpRequest(URL_ADD_REVIEW, "POST", params);
			Log.d("Create Response", json.toString());

			try {
				int success = json.getInt(TAG_SUCCESS);

				if (success == 1) {
					finish();
				}
			} catch (JSONException e) {
				System.out.println("HERE:J1");
				e.printStackTrace();
				System.out.println("HERE:J2");
			}
			return null;
		}
	}

/*******************************************************/
	class GetAllReviews extends AsyncTask<String, String, String> {

		/**
		 * getting All products from url
		 * */
		protected String doInBackground(String... args) {
			// Building Parameters
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			// getting JSON string from URL
			JSONObject json = jsonParser.makeHttpRequest(URL_GET_ALL_REVIEWS, "GET", params);

			// Check your log cat for JSON response
			Log.d("All Products: ", json.toString());

			try {
				// Checking for SUCCESS TAG
				int success = json.getInt(TAG_SUCCESS);

				if (success == 1) {
					// products found
					reviews = json.getJSONArray("reviews");

					// looping through All Products
					for (int i = 0; i < reviews.length(); i++) {
						JSONObject c = reviews.getJSONObject(i);

						// Storing each json item in variable
						String tempPizzaType = c.getString("pizzaType");
						String tempRating = c.getString("rating");
						String tempComment = c.getString("comment");
						String tempTime = c.getString("timestamp");
						
						Review newReview = new Review(tempPizzaType, Double
								.valueOf(tempRating), tempComment, tempTime); 
						reviewArray.add(newReview);
					}
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
}
