package com.example.prgm_9_calculator_gridlayout;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView display;

    Button zero, one, two, three, four, five;
    Button six, seven, eight, nine;
    Button add, subtract, multiply, divide;
    Button dot, equal, clear, backspace, percent;

    double firstNumber = 0;
    String operator = "";
    boolean newNumber = true;
    boolean resultShown = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Display
        display = findViewById(R.id.display);

        // Number buttons
        zero = findViewById(R.id.zero);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);

        // Operator buttons
        add = findViewById(R.id.add);
        subtract = findViewById(R.id.subtract);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);

        // Other buttons
        dot = findViewById(R.id.dot);
        equal = findViewById(R.id.equal);
        clear = findViewById(R.id.clear);
        backspace = findViewById(R.id.backspace);
        percent = findViewById(R.id.percent);


        // ---------------- NUMBER BUTTONS ----------------

        zero.setOnClickListener(v -> addNumber("0"));

        one.setOnClickListener(v -> addNumber("1"));

        two.setOnClickListener(v -> addNumber("2"));

        three.setOnClickListener(v -> addNumber("3"));

        four.setOnClickListener(v -> addNumber("4"));

        five.setOnClickListener(v -> addNumber("5"));

        six.setOnClickListener(v -> addNumber("6"));

        seven.setOnClickListener(v -> addNumber("7"));

        eight.setOnClickListener(v -> addNumber("8"));

        nine.setOnClickListener(v -> addNumber("9"));


        // ---------------- OPERATORS ----------------

        add.setOnClickListener(v -> setOperator("+"));

        subtract.setOnClickListener(v -> setOperator("-"));

        multiply.setOnClickListener(v -> setOperator("×"));

        divide.setOnClickListener(v -> setOperator("÷"));


        // ---------------- DECIMAL ----------------

        dot.setOnClickListener(v -> {

            String current = display.getText().toString();

            String[] parts = current.split(" ");

            String lastNumber = parts[parts.length - 1];

            if (!lastNumber.contains(".")) {

                if (newNumber) {
                    display.append("0.");
                    newNumber = false;
                } else {
                    display.append(".");
                }
            }
        });


        // ---------------- CLEAR ----------------

        clear.setOnClickListener(v -> {

            display.setText("0");

            firstNumber = 0;
            operator = "";
            newNumber = true;
            resultShown = false;
        });


        // ---------------- BACKSPACE ----------------

        backspace.setOnClickListener(v -> {

            String current = display.getText().toString();

            if (current.length() > 1) {

                display.setText(
                        current.substring(0, current.length() - 1)
                );

            } else {

                display.setText("0");
                newNumber = true;
            }
        });


        // ---------------- PERCENTAGE ----------------

        percent.setOnClickListener(v -> {

            try {

                String current = display.getText().toString();

                double number = Double.parseDouble(current);

                number = number / 100;

                display.setText(formatNumber(number));

                resultShown = true;

            } catch (Exception e) {

                display.setText("Error");
                resultShown = true;
            }
        });


        // ---------------- EQUAL ----------------

        equal.setOnClickListener(v -> calculate());
    }


    // Add number to display
    private void addNumber(String number) {

        // If previous operation is completed
        if (resultShown) {

            display.setText(number);

            resultShown = false;
            newNumber = false;

            return;
        }

        // If operator was just selected
        if (newNumber) {

            display.append(number);

            newNumber = false;

        } else {

            display.append(number);
        }
    }


    // Set operator
    private void setOperator(String op) {

        String current = display.getText().toString();

        // Don't allow two operators
        if (current.endsWith(" ")) {
            return;
        }

        try {

            String[] parts = current.split(" ");

            firstNumber = Double.parseDouble(
                    parts[parts.length - 1]
            );

            operator = op;

            // Show complete calculation
            display.setText(
                    current + " " + op + " "
            );

            newNumber = true;
            resultShown = false;

        } catch (Exception e) {

            display.setText("Error");
            resultShown = true;
        }
    }


    // Calculate result
    private void calculate() {

        String expression =
                display.getText().toString().trim();

        String[] parts = expression.split(" ");

        if (parts.length < 3) {
            return;
        }

        try {

            double secondNumber =
                    Double.parseDouble(parts[2]);

            double result = 0;

            switch (operator) {

                case "+":

                    result = firstNumber + secondNumber;
                    break;

                case "-":

                    result = firstNumber - secondNumber;
                    break;

                case "×":

                    result = firstNumber * secondNumber;
                    break;

                case "÷":

                    if (secondNumber == 0) {

                        display.setText(
                                "Cannot divide by zero"
                        );

                        resultShown = true;

                        return;
                    }

                    result = firstNumber / secondNumber;
                    break;
            }

            // Show result
            display.setText(formatNumber(result));

            resultShown = true;
            newNumber = true;
            operator = "";

        } catch (Exception e) {

            display.setText("Error");

            resultShown = true;
        }
    }


    // Remove unnecessary .0
    private String formatNumber(double number) {

        if (number == (long) number) {

            return String.valueOf((long) number);

        } else {

            return String.valueOf(number);
        }
    }
}