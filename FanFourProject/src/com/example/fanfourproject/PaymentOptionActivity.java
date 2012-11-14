package com.example.fanfourproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class PaymentOptionActivity extends Activity {
	
	//This is a string to hold the address that the user will input
	private String address = "";
	
	//This is a string to hold the phone number that the user will input
	private String phoneNumber = "";
	
	//This is a string to hold the e-mail address that the user will input
	private String eMail = "";
	
	//This is a string to hold "cash" if cash is chosen and the credit card number if that is chosen
	private String payment = "";
	
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_option);
        
        Order thisOrder = MainMenuActivity.mainOrder;
        TextView intialNumber = (TextView) findViewById(R.id.intial_total_number);
        TextView taxNumber = (TextView) findViewById(R.id.tax_total_number);
        TextView discountNumber = (TextView) findViewById(R.id.discounts_total_number);
        TextView finalNumber = (TextView) findViewById(R.id.final_total_number);
        intialNumber.setText("$" + thisOrder.getInitialPrice());
        taxNumber.setText("$" +thisOrder.getTax());
        discountNumber.setText("$" +thisOrder.getDiscounts());
        finalNumber.setText("$" +thisOrder.getFinalPrice());
        
    }
    
    /*
     * This is a method that runs when the Cash radio button is pressed.
     * It will set the visibility of the credit card field to invisible
     */
    public void clickCash(View view){
    	EditText creditText = (EditText) findViewById(R.id.credit_card_field);
    	creditText.setVisibility(View.INVISIBLE);
    }
    
    /*
     * This is a method that runs when the Credit Card radio button is pressed.
     * It will set the visibility of the credit card field to visible
     */
    public void clickCredit(View view){
    	EditText creditText = (EditText) findViewById(R.id.credit_card_field);
    	creditText.setVisibility(View.VISIBLE);
    }
    
    /*
     * This method verifies all aspects of the user's address. It will get the street, city,
     * state and zip-code and only approve of the address if certain criteria are met. 
     */
    public boolean verifyAddress(){
    	boolean va = false;
    	EditText myStreet = (EditText) findViewById(R.id.address_field);
    	EditText myCity = (EditText) findViewById(R.id.city_field);
    	EditText myState = (EditText) findViewById(R.id.state_field);
    	EditText myZip = (EditText) findViewById(R.id.zip_field);
    	
    	String tempStreet = myStreet.getText().toString();
    	String tempCity = myCity.getText().toString();
    	String tempState = myState.getText().toString();
    	String tempZip = myZip.getText().toString();
    	
    	boolean inMinnesota = tempState.toLowerCase().equals("mn");
    	boolean inZip1 = tempZip.equals("56321");
    	boolean inZip2 = tempZip.equals("56374");
    	
    	if(inMinnesota && (inZip1 || inZip2)){
    		va  = true;
    		address = tempStreet + "\n" + tempCity + ", " + tempState + ", " + tempZip;
    	}    	
    	return va;
    }
    
    /*
     * This method verifies the user's phone number. Currently, a valid phone number has length 10
     * after the optional dashes are removed. 
     */
    private boolean verifyPhoneNumber(){
    	boolean vpn = false;
    	EditText myEditText = (EditText) findViewById(R.id.phone_number_field);
    	String tempPhoneNumber = myEditText.getText().toString();
    	
    	String finalPhoneNumber = "";
    	for(int i = 0; i < tempPhoneNumber.length(); i++){
    		if(!tempPhoneNumber.substring(i, i+1).equals("-")){
    			finalPhoneNumber = finalPhoneNumber + tempPhoneNumber.substring(i, i+1);
    		}   		
    	}
    	
    	if(finalPhoneNumber.length() == 10){
    		vpn  = true;
    		phoneNumber = finalPhoneNumber;
    	}    	
    	
    	return vpn;
    }
    
    /*
     * This method verifies the user's e-mail address. Currently, a valid e-mail contains
     * an @ symbol. 
     */
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
    
    /*
     * This method verifies the user's payment info. If the credit card option is chosen,
     * payment is set to the credit card number which currently accepts an even number.
     */
    private boolean verifyPayment(){
    	boolean vp = false;	
    	boolean cashPressed = ((RadioButton) findViewById(R.id.cash_option)).isChecked();
    	String tempCreditCard = "";
    	
    	if(cashPressed){//want cash option
    		payment = "Cash";
    		vp = true;
    	}
    	else{//want credit card option
    		EditText myEditText = (EditText) findViewById(R.id.credit_card_field);
    		tempCreditCard = myEditText.getText().toString();
    		Integer ccNumber = null;
    		try{
    			ccNumber = Integer.valueOf(tempCreditCard);
    		}
    		catch(Exception e){}
    		
    		if(ccNumber==null || ccNumber%2!=0){    			
    			vp  = false;
        		
    		}
    		else{
    			payment = tempCreditCard;
    			vp= true;
    		}
    	}	
    	
    	return vp;
    }
    
    /*
     * This method is run when the user hits the submit order button. It checks whether each of the
     * verifications passed and if one does not, the message is altered and the order is not submitted.
     */
    public void submitOrder(View view){
    	boolean va = verifyAddress();
    	boolean vpn = verifyPhoneNumber();
    	boolean vem = verifyEmail();
    	boolean vp = verifyPayment();
    	
    	String message = "";
    	//System.out.println("" + va + vpn + vem + vp);
    	if(!va){
    		message = message + "Invalid Address" + "\n";
    	}
    	if(!vpn){
    		message = message + "Invalid Phone Number" + "\n";
    	}
    	if(!vem){
    		message = message + "Invalid E-Mail" + "\n";
    	}
    	if(!vp){
    		message = message + "Invalid Credit Card Number" + "\n";
    	}    	
    	if(va && vpn && vem && vp){
    		//finish();
    		System.out.println(phoneNumber);
    		System.out.println(address);
    		System.out.println(eMail);
    		System.out.println(payment);
    		System.out.println(MainMenuActivity.mainOrder);
    	}
    	TextView messageTextView = (TextView) findViewById(R.id.message_area);
    	messageTextView.setText(message);
    }
    
    @Override
    public void onBackPressed() {//disable the back button
    }
}
