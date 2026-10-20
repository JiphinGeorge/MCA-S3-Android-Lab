package com.example.prgm_14_togglebutton;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.CheckBox;
import android.widget.ToggleButton;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends Activity {

    EditText percentage;
    CheckBox terms;
    ToggleButton toggleBg;
    ImageView bgImage;
    Button submit;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        percentage = findViewById(R.id.percentage);
        terms = findViewById(R.id.terms);
        toggleBg = findViewById(R.id.toggleBg);
        bgImage = findViewById(R.id.bgImage);
        submit = findViewById(R.id.submit);
        result = findViewById(R.id.result);

        // Change full-screen background image
        toggleBg.setOnCheckedChangeListener((button, checked) -> {
            if (checked) {
                bgImage.setImageResource(R.drawable.bg2);
            } else {
                bgImage.setImageResource(R.drawable.bg1);
            }
        });

        // Validate percentage and terms
        submit.setOnClickListener(v -> {

            String input = percentage.getText()
                    .toString().trim();

            if (input.isEmpty()) {
                percentage.setError("Enter percentage");
                return;
            }

            double mark;

            try {
                mark = Double.parseDouble(input);
            } catch (NumberFormatException e) {
                percentage.setError("Enter a valid percentage");
                return;
            }

            if (Double.isNaN(mark) || Double.isInfinite(mark)
                    || mark < 0) {
                percentage.setError(
                        "Enter a valid non-negative percentage");
                return;
            }

            // Replace values above 100 with 100
            if (mark > 100) {
                mark = 100;
                percentage.setText("100");
            }

            // Check Terms and Conditions
            if (!terms.isChecked()) {
                Toast.makeText(
                        MainActivity.this,
                        "Please accept Terms and Conditions",
                        Toast.LENGTH_SHORT
                ).show();
                return;
            }

            result.setText(String.format(
                    Locale.getDefault(),
                    "Mark Percentage: %.2f%%",
                    mark
            ));
        });
    }
}
