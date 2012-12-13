package com.example.fanfourproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/*
 * This class is an extension of an order and is created when the
 * user presses the 'Add Discount' button on the MainMenuActivity page.
 * It is responsible having the user input a discount code and/or
 * a banner ID number
 */
public class AddDiscountActivity extends Activity {
	
	private static int TOAST_SHORT = Toast.LENGTH_SHORT;
	private static int TOAST_LONG = Toast.LENGTH_LONG;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_discount);
    }
    
    /**
     * Method which applies the discounts as they are entered on the page.
     * 
     * @param view The total view of the current activity.
     */
    
    public void applyDiscounts(View view){
    	EditText codeHolder = (EditText) findViewById(R.id.code_holder);
    	EditText bannerHolder = (EditText) findViewById(R.id.banner_holder);
    	
    	String codeString = codeHolder.getText().toString();
    	String bannerString = bannerHolder.getText().toString();
    	int bannerID;
    	try{
    		bannerID = Integer.valueOf(bannerString);
    	}
    	catch(Exception e){
    		bannerID = -1;
    	}
    	
    	String codeMessage = "";
    	String bannerMessage = "";

    	if(codeString.equals("")){
    		codeMessage = "";
    	}
    	else if(codeString.equals(DiscountCalculate.CODE_1)){
    		codeMessage = "A 10% discount will be added for that code!";
    		MainMenuActivity.codeString = DiscountCalculate.CODE_1;
    	}
       	else if(codeString.equals(DiscountCalculate.CODE_2)){
    		codeMessage = "A 15% discount will be added for that code!";
    		MainMenuActivity.codeString = DiscountCalculate.CODE_2;
    	}
    	else if(codeString.equals(DiscountCalculate.CODE_3)){
    		codeMessage = "A 20% discount will be added for that code!";
    		MainMenuActivity.codeString = DiscountCalculate.CODE_3;
    	}
    	else if(codeString.equals(DiscountCalculate.CODE_4)){
    		codeMessage = "Your order will only cost $4.00";
    		MainMenuActivity.codeString = DiscountCalculate.CODE_4;
    	}
    	else{    		
    		String toastMessage = "Invalid discount code";
    		Context context = getApplicationContext();
    		Toast toast = Toast.makeText(context, toastMessage, TOAST_LONG);
    		toast.show();
    	}
    	
    	if(bannerString.equals("")){
    		bannerMessage = "";
    	}
    	else if(bannerID >= DiscountCalculate.LOWEST_BANNER_ID && bannerID <= DiscountCalculate.HIGHEST_BANNER_ID){
    		bannerMessage = "A 10% discount will be added for that ID!";
    		MainMenuActivity.bannerString = bannerString;
    	}
    	else{
    		String toastMessage = "Invalid CSBSJU Banner ID number";
    		Context context = getApplicationContext();
    		Toast toast = Toast.makeText(context, toastMessage, TOAST_LONG);
    		toast.show();
    	}
    	
    	
    	TextView messageViewer = (TextView) findViewById(R.id.message_viewer);
    	messageViewer.setText(codeMessage + "\n" + bannerMessage);
    }
    
    /**
     * Closes the current activity.
     * 
     * @param view The total view of the current activity.
     */
    
    public void backToOrderMenu(View view){
    	finish();
    }
}
