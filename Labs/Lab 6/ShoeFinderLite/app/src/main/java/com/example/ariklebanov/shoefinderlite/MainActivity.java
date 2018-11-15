package com.example.ariklebanov.shoefinderlite;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void findShoe (View view) {
        Spinner styleList = findViewById(R.id.styleSpinner);
        String styleType = String.valueOf(styleList.getSelectedItem());
        ToggleButton upgradeToggle = findViewById(R.id.upgradeToggle);
        boolean pro = upgradeToggle.isChecked();
        RadioGroup budgetGroup = findViewById(R.id.budgetGroup);
        int budgetSelected = budgetGroup.getCheckedRadioButtonId();
        ImageView resultImage = findViewById(R.id.resultImage);
        TextView resultText = findViewById(R.id.resultText);
        if (budgetSelected == -1) {//if the user does not select a budget
            //toast
            Context context = getApplicationContext();
            CharSequence text = "Please choose a budget, either '$' or '$$$'";
            int duration = Toast.LENGTH_SHORT;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        } else {
            if (pro){//user chooses a pro shoe
                if (budgetSelected == R.id.budgetButton) {//user selects cheap pro shoes
                    //toast
                    Context context = getApplicationContext();
                    CharSequence text = "Pro shoes aren't cheap! Please select '$$$' or set the toggle to 'Classic'";
                    int duration = Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                } else if (budgetSelected == R.id.budgetButton2) {//user selects expensive pro shoes
                    switch (styleType) {
                        case "Sk8-Hi":
                            resultText.setText("You should buy some Sk8-Hi Pros!");
                            resultImage.setImageResource(R.drawable.sk8hipro);
                            break;

                        case "Old Skool":
                            resultText.setText("You should buy some Old Skool Pros!");
                            resultImage.setImageResource(R.drawable.oldskoolpro);
                            break;

                        case "Authentic":
                            resultText.setText("You should buy some Authentic Pros!");
                            resultImage.setImageResource(R.drawable.authenticpro);
                            break;

                        case "Classic Slip-On":
                            resultText.setText("You should buy some Slip-On Pros!");
                            resultImage.setImageResource(R.drawable.sliponpro);
                            break;

                        default:
                    }
                }
            } else {//user chooses a classic shoe
                if (budgetSelected == R.id.budgetButton) {//user selects cheap classic shoes
                    switch (styleType) {
                        case "Sk8-Hi":
                            resultText.setText("You should buy some Black and White Sk8-His!");
                            resultImage.setImageResource(R.drawable.bwsk8hi);
                            break;

                        case "Old Skool":
                            resultText.setText("You should buy some Black and White Old Skools!");
                            resultImage.setImageResource(R.drawable.bwoldskool);
                            break;

                        case "Authentic":
                            resultText.setText("You should buy some Black and White Authentics!");
                            resultImage.setImageResource(R.drawable.bwauthentic);
                            break;

                        case "Classic Slip-On":
                            resultText.setText("You should buy Black and White Classic Slip-Ons!");
                            resultImage.setImageResource(R.drawable.bwslipon);
                            break;

                        default:
                    }
                } else {//user selects expensive classic shoes
                    switch (styleType) {
                        case "Sk8-Hi":
                            resultText.setText("You should buy these super cool custom Sk8-His!");
                            resultImage.setImageResource(R.drawable.customsk8hi);
                            break;

                        case "Old Skool":
                            resultText.setText("You should buy these super cool custom Old Skools!");
                            resultImage.setImageResource(R.drawable.customoldskool);
                            break;

                        case "Authentic":
                            resultText.setText("You should buy these super cool custom Authentics!");
                            resultImage.setImageResource(R.drawable.customauthentic);
                            break;

                        case "Classic Slip-On":
                            resultText.setText("You should buy these super cool custom Slip-Ons!");
                            resultImage.setImageResource(R.drawable.customslipon);
                            break;

                        default:
                    }
                }
            }
        }
    }
}
