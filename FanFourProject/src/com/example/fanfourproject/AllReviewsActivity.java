package com.example.fanfourproject;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;

public class AllReviewsActivity extends Activity {

	ArrayList<Review> reviewArray = new ArrayList<Review>();
	DBHelperActivity myHelper = new DBHelperActivity();
	
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_reviews);
        reviewArray = myHelper.getAllReviewsFromDatabase();
                
        System.out.println(reviewArray);
    }

}
