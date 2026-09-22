package com.example.prgm_12_adapter_listviewimage;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {


    ListView listView;
    ImageView imageView;

    String[] names = {
            "Apple",
            "Banana",
            "Cranberry",
            "DragonFruit",
            "EldenBerry",
            "Fig"
    };

    int [] images={
            R.drawable.apple,R.drawable.banana,R.drawable.cranberry,R.drawable.dragonfruit,R.drawable.elderberry,R.drawable.fig
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        listView =findViewById(R.id.listviewid);
        imageView=findViewById(R.id.imageviewid);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                names
        );

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {

            imageView.setImageResource(images[position]);

        });
    }
}