package com.example.prgm_12_spinner_display;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner spinnerCountry;
    ImageView imageFlag;
    TextView txtCountry;

    String[] countries = {
            "India",
            "USA",
            "UK",
            "Russia",
            "Italy",
            "Germany",
            "Brazil",
            "Belgium",
            "Argentina",
            "England"
    };

    int[] flags = {
            R.drawable.flag_of_india_1024x683,
            R.drawable.flag_of_united_states_1024x539,
            R.drawable.flag_of_united_kingdom_1024x512,
            R.drawable.flag_of_russia_1024x683,
            R.drawable.flag_of_italy_1024x683,
            R.drawable.flag_of_germany_1024x613,
            R.drawable.flag_of_brazil_1024x716,
            R.drawable.flag_of_belgium_1024x891,
            R.drawable.flag_of_argentina_1024x640,
            R.drawable.flag_of_england_1024x614
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerCountry = findViewById(R.id.spinnerCountry);
        imageFlag = findViewById(R.id.imageFlag);
        txtCountry = findViewById(R.id.txtCountry);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                countries
        );

        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinnerCountry.setAdapter(adapter);

        spinnerCountry.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {

                        imageFlag.setImageResource(flags[position]);
                        txtCountry.setText(countries[position]);
                    }

                    @Override
                    public void onNothingSelected(
                            AdapterView<?> parent) {
                    }
                }
        );
    }
}
