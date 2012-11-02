package com.example.fanfourproject;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddPopActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pop);
    }

    /** Called when the user clicks the 'Finished Adding Pop' button */
    public void donePop(View view) {
    	
    	//EditText myEditText = (EditText) findViewById(R.id.editText1);
    	//String message = myEditText.getText().toString();
    	
        //MainMenuActivity.i2.putExtra("POP_PASS_1", message);    	
    	finish();
    }
}
