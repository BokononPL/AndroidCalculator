package com.example.androidcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button exitbutton;
    private Button simplebutton;
    private Button advancedbutton;
    private Button aboutbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        exitbutton = findViewById(R.id.exitbutton);
        simplebutton = findViewById(R.id.simplebutton);
        advancedbutton = findViewById(R.id.advancedbutton);
        aboutbutton = findViewById(R.id.aboutbutton);

        exitbutton.setOnClickListener(v -> {
            Intent homeIntent = new Intent(Intent.ACTION_MAIN);
            homeIntent.addCategory( Intent.CATEGORY_HOME );
            homeIntent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(homeIntent);
        });

        simplebutton.setOnClickListener(v -> {
            Intent nextScreen = new Intent(getApplicationContext(), SimpleActivity.class);
            startActivity(nextScreen);
        });

        advancedbutton.setOnClickListener(v -> {
            Intent nextScreen = new Intent(getApplicationContext(), AdvancedActivity.class);
            startActivity(nextScreen);
        });

        aboutbutton.setOnClickListener(v -> {
            Intent nextScreen = new Intent(getApplicationContext(), AboutActivity.class);
            startActivity(nextScreen);
        });

    }
}
