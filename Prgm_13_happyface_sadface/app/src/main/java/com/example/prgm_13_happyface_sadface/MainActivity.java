package com.example.prgm_13_happyface_sadface;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends Activity {

    EditText m1, m2, m3;
    Button btn;
    TextView result;
    ImageView face;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        m1 = findViewById(R.id.m1);
        m2 = findViewById(R.id.m2);
        m3 = findViewById(R.id.m3);
        btn = findViewById(R.id.btn);
        result = findViewById(R.id.result);
        face = findViewById(R.id.face);

        btn.setOnClickListener(v -> {

            String s1 = m1.getText().toString().trim();
            String s2 = m2.getText().toString().trim();
            String s3 = m3.getText().toString().trim();

            if (s1.isEmpty() || s2.isEmpty() || s3.isEmpty()) {
                Toast.makeText(this, "Enter all marks",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            double a, b, c;

            try {
                a = Double.parseDouble(s1);
                b = Double.parseDouble(s2);
                c = Double.parseDouble(s3);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Enter valid marks",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            if (a < 0 || a > 100 ||
                    b < 0 || b > 100 ||
                    c < 0 || c > 100) {

                Toast.makeText(this,
                        "Marks must be between 0 and 100",
                        Toast.LENGTH_SHORT).show();
                return;
            }

            double total = a + b + c;
            double percentage = (total / 300.0) * 100;

            result.setText(String.format(Locale.getDefault(),
                    "Total: %.1f / 300\nPercentage: %.2f%%",
                    total, percentage));

            if (percentage > 50) {
                face.setImageResource(R.drawable.happy);
            } else {
                face.setImageResource(R.drawable.sad);
            }

            face.setVisibility(View.VISIBLE);
        });
    }
}
