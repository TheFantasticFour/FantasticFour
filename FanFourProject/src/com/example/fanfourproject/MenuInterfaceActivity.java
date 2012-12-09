package com.example.fanfourproject;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;

public class MenuInterfaceActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_interface);
    }

    public void goToMainMenu(View view) {
        Intent intent = new Intent(this, MainMenuActivity.class);
        startActivity(intent);
    }
}
