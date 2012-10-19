package com.example.mytenthapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Page3Activity extends Activity {
	
	public final static String EXTRA_MESSAGE_3 = "com.example.mytenthapp.MESSAGE_3";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

    }
    
    /** Called when the user clicks the 'To Page 4' button */
    public void sendMessage4(View view) {
        Intent intent = new Intent(this, Page4Activity.class);
        
        EditText editText = (EditText) findViewById(R.id.delivery_address);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_3, message);
        
        startActivity(intent);
    }
}
