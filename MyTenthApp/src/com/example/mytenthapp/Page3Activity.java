package com.example.mytenthapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Page3Activity extends Activity {
	
	
	public String passPizza= "";
	public String passPop= "";
	
	public final static String EXTRA_MESSAGE_3 = "com.example.mytenthapp.MESSAGE_3";
	public final static String PASSPIZZA = "com.example.mytenthapp.PASSPIZZA";
	public final static String PASSPOP = "com.example.mytenthapp.PASSPOP";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);
        
        Intent intent = new Intent(this, Page3Activity.class);
        passPizza = intent.getStringExtra(Page2Activity.EXTRA_MESSAGE_3_pizza);
        
        passPop = intent.getStringExtra(Page2Activity.EXTRA_MESSAGE_3_soda); 

    }
    
    /** Called when the user clicks the 'To Page 4' button */
    public void sendMessage4(View view) {
        Intent intent = new Intent(this, Page4Activity.class);
        
        EditText editText = (EditText) findViewById(R.id.delivery_address);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_3, message);
        
        intent.putExtra(PASSPIZZA, passPizza);
        intent.putExtra(PASSPOP, passPop);
        
        
        startActivity(intent);
    }
}
