/**
 * Activity which is started when user selects 'Reviews' from the HomePageActivity. Displays reviews and allows users to subit their own.
 * 
 */
package com.example.fanfourproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

public class ReviewsActivity extends Activity {

	private DBHelperActivity myHelper = new DBHelperActivity();
	
    @Override
    /**
     * Initializes the Activity
     * 
     * @param savedInstanceState
     */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
    }
/**
 * Allows a user to submit thier review. Takes user to AllReviewsActivity.
 * 
 * @param view gathers the information submitted.
 */
    public void submitReview(View view){
    	Spinner myChoice = (Spinner) findViewById(R.id.spinner1);
    	String pizzaType = myChoice.getSelectedItem().toString();
    	
    	RatingBar rb = (RatingBar) findViewById(R.id.ratingBar1);
    	Double pizzaRating = Double.valueOf(rb.getRating());
    	
    	EditText commentText = (EditText) findViewById(R.id.editText1);
    	String comment = commentText.getText().toString();
    	    	
    	myHelper.addReviewToDatabase(pizzaType, pizzaRating, comment);
    	Intent intent = new Intent(this, AllReviewsActivity.class);
        startActivity(intent);
    	
    }
    /**
     * Skips the review
     * 
     * @param view 
     */
    public void skipReview(View view){
    	Intent intent = new Intent(this, AllReviewsActivity.class);
        startActivity(intent);
    }
}
