package com.example.topper;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity3 extends AppCompatActivity {
    TextView n,r,m;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        n = findViewById(R.id.toppername);
        r= findViewById(R.id.topperroll);
        m = findViewById(R.id.toppermark);

        SharedPreferences sp = getSharedPreferences("StudentData", MODE_PRIVATE);

        String name = sp.getString("name", "");
        String roll = sp.getString("rno", "");
        String mark =sp.getString("mark", "");

        n.setText("Name " + name);
        r.setText("Roll No : " + roll);
        m.setText("Mark :"+ mark);

    }
}