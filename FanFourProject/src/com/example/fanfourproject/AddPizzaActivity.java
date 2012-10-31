package com.example.fanfourproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddPizzaActivity extends Activity {

	//public final static String NUMBER_PIZZAS = "com.example.mytenthapp.NUMBER_PIZZAS";
		
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pizza);
    }

    /** Called when the user clicks the 'Finished Adding Pizza' button */
    public void donePizza(View view) {
    	
    	EditText myEditText = (EditText) findViewById(R.id.editText1);
    	String message = myEditText.getText().toString();
    	
        MainMenuActivity.i1.putExtra("PIZZA_PASS_1", message);    	
    	finish();
    }
}
