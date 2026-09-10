package com.example.prgm_8_relativelayout;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, email;
    RadioGroup genderGroup;
    ImageView genderImage;
    Button registerButton;

    int selectedImage = 0;
    String selectedGender = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        genderGroup = findViewById(R.id.genderGroup);
        genderImage = findViewById(R.id.genderImage);
        registerButton = findViewById(R.id.registerButton);

        // Select Male or Female
        genderGroup.setOnCheckedChangeListener(
                (group, checkedId) -> {

                    if (checkedId == R.id.maleRadio) {

                        selectedGender = "Male";
                        selectedImage = R.drawable.male;

                        genderImage.setImageResource(
                                R.drawable.male
                        );

                        genderImage.setVisibility(
                                ImageView.VISIBLE
                        );

                    } else if (checkedId == R.id.femaleRadio) {

                        selectedGender = "Female";
                        selectedImage = R.drawable.female;

                        genderImage.setImageResource(
                                R.drawable.female
                        );

                        genderImage.setVisibility(
                                ImageView.VISIBLE
                        );
                    }
                }
        );

        // Register button
        registerButton.setOnClickListener(v -> {

            String userName = name.getText().toString();
            String userEmail = email.getText().toString();

            if (userName.isEmpty() ||
                    userEmail.isEmpty() ||
                    selectedGender.isEmpty()) {

                Toast.makeText(
                        MainActivity.this,
                        "Please fill all details",
                        Toast.LENGTH_SHORT
                ).show();

                return;
            }

            // Send data to SecondActivity
            Intent intent = new Intent(
                    MainActivity.this, MainActivity2.class
            );

            intent.putExtra("name", userName);
            intent.putExtra("email", userEmail);
            intent.putExtra("gender", selectedGender);
            intent.putExtra("image", selectedImage);

            startActivity(intent);
        });
    }
}