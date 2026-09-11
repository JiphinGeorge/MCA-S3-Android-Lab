package com.example.prgm_9_calculator_gridlayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView display;
    Button one, two, three, four, five;
    Button six, seven, eight, nine, zero;
    Button add, subtract, multiply, divide;
    Button equal, clear;

    double num1, num2, result;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);

        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        zero = findViewById(R.id.zero);

        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);

        equal = findViewById(R.id.equal);
        clear = findViewById(R.id.clear);


        one.setOnClickListener(v -> display.append("1"));

        two.setOnClickListener(v -> display.append("2"));

        three.setOnClickListener(v -> display.append("3"));

        four.setOnClickListener(v -> display.append("4"));

        five.setOnClickListener(v -> display.append("5"));

        six.setOnClickListener(v -> display.append("6"));

        seven.setOnClickListener(v -> display.append("7"));

        eight.setOnClickListener(v -> display.append("8"));

        nine.setOnClickListener(v -> display.append("9"));

        zero.setOnClickListener(v -> display.append("0"));


        add.setOnClickListener(v -> {

            num1 = Double.parseDouble(display.getText().toString());

            operator = "+";

            display.setText("");
        });


        subtract.setOnClickListener(v -> {

            num1 = Double.parseDouble(display.getText().toString());

            operator = "-";

            display.setText("");
        });


        multiply.setOnClickListener(v -> {

            num1 = Double.parseDouble(display.getText().toString());

            operator = "*";

            display.setText("");
        });


        divide.setOnClickListener(v -> {

            num1 = Double.parseDouble(display.getText().toString());

            operator = "/";

            display.setText("");
        });


        equal.setOnClickListener(v -> {

            num2 = Double.parseDouble(
                    display.getText().toString()
            );

            if (operator.equals("+")) {

                result = num1 + num2;

            } else if (operator.equals("-")) {

                result = num1 - num2;

            } else if (operator.equals("*")) {

                result = num1 * num2;

            } else if (operator.equals("/")) {

                result = num1 / num2;
            }

            display.setText(String.valueOf(result));
        });


        clear.setOnClickListener(v -> {

            display.setText("0");

            num1 = 0;
            num2 = 0;
            result = 0;
            operator = "";
        });
    }
}