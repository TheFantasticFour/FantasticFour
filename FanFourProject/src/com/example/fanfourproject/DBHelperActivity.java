/**
 * This Class serves as the intermediary between the User interface and the Database functions. Specifically adds the functionality of adding, retrieving, editing, and deleting both reviews and orders.
 * 
 * @author FantasticFour 
 */

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
	private static final String URL_DELETE_ORDER = "http://www.users.csbsju.edu/~pghardy/fan4Connect/delete_order.php";
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
	/**
	 * Sets the ThreadPolicy to permit all. 
	 * 
	 */
	
	public DBHelperActivity(){
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy); 		
	}
    
	/**
	 * Using a confirmation ID calls on the database and retrieves the order specific to that ID.
	 * 
	 * @param confirmationID The confirmation ID for a specific order.
	 * @return Returns a ArrayList the specifics of the order if successful. If unsuccessful it returns NULL.
	 */
	
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
    /**
     * Adds a specific order to a database. Takes the parameters, creates an instance of CreateNewOrder which it then excecutes.
     * 
     * @param confID Confirmation ID for the Order.
     * @param phoneNumber Phone Number for the Order.
     * @param street Street Line of the addres for the Order.
     * @param city City for the address for the Order.
     * @param state State for the address for the Order.
     * @param zipCode ZIP code for the address for the Order.
     * @param email Email for the Order.
     * @param paymentType Payment Type for the Order.
     * @param creditCard Credit Card for the Order.
     * @param discountCode Discount Code for the Order.
     * @param myOrder The final Price.
     */
    
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
    /**
     * Takes the elements of a Order, creates an instance of CreateNewOrder and then executes.
     * 
     * 
     * @param confID Confirmation ID for the Order.
     * @param phoneNumber Phone Number for the Order.
     * @param street Street Line of the addres for the Order.
     * @param city City for the address for the Order.
     * @param state State for the address for the Order.
     * @param zipCode ZIP code for the address for the Order.
     * @param email Email for the Order.
     * @param paymentType Payment Type for the Order.
     * @param creditCard Credit Card for the Order.
     * @param discountCode Discount Code for the Order.
     * @param myOrder The final Price for the Order.
     */
    public void editOrderInDatabase(	
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
    	DeleteOrder deleteObject = new DeleteOrder();
    	deleteObject.execute();
    	try {
    		deleteObject.get(2000,TimeUnit.MILLISECONDS);
    	}
    	catch(Exception e){
    		e.printStackTrace();
    	}
    	
    	new CreateNewOrder().execute();
    }
    /**
     * This method takes the pizza type, rating, and comment then creates an instance of CreateNewReview then executes.
     * 
     * 
     * @param pizzaType Type of pizza
     * @param pizzaRating Rating given for the pizza.
     * @param comment Comment made for the pizza.
     */
	public void addReviewToDatabase(String pizzaType, Double pizzaRating, String comment){
		this.pizzaType = pizzaType;
		this.pizzaRating = pizzaRating;
		this.comment = comment;
		
		new CreateNewReview().execute();		
	}
	/**
	 * Simple method which retrieves all reviews from the database.
	 * 
	 * @return Returns a ArrayList of Reviews if successful, NULL if unsuccessful.
	 */
	public ArrayList<Review> getAllReviewsFromDatabase(){
		GetAllReviews gar = new GetAllReviews();
    	gar.execute();
    	try {
			gar.get(2000, TimeUnit.MILLISECONDS);
		}
    	catch (Exception e) {
			e.printStackTrace();
		}
    	    	
    	return reviewArray;    	
	}
    /**
     * This method takes the full string of an order and divides it into the necessary categories, Pizza and Pop.
     * 
     * @param fullOrder The complete order in one string. 
     * @return Returns an Order where pizza and pop are in seperate objects.
     */
    
    public Order convertOrderFromDatabase(String fullOrder){
    	Order myOrder = new Order();
    	String[] pizzaAndPop = fullOrder.split("///");
    	int fullOrderLength = fullOrder.length();
    	
    	if(!fullOrder.substring(0,3).equals("///")){
	    	String pizzaString = pizzaAndPop[0];
	    	String[] pizzaSplit = pizzaString.split("//");   	
	    	for(String s: pizzaSplit){
	    		myOrder.addPizza(convertStringToPizza(s));
	    	}
    	}
    	
    	if(!fullOrder.substring(fullOrderLength-3).equals("///")){
    		String popString = pizzaAndPop[1];
    		String[] popSplit = popString.split("//");
    		for(String s: popSplit){
    			myOrder.addPop(convertStringToPop(s));
    		}
    	}
    	return myOrder;    	
    }
    /**
     * Method converts an order in order for it to be properly sent to the database.
     * 
     * @param fullOrder Takes the original Order.
     * @return A string with breaks specified.
     */
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
    /**
     * Converts a String into a Pizza Object. 
     * 
     * @param databasePizza The original String. 
     * @return A Pizza that may be added to the database.
     */
    
    public Pizza convertStringToPizza(String databasePizza){
    	if(!databasePizza.contains(":")){
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
    	else{
    		if(databasePizza.equals("Special Pizza: Meat-Lovers Pizza")){
    			return new Pizza(1);
    		}
    		else if(databasePizza.equals("Special Pizza: Taco Pizza")){
    			return new Pizza(2);
    		}
    		else if(databasePizza.equals("Special Pizza: Veggie Pizza")){
    			return new Pizza(3);
    		}
    		else if(databasePizza.equals("Special Pizza: Fajita Pizza")){
    			return new Pizza(4);
    		}
    		else if(databasePizza.equals("Special Pizza: Buffalo-Chicken Pizza")){
    			return new Pizza(5);
    		}
    		else if(databasePizza.equals("Special Pizza: Bacon-Cheeseburger Pizza")){
    			return new Pizza(6);
    		}
    		else{ //"Special Pizza: Dessert Pizza"
    			return new Pizza(7);
    		}
    	}
    }
    /**
     * Converts a String into a Pop Object. 
     * 
     * @param databasePop The original String. 
     * @return A Pop that may be added to the database.
     */
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
    
    /**
     * This Class when initialized retrieves a specified order. 
     * 
     * @author FantasticFour
     */
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
	/**
	 * This Class when initialized creates a new order to be sent to the database. On Failure returns NULL.
	 * 
	 * @author FantasticFour
	 *
	 */
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
	/**
	 * This Class when initialized Deletes a specified Order. On failure returns NULL.
	 * 
	 * @author wjradomski
	 *
	 */
	class DeleteOrder extends AsyncTask<String, String, String>{

		protected String doInBackground(String... args) {

			// Check for success tag
			int success;
			try {
				// Building Parameters
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				params.add(new BasicNameValuePair("confID", confID));

				JSONObject json = jsonParser.makeHttpRequest(
						URL_DELETE_ORDER, "POST", params);

				// check your log for json response
				Log.d("Delete Product", json.toString());
				
				// json success tag
				success = json.getInt(TAG_SUCCESS);
				if (success == 1) {
					// Order successfully deleted
					finish();
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return null;
		}
	}
	
/*******************************************************/
	
	/**
	 * This Class when initialized creates a new review to be sent to the database. On failure returns NULL.
	 * 
	 * @author FantasticFour
	 *
	 */
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
	/**
	 * When initialized, returns all reviews from the database. On failure returns NULL.
	 * 
	 * @author FantasticFour
	 *
	 */
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
