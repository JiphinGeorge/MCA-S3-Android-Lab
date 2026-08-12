package com.example.customtoast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText username;
    EditText password;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.editTextText);
        password = findViewById(R.id.editTextText2);
        loginButton = findViewById(R.id.button);

        loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.equals("admin") && pass.equals("1234")) {

                    // Go directly to Second Activity
                    Intent intent = new Intent(
                            MainActivity.this,
                            SecondActivity.class
                    );

                    startActivity(intent);

                } else {

                    Toast.makeText(
                            MainActivity.this,
                            "Invalid Username or Password",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        });
    }
}