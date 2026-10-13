package com.example.registrationexam;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        EditText nametext, addrtxt, phtext, emailtext;
        Button submitbtn;
        RadioGroup gendergroup;

        nametext = findViewById(R.id.name);
        addrtxt = findViewById(R.id.address);
        phtext = findViewById(R.id.phone);
        emailtext = findViewById(R.id.email);

        gendergroup = findViewById(R.id.gender);
        submitbtn = findViewById(R.id.submit);

        submitbtn.setOnClickListener(v -> {

            String name = nametext.getText().toString();
            String address = addrtxt.getText().toString();
            String phone = phtext.getText().toString();
            String email = emailtext.getText().toString();

            int genderid = gendergroup.getCheckedRadioButtonId();

            if (genderid == -1) {
                return;
            }

            RadioButton selectedGender = findViewById(genderid);
            String gender = selectedGender.getText().toString();

            Intent intent = new Intent(
                    MainActivity.this,
                    SecondActivity.class
            );

            intent.putExtra("Name", name);
            intent.putExtra("Address", address);
            intent.putExtra("Phone", phone);
            intent.putExtra("Email", email);
            intent.putExtra("Gender", gender);

            startActivity(intent);
        });
    }
}
