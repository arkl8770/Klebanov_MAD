package com.example.ariklebanov.pocketcheflite;

public class Recipe {
    private String recipeName;
    private String recipe;
    private String[] arrayOfIngredients;
    private int imgSrc;

    public String getRecipeName() {
        return recipeName;
    }
    public void setRecipeName(String recipeNameIn) {
        recipeName = recipeNameIn;
    }
    public String getRecipe() {
        return recipe;
    }
    public void setRecipe(String recipeIn) {
        recipe = recipeIn;
    }
    public String[] getArrayOfIngredients() {
        return arrayOfIngredients;
    }
    public void setArrayOfIngredients(String[] arrayIngredientsIn) {
        arrayOfIngredients = arrayIngredientsIn;
    }
    public int getImgSrc() {
        return imgSrc;
    }
    public void setImgSrc(int imgSrcIn){
        imgSrc = imgSrcIn;
    }
}
