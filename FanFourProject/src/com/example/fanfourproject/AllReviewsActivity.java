package com.example.fanfourproject;

import java.util.ArrayList;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Activity;
import android.content.Intent;

public class AllReviewsActivity extends Activity {

	ArrayList<Review> reviewArray = new ArrayList<Review>();
	DBHelperActivity myHelper = new DBHelperActivity();
	ReviewCalculator reviewHelper = new ReviewCalculator();
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_reviews);
        reviewArray = myHelper.getAllReviewsFromDatabase();
                
        System.out.println(reviewArray);
        reviewArray = reviewHelper.putReviewsInOrder(reviewArray);
        System.out.println(reviewArray);
        
        ListView listView = (ListView) findViewById(R.id.list_view);

        String[] listValues = new String[reviewArray.size()];
        for(int i = 0; i < reviewArray.size(); i++){
        	Review tempReview = reviewArray.get(i);
        	String temp = "";
        	temp = temp + tempReview.getLongType() + ": " + tempReview.getRating() + " stars" + "\n" ;
        	temp = temp + "    " + tempReview.getComment();
        	listValues[i] = temp;        	
        }
        System.out.println(reviewHelper.calculatePizzaOrder(reviewArray));
       
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
          android.R.layout.simple_list_item_1, android.R.id.text1, listValues);

        // Assign adapter to ListView
        listView.setAdapter(adapter); 
    }
	
	public void closeAndRestart(View view){        
        Intent intent = new Intent(this, HomePageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
	
	@Override
    public void onBackPressed() {//disable the back button
    }

}
