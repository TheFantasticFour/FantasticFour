package com.example.fanfourproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

public class ReviewsActivity extends Activity {

	private DBHelperActivity myHelper = new DBHelperActivity();
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
    }

    public void submitReview(View view){
    	Spinner myChoice = (Spinner) findViewById(R.id.spinner1);
    	String pizzaType = myChoice.getSelectedItem().toString();
    	
    	RatingBar rb = (RatingBar) findViewById(R.id.ratingBar1);
    	System.out.println(rb.getRating());
    	Double pizzaRating = Double.valueOf(rb.getRating());
    	System.out.println(pizzaRating);
    	
    	EditText commentText = (EditText) findViewById(R.id.editText1);
    	String comment = commentText.getText().toString();
    	    	
    	myHelper.addReviewToDatabase(pizzaType, pizzaRating, comment);
    	Intent intent = new Intent(this, AllReviewsActivity.class);
        startActivity(intent);
    	
    }
}
