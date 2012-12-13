/**
 * Class which generates the confirmation ID for a given order once it has been submitted. 
 * 
 */
package com.example.fanfourproject;

import java.util.Random;


import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class ReceiveConfirmationActivity extends Activity {

	public String confirmationID = "";
	private DBHelperActivity myHelper = new DBHelperActivity();
	private Order myOrder = MainMenuActivity.mainOrder;
	
	public ReceiveConfirmationActivity(){
		
	}
    
    /**
     * Initializes the activity. Gathers Confirmation ID and displays it.
     * 
     * @param savedInstanceState
     */
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_confirmation);
        setConfirmationID(generateConfID());
        
        TextView idTextView = (TextView) findViewById(R.id.actual_id);
        idTextView.setText(confirmationID);
        
        TextView emailTextView = (TextView) findViewById(R.id.email_holder);
        emailTextView.setText(PaymentOptionActivity.geteMail());
        
        String paymentHolder = PaymentOptionActivity.getPayment();
        String cardNum = null;
        if(!paymentHolder.equals("Cash")){
        	paymentHolder = "Credit Card";
        	cardNum = PaymentOptionActivity.getPayment();
        }
        
        myHelper.addOrderToDatabase(
        		getConfirmationID(), 
        		PaymentOptionActivity.getPhoneNumber(), 
        		PaymentOptionActivity.getAddressStreet(), 
        		PaymentOptionActivity.getAddressCity(), 
        		PaymentOptionActivity.getAddressState(), 
        		PaymentOptionActivity.getAddressZip(), 
        		PaymentOptionActivity.geteMail(), 
        		paymentHolder, 
        		cardNum, 
        		MainMenuActivity.codeString + "|" + MainMenuActivity.bannerString, 
        		myOrder);
    }
	
    /**
     * Generates new confirmation ID
     * 
     * @return String of the confirmation ID generated
     */
    public String generateConfID(){
    	Random generator = new Random();
        String conf = "";
        
        for(int j = 0; j < 10; j++){
            int i = generator.nextInt(36);
            while(i == 0 || i == 24){//removes O's and 0's 
                i = generator.nextInt(36);
            }
            if(i < 10){
                conf = conf + i;
            }
            else{
                conf = conf + ((char) (i+55));
            }
        }
    	return conf;
    }
    
	/**
	 * Clears the information when Activity is closed, to avoid multiple copies.
	 * 
	 * @param view
	 */
    public void closeAndRestart(View view){        
        Intent intent = new Intent(this, HomePageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

	/**
	 * Gets confirmation ID
	 * 
	 * @return the confirmationID
	 */
	public String getConfirmationID() {
		return confirmationID;
	}

	/**
	 * Sets the confirmation ID
	 * 
	 * @param confirmationID
	 *            the confirmationID to set
	 * @param savedInstanceState
	 */
	public void setConfirmationID(String confirmationID) {
		this.confirmationID = confirmationID;
	}
	
	/**
	 * Ensures when 'Back' is pressed nothing happens.
	 * 
	 */
	@Override
    public void onBackPressed() {}//disable the back button
}
