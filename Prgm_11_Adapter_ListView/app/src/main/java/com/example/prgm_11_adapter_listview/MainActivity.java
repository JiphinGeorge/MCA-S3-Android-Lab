package com.example.prgm_11_adapter_listview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String[] days = {
            "Monday",
            "Tuesday",
            "Wednesday",
            "Thursday",
            "Friday",
            "Saturday",
            "Sunday"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.main);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                days
        );
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, i, id) -> {

            Toast.makeText(
                    MainActivity.this,days[i] +" "+
                    + i,
                    Toast.LENGTH_SHORT
            ).show();

        });
    }
}