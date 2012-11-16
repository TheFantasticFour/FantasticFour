package com.example.fanfourproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class ReceiveConfirmationActivity extends Activity {

	public String confirmationID = "";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_confirmation);
        setConfirmationID(generateConfID());
    }

    public String generateConfID(){
    	String id = "";
    	//Random int generators to generate a random string as a conf id
    	
    	
    	return id;
    }

	/**
	 * @return the confirmationID
	 */
	public String getConfirmationID() {
		return confirmationID;
	}

	/**
	 * @param confirmationID the confirmationID to set
	 */
	public void setConfirmationID(String confirmationID) {
		this.confirmationID = confirmationID;
	}
}
