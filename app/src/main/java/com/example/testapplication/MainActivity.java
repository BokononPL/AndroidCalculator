package com.example.testapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button exitbutton;
    private Button simplebutton;
    private Button advancedbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        exitbutton = findViewById(R.id.exitbutton);
        simplebutton = findViewById(R.id.simplebutton);
        advancedbutton = findViewById(R.id.advancedbutton);

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

    }
}
