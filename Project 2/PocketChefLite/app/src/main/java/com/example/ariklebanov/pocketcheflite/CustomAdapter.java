package com.example.ariklebanov.pocketcheflite;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;


public class CustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> validRecipesArrayList = new ArrayList<String>();
    ArrayList<Integer> validImagesArrayList = new ArrayList<Integer>();



    //String validRecipesToDisplay[];
    //int validImagesToDisplay[];
    LayoutInflater inflter;

    public CustomAdapter(Context appContext, ArrayList<String> validRecipesArrayList, ArrayList<Integer> validImagesArrayList) {
        this.context = appContext;
        this.validRecipesArrayList = validRecipesArrayList;
        this.validImagesArrayList = validImagesArrayList;
        inflter = (LayoutInflater.from(appContext));
    }
    @Override
    public int getCount(){
        return validRecipesArrayList.size();
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        convertView = inflter.inflate(R.layout.activity_list_view, null);
        TextView recipe = (TextView) convertView.findViewById(R.id.recipeName);
        ImageView image = (ImageView) convertView.findViewById(R.id.recipeImage);
        recipe.setText(validRecipesArrayList.get(i));
        image.setImageResource(validImagesArrayList.get(i));
        return convertView;
    }


}
