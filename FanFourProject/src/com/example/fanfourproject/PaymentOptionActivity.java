package com.example.fanfourproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class PaymentOptionActivity extends Activity {
	
	private String address = "";
	private String phoneNumber = "";
	private String eMail = "";
	private String creditCard = "";
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option);
        
        Order thisOrder = MainMenuActivity.mainOrder;
        TextView intialNumber = (TextView) findViewById(R.id.intial_total_number);
        TextView taxNumber = (TextView) findViewById(R.id.tax_total_number);
        TextView discountNumber = (TextView) findViewById(R.id.discounts_total_number);
        TextView finalNumber = (TextView) findViewById(R.id.final_total_number);
        intialNumber.setText(thisOrder.getInitialPrice());
        taxNumber.setText(thisOrder.getTax());
        discountNumber.setText(thisOrder.getDiscounts());
        finalNumber.setText(thisOrder.getFinalPrice());
        
    }
    
    public void clickCash(View view){
    	EditText creditText = (EditText) findViewById(R.id.credit_card_field);
    	creditText.setVisibility(View.INVISIBLE);
    }
    
    public void clickCredit(View view){
    	EditText creditText = (EditText) findViewById(R.id.credit_card_field);
    	creditText.setVisibility(View.VISIBLE);
    }
    
    public boolean verifyAddress(){
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
    	
    	if(tempPhoneNumber.length() == 10){
    		vpn  = true;
    		phoneNumber = tempPhoneNumber;
    	}    	
    	
    	return vpn;
    }
    
    private boolean verifyEmail(){
    	boolean vem = false;
    	EditText myEditText = (EditText) findViewById(R.id.email_field);
    	String tempEmail = myEditText.getText().toString();
    	
		if(tempEmail.indexOf('@') >= 0){
    		vem  = true;
    		eMail = tempEmail;
    	}
    	
    	return vem;
    }
    
    private boolean verifyCreditCard(){
    	boolean vcc = false;
    	EditText myEditText = (EditText) findViewById(R.id.credit_card_field);
    	String tempCreditCard = myEditText.getText().toString();
    	Integer ccNumber = Integer.valueOf(tempCreditCard);
    	    	
    	if(ccNumber%2==0){
    		vcc  = true;
    		creditCard = tempCreditCard;
    	}    	
    	
    	return vcc;
    }

    public void submitOrder(View view){
    	boolean va = verifyAddress();
    	boolean vpn = verifyPhoneNumber();
    	boolean vem = verifyEmail();
    	boolean vcc = verifyCreditCard();
    	
    	String message = "";
    	
    	if(!va){
    		message = message + "Invalid Address" + "\n";
    	}
    	if(!vpn){
    		message = message + "Invalid Phone Number" + "\n";
    	}
    	if(!vem){
    		message = message + "Invalid E-Mail" + "\n";
    	}
    	if(!vcc){
    		message = message + "Invalid CreditCardNumber" + "\n";
    	}    	
    	if(va && vpn && vem && vcc){
    		//finish();
    		System.out.println(phoneNumber);
    		System.out.println(address);
    		System.out.println(eMail);
    		System.out.println(creditCard);
    		System.out.println(MainMenuActivity.mainOrder);
    	}    	
    }
}
