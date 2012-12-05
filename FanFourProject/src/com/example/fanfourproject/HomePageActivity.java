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
    
    /** Called when the user clicks the 'Menu' button */
    public void goToMenu(View view) {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
    
    /** Called when the user clicks the 'Contact Us' button */
    public void goToContact(View view) {
        Intent intent = new Intent(this, ContactPageActivity.class);
        startActivity(intent);
    }
    
    public void goToChangeOrder(View view){
    	Intent intent = new Intent(this, ChangeOrderActivity.class);
        startActivity(intent);
    }
}
