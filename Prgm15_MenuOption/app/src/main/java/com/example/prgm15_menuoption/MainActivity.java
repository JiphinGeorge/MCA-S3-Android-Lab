package com.example.prgm15_menuoption;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    LinearLayout factorialLayout;
    EditText etNumber;
    Button btnCalculate;
    TextView result;
    ImageView genderImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        factorialLayout = findViewById(R.id.factorialLayout);
        etNumber = findViewById(R.id.etNumber);
        btnCalculate = findViewById(R.id.btnCalculate);
        result = findViewById(R.id.result);
        genderImage = findViewById(R.id.genderImage);

        btnCalculate.setOnClickListener(v -> calculateFactorial());
    }

    private void calculateFactorial() {
        String value = etNumber.getText().toString().trim();

        if (value.isEmpty()) {
            Toast.makeText(this, "Enter a number", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            int n = Integer.parseInt(value);

            if (n < 0 || n > 20) {
                Toast.makeText(this, "Enter a number from 0 to 20", Toast.LENGTH_SHORT).show();
                return;
            }

            long fact = 1;
            for (int i = 1; i <= n; i++) {
                fact = fact * i;
            }

            String resultMsg = n + "! = " + fact;
            result.setText(resultMsg);
            genderImage.setVisibility(ImageView.GONE);

            new AlertDialog.Builder(this)
                    .setTitle("Factorial")
                    .setMessage(resultMsg)
                    .setNegativeButton("Cancel", null)
                    .setPositiveButton("OK", null)
                    .show();

        } catch (NumberFormatException e) {
            Toast.makeText(this, "Enter a valid number", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.factorial) {
            factorialLayout.setVisibility(View.VISIBLE);
            genderImage.setVisibility(View.GONE);
            result.setText("");
            etNumber.setText("");
            etNumber.requestFocus();
            return true;
        }

        if (id == R.id.gender) {
            factorialLayout.setVisibility(View.GONE);
            result.setText("");
            showGenderDialog();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void showGenderDialog() {
        String[] genders = {"Male", "Female"};

        new AlertDialog.Builder(this)
                .setTitle("Select Gender")
                .setSingleChoiceItems(genders, -1, (dialog, which) -> {
                    if (which == 0) {
                        genderImage.setImageResource(R.drawable.male);
                        result.setText("Selected: Male");
                    } else {
                        genderImage.setImageResource(R.drawable.female);
                        result.setText("Selected: Female");
                    }
                    genderImage.setVisibility(ImageView.VISIBLE);
                    dialog.dismiss();
                })
                .setNegativeButton("Cancel", (dialog, which) -> {
                    // If user cancels gender selection, can keep factorial hidden or show factorial
                    dialog.dismiss();
                })
                .show();
    }
}
