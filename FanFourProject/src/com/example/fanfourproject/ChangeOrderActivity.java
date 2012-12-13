/**
 * This class is called when the user clicks the 'Change Order' button
 * on the Home Page. The user inputs their Confirmation ID and provided
 * it is valid, they can proceed to edit their order.
 * 
 * @author FantasticFour
 */
package com.example.fanfourproject;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;

/*

 */
public class ChangeOrderActivity extends Activity {

	private DBHelperActivity dbHelper = new DBHelperActivity();
	
	public static ArrayList<Object> mainArray = new ArrayList<Object>();
	
	public static boolean changeOrder = false;
	
    @Override
    /**
     * Initializes the Activity.
     * 
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_order);
    }
/**
 * Takes the current View as a parameter, gathering information from the confirmationEditText field and comparing this value to values stored in the database. If this value is confirmed then they are forwarded onto the MainMenuActivity.
 * 
 * @param view
 */
    public void confirmButton(View view){
    	EditText confirmationText = (EditText) findViewById(R.id.confirmationEditText);
    	String confirmationCode = confirmationText.getText().toString();
    	
    	ArrayList<Object> mainArray = new ArrayList<Object>();
    	mainArray = dbHelper.getOrderFromDatabase(confirmationCode);
    	
    	/*String confID = (String) mainArray.get(0);
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
    	orderText.setVisibility(View.VISIBLE);*/
    	
        Intent intent = new Intent(this, MainMenuActivity.class);
        ChangeOrderActivity.mainArray = mainArray;
        changeOrder= true;
        startActivity(intent);
        
        finish();    	
    }    
}
