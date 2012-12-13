package com.example.fanfourproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class HomePageActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
    }
    
    /** 
     * Called when the user clicks the 'Menu' button. Takes User to the MenuInterfaceActivity.
     *
     * @param view 
     */
    public void goToMenu(View view) {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
    
    /** 
     * Called when the user clicks the 'Contact Us' button. Takes User to the ContactPageActivity.
     *
     * @param view
     */
    public void goToContact(View view) {
        Intent intent = new Intent(this, ContactPageActivity.class);
        startActivity(intent);
    }
    /**
     * Called when user clicks the 'Change Order' button. Takes User to the ChangeOrderActivity.
     * 
     * @param view
     */
    public void goToChangeOrder(View view){
    	Intent intent = new Intent(this, ChangeOrderActivity.class);
        startActivity(intent);
    }
    /**
     * Called when user clicks 'Reviews' button. Takes User to the ReviewActivity.
     * 
     * @param view
     */
    
    public void goToReviewsActivity(View view){
    	Intent intent = new Intent(this, ReviewsActivity.class);
        startActivity(intent);
    }
}
