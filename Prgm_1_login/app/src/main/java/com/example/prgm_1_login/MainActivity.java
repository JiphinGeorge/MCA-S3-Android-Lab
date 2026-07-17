package com.example.prgm_1_login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    String username="jiphin";
    String pss="123";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Button login = findViewById(R.id.button);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.button)
        {
            EditText user =findViewById(R.id.editTextText3);
            EditText pass =findViewById(R.id.editTextText4);

            String a= user.getText().toString();
            String b=pass.getText().toString();
            if(a.equals(username) && b.equals(pss))
            {
                Toast.makeText(this,"Login Sucessful....!",Toast.LENGTH_LONG).show();

            }
            else {
                Toast.makeText(this,"Login Failedddddd",Toast.LENGTH_LONG).show();
            }
        }
    }
}