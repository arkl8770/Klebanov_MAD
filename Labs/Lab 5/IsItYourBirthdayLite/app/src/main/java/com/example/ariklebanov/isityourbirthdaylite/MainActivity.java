package com.example.ariklebanov.isityourbirthdaylite;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkBirthDay(View view) {
        Switch birthdaySwitch = findViewById(R.id.birthdaySwitch);
        TextView birthdayText = findViewById(R.id.messageView);
        EditText nameInput = findViewById(R.id.editText);
        String nameIn = nameInput.getText().toString();

        ImageView image = findViewById(R.id.imageView);
        if (birthdaySwitch.isChecked()) {//Birthday == true
            birthdayText.setText("Happy Birthday " + nameIn + "!");
            image.setImageResource(R.drawable.birthday);
        } else {
            birthdayText.setText("It's not your birthday " + nameIn + "... Try again tomorrow!");
            image.setImageResource(R.drawable.notbirthday);
        }


    }
}
