/**
 * This class is called when the user clicks the 'Change Order' button
 * on the Home Page. The user inputs their Confirmation ID and provided
 * it is valid, they can proceed to edit their order.
 * 
 * @author FantasticFour
 */
package com.example.fanfourproject;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/*

 */
public class ChangeOrderActivity extends Activity {

	private DBHelperActivity dbHelper = new DBHelperActivity();
	
	public static ArrayList<Object> mainArray = new ArrayList<Object>();
	
	public static boolean changeOrder = false;
	
    @Override
    /**
     * Initializes the Activity.
     * 
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_order);
    }
    
	/**
	 * Takes the current View as a parameter, gathering information from the
	 * confirmationEditText field and comparing this value to values stored in
	 * the database. If this value is confirmed then they are forwarded onto the
	 * MainMenuActivity.
	 * 
	 * @param view
	 */
    public void confirmButton(View view){
    	ArrayList<Object> mainArray = new ArrayList<Object>();
    	
    	EditText confirmationText = (EditText) findViewById(R.id.confirmationEditText);
    	String confirmationCode = confirmationText.getText().toString();
    	
    	mainArray = dbHelper.getOrderFromDatabase(confirmationCode);
    	    	
	    Intent intent = new Intent(this, MainMenuActivity.class);
	    ChangeOrderActivity.mainArray = mainArray;
	    changeOrder= true;
	    startActivity(intent);
	        
	    finish();
    }    
}
