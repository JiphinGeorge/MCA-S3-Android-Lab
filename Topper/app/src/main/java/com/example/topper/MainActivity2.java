package com.example.topper;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    EditText name1,rollno1,mark1;
    EditText name2,rollno2,mark2;
    EditText name3,rollno3,mark3;
    Button Top;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        String mark01,mark02,mark03;

        name1=findViewById(R.id.name1);
        rollno1=findViewById(R.id.rollno1);
        mark1=findViewById(R.id.mark1);
        name2=findViewById(R.id.name2);
        rollno2=findViewById(R.id.rollno2);
        mark2=findViewById(R.id.mark2);
        name3=findViewById(R.id.name3);
        rollno3=findViewById(R.id.rollno3);
        mark3=findViewById(R.id.mark3);

        mark01=mark1.getText().toString();

        mark02=mark2.getText().toString();

        mark03=mark3.getText().toString();

        double m1=Double.parseDouble(mark01);
        double m2=Double.parseDouble(mark02);
        double m3=Double.parseDouble(mark03);
        Top=findViewById(R.id.top);
        Top.setOnClickListener(v->{
            String topn,topr;
            double topm;
            if (m1>m2){
                if(m1>m3){
                    topn=name1.getText().toString();
                    topr=rollno1.getText().toString();
                    topm=m1;
                }else{
                    topn=name2.getText().toString();
                    topr=rollno2.getText().toString();
                    topm=m2;
                }
            }else{
                if(m2>m3){
                    topn=name2.getText().toString();
                    topr=rollno2.getText().toString();
                    topm=m2;
                }else{
                    topn=name3.getText().toString();
                    topr=rollno3.getText().toString();
                    topm=m3;
                }
            }
            SharedPreferences sp = getSharedPreferences("StudentData", MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();

            editor.putString("name", topn);
            editor.putString("rno", topr);
            editor.putString("mark", String.valueOf(topm));
            editor.apply();

            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent);
        });
    }
}