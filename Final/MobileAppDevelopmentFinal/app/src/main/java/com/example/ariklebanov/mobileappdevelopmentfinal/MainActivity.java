package com.example.ariklebanov.mobileappdevelopmentfinal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

    String sauce;
    String size;
    String crust;
    String gluten = "no";
    String pizzaShopName;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button generatePizzaButton = findViewById(R.id.generatePizza);
        Button findPizza = findViewById(R.id.intentButton);
        View.OnClickListener onClick = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generatePizza(view);
            }
        };
        View.OnClickListener onClick2 = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findPizzaShop(view);
            }
        };

        findPizza.setOnClickListener(onClick2);
        generatePizzaButton.setOnClickListener(onClick);
    }

    private void findPizzaShop(View view) {
        Intent intent = new Intent(this, PizzaActivity.class);

        intent.putExtra("name", pizzaShopName);
        startActivity(intent);
    }

    private void generatePizza(View view){
        ToggleButton sauceToggle = findViewById(R.id.sauceToggle);
        Spinner sizeSpinner = findViewById(R.id.sizeSpinner);
        RadioGroup crustGroup = findViewById(R.id.crustGroup);
        RadioButton thinButton = findViewById(R.id.radioButtonThin);
        RadioButton thickButton = findViewById(R.id.radioButtonThick);
        Switch glutenSwitch = findViewById(R.id.glutenSwitch);
        ImageView pizzaImage = findViewById(R.id.imageView);
        TextView pizzaText = findViewById(R.id.pizzaText);

        if (sauceToggle.isChecked()){
            Log.i("sauceToggle:", sauceToggle.getTextOn().toString());
            sauce = sauceToggle.getTextOn().toString();
            //Red Sauce
        } else {
            sauce = sauceToggle.getTextOff().toString();
            Log.i("sauceToggle:", sauceToggle.getTextOff().toString());
            //White Sauce
        }
        size = sizeSpinner.getSelectedItem().toString();
        Log.i("size:", sizeSpinner.getSelectedItem().toString());
        if (crustGroup.getCheckedRadioButtonId() == thinButton.getId()){//Thin Crust
            Log.i("crust:", "thin");
            crust = "Thin";
            pizzaImage.setImageResource(R.drawable.thin);
            pizzaShopName = "Pizzeria Locale";
            if (size.compareTo("Small") == 0){
                pizzaImage.setImageResource(R.drawable.thinsmall);
            } else if (size.compareTo("Medium") == 0){
                pizzaImage.setImageResource(R.drawable.thinmedium);
            }
            pizzaText.setText("A " + size + " freshly made " + crust + " crust pizza, made with " + sauce + " sauce has your name on it. As you requested, it has " + gluten + " gluten. Enjoy!" );


        } else if (crustGroup.getCheckedRadioButtonId() == thickButton.getId()){//Thick Crust
            Log.i("crust:", "thick");
            crust = "Thick";
            pizzaImage.setImageResource(R.drawable.thick);
            pizzaShopName = "Old Chicago";
            if (size.compareTo("Small") == 0){
                pizzaImage.setImageResource(R.drawable.thicksmall);
            } else if (size.compareTo("Medium") == 0){
                pizzaImage.setImageResource(R.drawable.thickmedium);
            }
            pizzaText.setText("A " + size + " freshly made " + crust + " crust pizza, made with " + sauce + " sauce has your name on it. As you requested, it has " + gluten + " gluten. Enjoy!" );

        } else {
            Toast.makeText(getApplicationContext(), "Please choose a thickness for your crust!", Toast.LENGTH_SHORT).show();
        }
        if(!glutenSwitch.isChecked()){//No Gluten
            gluten = "no";
        } else {//Gluten
            gluten = "";

        }


    }
}
