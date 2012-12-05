package com.example.fanfourproject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
	private String creditCard = "";
	private String discountCode = "";
	private Order myOrder = null;
	private String timestamp = "";

	
	@SuppressLint({ "NewApi", "NewApi", "NewApi" })
	public DBHelperActivity(){
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy); 
		
	}
	
    //@Override
    //public void onCreate(Bundle savedInstanceState) {
    //    super.onCreate(savedInstanceState);
    //    setContentView(R.layout.activity_dbhelper);
    //}
    
    public ArrayList<Object> getOrderFromDatabase(String confirmationID){
    	confID = confirmationID; 
    	ArrayList<Object> returnOrder = new ArrayList<Object>();
    	RetrieveOrder ro = new RetrieveOrder();
    	ro.execute();
    	try {
			ro.get(2000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
    	
    	//System.out.println("OORRDDEERR: " + myOrder);
    	//System.out.println("OORRDDEERR: " + myOrder.toString());
    	
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
    
    public void addOrderToDatabase(	String confID, 
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
    
    public Order convertOrderFromDatabase(String fullOrder){
    	Order myOrder = new Order();
    	
    	String[] pizzaAndPop = fullOrder.split("///");
    	
    	String pizzaString = pizzaAndPop[0];
    	String popString = pizzaAndPop[1];
    	
    	//System.out.println("pi: " + pizzaString);
    	//System.out.println("po: " + popString);
    	
    	String[] pizzaSplit = pizzaString.split("//");
    	String[] popSplit = popString.split("//");
    	
    	//System.out.println("piSplit: " + pizzaSplit[0]);
    	//System.out.println("poSplit: " + popSplit[0]);
    	
    	//for(String s: pizzaSplit) System.out.println(s);
    	
    	for(String s: pizzaSplit){
    		myOrder.addPizza(convertStringToPizza(s));
    		//System.out.println("Pizza1: " + convertStringToPizza(s));
    	}
    	for(String s: popSplit){
    		myOrder.addPop(convertStringToPop(s));
    		//System.out.println("Pop1: " + convertStringToPop(s));
    	}    	
    	
    	
    	//System.out.println(myOrder.toString());
    	
    	return myOrder;    	
    }
    
    public String convertOrderToDatabase(Order fullOrder){
    	ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
    	ArrayList<Pop> pops = new ArrayList<Pop>();
    	pizzas = fullOrder.getPizzas();
    	pops = fullOrder.getPop();
    	
    	//System.out.println(pizzas);
    	//System.out.println(pops);
    	
    	String s = "";	
    	if(pizzas != null && pizzas.size() > 0){
    		for(int i = 0; i < pizzas.size()-1; i++){
    			s = s + convertPizzaToString(pizzas.get(i)) + "//";
    		}
    		s = s + convertPizzaToString(pizzas.get(pizzas.size()-1)) + "///";
    	}
    	else{
    		s = s + "///";
    	}
    	//System.out.println("s: " + s);
    	
    	if(pops != null && pops.size() > 0){
    		for(int j = 0; j < pops.size()-1;j++){
    			s = s + convertPopToString(pops.get(j)) + "//";
    		}
    		s = s + convertPopToString(pops.get(pops.size()-1));
    	}
    	return s;
    }
    
    public Pizza convertStringToPizza(String databasePizza){
    	ArrayList<String> toppings = new ArrayList<String>();
    	
    	String[] sentence = databasePizza.split(" ");
    	//for(String s : sentence) System.out.println("A: " + s);
    	
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
    
	class RetrieveOrder extends AsyncTask<String, String, String> {
		
		protected String doInBackground(String... args) {

			// updating UI from Background Thread
			//runOnUiThread(new Runnable() {
				//public void run() {
					// Check for success tag
					int success;
					try {
						// Building Parameters
						List<NameValuePair> params = new ArrayList<NameValuePair>();
						params.add(new BasicNameValuePair("confID", confID));

						// getting product details by making HTTP request
						// Note that product details url will use GET request
						JSONObject json = jsonParser.makeHttpRequest(
								url_get_order, "GET", params);

						// check your log for json response
						Log.d("Single Product Details", json.toString());

						// json success tag
						success = json.getInt(TAG_SUCCESS);
						if (success == 1) {
							// successfully received product details
							JSONArray orderObj = json.getJSONArray("orderr"); // JSON
																				// Array

							// get first product object from JSON Array
							JSONObject order = orderObj.getJSONObject(0);

							// display product data in EditText
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
							//System.out.println("W: " + order.getString("myOrder"));
							myOrder = convertOrderFromDatabase(order.getString("myOrder"));
							timestamp = order.getString("timestamp");

							/*System.out.println("PconfID: " + confID);
							System.out.println("PphoneNumber: " + phoneNumber);
							System.out.println("Pstreet: " + street);
							System.out.println("Pcity: " + city);
							System.out.println("Pstate: " + state);
							System.out.println("PzipCode: " + zipCode);
							System.out.println("Pemail: " + email);
							System.out.println("PpaymentType: " + paymentType);
							System.out.println("PcreditCard: " + creditCard);
							System.out.println("PdiscountCode: " + discountCode);
							System.out.println("PmyOrder: " + myOrder);
							System.out.println("Ptimestamp: " + timestamp);*/

						} else {
							System.out.println("oops!");
							// product with pid not found
						}
					} catch (JSONException e) {
						System.out.println("HERE:B1");
						e.printStackTrace();
						System.out.println("HERE:B2");
					}
				//}
			//});

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
			params.add(new BasicNameValuePair("creditCard", creditCard));
			params.add(new BasicNameValuePair("discountCode", discountCode));
			params.add(new BasicNameValuePair("myOrder", convertOrderToDatabase(myOrder)));

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
