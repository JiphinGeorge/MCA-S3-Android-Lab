package com.example.prgm_8_relativelayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.prgm_8_relativelayout.MainActivity;

public class MainActivity2 extends AppCompatActivity {

    ImageView avatar;
    TextView details;
    Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        avatar = findViewById(R.id.avatar);
        details = findViewById(R.id.details);
        backButton = findViewById(R.id.backButton);

        // Receive data from MainActivity
        String name = getIntent().getStringExtra("name");
        String email = getIntent().getStringExtra("email");
        String gender = getIntent().getStringExtra("gender");

        int image = getIntent().getIntExtra(
                "image",
                0
        );

        // Display avatar
        if (image != 0) {
            avatar.setImageResource(image);
        }

        // Display registration details
        String registrationDetails =
                "Name: " + name +
                        "\n\nEmail: " + email +
                        "\n\nGender: " + gender;

        details.setText(registrationDetails);

        // Back button
        backButton.setOnClickListener(v -> {

            Intent intent = new Intent(
                    MainActivity2.this, MainActivity.class
            );

            startActivity(intent);
            finish();
        });
    }
}