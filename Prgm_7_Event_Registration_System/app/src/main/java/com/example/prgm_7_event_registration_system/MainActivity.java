package com.example.prgm_7_event_registration_system;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText name, email;
    RadioGroup categoryGroup;
    CheckBox android, aiml, cybersecurity;
    Button submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);

        categoryGroup = findViewById(R.id.categoryGroup);

        android = findViewById(R.id.android);
        aiml = findViewById(R.id.aiml);
        cybersecurity = findViewById(R.id.cybersecurity);

        submit = findViewById(R.id.submit);

        // Retrieve previously entered data
        loadData();

        submit.setOnClickListener(v -> {

            String userName = name.getText().toString();
            String userEmail = email.getText().toString();

            int selectedId = categoryGroup.getCheckedRadioButtonId();
            RadioButton selectedRadio = findViewById(selectedId);

            String category = selectedRadio != null
                    ? selectedRadio.getText().toString()
                    : "";

            String workshops = "";

            if (android.isChecked())
                workshops += "Android Development, ";

            if (aiml.isChecked())
                workshops += "AI & ML, ";

            if (cybersecurity.isChecked())
                workshops += "Cybersecurity";

            // Remove last comma
            workshops = workshops.replaceAll(", $", "");

            // Shared Preferences
            getSharedPreferences("RegistrationData", MODE_PRIVATE)
                    .edit()
                    .putString("name", userName)
                    .putString("email", userEmail)
                    .putString("category", category)
                    .putString("workshops", workshops)
                    .apply();

            // Move to Activity 2
            Intent intent = new Intent(
                    MainActivity.this,
                    MainActivity2.class
            );

            startActivity(intent);
        });
    }

    private void loadData() {

        android.content.SharedPreferences preferences =
                getSharedPreferences("RegistrationData", MODE_PRIVATE);

        name.setText(preferences.getString("name", ""));
        email.setText(preferences.getString("email", ""));

        String category = preferences.getString("category", "");

        if (category.equals("Student")) {
            categoryGroup.check(R.id.student);
        } else if (category.equals("Professional")) {
            categoryGroup.check(R.id.professional);
        }

        String workshops =
                preferences.getString("workshops", "");

        android.setChecked(workshops.contains("Android Development"));
        aiml.setChecked(workshops.contains("AI & ML"));
        cybersecurity.setChecked(workshops.contains("Cybersecurity"));
    }
}