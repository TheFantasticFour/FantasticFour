package com.example.fanfourproject;

import java.util.Random;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class ReceiveConfirmationActivity extends Activity {

	public String confirmationID = "";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_confirmation);
        setConfirmationID(generateConfID());
        
        TextView idTextView = (TextView) findViewById(R.id.actual_id);
        idTextView.setText(confirmationID);
    }

    public String generateConfID(){
    	Random generator = new Random();
        String conf = "";
        
        for(int j = 0; j < 10; j++){
            int i = generator.nextInt(36);
            while(i == 0 || i == 14){//removes O's and 0's 
                i = generator.nextInt(36);
            }
            if(i < 10){
                conf = conf + i;
            }
            else{
                conf = conf + ((char) (i+55));
            }
        }
        System.out.println(conf);
    	
    	
    	return conf;
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
