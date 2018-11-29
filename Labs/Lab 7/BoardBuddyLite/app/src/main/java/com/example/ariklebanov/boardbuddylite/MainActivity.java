package com.example.ariklebanov.boardbuddylite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    private longBoard myLongboard = new longBoard();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button findLongboardButton = findViewById(R.id.findButton);
        View.OnClickListener buttonClick = new View.OnClickListener() {
            public void onClick(View view) {
                findLongboard(view);
            }
        };
        findLongboardButton.setOnClickListener(buttonClick);
    }


    private void findLongboard(View view) {
        Spinner styleSpinner = findViewById(R.id.styleSpinner);
        Spinner heightSpinner = findViewById(R.id.heightSpinner);
        Integer style = styleSpinner.getSelectedItemPosition();
        Integer height = heightSpinner.getSelectedItemPosition();
        myLongboard.setLongboardInfo(style, height);
        String suggestedLongboard = myLongboard.getLongboardName();
        Log.i("longboard", suggestedLongboard);

        Intent intent = new Intent( this, ReceiveLongBoard.class);

        intent.putExtra( "longboardName", suggestedLongboard);

        startActivity(intent);

    }
}
