/**
 * This class shows a page that displays all of the reviews in the database.
 * It sorts the reviews by speciality pizza type and creates a scrollable list.
 * 
 * @author FantasticFour
 */

package com.example.fanfourproject;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;
import android.content.Intent;


public class AllReviewsActivity extends Activity {

	private ArrayList<Review> reviewArray = new ArrayList<Review>();
	private ReviewCalculator reviewHelper = new ReviewCalculator();
	private DBHelperActivity myHelper = new DBHelperActivity();
	
	/**
	 * Starts the Activity. Retrieves and orders all reviews from the database. Then displays them for the user.
	 */
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_reviews);
        
        reviewArray = myHelper.getAllReviewsFromDatabase();
        reviewArray = reviewHelper.putReviewsInOrder(reviewArray);

        ListView listView = (ListView) findViewById(R.id.list_view);
        String[] listValues = new String[reviewArray.size()];
        
        String listViewElement = "";
        for(int i = 0; i < reviewArray.size(); i++){
        	Review singleReview = reviewArray.get(i);
        	listViewElement = "";
        	listViewElement = singleReview.getLongType() + 
        					  ": " +
        					  singleReview.getRating() + 
        					  " stars" + 
        					  "\n     " + 
        					  singleReview.getComment();
        	listValues[i] = listViewElement;
        }
       
        ArrayAdapter<String> adapter = 
        		new ArrayAdapter<String>(this,
        		android.R.layout.simple_list_item_1, 
        		android.R.id.text1,
        		listValues);

        listView.setAdapter(adapter);
    }
	
	/**
	 * Closes the current Activity and returns the user to HomePageActivity.
	 * 
	 * @param view The current View.
	 */
	
	public void closeAndRestart(View view){        
        Intent intent = new Intent(this, HomePageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }

	
	/**
	 * When 'Back' button on device is pressed the method overrides and nothing occurs.
	 * 
	 */
	@Override
    public void onBackPressed() {}//disable the back button

}
