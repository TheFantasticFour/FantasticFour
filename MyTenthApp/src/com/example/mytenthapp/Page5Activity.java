package com.example.mytenthapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class Page5Activity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page5);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_page5, menu);
        return true;
    }
}
