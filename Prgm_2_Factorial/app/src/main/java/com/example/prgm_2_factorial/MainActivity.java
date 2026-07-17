package com.example.prgm_2_factorial;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editTextText);
        textView = findViewById(R.id.textView);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input = editText.getText().toString();

                if (!input.isEmpty()) {

                    int num = Integer.parseInt(input);
                    long fact = 1;

                    for (int i = 1; i <= num; i++) {
                        fact = fact * i;
                    }

                    textView.setText("Factorial = " + fact);

                } else {
                    textView.setText("Enter a number");
                }
            }
        });
    }
}