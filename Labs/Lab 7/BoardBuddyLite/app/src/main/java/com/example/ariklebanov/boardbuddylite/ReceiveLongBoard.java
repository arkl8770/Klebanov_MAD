package com.example.ariklebanov.boardbuddylite;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

public class ReceiveLongBoard extends AppCompatActivity {

    private String longboardName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_findlongboard);

        Intent intent = getIntent();
        longboardName = intent.getStringExtra("longboardName");
        Log.i("board received", longboardName);

        TextView resultText = findViewById(R.id.resultText);
        ImageView resultImage = findViewById(R.id.resultImage);
        resultText.setText("You should buy a " + longboardName);
        switch (longboardName) {
            case "Basic Cruiser":
                resultImage.setImageResource(R.drawable.basiccruiser);
                break;
            case "Top Mount":
                resultImage.setImageResource(R.drawable.topmount);
                break;
            case "Drop-deck":
                resultImage.setImageResource(R.drawable.dropdeck);
                break;
            case "Pintail":
                resultImage.setImageResource(R.drawable.pintail);
                break;
            default:
        }
    }
}
