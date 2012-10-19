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
	private static int pop ;
	private static int pizza;


	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
    }
    
    public void addOnePizza(View view){
    	EditText editText3 = (EditText) findViewById(R.id.editText4);
    	pizza = pizza + 1;
    	editText3.setText("" + pizza);
    }
    
    public void addOnePop(View view){
    	EditText editText2 = (EditText) findViewById(R.id.editText3);
    	pop = pop + 1;    	    	
    	editText2.setText("" + pop);
    }
    
    /** Called when the user clicks the 'To Page 3' button */
    public void sendMessage3(View view) {
        Intent intent = new Intent(this, Page3Activity.class);
        //EditText editText3 = (EditText) findViewById(R.id.editText4);
        //String s = editText3.getText().toString();
        intent.putExtra(EXTRA_MESSAGE_3_pizza, (new Integer(pizza)).toString());
        intent.putExtra(EXTRA_MESSAGE_3_soda, (new Integer(pop)).toString());
        startActivity(intent);
    }
}
