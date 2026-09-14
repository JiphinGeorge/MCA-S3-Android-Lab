package com.example.prgm_10_framelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    ImageView image1, image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image1= findViewById(R.id.imageView);
        image2= findViewById(R.id.imageView3);

        image1.setOnClickListener(v ->{
                image2.setVisibility(View.VISIBLE);
                image1.setVisibility(View.GONE);
            }
        );

        image2.setOnClickListener(v ->{
                image2.setVisibility(View.GONE);
                image1.setVisibility(View.VISIBLE);

        }
        );


    }
}