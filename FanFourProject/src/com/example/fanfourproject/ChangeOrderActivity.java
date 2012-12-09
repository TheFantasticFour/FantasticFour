package com.example.fanfourproject;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ChangeOrderActivity extends Activity {

	private DBHelperActivity dbHelper = new DBHelperActivity();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_order);
    }

    public void confirmButton(View view){
    	EditText confirmationText = (EditText) findViewById(R.id.confirmationEditText);
    	String confirmationCode = confirmationText.getText().toString();
    	
    	ArrayList<Object> mainArray = new ArrayList<Object>();
    	mainArray = dbHelper.getOrderFromDatabase(confirmationCode);
    	
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
