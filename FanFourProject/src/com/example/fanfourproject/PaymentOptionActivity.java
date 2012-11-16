package com.example.fanfourproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class PaymentOptionActivity extends Activity {
	
	//This is a string to hold the entire address that the user will input
	private String address = "";
	
	//This is a string to hold the phone number that the user will input
	private String phoneNumber = "";
	
	//This is a string to hold the e-mail address that the user will input
	private String eMail = "";
	
	//This is a string to hold "cash" if cash is chosen and the credit card number if that is chosen
	private String payment = "";
	
	//This is a string to hold the street address that the user will input
	private String addressStreet = "";
	
	//This is a string to hold the city address that the user will input
	private String addressCity = "";
	
	//This is a string to hold the state address that the user will input
	private String addressState = "";
	
	//This is a string to hold the zip address that the user will input
	private String addressZip = "";
	
	public PaymentOptionActivity(){
		
	}	
	
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
    
    public String getUserInputString(int idNumber){
    	EditText myStreet = (EditText) findViewById(idNumber);
    	String returnString = myStreet.getText().toString();   	
    	return returnString;
    }
    
    public boolean getUserInputRadio(int idNumber){
    	boolean returnBoolean = ((RadioButton) findViewById(idNumber)).isChecked();  	
    	return returnBoolean;
    }
    
    
    /*
     * This method verifies all aspects of the user's address. It will get the street, city,
     * state and zip-code and only approve of the address if certain criteria are met. 
     */
    public boolean verifyAddress(){
    	boolean va = false;
    	
    	String tempStreet = getAddressStreet();
    	String tempCity = getAddressCity();
    	String tempState = getAddressState();
    	String tempZip = getAddressZip();
    	try{
    		boolean inMinnesota = tempState.toLowerCase().equals("mn");
    		boolean inZip1 = tempZip.equals("56321");
        	boolean inZip2 = tempZip.equals("56374");
    		if(inMinnesota && (inZip1 || inZip2)){
    			setAddress(tempStreet + "\n" + tempCity + ", " + tempState + ", " + tempZip);
    			va  = true;
    		}
    	}
    	catch(Exception e){
    		return va;
    	}
    	return va;
    }
    
    /*
     * This method verifies the user's phone number. Currently, a valid phone number has length 10
     * after the optional dashes are removed. 
     */
    public boolean verifyPhoneNumber(){
    	boolean vpn = false;
    	String tempPhoneNumber = getPhoneNumber();
    	
    	try{
			String finalPhoneNumber = "";
			for(int i = 0; i < tempPhoneNumber.length(); i++){
				if(!tempPhoneNumber.substring(i, i+1).equals("-")){//this removes all of the dashes in a phone number
					finalPhoneNumber = finalPhoneNumber + tempPhoneNumber.substring(i, i+1);
				}   		
			}
			
			if(finalPhoneNumber.length() == 10){
				vpn  = true;
				setPhoneNumber(finalPhoneNumber);
			}
		} 
    	catch (Exception e){
			return vpn;
		}    	
    	
    	return vpn;
    }
    
    /*
     * This method verifies the user's e-mail address. Currently, a valid e-mail contains
     * an @ symbol. 
     */
    public boolean verifyEmail(){
    	boolean vem = false;
    	String tempEmail = eMail;
    	
		try{
			if(tempEmail.indexOf('@') >= 0){
				eMail = tempEmail;
				vem  = true;
			}
		}
		catch (Exception e){
			return vem;
		}
    	return vem;
    }
    
    /*
     * This method verifies the user's payment info. If the credit card option is chosen,
     * payment is set to the credit card number which currently accepts an even number.
     */
    public boolean verifyPayment(){
    	boolean vp = false;
    	String tempCreditCard = "";
    	
    	try {
			if(getPayment().equals("Cash")){//want cash option
				vp = true;
			}
			else{//want credit card option
				tempCreditCard = getPayment();
				Integer ccNumber = null;
				ccNumber = Integer.valueOf(tempCreditCard);
				
				if(ccNumber==null || ccNumber%2!=0){	
					vp = false;        		
				}
				else{
					vp = true;
				}
			}
		} catch (Exception e) {
			return vp;
		}
    	return vp;
    }
    
    /*
     * This method is run when the user hits the submit order button. It checks whether each of the
     * verifications passed and if one does not, the message is altered and the order is not submitted.
     */
    public void submitOrder(View view){
    	setAddressStreet(getUserInputString(R.id.address_field));
    	setAddressCity(getUserInputString(R.id.city_field));
    	setAddressState(getUserInputString(R.id.state_field));
    	setAddressZip(getUserInputString(R.id.zip_field));
    	
    	setPhoneNumber(getUserInputString(R.id.phone_number_field));
    	
    	seteMail(getUserInputString(R.id.email_field));
    	
    	if(getUserInputRadio(R.id.cash_option)){
    		setPayment("Cash");
    	}
    	else{//credit card radio button pressed
    		setPayment(getUserInputString(R.id.credit_card_field));
    	}    	
    	
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
    		//output this info to the database and start a final activity
    		System.out.println(getPhoneNumber());
    		System.out.println(getAddress());
    		System.out.println(geteMail());
    		System.out.println(getPayment());
    		System.out.println(MainMenuActivity.mainOrder);
    	}
    	TextView messageTextView = (TextView) findViewById(R.id.message_area);
    	messageTextView.setText(message);
    }
    
    /**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the eMail
	 */
	public String geteMail() {
		return eMail;
	}

	/**
	 * @param eMail the eMail to set
	 */
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	/**
	 * @return the payment
	 */
	public String getPayment() {
		return payment;
	}

	/**
	 * @param payment the payment to set
	 */
	public void setPayment(String payment) {
		this.payment = payment;
	}

	/**
	 * @return the addressStreet
	 */
	public String getAddressStreet() {
		return addressStreet;
	}

	/**
	 * @param addressStreet the addressStreet to set
	 */
	public void setAddressStreet(String addressStreet) {
		this.addressStreet = addressStreet;
	}

	/**
	 * @return the addressCity
	 */
	public String getAddressCity() {
		return addressCity;
	}

	/**
	 * @param addressCity the addressCity to set
	 */
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}

	/**
	 * @return the addressState
	 */
	public String getAddressState() {
		return addressState;
	}

	/**
	 * @param addressState the addressState to set
	 */
	public void setAddressState(String addressState) {
		this.addressState = addressState;
	}

	/**
	 * @return the addressZip
	 */
	public String getAddressZip() {
		return addressZip;
	}

	/**
	 * @param addressZip the addressZip to set
	 */
	public void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}

	//@Override
    //public void onBackPressed() {//disable the back button
    //}
}
