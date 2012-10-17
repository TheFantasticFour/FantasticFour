package com.example.mytenthapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Page2Activity extends Activity {
	
	public final static String EXTRA_MESSAGE_2 = "com.example.mytenthapp.MESSAGE_2";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
    }
    
    /** Called when the user clicks the 'To Page 3' button */
    public void sendMessage3(View view) {
        Intent intent = new Intent(this, Page3Activity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_2, message);
        startActivity(intent);
    }
}
