package com.example.prgm_2_factorial;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;
import android.widget.Button;

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

        button = new Button(this);
        button.setText("Calculate");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num = Integer.parseInt(editText.getText().toString());
                long fact = 1;

                for (int i = 1; i <= num; i++) {
                    fact = fact * i;
                }

                textView.setText("Factorial = " + fact);
            }
        });
    }
}