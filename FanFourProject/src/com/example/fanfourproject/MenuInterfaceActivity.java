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

    public void buildPizza(View view) {
        Intent intent = new Intent(this, AddPizzaActivity.class);
        startActivity(intent);
        finish();
    }
    
    public void specialtyPizza(View view) {
        Intent intent = new Intent(this, AddSpecialtyActivity.class);
        startActivity(intent);
        finish();
    }
    
    public void addPop(View view) {
        Intent intent = new Intent(this, AddPopActivity.class);
        startActivity(intent);
        finish();
    }
    
    public void addDiscount(View view) {
        Intent intent = new Intent(this, AddDiscountActivity.class);
        startActivity(intent);
        finish();
    }
}
