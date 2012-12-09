package com.example.fanfourproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
    	
    	if(codeString.equals(discountCalculate.CODE_1)){
    		codeMessage = "A 10% discount will be added for that code!";
    		MainMenuActivity.codeString = discountCalculate.CODE_1;
    	}
    	else if(codeString.equals(discountCalculate.CODE_2)){
    		codeMessage = "A 15% discount will be added for that code!";
    		MainMenuActivity.codeString = discountCalculate.CODE_2;
    	}
    	else if(codeString.equals(discountCalculate.CODE_3)){
    		codeMessage = "A 20% discount will be added for that code!";
    		MainMenuActivity.codeString = discountCalculate.CODE_3;
    	}
    	else if(codeString.equals(discountCalculate.CODE_4)){
    		codeMessage = "Your order will only cost $4.00";
    		MainMenuActivity.codeString = discountCalculate.CODE_4;
    	}
    	else{
    		codeMessage = "Invalid discount code.";
    	}
    	//else if(codeString.equals(discountCalculate.CODE_5)){
    		
    	//}
    	
    	if(bannerString.equals("")){
    		bannerMessage = "";
    	}
    	else if(bannerID >= discountCalculate.LOWEST_BANNER_ID && bannerID <= discountCalculate.HIGHEST_BANNER_ID){
    		bannerMessage = "A 10% discount will be added for that ID!";
    		MainMenuActivity.bannerString = bannerString;
    	}
    	else{
    		bannerMessage = "Invalid CSBSJU Banner ID number";
    	}
    	
    	
    	TextView messageViewer = (TextView) findViewById(R.id.message_viewer);
    	messageViewer.setText(codeMessage + "\n" + bannerMessage);
    }
    
    public void backToOrderMenu(View view){
    	finish();
    }
}
