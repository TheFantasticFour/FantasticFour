package com.example.fanfourproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;

public class PaymentOptionActivity extends Activity {
	
	private String address = "";
	private String phoneNumber = "";
	private String eMail = "";
	private String creditCard = "";
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option);
    }
    
    private boolean verifyAddress(){
    	boolean va = false;
    	EditText myEditText = (EditText) findViewById(R.id.address_field);
    	String tempAddress = myEditText.getText().toString();
    	
    	if(true){
    		va  = true;
    		address = tempAddress;
    	}
    	
    	return va;
    }
    
    private boolean verifyPhoneNumber(){
    	boolean vpn = false;
    	EditText myEditText = (EditText) findViewById(R.id.phone_number_field);
    	String tempPhoneNumber = myEditText.getText().toString();
    	
    	if(true){
    		vpn  = true;
    		phoneNumber = tempPhoneNumber;
    	}    	
    	
    	return vpn;
    }
    
    private boolean verifyEmail(){
    	boolean vem = false;
    	EditText myEditText = (EditText) findViewById(R.id.email_field);
    	String tempEmail = myEditText.getText().toString();
    	
    	if(true){
    		vem  = true;
    		eMail = tempEmail;
    	}
    	
    	return vem;
    }
    
    private boolean verifyCreditCard(){
    	boolean vcc = false;
    	EditText myEditText = (EditText) findViewById(R.id.credit_card_field);
    	String tempCreditCard = myEditText.getText().toString();
    	
    	if(true){
    		vcc  = true;
    		phoneNumber = tempCreditCard;
    	}    	
    	
    	return vcc;
    }

    public void submitOrder(View view){
    	boolean va = verifyAddress();
    	boolean vpn = verifyPhoneNumber();
    	boolean vem = verifyEmail();
    	boolean vcc = verifyCreditCard();
    	
    	if(va && vpn && vem && vcc){
    		//finish();
    	}
    	
    }
}
