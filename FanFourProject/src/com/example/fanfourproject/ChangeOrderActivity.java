package com.example.fanfourproject;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ChangeOrderActivity extends Activity {

	DBHelperActivity dbHelper = new DBHelperActivity();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_order);
    }

    public void confirmButton(View view){
    	EditText confText = (EditText) findViewById(R.id.editText1);
    	String confirmationCode = confText.getText().toString();
    	
    	ArrayList<Object> mainArray = new ArrayList<Object>();
    	mainArray = dbHelper.getOrderFromDatabase(confirmationCode);
    	//System.out.println("MainArray: " + mainArray);
    	
    	String confID = (String) mainArray.get(0);
    	String phoneNumber = (String) mainArray.get(1);
    	String street = (String) mainArray.get(2);
    	String city = (String) mainArray.get(3);
    	String state = (String) mainArray.get(4);
    	String zipCode = (String) mainArray.get(5);
    	String email = (String) mainArray.get(6);
    	String paymentType = (String) mainArray.get(7);
    	String creditCard = (String) mainArray.get(8);
    	String discountCode = (String) mainArray.get(9);
    	Order myOrder = (Order) mainArray.get(10);
    	String timestamp = (String) mainArray.get(11);
    	
    	/*System.out.println("confID: " + confID);
		System.out.println("phoneNumber: " + phoneNumber);
		System.out.println("street: " + street);
		System.out.println("city: " + city);
		System.out.println("state: " + state);
		System.out.println("zipCode: " + zipCode);
		System.out.println("email: " + email);
		System.out.println("paymentType: " + paymentType);
		System.out.println("creditCard: " + creditCard);
		System.out.println("discountCode: " + discountCode);
		System.out.println("myOrder: " + myOrder);
		System.out.println("timestamp: " + timestamp);*/
    	
    	TextView orderText = (TextView) findViewById(R.id.orderArea);
    	
    	//USE THIS INFO TO CONSTRUCT THE ORDER!
    	orderText.setText(confID + "\n" + 
    					  phoneNumber + "\n" + 
    					  street + "\n" + 
    					  city + "\n" + 
    					  state + "\n" + 
    					  zipCode + "\n" + 
    					  email + "\n" + 
    					  paymentType + "\n" + 
    					  creditCard + "\n" + 
    					  discountCode + "\n" + 
    					  myOrder + "\n" + 
    					  timestamp + "\n");
    	orderText.setVisibility(View.VISIBLE);
    	
    }
    
    
    
    
}
