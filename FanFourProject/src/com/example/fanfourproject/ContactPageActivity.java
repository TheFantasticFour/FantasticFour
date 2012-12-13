/**
 * This class is called when the User selects the 'Contact' button from the Initial page. Simply displays the contact information for the pizza chain.
 * 
 */

package com.example.fanfourproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class ContactPageActivity extends Activity {

    @Override
    /**
     * Initializes the activity.
     * 
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_page);
    }
    /**
     * Closes the current activity.0
     * 
     * @param view The current View and data. 
     */
    public void backToMain(View view) {
        finish();
    }
    
    @Override
    public void onBackPressed() {}//disable the back button
}
