package com.example.prgm_11_adapter_listview;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    ListView list;
    String []days= {"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list=findViewById(R.id.main);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,days );
        list.setAdapter(adapter);
        list.setOnItemClickListener((parent, view, position, id) ->
                Toast.makeText(MainActivity.this,days[position] +" "+position,Toast.LENGTH_SHORT ).show());
    }
}