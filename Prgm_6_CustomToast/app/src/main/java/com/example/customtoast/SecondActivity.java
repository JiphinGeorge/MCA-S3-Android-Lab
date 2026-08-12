package com.example.customtoast;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        // Create custom Toast
        LayoutInflater inflater = getLayoutInflater();

        View layout = inflater.inflate(
                R.layout.toast_layout,
                null
        );

        Toast toast = new Toast(SecondActivity.this);

        toast.setDuration(Toast.LENGTH_LONG);
        toast.setView(layout);
        toast.show();
    }
}