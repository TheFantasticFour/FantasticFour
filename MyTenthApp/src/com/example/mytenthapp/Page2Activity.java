package com.example.mytenthapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Page2Activity extends Activity {
	
	public final static String EXTRA_MESSAGE_2 = "com.example.mytenthapp.MESSAGE_2";
	
	public final static String EXTRA_MESSAGE_3_pizza = "com.example.mytenthapp.MESSAGE_3_2";
	public final static String EXTRA_MESSAGE_3_soda = "com.example.mytenthapp.MESSAGE_3_3";
	private ImageButton button1;
	private ImageButton button2;
	private int pop;
	private int pizza;


	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        this.button1 = (ImageButton) findViewById(R.id.imageButton1);
        this.button2 = (ImageButton)this.findViewById(R.id.imageButton2);        

        button1.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
           	pizza = pizza +1;
                EditText editText = (EditText) findViewById(R.id.editText4);
               // s = pizza.toString();
                editText.setText("" + pizza);
            }
            });

        
        button2.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
           	pop = pop +1;
                EditText editText2 = (EditText) findViewById(R.id.editText3);
                editText2.setText(""+pop);
          }
            });

    }
    
    /** Called when the user clicks the 'To Page 3' button */
    public void sendMessage3(View view) {
        Intent intent = new Intent(this, Page3Activity.class);
        EditText editText3 = (EditText) findViewById(R.id.editText4);
        String s = editText3.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_3_pizza, s);
        intent.putExtra(EXTRA_MESSAGE_3_soda, ""+ pop);
        startActivity(intent);
    }
}
