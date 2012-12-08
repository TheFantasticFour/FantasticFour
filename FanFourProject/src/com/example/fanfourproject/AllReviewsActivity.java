package com.example.fanfourproject;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class AllReviewsActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_reviews);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_all_reviews, menu);
        return true;
    }
}
