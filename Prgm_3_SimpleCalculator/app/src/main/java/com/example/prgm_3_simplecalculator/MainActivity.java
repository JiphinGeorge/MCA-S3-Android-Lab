package com.example.calculator;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    TextView output;
    Button sum, mul, div, sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.editTextText);
        num2 = findViewById(R.id.editTextText2);

        output = findViewById(R.id.textView);

        sum = findViewById(R.id.button);
        mul = findViewById(R.id.button2);
        div = findViewById(R.id.button3);
        sub = findViewById(R.id.button4);


        sum.setOnClickListener(v -> {
            int a = Integer.parseInt(num1.getText().toString());
            int b = Integer.parseInt(num2.getText().toString());

            output.setText("Result: " + (a + b));
        });


        sub.setOnClickListener(v -> {
            int a = Integer.parseInt(num1.getText().toString());
            int b = Integer.parseInt(num2.getText().toString());

            output.setText("Result: " + (a - b));
        });


        mul.setOnClickListener(v -> {
            int a = Integer.parseInt(num1.getText().toString());
            int b = Integer.parseInt(num2.getText().toString());

            output.setText("Result: " + (a * b));
        });


        div.setOnClickListener(v -> {
            int a = Integer.parseInt(num1.getText().toString());
            int b = Integer.parseInt(num2.getText().toString());

            if (b != 0) {
                output.setText("Result: " + (a / b));
            } else {
                output.setText("Cannot divide by zero");
            }
        });
    }
}