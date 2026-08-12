package com.example.prgm_7_event_registration_system;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    TextView summary;
    Button backButton;
    Button confirmButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        summary = findViewById(R.id.summary);
        backButton = findViewById(R.id.backButton);
        confirmButton = findViewById(R.id.confirmButton);

        // Retrieve data
        android.content.SharedPreferences preferences =
                getSharedPreferences("RegistrationData", MODE_PRIVATE);

        String name = preferences.getString("name", "");
        String email = preferences.getString("email", "");
        String category = preferences.getString("category", "");
        String workshops = preferences.getString("workshops", "");

        // Display summary
        String details =
                "Name: " + name +
                        "\n\nEmail: " + email +
                        "\n\nCategory: " + category +
                        "\n\nWorkshops: " + workshops;

        summary.setText(details);

        // Back to Edit
        backButton.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity2.this,
                    MainActivity.class
            );

            startActivity(intent);
            finish();
        });

        // Confirm Registration
        confirmButton.setOnClickListener(v -> {

            LayoutInflater inflater = getLayoutInflater();

            View layout = inflater.inflate(
                    R.layout.customtoast,
                    null
            );

            Toast toast = new Toast(MainActivity2.this);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(layout);
            toast.show();
        });
    }
}