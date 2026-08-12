package com.example.prgm_4_sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    TextView tvUsername, tvPassword;
    Button btnPrevious;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvUsername = findViewById(R.id.textView2);
        tvPassword = findViewById(R.id.textView3);
        btnPrevious = findViewById(R.id.button2);

        SharedPreferences sp = getSharedPreferences("UserData", MODE_PRIVATE);

        String username = sp.getString("username", "");
        String password = sp.getString("password", "");

        tvUsername.setText("Welcome " + username);
        tvPassword.setText("Password : " + password);

        btnPrevious.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}