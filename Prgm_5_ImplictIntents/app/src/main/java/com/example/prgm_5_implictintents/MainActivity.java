// Package name of this Android application
package com.example.prgm_5_implictintents;
// Import Intent class to communicate with other apps/components
import android.content.Intent;
// Import Uri class to handle Uniform Resource Identifier (links, locations, etc.)
import android.net.Uri;
// Import Bundle class to store activity state information
import android.os.Bundle;
// Import View class to handle UI events like button clicks
import android.view.View;
// Import Button class to work with Button widgets
import android.widget.Button;
// Base class for activities with AppCompat support
import androidx.appcompat.app.AppCompatActivity;
// MainActivity class inherits AppCompatActivity
// Implements View.OnClickListener to handle button click events
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // Declaring four Button variables
    Button b1, b2, b3, b4;
    // onCreate() method is called when the activity starts
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Connects Java code with activity_main.xml layout
        setContentView(R.layout.activity_main);
        // Linking Java button objects with XML button IDs
        b1 = findViewById(R.id.button);   // Map button
        b2 = findViewById(R.id.button2);  // PlayStore button
        b3 = findViewById(R.id.button3);  // Email button
        b4 = findViewById(R.id.button4);  // Messenger button
        // Registering click listener for each button
        // When a button is clicked, onClick() method will execute
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
    }
    // This method handles all button click events
    @Override
    public void onClick(View view) {
        // Declaring Intent object
        // Intent is used to start another activity or open another application
        Intent intent;
        // Checking which button was clicked
        if (view.getId() == R.id.button) {
            // Creates a URI containing a map location
            // geo: is used for opening map applications
            Uri uri = Uri.parse("geo:0,0?q=Kerala");
            // Creates an implicit intent
            // ACTION_VIEW tells Android to display the given data
            intent = new Intent(Intent.ACTION_VIEW, uri);
            // createChooser() displays available apps that can handle this intent
            // User can select which map application to open
            startActivity(Intent.createChooser(intent, "Open Map Using"));
        } else if (view.getId() == R.id.button2) {
            // Creates URI for opening Google Play Store
            // id specifies the application to view in Play Store
            Uri uri = Uri.parse("market://details?id=com.android.chrome");
            // Creates implicit intent for Play Store
            intent = new Intent(Intent.ACTION_VIEW, uri);
            // Displays apps that can open Play Store links
            startActivity(Intent.createChooser(intent, "Open Play Store Using"));
        } else if (view.getId() == R.id.button3) {
            // Creates an intent for sending an email
            // ACTION_SENDTO is specifically used for email applications
            intent = new Intent(Intent.ACTION_SENDTO);
            // Defines that the data should be handled as an email address
            intent.setData(Uri.parse("mailto:"));
            // Adds email subject
            intent.putExtra(Intent.EXTRA_SUBJECT, "Android Lab");
            // Adds email message content
            intent.putExtra(Intent.EXTRA_TEXT, "Testing Implicit Intent");
            // Opens email application chooser
            startActivity(Intent.createChooser(intent, "Send Email Using"));
        } else if (view.getId() == R.id.button4) {
            // Creates URI for opening Messenger website
            Uri uri = Uri.parse("https://www.messenger.com");
            // Creates implicit intent to open the URL
            intent = new Intent(Intent.ACTION_VIEW, uri);
            // Shows available apps (browser/Messenger) to open the link
            startActivity(Intent.createChooser(intent, "Open Messenger Using"));
        }
    }
}