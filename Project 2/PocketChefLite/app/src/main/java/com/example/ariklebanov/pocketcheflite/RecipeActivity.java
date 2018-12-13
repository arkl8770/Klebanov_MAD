package com.example.ariklebanov.pocketcheflite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class RecipeActivity extends AppCompatActivity {

    private String recipeName;
    private String recipe;
    private String ingredient1;
    private String ingredient2;
    private String ingredient3;
    private int imageSrc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);


        Intent intent = getIntent();
        recipeName = intent.getStringExtra("recipeName");
        recipe = intent.getStringExtra("recipe");
        ingredient1 = intent.getStringExtra("ingredient1");
        ingredient2 = intent.getStringExtra("ingredient2");
        ingredient3 = intent.getStringExtra("ingredient3");
        imageSrc = intent.getIntExtra("imageSrc", 0);



        Log.i("nameReceived", intent.getStringExtra("recipeName"));

        TextView recipeNameText = findViewById(R.id.recipeText);
        TextView recipeText = findViewById(R.id.recipeMainText);
        TextView ingredient1Text = findViewById(R.id.recipeIngredient1Text);
        TextView ingredient2Text = findViewById(R.id.recipeIngredient2Text);
        TextView ingredient3Text = findViewById(R.id.recipeIngredient3Text);
        ImageView recipeImage = findViewById(R.id.recipeImageView);

        recipeNameText.setText(recipeName);
        recipeText.setText(recipe);

        ingredient1Text.setText(ingredient1);
        ingredient2Text.setText(ingredient2);
        ingredient3Text.setText(ingredient3);
        recipeImage.setImageResource(imageSrc);

    }
}
