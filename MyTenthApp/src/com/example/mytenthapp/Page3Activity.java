package com.example.mytenthapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Page3Activity extends Activity {
	
	public final static String EXTRA_MESSAGE_3_total = "com.example.mytenthapp.MESSAGE_3";
	public final static String EXTRA_MESSAGE_3_pizza = "com.example.mytenthapp.MESSAGE_3_2";
	public final static String EXTRA_MESSAGE_3_soda = "com.example.mytenthapp.MESSAGE_3_3";	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

    }
    
    /** Called when the user clicks the 'To Page 4' button */
    public void sendMessage4(View view) {
        Intent intent = new Intent(this, Page4Activity.class);
        
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_3_total, message);
        
        EditText editText2 = (EditText) findViewById(R.id.number_of_pizzas);
        String message2 = editText2.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_3_pizza, message2);
        
        EditText editText3 = (EditText) findViewById(R.id.number_of_sodas);
        String message3 = editText3.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_3_soda, message3);
        
        startActivity(intent);
    }
}
