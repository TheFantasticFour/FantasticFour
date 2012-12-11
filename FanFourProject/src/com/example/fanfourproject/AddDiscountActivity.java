package com.example.fanfourproject;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
/*
 * This class is an extension of an order and is created when the
 * user presses the 'Add Discount' button on the MainMenuActivity page.
 * It is responsible having the user input a discount code and/or
 * a banner ID number
 */
public class AddDiscountActivity extends Activity {
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_discount);
    }

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
    	
    	if(codeString.equals(DiscountCalculate.CODE_1)){
    		//codeMessage = "A 10% discount will be added for that code!";
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setMessage("A 10% discount will be added for that code!")
    		       .setCancelable(false)
    		       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
    		           public void onClick(DialogInterface dialog, int id) {
    		                //do things
    		           }
    		       });
    		AlertDialog alert = builder.create();
    		alert.show();
    		MainMenuActivity.codeString = DiscountCalculate.CODE_1;
    	}
    	else if(codeString.equals(DiscountCalculate.CODE_2)){
    		//codeMessage = "A 15% discount will be added for that code!";
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setMessage("A 15% discount will be added for that code!")
    		       .setCancelable(false)
    		       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
    		           public void onClick(DialogInterface dialog, int id) {
    		                //do things
    		           }
    		       });
    		AlertDialog alert = builder.create();
    		alert.show();
    		MainMenuActivity.codeString = DiscountCalculate.CODE_2;
    	}
    	else if(codeString.equals(DiscountCalculate.CODE_3)){
    		//codeMessage = "A 20% discount will be added for that code!";
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setMessage("A 20% discount will be added for that code!")
    		       .setCancelable(false)
    		       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
    		           public void onClick(DialogInterface dialog, int id) {
    		                //do things
    		           }
    		       });
    		AlertDialog alert = builder.create();
    		alert.show();
    		MainMenuActivity.codeString = DiscountCalculate.CODE_3;
    	}
    	else if(codeString.equals(DiscountCalculate.CODE_4)){
    		//codeMessage = "Your order will only cost $4.00";
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setMessage("Your order will only cost $4.00")
    		       .setCancelable(false)
    		       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
    		           public void onClick(DialogInterface dialog, int id) {
    		                //do things
    		           }
    		       });
    		AlertDialog alert = builder.create();
    		alert.show();
    		MainMenuActivity.codeString = DiscountCalculate.CODE_4;
    	}
    	else{
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setMessage("Invalid discount code!")
    		       .setCancelable(false)
    		       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
    		           public void onClick(DialogInterface dialog, int id) {
    		                //do things
    		           }
    		       });
    		AlertDialog alert = builder.create();
    		alert.show();
    		//codeMessage = "Invalid discount code.";
    	}
    	
    	if(bannerString.equals("")){
    		bannerMessage = "";
    	}
    	else if(bannerID >= DiscountCalculate.LOWEST_BANNER_ID && bannerID <= DiscountCalculate.HIGHEST_BANNER_ID){
    		//bannerMessage = "A 10% discount will be added for that ID!";
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setMessage("A 10% discount will be added for that ID!")
    		       .setCancelable(false)
    		       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
    		           public void onClick(DialogInterface dialog, int id) {
    		                //do things
    		           }
    		       });
    		AlertDialog alert = builder.create();
    		alert.show();
    		MainMenuActivity.bannerString = bannerString;
    	}
    	else{
    		//bannerMessage = "Invalid CSBSJU Banner ID number";
    		AlertDialog.Builder builder = new AlertDialog.Builder(this);
    		builder.setMessage("Invalid CSBSJU Banner ID number!")
    		       .setCancelable(false)
    		       .setPositiveButton("OK", new DialogInterface.OnClickListener() {
    		           public void onClick(DialogInterface dialog, int id) {
    		                //do things
    		           }
    		       });
    		AlertDialog alert = builder.create();
    		alert.show();
    	}
    	
    	
    	TextView messageViewer = (TextView) findViewById(R.id.message_viewer);
    	messageViewer.setText(codeMessage + "\n" + bannerMessage);
    }
    
    public void backToOrderMenu(View view){
    	finish();
    }
}
