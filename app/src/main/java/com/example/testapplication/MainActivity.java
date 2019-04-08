package com.example.testapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button xDbutton;
    private Button simplebutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main);
        super.onCreate(savedInstanceState);

        xDbutton = findViewById(R.id.xDbutton);
        simplebutton = findViewById(R.id.simplebutton);

        xDbutton.setOnClickListener(v -> {
            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, "xD", Toast.LENGTH_SHORT);
            toast.show();
        });

        simplebutton.setOnClickListener(v -> {
            Intent nextScreen = new Intent(getApplicationContext(), SimpleActivity.class);
            startActivity(nextScreen);
        });

    }
}
