package com.example.registrationexam;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_second);

        EditText name, address, email, phone;
        ImageView image;

        name = findViewById(R.id.namedisplay);
        address = findViewById(R.id.addrdisplay);
        email = findViewById(R.id.emaildisplay);
        phone = findViewById(R.id.phonedisplay);
        image = findViewById(R.id.image);

        name.setText(getIntent().getStringExtra("Name"));
        address.setText(getIntent().getStringExtra("Address"));
        email.setText(getIntent().getStringExtra("Email"));
        phone.setText(getIntent().getStringExtra("Phone"));

        String genderval = getIntent().getStringExtra("Gender");

        if ("male".equals(genderval)) {
            image.setImageResource(R.drawable.male);
        } else if ("female".equals(genderval)) {
            image.setImageResource(R.drawable.female);
        }
    }
}
