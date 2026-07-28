package com.example.prgm_4_sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etUsername, etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.editTextUsername);
        etPassword = findViewById(R.id.editTextPassword);
        btnLogin = findViewById(R.id.buttonLogin);

        btnLogin.setOnClickListener(v -> {

            String username = etUsername.getText().toString();
            String password = etPassword.getText().toString();

            SharedPreferences sp = getSharedPreferences("UserData", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();

            editor.putString("username", username);
            editor.putString("password", password);
            editor.apply();

            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });
    }
}