package com.example.mytenthapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {
	//public final static String EXTRA_MESSAGE = "com.example.mytenthapp.MESSAGE";
	//THIS IS A TEST OF AN ADDITION TO THE NEW REPO
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
    }
    
    /** Called when the user clicks the Send button */
    public void sendMessage2(View view) {
        Intent intent = new Intent(this, Page2Activity.class);
        startActivity(intent);
    }
    
    public void goToContact(View view) {
        Intent intent = new Intent(this, ContactPageActivity.class);
        startActivity(intent);
    }
    
}
