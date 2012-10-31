package com.example.fanfourproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class ContactPageActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_page);
    }
    
    public void backToMain(View view) {
        finish();
    }
}
