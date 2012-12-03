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
	JSONParser jsonParser = new JSONParser();
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
	private String order = "";

	
	public DBHelperActivity(){
		
	}
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dbhelper);
    }
    
    public Order getOrderFromDatabase(String confirmationID){
    	Order returnOrder = null;
    	
    	
    	
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
    								String order){ 
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
			params.add(new BasicNameValuePair("myOrder", order));

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
