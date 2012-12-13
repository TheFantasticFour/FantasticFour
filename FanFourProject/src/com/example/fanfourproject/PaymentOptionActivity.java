/**
 * This class is called when the User selects the 'Proceed' button from the MainMenuActivity. Displays payment options.
 * 
 */
package com.example.fanfourproject;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class PaymentOptionActivity extends Activity {
	
	//This is a string to hold the entire address that the user will input
	static String address = "";
	
	//This is a string to hold the phone number that the user will input
	static String phoneNumber = "";
	
	//This is a string to hold the e-mail address that the user will input
	static String eMail = "";
	
	//This is a string to hold "cash" if cash is chosen and the credit card number if that is chosen
	static String payment = "";
	
	//This is a string to hold the street address that the user will input
	static String addressStreet = "";
	
	//This is a string to hold the city address that the user will input
	static String addressCity = "";
	
	//This is a string to hold the state address that the user will input
	static String addressState = "";
	
	//This is a string to hold the zip address that the user will input
	static String addressZip = "";
	
	//This is an Array List of integers to hold different messages to convey to the user
	static ArrayList<Integer> listOfMessages = new ArrayList<Integer>();	
	
	public static Boolean changeOrder = false;
	public static String confId = "";
	
	public static ArrayList<Object> mainArray = new ArrayList<Object>();
	
	public PaymentOptionActivity(){
		
	}	
   
    /**
     * Initializes the Activity. Gathers data from the current order and displays the necessary information.
     * 
     */
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
        System.out.println(thisOrder.getDiscounts());
        discountNumber.setText("$" +thisOrder.getDiscounts());
        finalNumber.setText("$" +thisOrder.getFinalPrice());
    	
        mainArray = MainMenuActivity.changeArray;
        changeOrder = ChangeOrderActivity.changeOrder;
        if(changeOrder!= null && changeOrder){
    		continueChangedOrder();
    	}      
    }
    
	/**
	 * This is a method that runs when the Cash radio button is pressed. It will
	 * set the visibility of the credit card field to invisible
	 * 
	 * @param view
	 */
    public void clickCash(View view){
    	EditText creditText = (EditText) findViewById(R.id.credit_card_field);
    	creditText.setVisibility(View.INVISIBLE);
    }
    
	/**
	 * This is a method that runs when the Credit Card radio button is pressed.
	 * It will set the visibility of the credit card field to visible
	 * 
	 * @param view
	 */
    public void clickCredit(View view){
    	EditText creditText = (EditText) findViewById(R.id.credit_card_field);
    	creditText.setVisibility(View.VISIBLE);
    }   
    
	/**
	 * This method verifies all aspects of the user's address. It will get the
	 * street, city, state and zip-code and only approve of the address if
	 * certain criteria are met.
	 * 
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
    		if(inMinnesota){
    			if((inZip1 || inZip2)){
    				setAddress(tempStreet + "\n" + tempCity + ", " + tempState + ", " + tempZip);
    				va  = true;
    				return va;
    			}
    			va = false;
    			addToListOfMessages(4);
    			return va;
    		}
    		else{
    			va = false;
    			addToListOfMessages(3);
    			return va;
    		}
    	}
    	catch(Exception e){
    		addToListOfMessages(5);
    		return va;
    	}
    }
    
	/**
	 * This method verifies the user's phone number. Currently, a valid phone
	 * number has length 10 after the optional dashes are removed.
	 * 
	 * @return Boolean whether or not Phone Number entered is valid.
	 * 
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
				return vpn;
			}
			else{
				vpn = false;
				addToListOfMessages(6);
				return vpn;
			}
		} 
    	catch (Exception e){
    		addToListOfMessages(6);
			return vpn;
		}    	
 
    }
    
	/**
	 * This method verifies the user's e-mail address. Currently, a valid e-mail
	 * contains an @ symbol.
	 * 
	 * @return Boolean returns true if email contains '@'
	 */
    public boolean verifyEmail(){
    	boolean vem = false;
    	String tempEmail = eMail;
    	
		try{
			if(tempEmail.indexOf('@') >= 0){
				eMail = tempEmail;
				vem  = true;
				return vem;
			}
			else{
				vem  = false;
				addToListOfMessages(7);
				return vem;
			}
		}
		catch (Exception e){
			addToListOfMessages(7);
			return vem;
		}
    }
    
	/**
	 * This method verifies the user's payment info. If the credit card option
	 * is chosen, payment is set to the credit card number which currently
	 * accepts an even number.
	 * 
	 * @return Boolean returns true if Payment information is properly submitted
	 */
    public boolean verifyPayment(){
    	boolean vp = false;
    	String tempCreditCard = "";
    	
    	try {
			if(getPayment().equals("Cash")){//want cash option
				vp = true;
				return vp;
			}
			else{//want credit card option
				tempCreditCard = getPayment();
				Integer ccNumber = null;
				ccNumber = Integer.valueOf(tempCreditCard);
				
				if(ccNumber == null || ccNumber%2!=0){	
					vp = false;
					addToListOfMessages(8);
					return vp;
				}
				else{
					vp = true;
					return vp;
				}
			}
		} catch (Exception e) {
			addToListOfMessages(8);
			return vp;
		}
    }
    
	/**
	 * This method is run when the user hits the submit order button. It checks
	 * whether each of the verifications passed and if one does not, the message
	 * is altered and the order is not submitted.
	 * 
	 * @param view
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

    	
    	for(Integer myInt: listOfMessages){
    		if(myInt == 1){
    			String toastMessage = "Invalid Street Address";
        		Context context = getApplicationContext();
        		Toast toast = Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT);
        		toast.show();
    		}
    		else if(myInt == 2){
    			String toastMessage = "Invalid City";
        		Context context = getApplicationContext();
        		Toast toast = Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT);
        		toast.show();    			
    		}
    		else if(myInt == 3){
    			String toastMessage = "Invalid State";
        		Context context = getApplicationContext();
        		Toast toast = Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT);
        		toast.show();
    		}
    		else if(myInt == 4){
    			String toastMessage = "Invalid ZipCode";
        		Context context = getApplicationContext();
        		Toast toast = Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT);
        		toast.show();
    		}
    		else if(myInt == 5){
    			String toastMessage = "Invalid Address";
        		Context context = getApplicationContext();
        		Toast toast = Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT);
        		toast.show();
    		}
    		else if(myInt == 6){
    			String toastMessage = "Invalid Phone Number";
        		Context context = getApplicationContext();
        		Toast toast = Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT);
        		toast.show();
    		}
    		else if(myInt == 7){
    			String toastMessage = "Invalid Email";
        		Context context = getApplicationContext();
        		Toast toast = Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT);
        		toast.show();
    		}
    		else if(myInt == 8){
    			String toastMessage = "Invalid Credit Card Number";
        		Context context = getApplicationContext();
        		Toast toast = Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT);
        		toast.show();
    		}
    	}
    	clearListOfMessages();
    	
    	if(va && vpn && vem && vp){
    		if(changeOrder){
    			Intent intent = new Intent(this, ConfirmChangedOrderActivity.class);
    			intent.putExtra("UserEmail", geteMail());
    			startActivity(intent);
    		}
    		else{
    			Intent intent = new Intent(this, ReceiveConfirmationActivity.class);
    			intent.putExtra("UserEmail", geteMail());
    			startActivity(intent);
    		}
    	}
    }
    
	/**
	 * Helper method for EditText
	 * 
	 * @param idNumber
	 *            ID number for a given text field.
	 * @return String of a given text field.
	 */
    private String getUserInputString(int idNumber){
    	EditText myStreet = (EditText) findViewById(idNumber);
    	String returnString = myStreet.getText().toString();   	
    	return returnString;
    }
    
	/**
	 * Helper method for RadioButton
	 * 
	 * @param idNumber
	 *            ID number for a given radio button.
	 * @return Boolean true if the radio button is selected.
	 */
    public boolean getUserInputRadio(int idNumber){
    	boolean returnBoolean = ((RadioButton) findViewById(idNumber)).isChecked();  	
    	return returnBoolean;
    }
    
	/**
	 * Gets address submitted.
	 * 
	 * @return The address
	 */
	public static String getAddress() {
		return address;
	}

	/**
	 * Sets Address for a Order
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		PaymentOptionActivity.address = address;
	}

	/**
	 * Gets phone number submitted
	 * @return The phoneNumber
	 */
	public static String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		PaymentOptionActivity.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the phone number
	 * @return the eMail
	 */
	public static String geteMail() {
		return eMail;
	}

	/**
	 * Sets the email
	 * @param eMail the eMail to set
	 */
	public void seteMail(String eMail) {
		PaymentOptionActivity.eMail = eMail;
	}

	/**
	 * Gets type of payment
	 * @return the payment
	 */
	public static String getPayment() {
		return payment;
	}

	/**
	 * Sets type of payment
	 * @param payment the payment to set
	 */
	public void setPayment(String payment) {
		PaymentOptionActivity.payment = payment;
	}

	/**
	 * Gets street address
	 * @return the addressStreet
	 */
	public static String getAddressStreet() {
		return addressStreet;
	}

	/**
	 * Sets the street address
	 * @param addressStreet the addressStreet to set
	 */
	public void setAddressStreet(String addressStreet) {
		PaymentOptionActivity.addressStreet = addressStreet;
	}

	/**
	 * Gets the city
	 * @return the addressCity
	 */
	public static String getAddressCity() {
		return addressCity;
	}

	/**
	 * Sets the city
	 * @param addressCity the addressCity to set
	 */
	public void setAddressCity(String addressCity) {
		PaymentOptionActivity.addressCity = addressCity;
	}

	/**
	 * Gets the state
	 * @return the addressState
	 */
	public static String getAddressState() {
		return addressState;
	}

	/**
	 * Sets the state
	 * @param addressState the addressState to set
	 */
	public void setAddressState(String addressState) {
		PaymentOptionActivity.addressState = addressState;
	}

	/**
	 * Gets the ZIP
	 * @return the addressZip
	 */
	public static String getAddressZip() {
		return addressZip;
	}

	/**
	 * Sets the ZIP
	 * @param addressZip the addressZip to set
	 */
	public void setAddressZip(String addressZip) {
		PaymentOptionActivity.addressZip = addressZip;
	}
	/**
	 * Adds to list of messages
	 * @param myInt Number of messages
	 */
	public void addToListOfMessages(Integer myInt){
		listOfMessages.add(myInt);
	}
	/**
	 * Clears list of messages
	 * 
	 */
	public void clearListOfMessages(){
		listOfMessages = new ArrayList<Integer>();
	}
	
	public ArrayList<Integer> getListOfMessages(){
		return listOfMessages;
	}
	/**
	 * Brings in data to continue an order
	 * 
	 */
	public void continueChangedOrder(){		
		ArrayList<Object> changeArray = mainArray;
		String confID = (String) changeArray.get(0);
    	String phoneNumber = (String) changeArray.get(1);
    	String street = (String) changeArray.get(2);
    	String city = (String) changeArray.get(3);
    	String state = (String) changeArray.get(4);
    	String zipCode = (String) changeArray.get(5);
    	String email = (String) changeArray.get(6);
    	String paymentType = (String) changeArray.get(7);
    	String creditCard = (String) changeArray.get(8);
    	//String discountCode = (String) changeArray.get(9);
    	//Order myOrder = (Order) changeArray.get(10);
    	//String timestamp = (String) changeArray.get(11);
		
    	confId = confID;    	
		EditText addressField = (EditText) findViewById(R.id.address_field);
    	addressField.setText(street);
    	
    	EditText cityField = (EditText) findViewById(R.id.city_field);
    	cityField.setText(city);
    	
    	EditText stateField = (EditText) findViewById(R.id.state_field);
    	stateField.setText(state);
    	
    	EditText zipField = (EditText) findViewById(R.id.zip_field);
    	zipField.setText(zipCode);
    	
    	EditText phoneField = (EditText) findViewById(R.id.phone_number_field);
    	phoneField.setText(phoneNumber);
    	
    	EditText emailField = (EditText) findViewById(R.id.email_field);
    	emailField.setText(email);
    	
    	if(!paymentType.equals("Cash")){
    		EditText creditText = (EditText) findViewById(R.id.credit_card_field);
    		creditText.setText(creditCard);
        	creditText.setVisibility(View.VISIBLE);
        	
        	RadioButton cashButton = (RadioButton) findViewById(R.id.cash_option);
        	RadioButton creditButton = (RadioButton) findViewById(R.id.credit_card_option);
        	
        	cashButton.setChecked(false);
        	creditButton.setChecked(true);
    	}
	}
}
