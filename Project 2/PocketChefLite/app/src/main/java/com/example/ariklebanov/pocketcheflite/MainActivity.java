package com.example.ariklebanov.pocketcheflite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends AppCompatActivity implements OnItemSelectedListener {

    String empty = "";
    String ingredient1 = empty;
    String ingredient2 = empty;
    String ingredient3 = empty;

//Creates all necessary instances of Recipe( ), total: 15
    Recipe chipsAndQueso = new Recipe();
    Recipe fondue = new Recipe();
    Recipe chickenQuesadilla = new Recipe();
    Recipe pizza = new Recipe();
    Recipe breakfastBurrito = new Recipe();
    Recipe chickenTortillaBites = new Recipe();
    Recipe grilledCheese = new Recipe();
    Recipe macAndCheese = new Recipe();
    Recipe eggSandwich = new Recipe();
    Recipe toast = new Recipe();
    Recipe peanutButterJelly = new Recipe();
    Recipe softTaco = new Recipe();
    Recipe chickenSandwich = new Recipe();
    Recipe chickenNachos = new Recipe();
    Recipe chipsAndSalsa = new Recipe();


//later converted to ArrayList, maybe initialize as such to save memory.
    String[] chipsAndQuesoIngredients = {"Cheddar Cheese", "Tortillas"};
    String[] fondueIngredients = {"Cheddar Cheese"};
    String[] chickenQuesadillaIngredients = {"Cheddar Cheese", "Tortillas", "Chicken Breast"};
    String[] pizzaIngredients = {"Cheddar Cheese", "Tortillas", "Marinara Sauce"};
    String[] breakfastBurritoIngredients = {"Tortillas", "Chicken Breast", "Eggs"};
    String[] chickenTortillaBitesIngredients = {"Tortillas", "Chicken Breast", "Ranch"};
    String[] grilledCheeseIngredients = {"Cheddar Cheese", "Bread"};
    String[] macAndCheeseIngredients = {"Cheddar Cheese", "Macaroni"};
    String[] eggSandwichIngredients = {"Cheddar Cheese", "Eggs", "Bread"};
    String[] toastIngredients = {"Bread", "Jelly"};
    String[] peanutButterJellyIngredients = {"Bread", "Peanut Butter", "Jelly"};
    String[] softTacoIngredients = {"Tortillas", "Chicken Breast", "Cheddar Cheese"};
    String[] chickenSandwichIngredients = {"Chicken Breast", "Bread", "Ranch"};
    String[] chickenNachosIngredients = {"Tortillas", "Chicken Breast", "Cheddar Cheese"};
    String[] chipsAndSalsaIngredients = {"Tortillas", "Salsa"};

    ListView validRecipes;
    ArrayList<String> validRecipesArrayList = new ArrayList<String>();
    ArrayList<Integer> validImagesArrayList = new ArrayList<Integer>();

    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//List View initialization, including custom adapter
        validRecipes = (ListView) findViewById(R.id.recipeListView);
        customAdapter = new CustomAdapter(getApplicationContext(), validRecipesArrayList, validImagesArrayList);
        validRecipes.setAdapter(customAdapter);
        customAdapter.notifyDataSetChanged();
        validRecipes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int pos, long id) {
                String userSelectedRecipe = validRecipesArrayList.get(pos);
                loadUserSelectedRecipe(userSelectedRecipe);
            }
        });


//Spinner 1 initialization, set onItemSelectedListener to trigger when user selects ingredient 1
        Spinner ingredient1Spinner = (Spinner) findViewById(R.id.ingredient1Spinner);
        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.ingredientList, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ingredient1Spinner.setAdapter(adapter1);
        ingredient1Spinner.setOnItemSelectedListener(this);

//Spinner 2 initialization, set onItemSelectedListener to trigger when user selects ingredient 2
        Spinner ingredient2Spinner = (Spinner) findViewById(R.id.ingredient2Spinner);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.ingredientList, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ingredient2Spinner.setAdapter(adapter2);
        ingredient2Spinner.setOnItemSelectedListener(this);

//Spinner 3 initialization, set onItemSelectedListener to trigger when user selects ingredient 3
        Spinner ingredient3Spinner = (Spinner) findViewById(R.id.ingredient3Spinner);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.ingredientList, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ingredient3Spinner.setAdapter(adapter3);
        ingredient3Spinner.setOnItemSelectedListener(this);


//Sets appropriate image sources to recipes
        chipsAndQueso.setImgSrc(R.drawable.chipsqueso);
        fondue.setImgSrc(R.drawable.fondue);
        chickenQuesadilla.setImgSrc(R.drawable.quesadilla);
        pizza.setImgSrc(R.drawable.pizza);
        breakfastBurrito.setImgSrc(R.drawable.burrito);
        chickenTortillaBites.setImgSrc(R.drawable.bites);
        grilledCheese.setImgSrc(R.drawable.grilledcheese);
        macAndCheese.setImgSrc(R.drawable.maccheese);
        eggSandwich.setImgSrc(R.drawable.eggsandwich);
        toast.setImgSrc(R.drawable.toast);
        peanutButterJelly.setImgSrc(R.drawable.pbj);
        softTaco.setImgSrc(R.drawable.softtaco);
        chickenSandwich.setImgSrc(R.drawable.chickensandwich);
        chickenNachos.setImgSrc(R.drawable.chickennachos);
        chipsAndSalsa.setImgSrc(R.drawable.chipssalsa);

//Sets appropriate recipe names to recipes
        chipsAndQueso.setRecipeName("Chips and Queso");
        fondue.setRecipeName("Fondue");
        chickenQuesadilla.setRecipeName("Chicken Quesadilla");
        pizza.setRecipeName("Pizza");
        breakfastBurrito.setRecipeName("Breakfast Burrito");
        chickenTortillaBites.setRecipeName("Chicken Tortilla Bites");
        grilledCheese.setRecipeName("Grilled Cheese");
        macAndCheese.setRecipeName("Mac and Cheese");
        eggSandwich.setRecipeName("Egg Sandwich");
        toast.setRecipeName("Jelly Toast");
        peanutButterJelly.setRecipeName("Peanut Butter and Jelly");
        softTaco.setRecipeName("Soft Taco");
        chickenSandwich.setRecipeName("Chicken Sandwich");
        chickenNachos.setRecipeName("Chicken Nachos");
        chipsAndSalsa.setRecipeName("Chips and Salsa");

//Sets appropriate ingredient lists to recipes
        chipsAndQueso.setArrayOfIngredients(chipsAndQuesoIngredients);
        fondue.setArrayOfIngredients(fondueIngredients);
        chickenQuesadilla.setArrayOfIngredients(chickenQuesadillaIngredients);
        pizza.setArrayOfIngredients(pizzaIngredients);
        breakfastBurrito.setArrayOfIngredients(breakfastBurritoIngredients);
        chickenTortillaBites.setArrayOfIngredients(chickenTortillaBitesIngredients);
        grilledCheese.setArrayOfIngredients(grilledCheeseIngredients);
        macAndCheese.setArrayOfIngredients(macAndCheeseIngredients);
        eggSandwich.setArrayOfIngredients(eggSandwichIngredients);
        toast.setArrayOfIngredients(toastIngredients);
        peanutButterJelly.setArrayOfIngredients(peanutButterJellyIngredients);
        softTaco.setArrayOfIngredients(softTacoIngredients);
        chickenSandwich.setArrayOfIngredients(chickenSandwichIngredients);
        chickenNachos.setArrayOfIngredients(chickenNachosIngredients);
        chipsAndSalsa.setArrayOfIngredients(chipsAndSalsaIngredients);

//Sets appropriate recipes to recipes
        chipsAndQueso.setRecipe("Either use tortilla chips, or toast Tortillas into chips. Set tortilla chips aside. Turn stove to medium-high and warm saucepan. Add 2 cups of Cheddar Cheese to saucepan. Stir regularly, and heat slowly until all cheese is melted. When cheese is melted, remove from saucepan and serve on top of tortilla chips. Feeds 3-5 people.");
        fondue.setRecipe("Turn stove to medium-high, using a sauce pan. Add 3 cups of cheddar cheese to saucepan. Add heat slowly, until all cheese is melted. When cheese is melted, remove from saucepan and serve with dippable items such as bread, crackers, etc. Feeds 2-4 people.");
        chickenQuesadilla.setRecipe("Turn stove to medium-low, using a skillet. Add one Tortilla to the skillet and warm it up. When warm, top Tortilla with Cheddar Cheese and Chicken Breast, both shredded. Be sure to add contents to half of the Tortilla, making it easier to fold at the end. Fold Tortilla in half, and toast until both sides are golden brown, and contents are thoroughly melted. Feeds 1-2 people.");
        pizza.setRecipe("Preheat oven to 400 degrees fahrenheit. Using a Tortilla (or two) as a base, top Tortilla(s) with Marinara Sauce, followed by Cheddar Cheese, shredded. Add Cheddar Cheese to taste. Bake Pizza in the oven for 20-25 minutes, or until cheese has turned golden brown. Remove, let cool, and serve. Feeds 2-4 people. ");
        breakfastBurrito.setRecipe("Turn stove to medium, and scramble two Eggs. Set the Eggs aside. Then, turn stove down to medium-low, using a skillet. Add one Tortilla to the skillet and warm it up. When warm, top with Eggs and Chicken Breast, shredded. Wrap contents in Tortilla, Burrito Style, and serve. Feeds 1-2 people.");
        chickenTortillaBites.setRecipe("Turn stove to medium-low, using a skillet. Add one Tortilla to the skillet and warm it up. When warm, top with Chicken Breast. Drizzle Ranch to taste. Roll Tortilla and contents, then cut into thirds and serve. Feeds 1-2 people.");
        grilledCheese.setRecipe("Turn stove to medium, using a skillet. Add one slice of Bread to the skillet and heat until underside is golden brown. When the Bread is nicely toasted, top with Cheddar Cheese and second piece of Bread. Flip the sandwich, allowing the other piece of Bread to be toasted, and the Cheddar Cheese to be melted. When both sides are golden-brown, remove and serve. Feeds 1-2 people.");
        macAndCheese.setRecipe("Turn stove to high, and boil 4-6 cups of water in a large pot. When water is boiled, add Macaroni and turn down the heat to medium-low. Allow Macaroni to simmer in water for 10-12 minutes, or until soft. When Macaroni is done, drain water, and add Cheddar Cheese to taste. Allow Cheddar Cheese to melt, and serve. Feeds 1-2 people.");
        eggSandwich.setRecipe("Turn stove to medium, using a skillet, and scramble two Eggs. Set the Eggs aside. Add one slice of Bread to the skillet and heat until underside is golden brown. When the Bread is nicely toasted, top with Cheddar Cheese and Eggs, and second piece of Bread. Flip the sandwich, allowing the other piece of Bread to be toasted, and the Cheddar Cheese to be melted. When both sides are golden-brown, remove and serve. Feeds 1-2 people.");
        toast.setRecipe("Toast a slice or two of Bread, until golden brown and slightly crispy. Top with Jelly to taste. Feeds 1-2 people.");
        peanutButterJelly.setRecipe("Get out two slices of bread, and set on plate. Top one piece of bread on one side with Peanut Butter, and top the other piece on once side with Jelly. Combine both pieces of Bread, slice in half, and serve. Feeds 1-2 people.");
        softTaco.setRecipe("Turn stove to medium-low, using a skillet. Add one Tortilla to the skillet and warm it up. When warm, set Tortilla on plate and top with Chicken Breast. and Cheddar Cheese, both shredded. Fold tortilla in half, and serve. Feeds 1-2 people");
        chickenSandwich.setRecipe("Turn stove to medium-high, using a skillet. Add Chicken Breast to skillet, and cook thoroughly (internal temperature 165+). When Chicken Breast is done, add to one Slice of Bread. Top with Ranch, and add another slice of Bread. Cut and serve. Feeds 1-2 people.");
        chickenNachos.setRecipe("Either use tortilla chips, or toast Tortillas into chips. Set tortilla chips aside. Turn stove to medium-high and warm saucepan. Add 2 cups of Cheddar Cheese to saucepan. Stir regularly, and heat slowly until all cheese is melted. When cheese is melted, remove from saucepan and serve on top of tortilla chips. Add Chicken Breast as desired. Feeds 3-5 people.");
        chipsAndSalsa.setRecipe("Either use tortilla chips, or toast Tortillas into chips. Serve with Salsa. Feeds 1-2 people.");
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        if (parent.getId() == R.id.ingredient1Spinner) {//called if the user is using ingredient1Spinner
            ingredient1 = parent.getItemAtPosition(pos).toString();
        } else if (parent.getId() == R.id.ingredient2Spinner) {//called if the user is using ingredient2Spinner
            ingredient2 = parent.getItemAtPosition(pos).toString();
        } else if (parent.getId() == R.id.ingredient3Spinner) {//called if the user is using ingredient3Spinner
            ingredient3 = parent.getItemAtPosition(pos).toString();
        }
        updateRecipes(ingredient1, ingredient2, ingredient3);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
    }

    public void updateRecipes(String ingredient1, String ingredient2, String ingredient3) {
        validRecipesArrayList.clear();
        validImagesArrayList.clear();
        customAdapter.notifyDataSetChanged();
        searchQueso(ingredient1, ingredient2, ingredient3);
        searchFondue(ingredient1, ingredient2, ingredient3);
        searchQuesadilla(ingredient1, ingredient2, ingredient3);
        searchPizza(ingredient1, ingredient2, ingredient3);
        searchBurrito(ingredient1, ingredient2, ingredient3);
        searchBites(ingredient1, ingredient2, ingredient3);
        searchGrilled(ingredient1, ingredient2, ingredient3);
        searchMac(ingredient1, ingredient2, ingredient3);
        searchEgg(ingredient1, ingredient2, ingredient3);
        searchToast(ingredient1, ingredient2, ingredient3);
        searchPBJ(ingredient1, ingredient2, ingredient3);
        searchTaco(ingredient1, ingredient2, ingredient3);
        searchSandwich(ingredient1, ingredient2, ingredient3);
        searchNachos(ingredient1, ingredient2, ingredient3);
        searchSalsa(ingredient1, ingredient2, ingredient3);
    }

    public void searchQueso(String ingredient1, String ingredient2, String ingredient3) {
        boolean display1 = true;
        boolean display2 = true;
        boolean display3 = true;

        if (ingredient1.compareTo("") != 0){
            if (!Arrays.asList(chipsAndQuesoIngredients).contains(ingredient1)){
                display1 = false;
            }
        }
        if (ingredient2.compareTo("") != 0){
            if (!Arrays.asList(chipsAndQuesoIngredients).contains(ingredient2)){
                display2 = false;
            }
        }
        if (ingredient3.compareTo("") != 0){
            if (!Arrays.asList(chipsAndQuesoIngredients).contains(ingredient3)){
                display3 = false;
            }
        }
        if (display1 && display2 && display3) {
            if (ingredient1.compareTo("") != 0 || ingredient2.compareTo("") != 0 || ingredient3.compareTo("") != 0){
                validRecipesArrayList.add("Chips and Queso");
                validImagesArrayList.add(R.drawable.chipsqueso);
                customAdapter.notifyDataSetChanged();
            }
        }
    }
    public void searchFondue(String ingredient1, String ingredient2, String ingredient3) {
        boolean display1 = true;
        boolean display2 = true;
        boolean display3 = true;

        if (ingredient1.compareTo("") != 0){
            Log.i("ingredient1Null", "blank");
            if (!Arrays.asList(fondueIngredients).contains(ingredient1)){
                display1 = false;
            }
        }
        if (ingredient2.compareTo("") != 0){
            Log.i("ingredient2Null", "blank");
            if (!Arrays.asList(fondueIngredients).contains(ingredient2)){
                display2 = false;
            }
        }
        if (ingredient3.compareTo("") != 0){
            Log.i("ingredient3Null", "blank");
            if (!Arrays.asList(fondueIngredients).contains(ingredient3)){
                display3 = false;
            }
        }
        if (display1 && display2 && display3) {
            if (ingredient1.compareTo("") != 0 || ingredient2.compareTo("") != 0 || ingredient3.compareTo("") != 0){
                Log.i("isFondueValid", "true");
                validRecipesArrayList.add("Fondue");
                validImagesArrayList.add(R.drawable.fondue);
                customAdapter.notifyDataSetChanged();
            }
        }
    }
    public void searchQuesadilla(String ingredient1, String ingredient2, String ingredient3) {
        boolean display1 = true;
        boolean display2 = true;
        boolean display3 = true;

        if (ingredient1.compareTo("") != 0){
            Log.i("ingredient1Null", "blank");
            if (!Arrays.asList(chickenQuesadillaIngredients).contains(ingredient1)){
                display1 = false;
            }
        }
        if (ingredient2.compareTo("") != 0){
            Log.i("ingredient2Null", "blank");
            if (!Arrays.asList(chickenQuesadillaIngredients).contains(ingredient2)){
                display2 = false;
            }
        }
        if (ingredient3.compareTo("") != 0){
            Log.i("ingredient3Null", "blank");
            if (!Arrays.asList(chickenQuesadillaIngredients).contains(ingredient3)){
                display3 = false;
            }
        }
        if (display1 && display2 && display3) {
            if (ingredient1.compareTo("") != 0 || ingredient2.compareTo("") != 0 || ingredient3.compareTo("") != 0){
                Log.i("isQuesadillaValid", "true");
                validRecipesArrayList.add("Chicken Quesadilla");
                validImagesArrayList.add(R.drawable.quesadilla);
                customAdapter.notifyDataSetChanged();
            }
        }
    }
    public void searchPizza(String ingredient1, String ingredient2, String ingredient3) {
        boolean display1 = true;
        boolean display2 = true;
        boolean display3 = true;

        if (ingredient1.compareTo("") != 0){
            Log.i("ingredient1Null", "blank");
            if (!Arrays.asList(pizzaIngredients).contains(ingredient1)){
                display1 = false;
            }
        }
        if (ingredient2.compareTo("") != 0){
            Log.i("ingredient2Null", "blank");
            if (!Arrays.asList(pizzaIngredients).contains(ingredient2)){
                display2 = false;
            }
        }
        if (ingredient3.compareTo("") != 0){
            Log.i("ingredient3Null", "blank");
            if (!Arrays.asList(pizzaIngredients).contains(ingredient3)){
                display3 = false;
            }
        }
        if (display1 && display2 && display3) {
            if (ingredient1.compareTo("") != 0 || ingredient2.compareTo("") != 0 || ingredient3.compareTo("") != 0){
                Log.i("isPizzaValid", "true");
                validRecipesArrayList.add("Pizza");
                validImagesArrayList.add(R.drawable.pizza);
                customAdapter.notifyDataSetChanged();
            }
        }
    }
    public void searchBurrito(String ingredient1, String ingredient2, String ingredient3) {
        boolean display1 = true;
        boolean display2 = true;
        boolean display3 = true;

        if (ingredient1.compareTo("") != 0){
            Log.i("ingredient1Null", "blank");
            if (!Arrays.asList(breakfastBurritoIngredients).contains(ingredient1)){
                display1 = false;
            }
        }
        if (ingredient2.compareTo("") != 0){
            Log.i("ingredient2Null", "blank");
            if (!Arrays.asList(breakfastBurritoIngredients).contains(ingredient2)){
                display2 = false;
            }
        }
        if (ingredient3.compareTo("") != 0){
            Log.i("ingredient3Null", "blank");
            if (!Arrays.asList(breakfastBurritoIngredients).contains(ingredient3)){
                display3 = false;
            }
        }
        if (display1 && display2 && display3) {
            if (ingredient1.compareTo("") != 0 || ingredient2.compareTo("") != 0 || ingredient3.compareTo("") != 0){
                Log.i("isBurritoValid", "true");
                validRecipesArrayList.add("Breakfast Burrito");
                validImagesArrayList.add(R.drawable.burrito);
                customAdapter.notifyDataSetChanged();
            }
        }
    }
    public void searchBites(String ingredient1, String ingredient2, String ingredient3) {
        boolean display1 = true;
        boolean display2 = true;
        boolean display3 = true;

        if (ingredient1.compareTo("") != 0){
            Log.i("ingredient1Null", "blank");
            if (!Arrays.asList(chickenTortillaBitesIngredients).contains(ingredient1)){
                display1 = false;
            }
        }
        if (ingredient2.compareTo("") != 0){
            Log.i("ingredient2Null", "blank");
            if (!Arrays.asList(chickenTortillaBitesIngredients).contains(ingredient2)){
                display2 = false;
            }
        }
        if (ingredient3.compareTo("") != 0){
            Log.i("ingredient3Null", "blank");
            if (!Arrays.asList(chickenTortillaBitesIngredients).contains(ingredient3)){
                display3 = false;
            }
        }
        if (display1 && display2 && display3) {
            if (ingredient1.compareTo("") != 0 || ingredient2.compareTo("") != 0 || ingredient3.compareTo("") != 0){
                Log.i("isBitesValid", "true");
                validRecipesArrayList.add("Chicken Tortilla Bites");
                validImagesArrayList.add(R.drawable.bites);
                customAdapter.notifyDataSetChanged();
            }
        }

    }
    public void searchGrilled(String ingredient1, String ingredient2, String ingredient3) {
        boolean display1 = true;
        boolean display2 = true;
        boolean display3 = true;

        if (ingredient1.compareTo("") != 0){
            Log.i("ingredient1Null", "blank");
            if (!Arrays.asList(grilledCheeseIngredients).contains(ingredient1)){
                display1 = false;
            }
        }
        if (ingredient2.compareTo("") != 0){
            Log.i("ingredient2Null", "blank");
            if (!Arrays.asList(grilledCheeseIngredients).contains(ingredient2)){
                display2 = false;
            }
        }
        if (ingredient3.compareTo("") != 0){
            Log.i("ingredient3Null", "blank");
            if (!Arrays.asList(grilledCheeseIngredients).contains(ingredient3)){
                display3 = false;
            }
        }
        if (display1 && display2 && display3) {
            if (ingredient1.compareTo("") != 0 || ingredient2.compareTo("") != 0 || ingredient3.compareTo("") != 0){
                validRecipesArrayList.add("Grilled Cheese");
                validImagesArrayList.add(R.drawable.grilledcheese);
                customAdapter.notifyDataSetChanged();
            }
        }
    }
    public void searchMac(String ingredient1, String ingredient2, String ingredient3) {
        boolean display1 = true;
        boolean display2 = true;
        boolean display3 = true;

        if (ingredient1.compareTo("") != 0){
            if (!Arrays.asList(macAndCheeseIngredients).contains(ingredient1)){
                display1 = false;
            }
        }
        if (ingredient2.compareTo("") != 0){
            if (!Arrays.asList(macAndCheeseIngredients).contains(ingredient2)){
                display2 = false;
            }
        }
        if (ingredient3.compareTo("") != 0){
            if (!Arrays.asList(macAndCheeseIngredients).contains(ingredient3)){
                display3 = false;
            }
        }
        if (display1 && display2 && display3) {
            if (ingredient1.compareTo("") != 0 || ingredient2.compareTo("") != 0 || ingredient3.compareTo("") != 0){
                validRecipesArrayList.add("Mac and Cheese");
                validImagesArrayList.add(R.drawable.maccheese);
                customAdapter.notifyDataSetChanged();
            }
        }
    }
    public void searchEgg(String ingredient1, String ingredient2, String ingredient3) {
        boolean display1 = true;
        boolean display2 = true;
        boolean display3 = true;

        if (ingredient1.compareTo("") != 0){
            if (!Arrays.asList(eggSandwichIngredients).contains(ingredient1)){
                display1 = false;
            }
        }
        if (ingredient2.compareTo("") != 0){
            if (!Arrays.asList(eggSandwichIngredients).contains(ingredient2)){
                display2 = false;
            }
        }
        if (ingredient3.compareTo("") != 0){
            if (!Arrays.asList(eggSandwichIngredients).contains(ingredient3)){
                display3 = false;
            }
        }
        if (display1 && display2 && display3) {
            if (ingredient1.compareTo("") != 0 || ingredient2.compareTo("") != 0 || ingredient3.compareTo("") != 0){
                validRecipesArrayList.add("Egg Sandwich");
                validImagesArrayList.add(R.drawable.eggsandwich);
                customAdapter.notifyDataSetChanged();
            }
        }
    }
    public void searchToast(String ingredient1, String ingredient2, String ingredient3) {
        boolean display1 = true;
        boolean display2 = true;
        boolean display3 = true;

        if (ingredient1.compareTo("") != 0) {
            if (!Arrays.asList(toastIngredients).contains(ingredient1)) {
                display1 = false;
            }
        }
        if (ingredient2.compareTo("") != 0) {
            if (!Arrays.asList(toastIngredients).contains(ingredient2)) {
                display2 = false;
            }
        }
        if (ingredient3.compareTo("") != 0) {
            if (!Arrays.asList(toastIngredients).contains(ingredient3)) {
                display3 = false;
            }
        }
        if (display1 && display2 && display3) {
            if (ingredient1.compareTo("") != 0 || ingredient2.compareTo("") != 0 || ingredient3.compareTo("") != 0) {
                validRecipesArrayList.add("Jelly Toast");
                validImagesArrayList.add(R.drawable.toast);
                customAdapter.notifyDataSetChanged();
            }
        }
    }
    public void searchPBJ(String ingredient1, String ingredient2, String ingredient3) {
        boolean display1 = true;
        boolean display2 = true;
        boolean display3 = true;

        if (ingredient1.compareTo("") != 0) {
            if (!Arrays.asList(peanutButterJellyIngredients).contains(ingredient1)) {
                display1 = false;
            }
        }
        if (ingredient2.compareTo("") != 0) {
            if (!Arrays.asList(peanutButterJellyIngredients).contains(ingredient2)) {
                display2 = false;
            }
        }
        if (ingredient3.compareTo("") != 0) {
            if (!Arrays.asList(peanutButterJellyIngredients).contains(ingredient3)) {
                display3 = false;
            }
        }
        if (display1 && display2 && display3) {
            if (ingredient1.compareTo("") != 0 || ingredient2.compareTo("") != 0 || ingredient3.compareTo("") != 0) {
                validRecipesArrayList.add("Peanut Butter and Jelly");
                validImagesArrayList.add(R.drawable.pbj);
                customAdapter.notifyDataSetChanged();
            }
        }
    }
    public void searchTaco(String ingredient1, String ingredient2, String ingredient3) {
        boolean display1 = true;
        boolean display2 = true;
        boolean display3 = true;

        if (ingredient1.compareTo("") != 0) {
            if (!Arrays.asList(softTacoIngredients).contains(ingredient1)) {
                display1 = false;
            }
        }
        if (ingredient2.compareTo("") != 0) {
            if (!Arrays.asList(softTacoIngredients).contains(ingredient2)) {
                display2 = false;
            }
        }
        if (ingredient3.compareTo("") != 0) {
            if (!Arrays.asList(softTacoIngredients).contains(ingredient3)) {
                display3 = false;
            }
        }
        if (display1 && display2 && display3) {
            if (ingredient1.compareTo("") != 0 || ingredient2.compareTo("") != 0 || ingredient3.compareTo("") != 0) {
                validRecipesArrayList.add("Soft Taco");
                validImagesArrayList.add(R.drawable.softtaco);
                customAdapter.notifyDataSetChanged();
            }
        }
    }
    public void searchSandwich(String ingredient1, String ingredient2, String ingredient3) {
        boolean display1 = true;
        boolean display2 = true;
        boolean display3 = true;

        if (ingredient1.compareTo("") != 0) {
            if (!Arrays.asList(chickenSandwichIngredients).contains(ingredient1)) {
                display1 = false;
            }
        }
        if (ingredient2.compareTo("") != 0) {
            if (!Arrays.asList(chickenSandwichIngredients).contains(ingredient2)) {
                display2 = false;
            }
        }
        if (ingredient3.compareTo("") != 0) {
            if (!Arrays.asList(chickenSandwichIngredients).contains(ingredient3)) {
                display3 = false;
            }
        }
        if (display1 && display2 && display3) {
            if (ingredient1.compareTo("") != 0 || ingredient2.compareTo("") != 0 || ingredient3.compareTo("") != 0) {
                validRecipesArrayList.add("Chicken Sandwich");
                validImagesArrayList.add(R.drawable.chickensandwich);
                customAdapter.notifyDataSetChanged();
            }
        }
    }
    public void searchNachos(String ingredient1, String ingredient2, String ingredient3) {
        boolean display1 = true;
        boolean display2 = true;
        boolean display3 = true;

        if (ingredient1.compareTo("") != 0) {
            if (!Arrays.asList(chickenNachosIngredients).contains(ingredient1)) {
                display1 = false;
            }
        }
        if (ingredient2.compareTo("") != 0) {
            if (!Arrays.asList(chickenNachosIngredients).contains(ingredient2)) {
                display2 = false;
            }
        }
        if (ingredient3.compareTo("") != 0) {
            if (!Arrays.asList(chickenNachosIngredients).contains(ingredient3)) {
                display3 = false;
            }
        }
        if (display1 && display2 && display3) {
            if (ingredient1.compareTo("") != 0 || ingredient2.compareTo("") != 0 || ingredient3.compareTo("") != 0) {
                validRecipesArrayList.add("Chicken Nachos");
                validImagesArrayList.add(R.drawable.chickennachos);
                customAdapter.notifyDataSetChanged();
            }
        }
    }
    public void searchSalsa(String ingredient1, String ingredient2, String ingredient3) {
        boolean display1 = true;
        boolean display2 = true;
        boolean display3 = true;

        if (ingredient1.compareTo("") != 0) {
            if (!Arrays.asList(chipsAndSalsaIngredients).contains(ingredient1)) {
                display1 = false;
            }
        }
        if (ingredient2.compareTo("") != 0) {
            if (!Arrays.asList(chipsAndSalsaIngredients).contains(ingredient2)) {
                display2 = false;
            }
        }
        if (ingredient3.compareTo("") != 0) {
            if (!Arrays.asList(chipsAndSalsaIngredients).contains(ingredient3)) {
                display3 = false;
            }
        }
        if (display1 && display2 && display3) {
            if (ingredient1.compareTo("") != 0 || ingredient2.compareTo("") != 0 || ingredient3.compareTo("") != 0) {
                validRecipesArrayList.add("Chips and Salsa");
                validImagesArrayList.add(R.drawable.chipssalsa);
                customAdapter.notifyDataSetChanged();
            }
        }
    }


    public void loadUserSelectedRecipe(String userSelectedRecipe) {
        switch (userSelectedRecipe) {
            case "Chips and Queso":
                Intent intentQueso = new Intent(this, RecipeActivity.class);
                intentQueso.putExtra("recipeName", chipsAndQueso.getRecipeName());
                intentQueso.putExtra("recipe", chipsAndQueso.getRecipe());
                intentQueso.putExtra("ingredient1", chipsAndQuesoIngredients[0]);
                intentQueso.putExtra("ingredient2", chipsAndQuesoIngredients[1]);
                intentQueso.putExtra("imageSrc", chipsAndQueso.getImgSrc());
                startActivity(intentQueso);
                break;

            case "Fondue":
                Intent intentFondue = new Intent(this, RecipeActivity.class);
                intentFondue.putExtra("recipeName", fondue.getRecipeName());
                intentFondue.putExtra("recipe", fondue.getRecipe());
                intentFondue.putExtra("ingredient1", fondueIngredients[0]);
                intentFondue.putExtra("imageSrc", fondue.getImgSrc());
                startActivity(intentFondue);
                break;

            case "Chicken Quesadilla":
                Intent intentQuesadilla = new Intent(this, RecipeActivity.class);
                intentQuesadilla.putExtra("recipeName", chickenQuesadilla.getRecipeName());
                intentQuesadilla.putExtra("recipe", chickenQuesadilla.getRecipe());
                intentQuesadilla.putExtra("ingredient1", chickenQuesadillaIngredients[0]);
                intentQuesadilla.putExtra("ingredient2", chickenQuesadillaIngredients[1]);
                intentQuesadilla.putExtra("ingredient3", chickenQuesadillaIngredients[2]);
                intentQuesadilla.putExtra("imageSrc", chickenQuesadilla.getImgSrc());
                startActivity(intentQuesadilla);
                break;

            case "Pizza":
                Intent intentPizza = new Intent(this, RecipeActivity.class);
                intentPizza.putExtra("recipeName", pizza.getRecipeName());
                intentPizza.putExtra("recipe", pizza.getRecipe());
                intentPizza.putExtra("ingredient1", pizzaIngredients[0]);
                intentPizza.putExtra("ingredient2", pizzaIngredients[1]);
                intentPizza.putExtra("ingredient3", pizzaIngredients[2]);
                intentPizza.putExtra("imageSrc", pizza.getImgSrc());
                startActivity(intentPizza);
                break;

            case "Breakfast Burrito":
                Intent intentBurrito = new Intent(this, RecipeActivity.class);
                intentBurrito.putExtra("recipeName", breakfastBurrito.getRecipeName());
                intentBurrito.putExtra("recipe", breakfastBurrito.getRecipe());
                intentBurrito.putExtra("ingredient1", breakfastBurritoIngredients[0]);
                intentBurrito.putExtra("ingredient2", breakfastBurritoIngredients[1]);
                intentBurrito.putExtra("ingredient3", breakfastBurritoIngredients[2]);
                intentBurrito.putExtra("imageSrc", breakfastBurrito.getImgSrc());
                startActivity(intentBurrito);
                break;

            case "Chicken Tortilla Bites":
                Intent intentBites = new Intent(this, RecipeActivity.class);
                intentBites.putExtra("recipeName", chickenTortillaBites.getRecipeName());
                intentBites.putExtra("recipe", chickenTortillaBites.getRecipe());
                intentBites.putExtra("ingredient1", chickenTortillaBitesIngredients[0]);
                intentBites.putExtra("ingredient2", chickenTortillaBitesIngredients[1]);
                intentBites.putExtra("ingredient3", chickenTortillaBitesIngredients[2]);
                intentBites.putExtra("imageSrc", chickenTortillaBites.getImgSrc());
                startActivity(intentBites);
                break;

            case "Grilled Cheese":
                Intent intentGrilled = new Intent(this, RecipeActivity.class);
                intentGrilled.putExtra("recipeName", grilledCheese.getRecipeName());
                intentGrilled.putExtra("recipe", grilledCheese.getRecipe());
                intentGrilled.putExtra("ingredient1", grilledCheeseIngredients[0]);
                intentGrilled.putExtra("ingredient2", grilledCheeseIngredients[1]);
                intentGrilled.putExtra("imageSrc", grilledCheese.getImgSrc());
                startActivity(intentGrilled);
                break;

            case "Mac and Cheese":
                Intent intentMac = new Intent(this, RecipeActivity.class);
                intentMac.putExtra("recipeName", macAndCheese.getRecipeName());
                intentMac.putExtra("recipe", macAndCheese.getRecipe());
                intentMac.putExtra("ingredient1", macAndCheeseIngredients[0]);
                intentMac.putExtra("ingredient2", macAndCheeseIngredients[1]);
                intentMac.putExtra("imageSrc", macAndCheese.getImgSrc());
                startActivity(intentMac);
                break;

            case "Egg Sandwich":
                Intent intentEgg = new Intent(this, RecipeActivity.class);
                intentEgg.putExtra("recipeName", eggSandwich.getRecipeName());
                intentEgg.putExtra("recipe", eggSandwich.getRecipe());
                intentEgg.putExtra("ingredient1", eggSandwichIngredients[0]);
                intentEgg.putExtra("ingredient2", eggSandwichIngredients[1]);
                intentEgg.putExtra("imageSrc", eggSandwich.getImgSrc());
                startActivity(intentEgg);
                break;

            case "Jelly Toast":
                Intent intentToast = new Intent(this, RecipeActivity.class);
                intentToast.putExtra("recipeName", toast.getRecipeName());
                intentToast.putExtra("recipe", toast.getRecipe());
                intentToast.putExtra("ingredient1", toastIngredients[0]);
                intentToast.putExtra("ingredient2", toastIngredients[1]);
                intentToast.putExtra("imageSrc", toast.getImgSrc());
                startActivity(intentToast);
                break;

            case "Peanut Butter and Jelly":
                Intent intentPBJ = new Intent(this, RecipeActivity.class);
                intentPBJ.putExtra("recipeName", peanutButterJelly.getRecipeName());
                intentPBJ.putExtra("recipe", peanutButterJelly.getRecipe());
                intentPBJ.putExtra("ingredient1", peanutButterJellyIngredients[0]);
                intentPBJ.putExtra("ingredient2", peanutButterJellyIngredients[1]);
                intentPBJ.putExtra("ingredient3", peanutButterJellyIngredients[2]);
                intentPBJ.putExtra("imageSrc", peanutButterJelly.getImgSrc());
                startActivity(intentPBJ);
                break;

            case "Soft Taco":
                Intent intentTaco= new Intent(this, RecipeActivity.class);
                intentTaco.putExtra("recipeName", softTaco.getRecipeName());
                intentTaco.putExtra("recipe", softTaco.getRecipe());
                intentTaco.putExtra("ingredient1", softTacoIngredients[0]);
                intentTaco.putExtra("ingredient2", softTacoIngredients[1]);
                intentTaco.putExtra("ingredient3", softTacoIngredients[2]);
                intentTaco.putExtra("imageSrc", softTaco.getImgSrc());
                startActivity(intentTaco);
                break;

            case "Chicken Sandwich":
                Intent intentSandwich= new Intent(this, RecipeActivity.class);
                intentSandwich.putExtra("recipeName", chickenSandwich.getRecipeName());
                intentSandwich.putExtra("recipe", chickenSandwich.getRecipe());
                intentSandwich.putExtra("ingredient1", chickenSandwichIngredients[0]);
                intentSandwich.putExtra("ingredient2", chickenSandwichIngredients[1]);
                intentSandwich.putExtra("ingredient3", chickenSandwichIngredients[2]);
                intentSandwich.putExtra("imageSrc", chickenSandwich.getImgSrc());
                startActivity(intentSandwich);
                break;

            case "Chicken Nachos":
                Intent intentNachos= new Intent(this, RecipeActivity.class);
                intentNachos.putExtra("recipeName", chickenNachos.getRecipeName());
                intentNachos.putExtra("recipe", chickenNachos.getRecipe());
                intentNachos.putExtra("ingredient1", chickenNachosIngredients[0]);
                intentNachos.putExtra("ingredient2", chickenNachosIngredients[1]);
                intentNachos.putExtra("ingredient3", chickenNachosIngredients[2]);
                intentNachos.putExtra("imageSrc", chickenNachos.getImgSrc());
                startActivity(intentNachos);
                break;

            case "Chips and Salsa":
                Intent intentSalsa= new Intent(this, RecipeActivity.class);
                intentSalsa.putExtra("recipeName", chipsAndSalsa.getRecipeName());
                intentSalsa.putExtra("recipe", chipsAndSalsa.getRecipe());
                intentSalsa.putExtra("ingredient1", chipsAndSalsaIngredients[0]);
                intentSalsa.putExtra("ingredient2", chipsAndSalsaIngredients[1]);
                intentSalsa.putExtra("imageSrc", chipsAndSalsa.getImgSrc());
                startActivity(intentSalsa);
                break;

            default:
                break;

        }
    }
}
