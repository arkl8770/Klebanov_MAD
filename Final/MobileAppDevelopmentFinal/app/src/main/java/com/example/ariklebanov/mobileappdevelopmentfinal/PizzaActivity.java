package com.example.ariklebanov.mobileappdevelopmentfinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class PizzaActivity extends Activity {

    String pizzaShop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza);

        TextView mainText = findViewById(R.id.mainText);
        Intent intent = getIntent();
        pizzaShop = intent.getStringExtra("name");
        mainText.setText("You should check out " + pizzaShop + ".");
    }
}
