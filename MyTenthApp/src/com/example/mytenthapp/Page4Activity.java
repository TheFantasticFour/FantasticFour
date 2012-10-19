package com.example.mytenthapp;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Page4Activity extends Activity {
	
	public final static String EXTRA_MESSAGE_4 = "com.example.mytenthapp.MESSAGE_4";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page4);
        
        Intent intent = getIntent();
        
        String message1 = intent.getStringExtra(Page3Activity.PASSPIZZA);
        //System.out.println(intent.getStringExtra(Page3Activity.PASSPIZZA));
        TextView myTextView1= (TextView) findViewById(R.id.number_pizzas);
        myTextView1.setText("2");
        
        String message2 = intent.getStringExtra(Page3Activity.PASSPOP);
        TextView myTextView2= (TextView) findViewById(R.id.number_sodas);
        myTextView2.setText("3");        
        
        String message = intent.getStringExtra(Page3Activity.EXTRA_MESSAGE_3);
        TextView myTextView= (TextView) findViewById(R.id.order_total);
        myTextView.setText(message);
        
        

        // Get the message from the intent
        //Intent intent = getIntent();
        //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Create the text view
        //TextView textView = new TextView(this);
        //textView.setTextSize(40);
        //textView.setText(message);

        // Set the text view as the activity layout
        //setContentView(textView);
    }
    
    /** Called when the user clicks the Send button */
    public void sendMessage5(View view) {
        Intent intent = new Intent(this, Page5Activity.class);
        EditText editText = (EditText) findViewById(R.id.edit_message);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_4, message);
        startActivity(intent);
        
        String state = Environment.getExternalStorageState();
        
        System.out.println(state);
        if (Environment.MEDIA_MOUNTED.equals(state)){
        	System.out.println(state);
        	//SDcard is available
        	File f=new File("/sdcard/test.txt");
        	if (!f.exists()) {
        		//File does not exists
        		try {
					f.createNewFile();
				} catch (IOException e) {
					System.out.println(e);
				}
        	}
        }
    }
}
