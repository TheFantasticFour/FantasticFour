/**
 * This Class is called when the Confirmation ID of a user is confirmed from the ChangeOrderActivity and grabs the Order attached to the specified Confirmation ID.
 * 
 * @author FantasticFour
 */

package com.example.fanfourproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

public class ConfirmChangedOrderActivity extends Activity {

	private DBHelperActivity myHelper = new DBHelperActivity();
	private Order myOrder = MainMenuActivity.mainOrder;
	
    @Override
    /**
     * Initializes the Activity.
     * 
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_changed_order);
        
        TextView confIdText = (TextView) findViewById(R.id.actual_id);
        confIdText.setText(PaymentOptionActivity.confId);
        
        TextView emailTextView = (TextView) findViewById(R.id.email_holder);
        emailTextView.setText(PaymentOptionActivity.geteMail());
        
        String paymentHolder = PaymentOptionActivity.getPayment();
        String cardNum = null;
        if(!paymentHolder.equals("Cash")){
        	paymentHolder = "Credit Card";
        	cardNum = PaymentOptionActivity.getPayment();
        }
        
        myHelper.editOrderInDatabase(
        		PaymentOptionActivity.confId, 
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
     * Closes the current Activity and directs the User to the HomePageActivity. 
     * 
     * @param view The current viewpane and corresponding data.
     */
    public void closeAndRestart(View view){        
        Intent intent = new Intent(this, HomePageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    
    @Override
    /**
     * Used when 'Back' button is pressed. Overrides and does nothing.
     * 
     */
    public void onBackPressed() {}//disable the back button
}
