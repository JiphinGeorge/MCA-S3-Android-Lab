package com.example.topper;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText u_name,pass;
    Button login;
    String uname="Jhon";
    String password="1234";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        u_name=findViewById(R.id.name);
        pass=findViewById(R.id.pass);
        String name=u_name.getText().toString();
        String p=pass.getText().toString();
        login=findViewById(R.id.login);
        login.setOnClickListener(v -> {

            Intent intent=new Intent(MainActivity.this, MainActivity3.class);
            startActivity(intent);
//            if(name.isEmpty() || p.isEmpty()){
//                Toast.makeText("Enter Name & Password" ,Toast.LENGTH_SHORT).show();
//            }else{
//                if(name.equals(uname) && p.equals(password)){
//                    Intent intent=new Intent(MainActivity.this, MainActivity2.class);
//                    startActivity(intent);
//                }
//            }
        });
    }
}